package controller;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {
    public AnchorPane loadFormContent;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        URL resource = this.getClass().getResource("/view/order_form.fxml");

        assert resource!=null;

        Parent load = null;
        try {
            load = FXMLLoader.load(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.loadFormContent.getChildren().clear();
        this.loadFormContent.getChildren().add(load);




    }





    public void btnCustomerFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/customer-form.fxml");

        assert resource!=null;

        Parent load = FXMLLoader.load(resource);
        this.loadFormContent.getChildren().clear();
        this.loadFormContent.getChildren().add(load);


        FadeTransition fadeIn = new FadeTransition(Duration.millis(600), load.getScene().getRoot());
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();

    }

    public void btnOrderFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/order_form.fxml");

        assert resource!=null;

        Parent load = FXMLLoader.load(resource);
        this.loadFormContent.getChildren().clear();
        this.loadFormContent.getChildren().add(load);


        FadeTransition fadeIn = new FadeTransition(Duration.millis(600), load.getScene().getRoot());
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();
    }


    public void btnAboutUsOnAction(ActionEvent actionEvent) throws IOException {

        URL resource = this.getClass().getResource("/view/aboutUs.fxml");

        assert resource!=null;

        Parent load = FXMLLoader.load(resource);
        this.loadFormContent.getChildren().clear();
        this.loadFormContent.getChildren().add(load);


        FadeTransition fadeIn = new FadeTransition(Duration.millis(600), load.getScene().getRoot());
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();

    }

    public void btnItemOnAction(ActionEvent actionEvent) throws IOException {

        URL resource = this.getClass().getResource("/view/Item.fxml");

        assert resource!=null;

        Parent load = FXMLLoader.load(resource);
        this.loadFormContent.getChildren().clear();
        this.loadFormContent.getChildren().add(load);



        FadeTransition fadeIn = new FadeTransition(Duration.millis(600), load.getScene().getRoot());
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();


    }
}
