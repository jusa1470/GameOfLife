package graphics;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import game.StartListener;
import game.StopListener;
import utils.Constants;

public class BoardLayout extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	public StartListener startListener;
	public StopListener stopListener;
	private Grid grid;

	public BoardLayout() {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setSize(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
		
		// Add Start Button
		startListener = new StartListener();
		this.add(new Button("Start", startListener));
		
		// Add Grid
		grid = new Grid();
		this.add(grid);
		
		// Add Stop Button
		stopListener = new StopListener();
		this.add(new Button("Stop", stopListener));
	}

	@Override
	public void run() {
		while (true) {
			while (!startListener.getHasStarted()) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			startListener.resetHasStarted();
			while (!stopListener.getHasStopped()) {
				grid.updateTiles();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			stopListener.resetHasStopped();
		}
	}

}
