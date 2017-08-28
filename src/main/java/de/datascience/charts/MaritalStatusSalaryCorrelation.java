package de.datascience.charts;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.text.DecimalFormat;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class MaritalStatusSalaryCorrelation extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Scatter Chart Sample");
		final NumberAxis yAxis = new NumberAxis(0, 35000, 100);
		final CategoryAxis xAxis = new CategoryAxis();

		final ScatterChart<String, Number> scatterChart = new ScatterChart<>(xAxis, yAxis);
		yAxis.setLabel("Salary");
		xAxis.setLabel("Marital Status");
		scatterChart.setTitle("Salary - Marital Status correlation");

		XYChart.Series series = new XYChart.Series();

		series.setName("Salary-MaritalStatus");
		DecimalFormat df = new DecimalFormat("0.00");
		df.setMaximumFractionDigits(2);

		try (CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(new FileInputStream("docs/bank_clean.csv"), "UTF-8")).withSkipLines(1)
				.build()) {
			String[] nextLine;
			while ((nextLine = csvReader.readNext()) != null) {
				String maritalStatus = "";
				switch(String.valueOf(nextLine[7])){
				case "1": maritalStatus="REMARRIED";break;
				case "2": maritalStatus="MARRIED";break;
				case "3": maritalStatus="DIVORCED";break;
				case "4": maritalStatus="SINGLE";break;
				case "5": maritalStatus="WIDOW";break;
				default: maritalStatus="undefined";
				}
				
				
				Float salary =Float.parseFloat(nextLine[11]);
				System.out.println("MS: "+maritalStatus + "-  SL: " +salary);

				series.getData().add(new XYChart.Data(maritalStatus, salary));
			}
		}

		scatterChart.getData().addAll(series);
		Scene scene = new Scene(scatterChart, 800, 800);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
