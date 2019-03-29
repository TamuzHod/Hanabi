package app;

public enum Card {
	RED_ONE      (1, Color.RED),
	RED_TWO      (2, Color.RED),
	RED_THREE    (3, Color.RED),
	RED_FOUR     (4, Color.RED),
	RED_FIVE     (5, Color.RED),
	YELLOW_ONE   (1, Color.YELLOW),
	YELLOW_TWO   (2, Color.YELLOW),
	YELLOW_THREE (3, Color.YELLOW),
	YELLOW_FOUR  (4, Color.YELLOW),
	YELLOW_FIVE  (5, Color.YELLOW),
	BLUE_ONE     (1, Color.BLUE),
	BLUE_TWO     (2, Color.BLUE),
	BLUE_THREE   (3, Color.BLUE),
	BLUE_FOUR    (4, Color.BLUE),
	BLUE_FIVE    (5, Color.BLUE),
	WHITE_ONE    (1, Color.WHITE),
	WHITE_TWO    (2, Color.WHITE),
	WHITE_THREE  (3, Color.WHITE),
	WHITE_FOUR   (4, Color.WHITE),
	WHITE_FIVE   (5, Color.WHITE),
	GREEN_ONE    (1, Color.GREEN),
	GREEN_TWO    (2, Color.GREEN),
	GREEN_THREE  (3, Color.GREEN),
	GREEN_FOUR   (4, Color.GREEN),
	GREEN_FIVE   (5, Color.GREEN),
	MULTICOLOR_ONE   (1, Color.MULTICOLOR),
	MULTICOLOR_TWO   (2, Color.MULTICOLOR),
	MULTICOLOR_THREE (3, Color.MULTICOLOR),
	MULTICOLOR_FOUR  (4, Color.MULTICOLOR),
	MULTICOLOR_FIVE  (5, Color.MULTICOLOR);
	
	public final int number;
	public final Color color;
	
	Card(int number, Color color) {
		this.number = number;
		this.color = color;
	}
}
