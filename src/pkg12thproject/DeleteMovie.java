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

public class DeleteMovie extends ConnectDB implements SubmitInterface{
    @FXML
    private TextField txtDeleteName;

    @Override
    public void Submit(ActionEvent event) {
        try {
            ConnectDB();
            SQL = "DELETE FROM movies WHERE MOVIE_NAME = ?";
            preparedStatement = con.prepareStatement(SQL);
            preparedStatement.setString(1, txtDeleteName.getText());
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
//shows movie list
    @FXML
    void DisplayMovieList(ActionEvent event) throws IOException {
        Parent MoviePage = FXMLLoader.load(getClass().getResource("MovieList.fxml"));
        Scene MovieScene = new Scene(MoviePage);
        Stage page = (Stage) ((Node) event.getSource()).getScene().getWindow();
        page.setScene(MovieScene);
        page.show();
    }
}
