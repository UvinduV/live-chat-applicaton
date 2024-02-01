package org.example.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginFormController {

    @FXML
    private JFXButton btnLogin;

    @FXML
    private AnchorPane loginPanel;

    @FXML
    private TextField txtUsername;

    public void btnLoginOnAction(ActionEvent event) {
    }
}
