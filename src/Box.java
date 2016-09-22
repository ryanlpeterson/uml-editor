import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Box extends Rectangle {
	//Eric- maybe instance variable, maybe find better selection tracking method
	boolean isSelected = false;

	//Eric- this constructor is shit
	//Eric- whatever is tracking all selectable objects should probably be instance variable, yes? right now just passing in allBoxes
	//Eric- also don't want to have to pass in the ContextMenu, probably want a specified controller that links the ContextMenu to each box
	public Box(int x, int y, int h, int w, Pane grid, ArrayList<Box> allBoxes, ContextMenu bar) {
		super(x, y, h, w);
		setFill(null);
		setId("rect");
		allBoxes.add(this);
		
		//Eric- box corner jumps to cursor on drag, need to fix that
		setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				grid.getStyleClass().remove("noGrid");
				grid.getStyleClass().add("grid");
				double x = event.getX();
				double y = event.getY();
				setX(Math.floorDiv((int) x, 20) * 20);
				setY(Math.floorDiv((int) y, 20) * 20);
			}
		});
		
		setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				grid.getStyleClass().add("noGrid");				
			}
		});
		
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				//Eric- check if anything else was previously selected - again, we should implement better selection tracking, needs to work for boxes and relationships
				for(Box b : allBoxes){
					b.isSelected = false;
					b.setStroke(null);
				}
				isSelected = true;
				setStroke(Color.WHITE);
				//Eric -this is a shit call to a shit method - don't like passing allBoxes and grid all the time all elements should have access to key objects all the time
				bar.createDeleteButton(allBoxes, grid);
			}
		});
	}	
	
}
