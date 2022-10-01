import java.awt.Color;
import java.util.Random;


public class Orca extends Critter {

	private int count;
	private Color firstColor;

	public Orca() {
		this.count = 0;
	}

	public Action getMove(CritterInfo info) {
		if (info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.EMPTY) {
			return Action.HOP;
		} else if (info.getRight() == Neighbor.WALL) { // if wall is to the right, go left
			return Action.LEFT;
		} else if (info.getFront() == Neighbor.SAME) { // if a orca is in front, go right
			return Action.RIGHT;
		} else {
			return Action.LEFT;
		}
	}

	public Color getColor() {
		this.count = this.count + 1; // count increases for each getColor() call

		if ((this.count - 1) % 5 == 0) { // after color for 5 moves, change color
			Color randomColor = getDifferentColor(); // call getDifferentColor
			this.firstColor = randomColor; // set current color to new random color
			return randomColor; // return new random color
		} else {
			return this.firstColor; // otherwise keep current color
		}

	}

	public String toString() {
		return "Orca"; // name will be Orca
	}

	public Color getDifferentColor() {
		Random random = new Random();
		int answer = random.nextInt(3); // number generator
		if (answer == 0) {
			return Color.MAGENTA; // if number is 0, magenta
		} else if (answer == 1) {
			return Color.ORANGE; // if number is 1, orange
		} else if (answer == 2) {
			return Color.YELLOW; // if number is 2, yellow

		} else {
			return null;
		}

	}

}
