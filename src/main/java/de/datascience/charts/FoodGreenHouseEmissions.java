package de.datascience.charts;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

//http://www.chartvalley.com/food-group-pie-chart/best-of-food-group-pie-chart/
public class FoodGreenHouseEmissions extends Application {
    
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Food group pie chart");
        stage.setWidth(500);
        stage.setHeight(500);
 
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Cereals & Carbs", 11),
                new PieChart.Data("Fruits and Vegs", 11),
                new PieChart.Data("Dairy", 18),
                new PieChart.Data("Red Meat", 30),
                new PieChart.Data("Fish", 4),
                new PieChart.Data("Chicken and eggs", 5),
                new PieChart.Data("Junk food", 16),
        		new PieChart.Data("Drinks",15));
        	
        final PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("U.S. greenhouse gas emissions from food");

        ((Group) scene.getRoot()).getChildren().add(pieChart);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
