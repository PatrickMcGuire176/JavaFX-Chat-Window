package com.company;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginScreen {

    public static String display(){
        String username = "";
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Login Screen");
        window.setMinWidth(250);
        window.setMinHeight(150);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label label1 = new Label();
        label1.setText("Enter Username to Begin");
        gridPane.setConstraints(label1, 0,0);

        Label label2 = new Label();
        label2.setText("UserName");
        gridPane.setConstraints(label2, 0,1);

        TextField textInput = new TextField();
        gridPane.setConstraints(textInput, 1,1);

        Button closeButton = new Button("Close the window");
        closeButton.setOnAction(e -> {
            window.close();

        });
        gridPane.setConstraints(closeButton, 0,2);



        gridPane.getChildren().addAll(label1, label2, textInput, closeButton);

        Scene scene = new Scene(gridPane);
        window.setScene(scene);
        window.showAndWait();

        return username;

    }
}
