package pkg12thproject;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditMovie extends ConnectDB implements SubmitInterface{
    @FXML
    private TextField oldname;

    @FXML
    private TextField newname;

    @FXML
    private TextField ncode;

    @FXML
    private TextField ndate;

    @FXML
    private TextField ntime;

    @FXML
    private TextField nprice;
    
    @Override
    public void Submit(ActionEvent event) {
        try {
            ConnectDB();
           String SQL = "UPDATE movies SET MOVIE_NAME=?,CODE =?, DATE=?,TIME=?,PRICE=? WHERE MOVIE_NAME LIKE ?";
            preparedStatement = con.prepareStatement(SQL);
            preparedStatement.setString(1, newname.getText());
            preparedStatement.setString(2, ncode.getText());
            preparedStatement.setString(3, ndate.getText());
            preparedStatement.setString(4, ntime.getText());
            preparedStatement.setString(5, nprice.getText());
            preparedStatement.setString(6, "%" + oldname.getText() + "%");

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
