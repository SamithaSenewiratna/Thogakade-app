package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.jasypt.util.text.BasicTextEncryptor;

import java.sql.*;

public class RegisterFromController {

    @FXML
    private JFXPasswordField txtCPassword;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    void btnRegisterOnAction(ActionEvent event) throws SQLException {
        String key ="12345";

        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
        basicTextEncryptor.setPassword(key);

        if (txtPassword.getText().equals(txtCPassword.getText())){
            System.out.println(true);
            Connection connection = DBConnection.getInstance().getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM users WHERE email=" + "'" + txtEmail.getText() + "'");
            if (!resultSet.next()){
                System.out.println(false);

                String SQL = "INSERT INTO users (username,email,password) VALUES (?,?,?)";
                PreparedStatement psTm = connection.prepareStatement(SQL);
                psTm.setString(1,txtUserName.getText());
                psTm.setString(2,txtEmail.getText());
                psTm.setString(3,basicTextEncryptor.encrypt(txtPassword.getText()));
                psTm.executeUpdate();

            }else{
                System.out.println(true);
            }

        }else {
            System.out.println(false);
        }
    }

}
