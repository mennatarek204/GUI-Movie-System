package pkg12thproject;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BookTicket extends ConnectDB {
    
    NumCustomers customers = new NumCustomers();
    
    Parent customer;
    Scene scene;
    Stage stage;

    @FXML
    private TextField txtNumCustomer;
    
    @FXML
    private Button bttest;
    
    @FXML
    private void NumCustomerAction(ActionEvent event){
        if(event.getSource() == bttest){
            customers.countCustomers(txtNumCustomer.getText());  
            try {
                    System.out.println("Here is the customer class");
                    Parent parent = FXMLLoader.load(getClass().getResource("PrintTicket.fxml"));
                    scene = new Scene(parent);
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setTitle("Print Ticket");
                    stage.hide();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
        }
    }
    
}