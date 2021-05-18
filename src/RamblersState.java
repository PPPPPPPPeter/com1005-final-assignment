import java.util.ArrayList;

public class RamblersState extends SearchState {
    private Coords coords;

    public RamblersState(Coords c, int lc, int rc) {
        coords = c;
        localCost = lc;
        estRemCost = rc;
    }

    public Coords getCoords() {
        return coords;
    }
    @Override
    boolean goalPredicate(Search searcher) {
        RamblersSearch ramblersSearcher = (RamblersSearch) searcher;
        Coords goal = ramblersSearcher.getGoal();
        return coords.getx() == goal.getx() && coords.gety() == goal.gety();
    }

    @Override
    ArrayList<SearchState> getSuccessors(Search searcher) {
        RamblersSearch ramblersSearcher = (RamblersSearch) searcher;
        TerrainMap map = ramblersSearcher.getMap();
        int[][] tmap = map.getTmap();
        int width = map.getWidth();
        int depth = map.getDepth();
        ArrayList<SearchState> succs = new ArrayList<>();
        int x = coords.getx();
        int y = coords.gety();
        int gx = ramblersSearcher.getGoal().getx();
        int gy = ramblersSearcher.getGoal().gety();
        if (x + 1 < width) {
            int lc = 1;
            if (tmap[y][x+1] > tmap[y][x]) {
                lc += tmap[y][x+1] - tmap[y][x];
            }
            succs.add(new RamblersState(new Coords(y, x+1), lc, getRC(x+1, y, gx, gy, tmap)));
        }
        if (x - 1 >= 0) {
            int lc = 1;
            if (tmap[y][x-1] > tmap[y][x]) {
                lc += tmap[y][x-1] - tmap[y][x];
            }
            succs.add(new RamblersState(new Coords(y, x-1), lc, getRC(x-1, y, gx, gy, tmap)));
        }
        if (y + 1 < depth) {
            int lc = 1;
            if (tmap[y+1][x] > tmap[y][x]) {
                lc += tmap[y+1][x] - tmap[y][x];
            }
            succs.add(new RamblersState(new Coords(y+1, x), lc, getRC(x, y+1, gx, gy, tmap)));
        }
        if (y - 1 >= 0) {
            int lc = 1;
            if (tmap[y-1][x] > tmap[y][x]) {
                lc += tmap[y-1][x] - tmap[y][x];
            }
            succs.add(new RamblersState(new Coords(y-1, x), lc, getRC(x, y-1, gx, gy, tmap)));
        }
        return succs;
    }

    @Override
    boolean sameState(SearchState n2) {
        RamblersState ramblersState = (RamblersState) n2;
        return coords.getx() == ramblersState.getCoords().getx() && coords.gety() == ramblersState.getCoords().gety();
    }

    public String toString() {
        return "Map State: (" + coords.gety() + ", " + coords.getx() + ")";
    }
     /*
     * get different estRemCost of Astar.
     * 
     */

    public int getRC(int x, int y, int gx, int gy, int[][] tmap) {
        int rc = 0;
        if ("MD".equals(RamblersSearch.heuristicsMethod)) {
            rc = Math.abs(y + x - gx - gy);
        } else if ("ED".equals(RamblersSearch.heuristicsMethod)) {
            rc = (int)(Math.pow((x - gx), 2) + Math.pow((y - gy), 2));
        } else if ("HD".equals(RamblersSearch.heuristicsMethod)) {
            rc = 1 + (tmap[y][x] < tmap[gy][gx] ? (tmap[gy][gx] - tmap[y][x]) : 0);
        } else {
            rc = Math.abs(y + x - gx - gy) + (tmap[y][x] < tmap[gy][gx] ? (tmap[gy][gx] - tmap[y][x]) : 0);
        }
        return rc;
    }
}
