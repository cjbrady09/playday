import java.util.ArrayList;

/**
 * The Class Node. The primary purpose of Node objects are to keep track
 * of a particular state and other relevant features in the search tree that go
 * with it such as a reference to this node's parent, the path costs, and so on.
 * For a simple application like this, this could easily be rolled into the State
 * class, but I keep them separate to drive home the distinction made by the textbook
 * between states and nodes.
 * 
 * @author Eric D. Manley
 */
public class Node {
		
	/** the state associated with this node */
	private State myState;
	/** the step cost between the action of placing the last tile on the current list */
	private double stepCost;
	/** the total cost of the entire set of placed tiles */
	private double pathCost;
	/** a reference to this node's parent in case traversing the tree from bottom to top is necessary */
	private Node parent;
	
	/**
	 * Instantiates a new Node
	 * 
	 * @param s the state
	 * @param sc the step cost
	 * @param pc the path cost
	 * @param p the parent Node
	 */
	public Node(State s, double sc, double pc, Node p)
	{
		myState = s;
		stepCost = sc;
		pathCost = pc;
		parent = p;
	}
	

	/**
	 * getter method for the state
	 * 
	 * @return the state
	 */
	public State getState() {
		return myState;
	}

	/**
	 * getter method for the step cost
	 * 
	 * @return the step cost
	 */
	public double getStepCost() {
		return stepCost;
	}

	/**
	 * getter method for the path cost
	 * 
	 * @return the path cost
	 */
	public double getPathCost() {
		return pathCost;
	}

	/**
	 * getter method for the parent reference
	 * 
	 * @return the parent reference
	 */
	public Node getParent() {
		return parent;
	}
	
	/**
	 * Expands this node in the search tree. This essentially uses
	 * the generateSuccessors function for the state to create all child
	 * nodes. If the State and Node classes were combined, we wouldn't need
	 * the extra overhead for this, but it helps keep the role of the states
	 * and nodes distinct in our heads.
	 * 
	 * @return a list of the child nodes
	 */
	public ArrayList<Node> expand()
	{
		//first get the successor states
		ArrayList<State> childStates = myState.generateSuccessors();
		//the return list
		ArrayList<Node> childNodes = new ArrayList<Node>();
		//create a node for each child state
		for(State cs : childStates)
		{
			double cStepCost = cs.costOfLastTilePlaced();
			Node cn = new Node(cs,cStepCost,pathCost+cStepCost,this);
			childNodes.add(cn);
		}
		return childNodes;
	}

}
