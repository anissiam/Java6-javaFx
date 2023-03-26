package com.example.javafxg6;

import com.example.javafxg6.model.User;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

import java.io.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends Application {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    User user;

    private String gender = "Male";
    @Override
    public void start(Stage stage) throws Exception {
        user = new User();
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

        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue,
                                Toggle toggle, Toggle t1) {
                RadioButton radioButton =(RadioButton) t1.getToggleGroup().getSelectedToggle();
                gender = radioButton.getText();
                System.out.println(gender);

            }
        });


        hBox.getChildren().addAll(label1, rbMale, rbFemale);
        setNode(root, hBox);

        CheckBox checkBox = new CheckBox();
        checkBox.setIndeterminate(true);
        checkBox.setText("Agree the role");
        setNode(root, checkBox);


        /*checkBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });
        */

        Button button = new Button("SignUp");
        setNode(root, button);

        Label massageLabel = new Label();
        massageLabel.setFont(new Font(15));
        massageLabel.setTextFill(Color.RED);
        setNode(root, massageLabel);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String name = tfName.getText();
                if (name.isEmpty()){
                   massageLabel.setText("Plz enter user name");
                   return;
                }

                String email = tfEmail.getText();
                if (email.isEmpty()){
                    massageLabel.setText("Plz enter user email");
                    return;
                }

                if(!validate(email)){
                    massageLabel.setText("Plz add valid email");
                    return;
                }

                String password = pfPassword.getText();
                if (password.isEmpty()){
                    massageLabel.setText("Plz enter user password");
                    return;
                }

                if(password.length()<6){
                    massageLabel.setText("Plz add password up to 6 digits");
                    return;
                }

                if (gender==null && gender.isEmpty()){
                    massageLabel.setText("Plz select gender");
                    return;
                }

                if(!checkBox.isSelected()){
                    massageLabel.setText("Plz agree the role");
                    return;
                }
                massageLabel.setText("");
                Date date = new Date();

                user = new User(name , email , password, gender , date);
                System.out.println(user.toString());

                addToFile(user , stage);
            }
        });




        stage.setScene(scene);
        stage.show();
    }

    private void addToFile(User user, Stage stage) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("User.txt");
            ObjectOutputStream stream = new ObjectOutputStream(fileOutputStream);
            stream.writeObject(user);
            stream.flush();
            stream.close();

            VBox vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);
            Scene scene = new Scene(vBox, 500, 400);

            Label label = new Label();
            label.setText(user.toString());
            vBox.getChildren().add(label);
            stage.setScene(scene);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }

    private static void setNode(VBox root, Node node) {
        root.getChildren().add(node);
    }
}
