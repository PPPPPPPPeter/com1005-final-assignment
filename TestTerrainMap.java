
/**
  * TestTerrainMap.java
  *
  * Phil Green 2013 version
  * Heidi Christensen 2021 version
  * 
  * Example of how you load a terrain map
*/

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestTerrainMap {

  /**
   * constructor, given a PGM image Reads a PGM file. The maximum greyscale value
   * is rescaled to be between 0 and 255.
   * 
   * @param filename
   * @return
   * @throws FileNotFoundException
   */

  public static void main(String[] arg) {

    TerrainMap tm = new TerrainMap("src/tmc.pgm");
    int heightDifference;
    
    int a = tm.getTmap()[7][0];
    int b = tm.getTmap()[15][3];
    System.out.println(a+"  "+b);
    for (int i = 0; i <tm.getDepth(); i++) {
    	for (int j = 0; j <tm.getWidth(); j++) {
    		System.out.println(tm.getTmap()[i][j]);
    		if (tm.getTmap()[i][j]>=tm.getTmap()[i+1][j+1]) {
    			heightDifference = 1;
    			
    		}
    		else {
    			heightDifference = 1 + tm.getTmap()[i+1][j+1] - tm.getTmap()[i][j];
    			
    		}
    		
    	}
    }
  }
}
