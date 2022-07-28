package pkg12thproject;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmployerMain {
    @FXML // Add scene
    void DisplayAdPage(ActionEvent event) throws IOException {
        Parent AddMoviePage = FXMLLoader.load(getClass().getResource("AddMovie.fxml"));
        Scene AddMovieScene = new Scene(AddMoviePage);
        Stage page = (Stage) ((Node) event.getSource()).getScene().getWindow();
        page.setScene(AddMovieScene);
        page.show();
    }

    @FXML // Edit Scene
    void DisplayEdPage(ActionEvent event) throws IOException {
        Parent EdMoviePage = FXMLLoader.load(getClass().getResource("EditMovie.fxml"));
        Scene EdMovieScene = new Scene(EdMoviePage);
        Stage page = (Stage) ((Node) event.getSource()).getScene().getWindow();
        page.setScene(EdMovieScene);
        page.show();

    }

    @FXML //Delete Scene
    void DisplayDelPage(ActionEvent event) throws IOException {
        Parent DelMoviePage = FXMLLoader.load(getClass().getResource("DeleteMovie.fxml"));
        Scene DelMovieScene = new Scene(DelMoviePage);
        Stage page = (Stage) ((Node) event.getSource()).getScene().getWindow();
        page.setScene(DelMovieScene);
        page.show();

    }
}
