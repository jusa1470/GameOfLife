package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartListener implements ActionListener {
	
	private boolean hasStarted;

	public StartListener() {
		hasStarted = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.hasStarted = true;
	}
	
	public boolean getHasStarted() {
		return this.hasStarted;
	}
	
	public void resetHasStarted() {
		this.hasStarted = false;
	}

}
