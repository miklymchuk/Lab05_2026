package com.mycompany.lab06_2026;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) { 
        // Task 01
        
        var bagList = new ListView();
        bagList.getItems().addAll("Full Decorative", "Beaded", "Pirate Design", "Fringed", "Leather", "Plain");
        bagList.setPrefHeight(140);
        
        var bagCombo = new ComboBox();
        bagCombo.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        bagCombo.setTranslateY(-58);
        
        var btnGroup = new ToggleGroup();
        var btn1 = new RadioButton("Small");
        btn1.setUserData("Small");
        btn1.setToggleGroup(btnGroup);
        var btn2 = new RadioButton("Medium");
        btn2.setUserData("Medium");
        btn2.setToggleGroup(btnGroup);
        var btn3 = new RadioButton("Large");
        btn3.setUserData("Large");
        btn3.setToggleGroup(btnGroup);
        
        var btnLayout = new VBox(btn1, btn2, btn3);
        
        var order = new Button("Order");
        var clear = new Button("Clear");
        
        var orderLabel = new Label("");
         
        var root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(15);
        root.setVgap(15);
        root.add(bagList, 0, 0);
        root.add(bagCombo, 1, 0);
        root.add(btnLayout, 2, 0);
        root.add(order, 0, 1);
        root.add(clear, 1, 1);
        root.add(orderLabel, 0, 2);
        
        // To get from Task 01 to Task 02
        
        var nextScene = new Button("Next Scene");
        root.add(nextScene, 2, 1);
        
        var scene = new Scene(root, 640, 480);
        stage.setTitle("Bag Order Form");
        stage.setScene(scene);
        stage.show();   
        
        order.setOnAction(event -> { 
            if (bagList.getSelectionModel().getSelectedItem() == null || bagCombo.getSelectionModel().getSelectedItem() == null || btnGroup.getSelectedToggle().getUserData() == null) {
                orderLabel.setText("You did not enter all the required order information.");
                return;
            }
            
            if (bagCombo.getSelectionModel().getSelectedItem().toString().equals("1")) {
                orderLabel.setText("You ordered 1 " + btnGroup.getSelectedToggle().getUserData().toString() + " " + bagList.getSelectionModel().getSelectedItem().toString() + " Bag.");
            } else {
                orderLabel.setText("You ordered " + bagCombo.getSelectionModel().getSelectedItem().toString() + " " + btnGroup.getSelectedToggle().getUserData().toString() + " " + bagList.getSelectionModel().getSelectedItem().toString() + " Bags.");
            }         
        });    
        
        clear.setOnAction(event -> {
            bagList.getSelectionModel().clearSelection();
            bagCombo.getSelectionModel().clearSelection();
            btnGroup.selectToggle(null);
            orderLabel.setText("");
        });       
        
        // Task 02
        
        var category = new Label("Category");
        var itemName = new Label("Item Name, Price ($)");
               
        var beverage = new Label("Beverage");
        var appetizer = new Label("Appetizer");
        var mainCourse = new Label("Main Course");
        var dessert = new Label("Dessert");
        
        ComboBox<String> beverages = new ComboBox();
        beverages.getItems().addAll("Coffee, $2.50", "Tea, $2.00", "Soft Drink, $1.75");
        Map<String, Double> beverageMap = new HashMap<>();
        beverageMap.put("Coffee, $2.50", 2.50);
        beverageMap.put("Tea, $2.00", 2.00);
        beverageMap.put("Soft Drink, $1.75", 1.75);
        var appetizers = new ComboBox();
        appetizers.getItems().addAll("Soup, $4.50", "Salad, $3.75", "Spring Rolls, $5.25");
        Map<String, Double> appetizerMap = new HashMap<>();
        appetizerMap.put("Soup, $4.50", 4.50);
        appetizerMap.put("Salad, $3.75", 3.75);
        appetizerMap.put("Spring Rolls, $5.25", 5.25);
        var mainCourses = new ComboBox();
        var mainCourseMap = new HashMap<>();
        mainCourses.getItems().addAll("Steak, $15.00", "Grilled Chicken, $13.50", "Pasta, $11.75");
        var desserts = new ComboBox();
        desserts.getItems().addAll("Apple Pie, $5.95", "Carrot Cake, $4.50", "Pudding, $3.25");
        
        var root2 = new GridPane();
        root2.gridLinesVisibleProperty().set(true);
        root2.add(category, 0, 0);
        root2.add(itemName, 1, 0);
        root2.add(beverage, 0, 1);
        root2.add(appetizer, 0, 2);
        root2.add(mainCourse, 0, 3);
        root2.add(dessert, 0, 4);
        root2.add(beverages, 1, 1);
        root2.add(appetizers, 1, 2);
        root2.add(mainCourses, 1, 3);
        root2.add(desserts, 1, 4);
        
        var scene2 = new Scene(root2, 640, 480);
        
        nextScene.setOnAction(event -> {
            stage.setScene(scene2);
        });
    }

    public static void main(String[] args) {
        launch();
    }

}