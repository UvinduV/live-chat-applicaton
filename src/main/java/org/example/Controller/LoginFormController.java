package org.example.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.Server.Server;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private JFXButton btnLogin;

    @FXML
    private AnchorPane loginPanel;

    @FXML
    private TextField txtUsername;

    public static String user;

    public void initialize(){

    }
    public void btnLoginOnAction(ActionEvent event) throws IOException {
        /*startServer();

        loginPanel.getChildren().clear();
        Stage stage = (Stage) loginPanel.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ClientForm.fxml"))));
        stage.show();
    }
    private void startServer() throws IOException {
        Server server = Server.getServerSocket();
        Thread thread = new Thread(server);
        thread.start();
    }*/

        if (!txtUsername.getText().isEmpty() && txtUsername.getText().matches("[A-Za-z0-9]+")) {

            Stage primaryStage= new Stage();
            primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ClientForm.fxml"))));

            ClientFormController controller = new ClientFormController();
            controller.setClientName(txtUsername.getText());
            //user=txtUsername.getText();
            // Set the parameter
            //fxmlLoader.setController(controller);

            primaryStage.setTitle(txtUsername.getText());
            primaryStage.centerOnScreen();
            primaryStage.setResizable(false);
            primaryStage.show();

            txtUsername.clear();
        } else {
            new Alert(Alert.AlertType.ERROR, "Please enter your name").show();
        }
    }

}
