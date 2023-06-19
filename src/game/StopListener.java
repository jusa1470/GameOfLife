package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopListener implements ActionListener {
	
	private boolean hasStopped;

	public StopListener() {
		this.hasStopped = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.hasStopped = true;
		System.out.println("BUTTON WAS CLICKED!");
	}
	
	public boolean getHasStopped() {
		return this.hasStopped;
	}
	
	public void resetHasStopped() {
		this.hasStopped = false;
	}

}
