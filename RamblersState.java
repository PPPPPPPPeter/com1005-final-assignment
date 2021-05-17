import java.util.*;



public class RamblersState extends SearchState{
	private int y;
	private int x;
	//the constructor
	public RamblersState(int depth, int width, int heightDifference, String filename) {
		this.y = depth;
		this.x = width;
		//TODO
		TerrainMap mapForDifference = new TerrainMap(filename);
		
		//int [][] arrayForDifference = new int[mapForDifference.getDepth()][mapForDifference.getWidth()];
		
		this.localCost = heightDifference;
	}
	//accessor
	public int getY() {
		return this.y;
	}
	public int getX() {
		return this.x;
	}
	//goalPredicate
	public boolean goalPredicate(Search searcher) {
		RamblersSearch msearch = (RamblersSearch) searcher;
		int theTarY = msearch.getYforsearch();
		int theTarX = msearch.getXforsearch();
		if (this.y == theTarY || this.x == theTarX) {
			return true;
		}
		else {
			return false;
		}
	}
	//getSuccessors
	public ArrayList<SearchState> getSuccessors(Search searcher) {
		ArrayList<SearchState> succs = new ArrayList<>();
		//TODO
		
		
		
		return succs;
	}
	//sameState
	public boolean sameState(SearchState s2) {
		RamblersState ms2 = (RamblersState) s2;
		if (this.y == ms2.getY() || this.x == ms2.getX()) {
			return true;
		}
		else {
			return false;
		}
	}  
	//toString
	public String toString() {
		return "The Rambler state ("+this.y+" , "+this.x+")";
	}
}
