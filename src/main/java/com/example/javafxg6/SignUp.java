package com.example.javafxg6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SignUp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(15);
        root.setPadding(new Insets(20 , 60,0,60));
        Scene scene = new Scene(root , 500 , 400);

        Label label = new Label("SignUp");
        label.setFont(new Font(25));
        setNode(root , label);

        TextField tfName = new TextField();
        tfName.setFocusTraversable(false);
        tfName.setPromptText("Enter user name");
        setNode(root, tfName);

        TextField tfEmail = new TextField();
        tfEmail.setFocusTraversable(false);
        tfEmail.setPromptText("Enter user email");
        setNode(root, tfEmail);

        PasswordField pfPassword = new PasswordField();
        pfPassword.setFocusTraversable(false);
        pfPassword.setPromptText("Enter user password");
        setNode(root, pfPassword);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(5);

        Label label1 = new Label("Gender");
        label1.setFont(new Font(15));
        //setNode(root, label1);

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton rbMale = new RadioButton("Male");
        rbMale.setSelected(true);
        RadioButton rbFemale = new RadioButton("Female");
        rbMale.setToggleGroup(toggleGroup);
        rbFemale.setToggleGroup(toggleGroup);

        hBox.getChildren().addAll(label1, rbMale, rbFemale);
        setNode(root, hBox);

        CheckBox checkBox = new CheckBox();
        checkBox.setIndeterminate(true);
        checkBox.setText("Agree the role");
        setNode(root, checkBox);

        Button button = new Button("SignUp");
        setNode(root, button);

        Label massageLabel = new Label();
        massageLabel.setFont(new Font(15));
        massageLabel.setTextFill(Color.RED);
        setNode(root, massageLabel);

        stage.setScene(scene);
        stage.show();
    }

    private static void setNode(VBox root, Node node) {
        root.getChildren().add(node);
    }
}
