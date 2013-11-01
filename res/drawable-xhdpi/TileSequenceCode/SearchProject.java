
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Class SearchProject. This class is intended to be a collection of static methods
 * implementing various search algorithms on the numbered-tile-sequence problem from class.
 * 
 * The code for breadth-first search has been given. You need to implement the others.
 * 
 * The other two search methods I have implemented
 *
 * I did assist Time Alguire with this assignment on the UCS algorithm.  No solutions were shared
 * between us, but I did walk him through how I conceptualized the project, and assisted him when
 * he got stuck or had errors.  I had him draw several search trees on paper and walk through
 * step by step how to solve it (I can submit a few if you would like to see how I helped him). 
 * I can provide more information on how I helped if you need it but again no completed solutions
 * were shared.
 *
 * @author Clayton Brady
 */
public class SearchProject {
	
	
	/**
	 * Takes a file with a list of tiles and puts them into an ArrayList of 
	 * Tile instances that can be used with the search algorithms. Each line of the file
	 * will have four doubles on it representing the four numbers for a tile. No other punctuation 
	 * is used - just whitespace for separation.
	 * 
	 * @param filename the name of the file
	 * @return an ArrayList of Tile instances from the file.
	 */
	public static ArrayList<Tile> getTilesFromFile(String filename)
	{
		//initially empty tile set
		ArrayList<Tile> tileSet = new ArrayList<Tile>();
		//scanner for reading input file
		Scanner scan;
	    File file = new File(filename);
	    try {
	        scan = new Scanner(file);

	        //really, this should stop when it gets to  the end-of-file
	        while(scan.hasNextDouble())
	        {
	        	//read in all four doubles on this line and call the Tile constructor
	        	Tile t = new Tile(scan.nextDouble(),scan.nextDouble(),scan.nextDouble(),scan.nextDouble());
	        	//add it to the tile set
	            tileSet.add(t);
	        }

	    } catch (FileNotFoundException e1) {
	            e1.printStackTrace();
	    }
	    return tileSet;
	}
	
	/**
	 * Performs a breadth-first search of the tile-sequence problem.
	 * The best solution and its cost are output.
	 * 
	 * @param filename containing the tile set to search on
	 */
	public static void BFS(String filename)
	{
		//a double-ended queue, when used with "add" and "remove", it's a FIFO queue
		ArrayDeque<Node> fringe = new ArrayDeque<Node>();
		//initial tile set
		ArrayList<Tile> tileSet = getTilesFromFile(filename);
		//start state has no placed tiles, and all tiles are in the unplaced list
		State startState = new State(new ArrayList<Tile>(),tileSet);
		//the node that goes with the start state, it has 0 path and step cost, and a null parent
		Node root = new Node(startState,0.0,0.0,null);
		
		double startTime = System.nanoTime();
		
		//the fringe starts with just the root node
		fringe.add(root);
		//keeps track of generated nodes
		int genNodes=1;
		
		//These are for keeping track of the best solution since
		//we don't just need /a/ solution, we need the best one
		//after generating the whole tree
		double bestCost = Double.MAX_VALUE;
		State bestSolution = null;
		
		//we go until there are no nodes left to be expanded
		while(!fringe.isEmpty())
		{
			//grab the node at the front of the FIFO queue
			Node currNode = fringe.remove();
			
			//if it is a goal state and the path cost is better than the best
			//goal state we've seen so far, it's the new best
			if(currNode.getState().isGoal() && currNode.getPathCost() < bestCost)
			{
				bestCost = currNode.getPathCost();
				bestSolution = currNode.getState();
			}
			
			//generate all child nodes and put them in the fringe 
			//at the back of the FIFO queue
			ArrayList<Node> childNodes = currNode.expand();
			for(Node c : childNodes)
			{
				fringe.add(c);
				genNodes++;
			}
		}
		
		//takes a time stamp after the algorthm is done and calculates the elapsed time in seconds
		double endTime = System.nanoTime();
		double totalTime = (endTime-startTime)/1000000000.0;
		
		
		//print the solution along with the cost
		//you should also print the number of nodes generated and the amount of time it took
		//to perform the search
		System.out.println(bestSolution);
		System.out.println("Cost of best solution: "+bestCost);
		System.out.println("Number of nodes generated: "+genNodes);
		System.out.println("Total run time: "+totalTime+" seconds");
	}
	
