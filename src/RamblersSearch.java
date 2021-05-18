
public class RamblersSearch extends Search{
	
	
	private TerrainMap map;
	private Coords goal;
	/*
	     * this static variable is used to test the efficiency of different estRemCost in Astar.
	     * the String variables options:
	     * the Manhattan Distance
	     * the Euclidean distance
	     * the height difference
	     */
    	public static final String heuristicsMethod = "Other";
	//public static final String heuristicsMethod = "MD";
	//public static final String heuristicsMethod = "ED";
	//public static final String heuristicsMethod = "HD";
	
	public TerrainMap getTerrainMap() {
		return this.map;
	}
	
	public Coords getYforsearch() {
		return this.goal;
	}
	
	
	
	public RamblersSearch(TerrainMap m, Coords g) {
		map = m;
		goal = g;
	}
	
	
}


