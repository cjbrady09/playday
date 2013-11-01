import java.util.ArrayList;

/**
 * The Class State. Instances of this class represent partial solutions
 * to the number-tile-sequence search problem discussed in class. These states are
 * determined by an ordered list of currently placed tiles as well as a 
 * "pile" of unplaced tiles. Methods are included for generating successor
 * states, checking for goal states, and determining the cost of the most
 * recently placed tile.
 * 
 * @author Eric D. Manley
 */
public class State {
	
	/** The ordered list of placed tiles. The tile at index 0 is the top tile and it grows down with increasing index. */
	private ArrayList<Tile> placedTiles;
	
	/** The pile of unplaced tiles. An ordered array list data structure is used, but it need not be ordered for the problem */
	private ArrayList<Tile> unplacedTiles;
	
	/**
	 * Instantiates a new state.
	 *
	 * @param p the placed tiles for this state. This constructor does not make a copy of the arrayList,
	 * 	so if a copy is needed, it should be done before calling this constructor.
	 * @param u the unplaced tiles for this state. This constructor does not make a copy of the arrayList,
	 * 	so if a copy is needed, it should be done before calling this constructor.
	 */
	public State(ArrayList<Tile> p, ArrayList<Tile> u)
	{
		placedTiles = p; 
		unplacedTiles = u;
	}
	
	/**
	 * Checks if this state is a goal state
	 * 
	 * @return a boolean indicating whether or not this is a goal state
	 */
	public boolean isGoal()
	{
		return unplacedTiles.isEmpty();
	}
	
	
	/**
	 * Calculates the penalty incurred between the last two tiles in the placedTiles list.
	 * 
	 * @return a double representing the cost of the last tile in the ArrayList placedTiles
	 * 		as determined by its penalty from the second to last tile. If there are fewer than
	 * 		two tiles, there is no cost associated, so we return 0.0
	 */
	public double costOfLastTilePlaced()
	{
		double rVal = 0.0; //return value defaults to 0.0 if 1 or 0 tiles
		int sz = placedTiles.size();
		if(sz>=2)
		{	//placedTiles.get(sz-1) - last tile; placedTiles.get(sz-2) - second to last tile
			rVal = placedTiles.get(sz-1).penaltyIfPrevTile(placedTiles.get(sz-2));
		}
		return rVal;
	}
	
	
	/**
	 * Computes all successor states. Here, the actions are the choices of which tile
	 * to place next.
	 * 
	 * @return a list of states that can be formed by removing one tile from the 
	 * 		unplaced list and putting at the end of the placed list
	 */
	public ArrayList<State> generateSuccessors()
	{
		//the list of child states to be returned, initially empty
		ArrayList<State> children = new ArrayList<State>();
		
		//go through all of the unplaced tiles and generate the successor from
		//the action of placing that tile
		for(int i = 0; i < unplacedTiles.size(); i++)
		{
			//the new ArrayLists for the child state are clones of those in this state
			//so that we can change it without affecting the current state
			ArrayList<Tile> childPlacedTiles  = new ArrayList<Tile>(placedTiles);
			ArrayList<Tile> childUnplacedTiles = new ArrayList<Tile>(unplacedTiles);
			//remove ith unplaced tile and add it to the placed tiles
			childPlacedTiles.add(childUnplacedTiles.get(i));
			childUnplacedTiles.remove(i);
			//instantiate the new state and add it to the return list
			State child = new State(childPlacedTiles,childUnplacedTiles);
			children.add(child);
		}
		return children;
	}
	
	/**
	 * A toString function for used when printing the states nicely.
	 * This merely concatenates the toString results from each of the tiles.
	 * 
	 * @return a string representing the list of placed tiles
	 */
	public String toString()
	{
		String r = "";
		for(Tile t : placedTiles)
		{
			r += t;
		}
		return r;
	}

}
