/**
 * The Class Tile. Instances of this class represent a single tile in the
 * number-tile-sequence search problem discussed in class. Each has four numbers
 * referred to as a, b, c, and d.
 * 
 * @author Eric D. Manley
 */
public class Tile {
	
	/** the first of the four values on the tile */
	private double a;
	/** the second of the four values on the tile */
	private double b;
	/** the third of the four values on the tile */
	private double c;
	/** the fourth of the four values on the tile */
	private double d;
	
	/**
	 * Instantiates a new tile.
	 *
	 * @param ia the first value for this tile
	 * @param ib the second value for this tile
	 * @param ic the third value for this tile
	 * @param id the fourth value for this tile
	 */
	public Tile(double ia, double ib, double ic, double id)
	{
		a = ia;
		b = ib;
		c = ic;
		d = id;
	}
	
	/**
	 * getter method for a
	 * 
	 * @return the a value
	 */
	public double getA(){ return a; }
	
	/**
	 * getter method for b
	 * 
	 * @return the b value
	 */
	public double getB(){ return b; }
	
	/**
	 * getter method for c
	 * 
	 * @return the c value
	 */
	public double getC(){ return c; }
	
	/**
	 * getter method for d
	 * 
	 * @return the d value
	 */
	public double getD(){ return d; }
	
	
	/**
	 * Calculates the cost of this tile being placed after another given tile.
	 * The cost is the difference between this tile's a and the previous tile's
	 * c plus the difference between this tile's b and the previous tile's d.
	 * 
	 * @param another tile
	 * @return the cost of this tile if it is placed after the given tile
	 */
	public double penaltyIfPrevTile(Tile other)
	{	
		return Math.abs(a-other.c)+Math.abs(b-other.d);
	}
	
	/**
	 * Calculates the cost of this tile being placed before another given tile.
	 * The cost is the difference between this tile's c and the next tile's
	 * a plus the difference between this tile's d and the next tile's b.
	 * 
	 * @param another tile
	 * @return the cost of this tile if it is placed after the given tile
	 */
	public double penaltyIfNextTile(Tile other)
	{
		return Math.abs(other.a-c)+Math.abs(other.b-d);
	}
	
	/**
	 * For pretty printing the tile.
	 * 
	 * @return a string used for pretty printing the tile
	 */
	public String toString()
	{
		return "-------------------------\n|\t"+a+"\t"+b+"\t|\n|\t"+c+"\t"+d+"\t|\n-------------------------\n";
	}

}
