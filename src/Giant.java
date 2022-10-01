import java.awt.Color;







public class Giant extends Critter {
	private int count; // count for fee fie foe fum
	private final String[] names = {"fee", "fie", "foe", "fum"}; // names of the giants
	private int index; // index for array
	private String oldName; // previous name
	
	public Giant(){
		this.count = 0; // giving class the count and index
		this.index = 0;
		
	}
	
	
	public Action getMove(CritterInfo info) { // pretty simple
		if(info.getFront() ==  Neighbor.OTHER) { // if there is enemy in front, infect
			return Action.INFECT;
		} else if(info.getFront() == Neighbor.EMPTY){ //if no wall/enemy in front, hop
			return Action.HOP;
		} else {
			return Action.RIGHT; // go right
		}
        
    }

    public Color getColor() { // giant will be gray
        return Color.GRAY;
    }

    public String toString() { // just using the count and index to tell 
    	this.count = this.count + 1; // the computer to loop through the array
    	if((this.count - 1) % 6 == 0) { // and return the value based on the count
    		if (this.index == 4) {
    			this.index = 0; // reseting index... array will be set to 0
    		}
    		
    		this.index = this.index + 1;  // index increase by 1 for each move
    		return names[index - 1].toString(); // return the string the index corresponds to
    		
    	} else {
    		this.oldName = names[index -1];
    	}
        return this.oldName;
    }

}
