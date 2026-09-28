package com.mycompany.lab06_2026;

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
        var bagList = new ListView();
        bagList.getItems().addAll("Full Decorative", "Beaded", "Pirate Design", "Fringed", "Leather", "Plain");
        bagList.setPrefHeight(140);
        
        var bagCombo = new ComboBox();
        bagCombo.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        bagCombo.setTranslateY(-58);
        
        var btnGroup = new ToggleGroup();
        var btn1 = new RadioButton("Small");
        btn1.setToggleGroup(btnGroup);
        var btn2 = new RadioButton("Medium");
        btn2.setToggleGroup(btnGroup);
        var btn3 = new RadioButton("Large");
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
        
        
        var scene = new Scene(root, 640, 480);
        stage.setTitle("Bag Order Form");
        stage.setScene(scene);
        stage.show();       
    }

    public static void main(String[] args) {
        launch();
    }

}