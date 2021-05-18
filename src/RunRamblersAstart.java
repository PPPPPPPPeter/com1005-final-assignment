import java.util.ArrayList;
import java.util.Random;

public class RunRamblersAstart {
    public static void main(String[] arg) {

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
        for (Coords c :goals) {
            System.out.println("Goal : (" + c.gety() + "," + c.getx() + ")");
            RamblersSearch searcher = new RamblersSearch(map1, c);
            SearchState initState = (SearchState) new RamblersState(new Coords(0, 0), 0, 0);
            float res = searcher.runSearchE(initState, "AStar");
            System.out.println("Efficiency " + res);
        }
    }

    static boolean inGoals(Coords c, ArrayList<Coords> goals) {
        for (Coords item : goals) {
            if (c.getx() == item.getx() && c.gety() == item.gety()) {
                return true;
            }
        }
        return false;
    }
}
