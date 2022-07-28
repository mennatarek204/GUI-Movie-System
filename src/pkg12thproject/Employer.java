package pkg12thproject;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Employer extends Person implements Instructions {

    @FXML
    private void EmpAction(ActionEvent event) {
        if (event.getSource() == getBtLogin()) {
            // Login
            if (login().equals("Success")) {
                try {
                    System.out.println("Here is the customer class");
                    Parent customer = FXMLLoader.load(getClass().getResource("EmployerMain.fxml"));
                    Scene scene = new Scene(customer);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setTitle("Movie List");
                    stage.hide();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    @Override
    public String login() {
        String output = "Success";
        try {
            ConnectDB();
            uname = getTxtUsername().getText();
            pass = getTxtPassword().getText();

            SQL = "SELECT * FROM EMPLOYER WHERE USERNAME=? AND PASSWORD=?";

            preparedStatement = con.prepareStatement(SQL);
            preparedStatement.setString(1, uname);
            preparedStatement.setString(2, pass);
            rs = preparedStatement.executeQuery();

            if (!rs.next()) {
                getLblError().setText("Enter Correct Username or Password");
                getLblError().setTextFill(Color.BROWN);
                System.out.println("Enter Correct Username or Password");
                output = "Wrong";
            } else {
                System.out.println("Login Succssful...");
                output = "Success";
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            output = "Message";
        }
        return output;
    }

}