	/**
	 * Performs a depth-first search of the tile-sequence problem.
	 * The best solution and its cost are output.
	 * 
	 * @param filename containing the tile set to search on
	 */
	public static void DFS(String filename)
	{
		//a double-ended queue, when used with "push" and "pop", it's a LIFO queue
		ArrayDeque<Node> fringe = new ArrayDeque<Node>();
		//initial tile set
		ArrayList<Tile> tileSet = getTilesFromFile(filename);
		//start state has no placed tiles, and all tiles are in the unplaced list
		State startState = new State(new ArrayList<Tile>(),tileSet);
		//the node that goes with the start state, it has 0 path and step cost, and a null parent
		Node root = new Node(startState,0.0,0.0,null);
		
		double startTime = System.nanoTime();
		
		//the fringe starts with just the root node
		fringe.push(root);
		//keeps track of generated nodes
		int genNodes=1;
		
		//These are for keeping track of the best solution since
		//we don't just need /a/ solution, we need the best one
		//after generating the whole tree
		double bestCost = Double.MAX_VALUE;
		State bestSolution = null;
		
		//we go until there are no nodes left to be expanded
		while(!fringe.isEmpty())
		{
			//grab the node at the top of the stack
			Node currNode = fringe.pop();
			
			//if it is a goal state and the path cost is better than the best
			//goal state we've seen so far, it's the new best
			if(currNode.getState().isGoal() && currNode.getPathCost() < bestCost)
			{
				bestCost = currNode.getPathCost();
				bestSolution = currNode.getState();
			}
			
			//generate all child nodes and put them in the fringe 
			//at the top of the LIFO stack
			ArrayList<Node> childNodes = currNode.expand();
			for(Node c : childNodes)
			{
				fringe.push(c);
				genNodes++;
			}
		}
		
		//takes a time stamp after the algorithm and calculates the elapsed time in seconds
		double endTime = System.nanoTime();
		double totalTime = (endTime-startTime)/1000000000.0;
		
		//print the solution along with the cost
		//you should also print the number of nodes generated and the amount of time it took
		//to perform the search
		System.out.println(bestSolution);
		System.out.println("Cost of best solution: "+bestCost);
		System.out.println("Number of nodes generated: "+genNodes);
		System.out.println("Total run time: "+totalTime+" seconds");
	}
	
	/**
	 * Performs a uniform-cost search of the tile-sequence problem.
	 * The best solution and its cost are output.
	 * 
	 * @param filename containing the tile set to search on
	 */
	public static void UCS(String filename)
	{
		//a double-ended queue, when used with "add" and "remove", it's a FIFO queue
		ArrayDeque<Node> fringe = new ArrayDeque<Node>();
		//a double-ended queue used for determining the order of the queue
		ArrayDeque<Node> newFringe = new ArrayDeque<Node>();
		//initial tile set
		ArrayList<Tile> tileSet = getTilesFromFile(filename);
		//start state has no placed tiles, and all tiles are in the unplaced list
		State startState = new State(new ArrayList<Tile>(),tileSet);
		//the node that goes with the start state, it has 0 path and step cost, and a null parent
		Node root = new Node(startState,0.0,0.0,null);
		
		double startTime = System.nanoTime();
		
		//the fringe starts with just the root node
		fringe.add(root);
		//keeps track of generated nodes
		int genNodes=1;
		int turn=1;
		
		//These are for keeping track of the best solution since
		//we don't just need /a/ solution, we need the best one
		//after generating the whole tree
		double bestCost = Double.MAX_VALUE;
		State bestSolution = null;
		
		//we go until there are no nodes left to be expanded or we have found
		//a goal state, then we must check to see if there are any other paths
		//in the fringe with the same path cost or better
		while(!fringe.isEmpty())
		{
			//grab the node at the front of the FIFO queue
			Node currNode = fringe.remove();
			
			//if it is a goal state and the path cost is better than the best
			//goal state we've seen so far, it's the new best
			if(currNode.getState().isGoal() && currNode.getPathCost() < bestCost)
			{
				bestCost = currNode.getPathCost();
				bestSolution = currNode.getState();
			}
			
			//generate all child nodes and put them in the fringe 
			//at the back of the FIFO queue if there isn't a bestSolution or if 
			//the current node has a pathCost that is less than the best cost
			if(bestSolution == null || currNode.getPathCost()<=bestCost){
				ArrayList<Node> childNodes = currNode.expand();
				for(Node c : childNodes)
				{		
					fringe.add(c);
					genNodes++;	
				}
				//keeps a fringe cost to walk through which element in the fringe has the best cost
				double fringeCost = Double.MAX_VALUE;
				
				//empties out the fringe and places them in the newFringe
				while(!fringe.isEmpty())
				{
					Node newNode = fringe.remove();
					
					//if the newNode has the lowest path cost, then push it to the front of the queue
					if(newNode.getPathCost() < fringeCost)
					{
						newFringe.push(newNode);
						fringeCost=newNode.getPathCost();
					}
					//if the newNode isn't the lowest, then add it to the back of the queue
					else{
						newFringe.add(newNode);
					}
				}
				
				//moves the newly sorted queue into the fringe
				while(!newFringe.isEmpty())
				{
					Node newNode = newFringe.remove();
					fringe.add(newNode);
				}
			}
		}
		
		//takes a time stamp after the algorithm has finished
		double endTime = System.nanoTime();
		
		//finds out how many seconds it took
		double totalTime = (endTime-startTime)/1000000000.0;
		
		
		//print the solution along with the cost
		//you should also print the number of nodes generated and the amount of time it took
		//to perform the search
		System.out.println(bestSolution);
		System.out.println("Cost of best solution: "+bestCost);
		System.out.println("Number of nodes generated: "+genNodes);
		System.out.println("Total run time: "+totalTime+" seconds");
	}
	
	
	/**
	 * You should write your search algorithms in separate static
	 * methods and then test them from the main method for comparison sake.
	 * 
	 * @param args unused
	 */
	public static void main(String[] args)
	{

		SearchProject.DFS("tile2.txt");
		SearchProject.UCS("tile2.txt");		
		SearchProject.BFS("tile2.txt");
	}

}
