
public class RamblersSearch extends Search{
	
	
	private TerrainMap ramblersMap;
	private int y;
	private int x;
	
	
	public TerrainMap getTerrainMap() {
		return this.ramblersMap;
	}
	
	public int getYforsearch() {
		return this.y;
	}
	public int getXforsearch() {
		return this.x;
	}
	
	
	public RamblersSearch(TerrainMap map, int y, int x) {
		this.ramblersMap = map;
		this.y = y;
		this.x = x;
	}
	
	
}


