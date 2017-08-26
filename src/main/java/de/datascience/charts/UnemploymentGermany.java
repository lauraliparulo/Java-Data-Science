package de.datascience.charts;

import java.io.FileReader;
import java.io.Reader;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class UnemploymentGermany extends Application {

	   @Override
	    public void start(Stage stage) throws Exception {
	        stage.setTitle("Index Chart Sample");
	        final NumberAxis yAxis = new NumberAxis(0, 5000000, 1);
	        final CategoryAxis xAxis = new CategoryAxis();

	        final LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
	        yAxis.setLabel("People without job");
	        xAxis.setLabel("year");
	        lineChart.setTitle("Unemployment in Germnay");

	        XYChart.Series series = new XYChart.Series();

	        try (CSVReader dataReader = new CSVReader(new FileReader("docs/unemployment_germany.csv"))) {
	            String[] nextLine;
	            while ((nextLine = dataReader.readNext()) != null) {
	                String year = String.valueOf(nextLine[0]);
	                int population = Integer.parseInt(nextLine[1]);
	                series.getData().add(new XYChart.Data(year, population));
	            }
	        }

	        lineChart.getData().addAll(series);
	        Scene scene = new Scene(lineChart, 500, 400);
	        stage.setScene(scene);
	        stage.show();
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
}
