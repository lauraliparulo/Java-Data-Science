package de.datascience.charts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ExpendituresShares extends Application {

    final static String FOOD = "Food";
    final static String HOUSING = "Housing";
    final static String TRANSPORTATION = "Transportation";
    final static String HEALTHCARE = "Health care";
    final static String CLOTHING = "Clothing";
    
    final static String USA="U.S.A.";
    final static String UK="United Kingdom";
    final static String CANADA="Canada";
    final static String JAPAN="Japan";

    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();

    final XYChart.Series<String, Number> usaSeries = new XYChart.Series<>();
    final XYChart.Series<String, Number> canadaSeries2 = new XYChart.Series<>();
    final XYChart.Series<String, Number> ukSeries = new XYChart.Series<>();
    final XYChart.Series<String, Number> japanSeries = new XYChart.Series<>();

    public void simpleBarChartByCountry(Stage stage) {
        stage.setTitle("Bar Chart");
        final BarChart<String, Number> barChart
                = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Shares of expenditures by Country");
        xAxis.setLabel("Category");
        yAxis.setLabel("Percentage");

        usaSeries.setName(USA);
        addDataItem(usaSeries, FOOD, 14);
        addDataItem(usaSeries, HOUSING, 26);
        addDataItem(usaSeries, TRANSPORTATION, 17);
        addDataItem(usaSeries, HEALTHCARE, 8);
        addDataItem(usaSeries, CLOTHING, 4);

        canadaSeries2.setName(CANADA);
        addDataItem(canadaSeries2, FOOD, 15);
        addDataItem(canadaSeries2, HOUSING, 21);
        addDataItem(canadaSeries2, TRANSPORTATION, 20);
        addDataItem(canadaSeries2, HEALTHCARE, 7);
        addDataItem(canadaSeries2, CLOTHING, 6);

        ukSeries.setName(UK);
        addDataItem(ukSeries, FOOD, 20);
        addDataItem(ukSeries, HOUSING, 24);
        addDataItem(ukSeries, TRANSPORTATION, 15);
        addDataItem(ukSeries, HEALTHCARE, 2);
        addDataItem(ukSeries, CLOTHING, 6);
        
        japanSeries.setName(JAPAN);
        addDataItem(japanSeries, FOOD, 23);
        addDataItem(japanSeries, HOUSING, 22);
        addDataItem(japanSeries, TRANSPORTATION, 10);
        addDataItem(japanSeries, HEALTHCARE, 4);
        addDataItem(japanSeries, CLOTHING, 4);

        Scene scene = new Scene(barChart, 800, 600);
        barChart.getData().addAll(usaSeries, canadaSeries2, ukSeries, japanSeries);
        stage.setScene(scene);
        stage.show();
    }

    public void addDataItem(XYChart.Series<String, Number> series,
            String x, Number y) {
        series.getData().add(new XYChart.Data<>(x, y));
    }

    @Override
    public void start(Stage stage) {
        simpleBarChartByCountry(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
