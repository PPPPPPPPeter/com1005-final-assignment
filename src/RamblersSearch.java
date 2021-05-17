
public class RamblersSearch extends Search{
	
	
	private TerrainMap map;
	private Coords goal;
    	public static final String heuristicsMethod = "Other";
	
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


