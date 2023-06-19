package graphics;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Button extends JPanel {//implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	public Button(String name, ActionListener listener) {
		super();
		this.setOpaque(true);
		this.setBackground(Color.green);
		JButton button = new JButton(name);
		button.addActionListener(listener);
		this.add(button);
	}

}
