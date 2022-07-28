package pkg12thproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btcust;
    @FXML
    private Button btemp;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == btcust) {
            System.out.println("You Clicked Me!");
            Parent start = FXMLLoader.load(getClass().getResource("CustomerLogin.fxml"));
            Scene person = new Scene(start);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Customer Login");
            stage.hide();
            stage.setScene(person);
            stage.show();
        } else if (event.getSource() == btemp) {
            System.out.println("You Clicked Me!");
            Parent start = FXMLLoader.load(getClass().getResource("EmployerLogin.fxml"));
            Scene person = new Scene(start);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Employer Login");
            stage.hide();
            stage.setScene(person);
            stage.show();
        }else System.out.println("ERROR");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
