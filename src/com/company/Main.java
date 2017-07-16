package com.company;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.*;

public class Main extends Application {

    Stage window;
    TableView<Product> table;
    ListView<String> listView;
    String username = "Test User";

    public static void main(String[] args) {
        launch();
        //launch(args);

    }

    @Override
    public void start(Stage window) throws Exception {
        this.window = window;

        //Text Area of GridPane Center
        TextArea textArea = new TextArea();
        textArea.setPrefWidth(800);
        textArea.setPrefHeight(400);
        textArea.setText("Test");
        textArea.setEditable(false);
        textArea.setStyle("-fx-background-color: #ffffff;-fx-text-fill: black; -fx-opacity: 1;");

        //Text field for User Chatting
        TextField textInput = new TextField();
        textInput.setPrefWidth(1000);
        textInput.setPrefHeight(100);
        textInput.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                System.out.println("Test");
                textArea.setText(textArea.getText() + "\n" + textInput.getText());
                textInput.clear();
            }
        });

        //Label for UserList
        Label label1 = new Label();
        label1.setText(username + "\n");


        //choiceBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> System.out.println("newValue"));

        VBox vBox = new VBox();
        vBox.setSpacing(100);
        vBox.setPadding(new Insets(5,10,10,5));
        vBox.setBorder(new Border(new BorderStroke(Color.RED,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        vBox.setPrefWidth(200);
        vBox.getChildren().addAll(label1);

        //Bottom HBox Row
        HBox hBox = new HBox();
        hBox.getChildren().add(textInput);
        hBox.setBorder(new Border(new BorderStroke(Color.GOLD,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        hBox.setPrefWidth(200);


        //Window GridPane - More Flexible than HBox and VBox
        GridPane gridPane = new GridPane();
        gridPane.setBorder(new Border(new BorderStroke(Color.BLUE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        gridPane.getChildren().add(textArea);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(vBox);
        borderPane.setCenter(gridPane);
        borderPane.setBottom(hBox);
        borderPane.setPadding(new Insets(20, 20, 20, 20));


        Scene scene = new Scene(borderPane, 1000, 500);
        window.setTitle("Title of Window");
        window.setScene(scene);
        window.show();

        LoginScreen loginScreen = new LoginScreen();
        username += loginScreen.display();


    }

}
