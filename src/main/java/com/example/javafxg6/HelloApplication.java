package com.example.javafxg6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("init");
    }

    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("Start");
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500);
        //scene.setFill(Color.BLUE);//اضافة لون

        Text text = new Text("Hello");
        text.setX(50);
        text.setY(50);
        text.setFill(Color.BLUEVIOLET);
        Font font = new Font("Cantarell Regular",20 );
        text.setFont(font);
        text.setEffect(new DropShadow(10, Color.BLUE));
        root.getChildren().add(text);

        Line line = new Line();
        line.setStartX(20);
        line.setStartY(20);
        line.setEndX(200);
        line.setEndY(20);
        line.setFill(Color.CYAN);
        line.setStroke(Color.RED);
        line.setRotate(30);
        line.setOpacity(0.5);
        line.setStrokeWidth(30);
        root.getChildren().add(line);

        Rectangle rectangle = new Rectangle(100,50);
        rectangle.setY(80);
        rectangle.setX(80);
        rectangle.setWidth(300);
        rectangle.setHeight(100);

        rectangle.setFill(Color.YELLOW);
        rectangle.setStroke(Color.RED);
        rectangle.setStrokeWidth(5);
        root.getChildren().add(rectangle);

        stage.setScene(scene);
        //stage.setResizable(false);
        //stage.setTitle("Hello from java");
        //stage.setFullScreen(true);
        stage.show();

        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();*/
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Stop");
    }

    public static void main(String[] args) {
        launch();
    }
}