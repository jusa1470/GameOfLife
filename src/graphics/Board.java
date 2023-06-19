package graphics;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import utils.Constants;

public class Board extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public Board() {
		// Set any settings
		super("Game Of Life");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
		this.getContentPane().setBackground(Color.blue);
		
		// Set main screen box layout
		this.setLayout(new GridBagLayout());
		
		// Add the board panel
		BoardLayout boardLayout = new BoardLayout();
		this.add(boardLayout);
		Thread t = new Thread(boardLayout);
		t.start();
	}
		
}
