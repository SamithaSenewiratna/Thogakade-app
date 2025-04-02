package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import dto.User;
import javafx.util.Duration;
import org.jasypt.util.text.BasicTextEncryptor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFromController {

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws  IOException {

//
//        Stage stage = new Stage();
//        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dash_board.fxml"))));
//        stage.show();


        Parent root = FXMLLoader.load(getClass().getResource("../view/dash_board.fxml"));


        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();

        FadeTransition fadeIn = new FadeTransition(Duration.millis(600), root.getScene().getRoot());
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();


//        String key ="12345";
//
//        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
//        basicTextEncryptor.setPassword(key);
//
//        String SQL = "SELECT * FROM users WHERE email=" + "'" + txtEmail.getText() + "'";
//        try {
//            Connection  connection = DBConnection.getInstance().getConnection();
//            ResultSet resultSet = connection.createStatement().executeQuery(SQL);
//            resultSet.next();
//            User user = new User(resultSet.getString(2),
//                    resultSet.getString(3),
//                    resultSet.getString(4)
//            );
//            System.out.println(user);
//            if (user != null) {
//                if (basicTextEncryptor.decrypt(user.getPassword()).equals(txtPassword.getText())) {
//                    System.out.println("Login!");
//                    Stage stage = new Stage();
//                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dash_board.fxml"))));
//                    stage.show();
//                } else {
//                    new Alert(Alert.AlertType.ERROR,"Check your Password").show();
//                    System.out.println("Check your password");
//                }
//            } else {
//                new Alert(Alert.AlertType.ERROR,"User Not Found").show();
//                System.out.println("user Not found!");
//            }
//        } catch (SQLException e) {
//           new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
//        }

    }

    @FXML
    void hiperRegisterOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/register.fxml"))));
        stage.show();
    }

}
