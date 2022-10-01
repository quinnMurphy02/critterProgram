import java.awt.Color;
import java.util.Random;




public class Lion extends Critter {
	
	private int count; // initialize count and color
	private Color firstColor;
	
	
	
	public Lion() {
		this.count = 0;
		
	}
	
	
	
	public Action getMove(CritterInfo info) {
		
        if(info.getFront() == Neighbor.OTHER) { // if enemy in front, infect
        	return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL) { // if wall, left
        	return Action.LEFT;
        	}
        	else if(info.getRight() == Neighbor.WALL) { // if wall is to the right, go left
        		return Action.LEFT;
        	}
         else if (info.getFront() == Neighbor.SAME) { // if a lion is in front, go right
        	return Action.RIGHT;
        } else { // otherwise hop
        	return Action.HOP;
        }
		
    }

    public Color getColor() {
    	this.count = this.count + 1; // count increase for each getColor() call
    	
    	if((this.count - 1) % 3 == 0) { // after color for 3 moves, change color
    		Color randomColor = getDifferentColor();
    		this.firstColor = randomColor; // firstColor is the new color now
    		return randomColor;
    	} else {
    		return this.firstColor; // otherwise return current color
    	}
    	
    	
      
    }

    public String toString() {
        return "L";
    }
    
    public Color getDifferentColor() {
    	Random random = new Random();
    	int answer = random.nextInt(3); // random number generator
    	if(answer == 0) { 
    		return Color.RED;
    	} else if(answer == 1) { // pretty simple, number corresponds to color
    		return Color.GREEN;
    	} else if(answer == 2) {
    		return Color.BLUE;
    		
    	} else {
    		return null;
    	}
    	
    	
    }

}
