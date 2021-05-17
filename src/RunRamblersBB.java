
public class RunRamblersBB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TerrainMap map1 = new TerrainMap("src/tmc.pgm");
		Random random = new Random();
		ArrayList<Coords> goals = new ArrayList<>();
		int num = 10;
		while (num >= 0) {
		    int x = Math.abs(random.nextInt()) % map1.getWidth();
		    int y = Math.abs(random.nextInt()) % map1.getDepth();
		    if (x == 0 && y == 0) {
			continue;
		    }
		    Coords coords = new Coords(y, x);
		    if (!inGoals(coords, goals)) {
			goals.add(coords);
			num--;
		    }
		}
		
	}

}
