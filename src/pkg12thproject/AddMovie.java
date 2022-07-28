package pkg12thproject;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddMovie extends ConnectDB implements SubmitInterface {

    @FXML
    private TextField txtMovieName;
    @FXML
    private TextField txtCode;
    @FXML
    private TextField txtDate;
    @FXML
    private TextField txtTime;
    @FXML
    private TextField txtPrice;
    @FXML
    private Button BtSubmit;

    //inside the add page
    @Override
    public void Submit(ActionEvent event) {
        try {
            ConnectDB();
            SQL = "INSERT into movies (MOVIE_NAME, CODE, DATE, TIME, PRICE) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = con.prepareStatement(SQL);
            preparedStatement.setString(1, txtMovieName.getText());
            preparedStatement.setString(2, txtCode.getText());
            preparedStatement.setString(3, txtDate.getText());
            preparedStatement.setString(4, txtTime.getText());
            preparedStatement.setString(5, txtPrice.getText());
            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    @FXML //back to main page button
    void GoBack(ActionEvent event) throws IOException {
        Parent backPage = FXMLLoader.load(getClass().getResource("EmployerMain.fxml"));
        Scene backScene = new Scene(backPage);
        Stage page = (Stage) ((Node) event.getSource()).getScene().getWindow();
        page.setScene(backScene);
        page.show();
    }

    //-----------------------------------
    @FXML//shows movie list
    void DisplayMovieList(ActionEvent event) throws IOException {
        Parent MoviePage = FXMLLoader.load(getClass().getResource("MovieList.fxml"));
        Scene MovieScene = new Scene(MoviePage);
        Stage page = (Stage) ((Node) event.getSource()).getScene().getWindow();
        page.setScene(MovieScene);
        page.show();
    }

}
