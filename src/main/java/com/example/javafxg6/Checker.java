package com.example.javafxg6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Checker extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        Scene scene = new Scene(root , 400 , 300);
        root.setSpacing(10);
        root.setPadding(new Insets(10, 0, 0, 0));
        root.setAlignment(Pos.TOP_CENTER);

        Label label = new Label("Check");
        label.setFont(new Font(20));
        root.getChildren().add(label);

        TextField field = new TextField();
        field.setFocusTraversable(false);
        //field.setText("Plz enter text");
        field.setPromptText("Plz enter email/url");
        field.setMaxWidth(300);
        root.getChildren().add(field);

        Button button = new Button("Check");
        //button.setText("C");
        root.getChildren().add(button);

        Label label1 = new Label();
        root.getChildren().addAll(label1);
        /*Text text = new Text();
        root.getChildren().add(text);*/
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                VBox vBox = new VBox();
                Scene scene1 = new Scene(vBox, 600, 400);
                Button button1 = new Button();
                vBox.getChildren().add(button1);
                button1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        stage.setScene(scene);
                    }
                });
                /*Stage stage1 = new Stage();
                stage1.setTitle("HGGGGGGGGGGG");*/
                stage.setScene(scene1);

               /* String text = field.getText();
                if (text.isEmpty()){
                    //System.out.println("Empty");
                    //label1.setText("Empty");

                }else if(text.contains("@")){
                    //System.out.println("Email");
                    label1.setText("Email");
                }else if(text.contains("https://")){
                    label1.setText("URL");
                }else {
                    label1.setText("Normal text");
                }*/
            }
        });



        stage.setScene(scene);

        stage.show();

    }
}
