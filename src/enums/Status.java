package enums;

import java.awt.Color;

public enum Status {
	LIVE(Color.black),
	DEAD(Color.white);
	Color value;

	Status(Color color) {
		this.value = color;
	}
	
	public Color getValue() {
		return this.value;
	}
}
