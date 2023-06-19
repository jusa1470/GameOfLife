package graphics;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import enums.Status;
import utils.Constants;

public class Grid extends JPanel {

	private static final long serialVersionUID = 1L;
	private int numTiles;

	public Grid() {
		super(new GridLayout(Constants.X_AXIS, Constants.Y_AXIS));
		
		List<Color> list = new ArrayList<Color>();
		list.add(Color.black);
		list.add(Color.white);
		
		this.numTiles = Constants.X_AXIS * Constants.Y_AXIS;
		for (int i = 0; i < numTiles; ++i) {
			Color color = list.get(new Random().nextInt(list.size()));
			this.add(new Tile(color));
		}
	}
	
	public void updateTiles() {
		System.out.println("HELLO");
		for (int i = 0; i < this.numTiles; ++i) {
			Tile tile = (Tile)this.getComponent(i);
			int liveNeighbors = this.getNumberLiveNeighbors(i);
			
			if (tile.getCurrentStatus() == Status.LIVE) {
				if (liveNeighbors < 2 || liveNeighbors > 3) {
					tile.setNextStatus(Status.DEAD);
				}
				else {
					tile.setNextStatus(Status.LIVE);
				}
			}
			else {
				if (liveNeighbors == 3) {
					tile.setNextStatus(Status.LIVE);
				}
				else {
					tile.setNextStatus(Status.DEAD);
				}
			}
		}
		for (int i = 0; i < this.numTiles; ++i) {
			Tile tile = (Tile)this.getComponent(i);
			tile.setCurrentStatus();
		}
	}
	
	public int getNumberLiveNeighbors(int pos) {
		int liveNeighbors = 0;
		
		List<Integer> neighborPos = new ArrayList<Integer>();
		neighborPos.add(pos - Constants.X_AXIS - 1);
		neighborPos.add(pos - Constants.X_AXIS);
		neighborPos.add(pos - Constants.X_AXIS + 1);
		neighborPos.add(pos - 1);
		neighborPos.add(pos + 1);
		neighborPos.add(pos + Constants.X_AXIS - 1);
		neighborPos.add(pos + Constants.X_AXIS);
		neighborPos.add(pos + Constants.X_AXIS + 1);
		
		for (int index : neighborPos) {
			if (index >= 0 && index < this.numTiles) {
				if (((Tile) this.getComponent(index)).getCurrentStatus() == Status.LIVE) {
					++liveNeighbors;
				}
			}
		}
		
		return liveNeighbors;
	}
	
}
