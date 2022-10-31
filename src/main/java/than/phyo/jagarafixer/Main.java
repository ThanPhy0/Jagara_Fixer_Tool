package than.phyo.jagarafixer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import than.phyo.jagarafixer.view.UIController;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(UIController.class.getResource("UI.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(UIController.class.getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

}
