package com.atcn.bdd.ui.mobile.runners;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenCucumberReport {

    /**
     * Reference
     * https://github.com/damianszczepanik/cucumber-reporting
     * https://www.mkyong.com/java/java-how-to-list-all-files-in-a-directory/
     */

    public static void generateReport() {

        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<>();

        try (Stream<Path> walk = Files.walk(Paths.get("target/cucumber-report-json"))) {

            List<String> result = walk.map(x -> x.toString())
                    .filter(f -> f.endsWith(".json")).collect(Collectors.toList());

            result.forEach(System.out::println);
            jsonFiles.addAll(result);

        } catch (IOException e) {
            e.printStackTrace();
        }

//        String buildNumber = "1";
        String projectName = "cucumberProject";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        // optional configuration - check javadoc for details
        configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
        // do not make scenario failed when step has status SKIPPED
        configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
//        configuration.setBuildNumber(buildNumber);
        // addidtional metadata presented on main page
//        configuration.addClassifications("Platform", "Windows");
//        configuration.addClassifications("Browser", "Firefox");
//        configuration.addClassifications("Branch", "release/1.0");

        // optionally add metadata presented on main page via properties file
//        List<String> classificationFiles = new ArrayList<>();
//        classificationFiles.add("properties-1.properties");
//        classificationFiles.add("properties-2.properties");
//        configuration.addClassificationFiles(classificationFiles);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
// and here validate 'result' to decide what to do if report has failed
    }
}
