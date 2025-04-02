import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jasypt.util.text.BasicTextEncryptor;

public class Starter extends Application {
    public static void main(String[] args) {

        String key ="12345";

        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
        basicTextEncryptor.setPassword(key);


        String password = "samitha123";

        String encrypt = basicTextEncryptor.encrypt(password);

        System.out.println("encrypt password : "+encrypt);

        String decrypt = basicTextEncryptor.decrypt(encrypt);

        System.out.println("decrypt password : "+decrypt);


        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/dash_board.fxml"))));
        stage.show();

//        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/login.fxml" ))));
//        stage.show();
//
//        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/register.fxml"))));
//        stage.show();
    }
}
