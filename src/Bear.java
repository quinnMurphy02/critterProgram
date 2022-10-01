import java.awt.Color;



public class Bear extends Critter {
	private boolean polar;
	private int myCount; // initialize boolean for color, and count
	
	
	public Bear(boolean polar) {
		this.polar = polar;
		this.myCount = 0;
		
		
	}
	
	
	public Action getMove(CritterInfo info) {
		
		if (info.getFront() == Neighbor.OTHER) { // if enemy is in front, infect
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) { // if there is no enemy or wall, hop
            return Action.HOP;
        } else { // otherwise turn left
        	return Action.LEFT;
        }
    }
    

		 

		public Color getColor() {
			if(polar) { // if polar is true, bear is white
			return Color.WHITE;
		} else { // if polar is false, bear if black
			return Color.BLACK;
		}

		 
		}

		 

		public String toString() {
			this.myCount = this.myCount+1; // count increases for each toString() call
			if(myCount % 2 == 1) { // if count is even or odd number, / or \\ is returned
				return "/";
			} else {
				return "\\";
			}
			
		

		  
		}

}
