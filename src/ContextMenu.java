import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

//Eric- may want to look at extending "ToolBar" instead or whatever works better than VBox if that isn't working great
public class ContextMenu extends VBox {
	
	//Eric- Again, see Box class, more shit here - how should we interface all the elements? 
	public ContextMenu(Pane grid, ArrayList<Box> allBoxes) {
		super();
		ContextMenu thisbar = this;

		setSpacing(10);
		setPadding(new Insets(20, 10, 10, 10));

		Button addBox = new Button("Create Box");

		addBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Box rect = new Box(20, 20, 141, 241, grid, allBoxes, thisbar);
				grid.getChildren().add(rect);

			}
		});

		getChildren().add(addBox);
		getStyleClass().add("vbox");
	}

	//Eric- really ugly shit here - just adds delete button if box is selected, currently unselect isn't implemented, so button never goes away
	//Eric- this was quick and dirty, we need better way to implement context menu switching based on selection
	public void createDeleteButton(ArrayList<Box> allBoxes, Pane grid) {
		Button delete = null;
		//Eric- check for delete button already existing
		if (getChildren().size() < 2) {
			delete = new Button("Delete Box");
			getChildren().add(delete);

			delete.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					for (Box b : allBoxes) {
						if (b.isSelected) {
							grid.getChildren().remove(b);
						}
					}
				}
			});
		}
	}

}
