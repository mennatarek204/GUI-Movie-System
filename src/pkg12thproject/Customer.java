package pkg12thproject;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Customer extends Person implements Instructions {

    @FXML
    private TextField txtFname;
    @FXML
    private TextField txtLname;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField intID;
    @FXML
    private Button btsignup;
    @FXML
    private Button CusSignup;
    @FXML
    private TextField txtUsernameSign;
    @FXML
    private PasswordField txtPasswordSign;

    Parent customer;
    Scene scene;
    Stage stage;

    @FXML
    private void CustomerAction(ActionEvent event) {
        if (event.getSource() == getBtLogin()) {
            // Login
            if (login().equals("Success")) {
                try {
                    System.out.println("Here is the customer class");
                    customer = FXMLLoader.load(getClass().getResource("BookTicket.fxml"));
                    scene = new Scene(customer);
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setTitle("Book Ticket");
                    stage.hide();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            } else {
                System.out.println("SOMETHING WRONG");
            }
        } else {
            System.out.println("CRYYYY");
        }
    }

    @FXML
    public void SignUPAction(ActionEvent event) {
        if (event.getSource() == btsignup) {
            try {
                System.out.println("Here is the customer Sign Up class");
                customer = FXMLLoader.load(getClass().getResource("CustomerSignup.fxml"));
                scene = new Scene(customer);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("Sign up");
                stage.hide();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println("Something wrong in signup");
        }
    }

    @FXML
    private void FinishSignUPAction(ActionEvent event) {
        if (Error()) {
            SignUPAction();
            if (event.getSource() == CusSignup) {
                try {
                    CustomerAction(event);
                    System.out.println("Here is the customer class");
                    customer = FXMLLoader.load(getClass().getResource("BookTicket.fxml"));
                    scene = new Scene(customer);
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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

            SQL = "SELECT * FROM CUSTOMERDETALIS WHERE USERNAME=? AND PASSWORD=?";

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
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            output = "Message";
        }
        return output;
    }
    
    public void SignUPAction() {
        try {
            ConnectDB();
            SQL = "INSERT INTO CUSTOMERDETALIS (FIRSTNAME, LASTNAME, USERNAME, PASSWORD, EMAIL, NATIONALID) VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = con.prepareStatement(SQL);
            preparedStatement.setString(1, txtFname.getText());
            preparedStatement.setString(2, txtLname.getText());
            preparedStatement.setString(3, txtUsernameSign.getText());
            preparedStatement.setString(4, txtPasswordSign.getText());
            preparedStatement.setString(5, txtEmail.getText());
            preparedStatement.setString(6, intID.getText());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private boolean Error() {
        if (txtFname.getText().isEmpty() | txtLname.getText().isEmpty() | txtUsernameSign.getText().isEmpty() | txtPasswordSign.getText().isEmpty() | txtEmail.getText().isEmpty() | intID.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Validate Fields");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Into The Fields");
            alert.showAndWait();
            return false;
        }
        return true;
    }
}
