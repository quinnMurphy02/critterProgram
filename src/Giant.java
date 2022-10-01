import java.awt.Color;



public class Giant extends Critter {
	
	// Author: Quinn Murphy
	// Date: 10/1/22
	// Class: CS145
	// Giant class
	// Has an array of names and an index to keep track of 
	// the moves. The names will be displayed in order 
	// every 6 moves. Has a pretty short getMove() class.
	
	private int count; // count for fee fie foe fum
	private final String[] names = { "fee", "fie", "foe", "fum" }; // names of the giants
	private int index; // index for array
	private String oldName; // previous name

	public Giant() {
		this.count = 0; // giving class the count and index
		this.index = 0;

	}

	public Action getMove(CritterInfo info) { // pretty simple
		if (info.getFront() == Neighbor.OTHER) { // if there is enemy in front, infect
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.EMPTY) { // if no wall/enemy in front, hop
			return Action.HOP;
		} else {
			return Action.RIGHT; // go right
		}

	}

	public Color getColor() { // giant will be gray
		return Color.GRAY;
	}

	public String toString() { // count will increase for each toString() call
		this.count = this.count + 1;
		if ((this.count - 1) % 6 == 0) { // after 6 moves, reset count/index to 0
			if (this.index == 4) {
				this.index = 0; // reseting index... array will be set to 0 (fee)
			}

			this.index = this.index + 1; // index increase by 1 for each move
			return names[index - 1].toString(); // return the string the index corresponds to

		} else {
			this.oldName = names[index - 1];
		}
		return this.oldName;
	}

}
