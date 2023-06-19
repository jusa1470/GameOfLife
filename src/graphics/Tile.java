package graphics;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import enums.Status;

public class Tile extends JPanel {

	private static final long serialVersionUID = 1L;
	private Status currentStatus;
	private Status nextStatus;

	public Tile(Color color) {
		super();
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setPreferredSize(new Dimension(30, 30));
		this.setOpaque(true);
		this.setBackground(color);
		
		if (color == Color.black) {
			this.currentStatus = Status.LIVE;
		}
		else {
			this.currentStatus = Status.DEAD;
		}
	}
	
	public void setCurrentStatus() {
		this.currentStatus = this.nextStatus;
		this.setBackground(this.nextStatus.getValue());
	}
	
	public Status getCurrentStatus() {
		return this.currentStatus;
	}
	
	public void setNextStatus(Status status) {
		this.nextStatus = status;
	}
	
	public Status getNextStatus() {
		return this.nextStatus;
	}

}
