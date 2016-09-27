import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ContextMenu extends VBox {

	Controller controller;
	Button delete;
	Button addBox;

	public ContextMenu(Controller c) {
		super();
		
		controller = c;

		setSpacing(10);
		setPadding(new Insets(20, 10, 10, 10));

		addBox = new Button("Create Box");

		addBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Box rect = new Box(20, 20, 141, 241, controller);
				controller.workspace.getChildren().add(rect);

			}
		});
		
		delete = new Button("Delete Box");

		delete.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				controller.deleteSelected();
			}
		});

		getChildren().add(addBox);
		getStyleClass().add("vbox");
	}

	public void showDeleteButton() {
		getChildren().add(delete);
	}
	
	public void hideDeleteButton() {
		getChildren().remove(delete);
	}

}
