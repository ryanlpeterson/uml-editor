import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("UML Editor - by fiVe");

		//Eric- grid is the workspace, probably should subclass Pane so we can customize it
		Pane grid = new Pane();
		grid.getStyleClass().add("noGrid");
		
		//Eric- need to implement a better way of tracking all boxes - maybe http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/SingleSelectionModel.html
		ArrayList<Box> allBoxes = new ArrayList<Box>();
		
		//Eric- borderpane holds the elements (menu, toolbar, grid)
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(grid);
		borderPane.setTop(new FileMenu());
		borderPane.setLeft(new ContextMenu(grid, allBoxes));
		

		Scene scene = new Scene(borderPane, 1200, 800);
		scene.getStylesheets().add("style.css");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}