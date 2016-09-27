import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class Controller {

	ContextMenu toolbar;
	FileMenu menu;
	WorkSpace workspace;
	BorderPane ui;
	Box selectedBox = null;

	public Controller() {
		toolbar = new ContextMenu(this);
		menu = new FileMenu();
		workspace = new WorkSpace(this);
		ui = new BorderPane();
		
		ui.setLeft(toolbar);
		ui.setTop(menu);
		ui.setCenter(workspace);
	}

	public void selectBox(Box box) {
		if (selectedBox == null) {
			selectedBox = box;
			box.setStroke(Color.WHITE);
		    toolbar.showDeleteButton();
		} 
		else if (box != selectedBox) {
			selectedBox.setStroke(null);
			selectedBox = box;
			box.setStroke(Color.WHITE);
		}
	}

	public void deleteSelected() {
		if (selectedBox != null) {
			workspace.getChildren().remove(selectedBox);
			toolbar.hideDeleteButton();
			selectedBox = null;
		}
	}
	
	public void deselect() {
		if (selectedBox != null){
			toolbar.hideDeleteButton();
			selectedBox.setStroke(null);
			selectedBox = null;
		}
		
	}

	public void showGrid() {
		workspace.getStyleClass().add("noGrid");
	}

}
