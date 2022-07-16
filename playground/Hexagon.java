package byog.lab5;

import byog.TileEngine.TETile;


public class Hexagon {
    /** 返回size = i的hexagon，第i行的width。*/
    public static int hexRowWidth(int s, int i) {
        int factor = i;
        if (i >= s) {
            factor = 2*s - 1 - i;
        }
        return s + 2*factor;
    }

    /**返回第i行最左边的tile的横坐标。（纵坐标就依次+1.）*/
    public static int hexRowOffset(int s, int i) {
        int factor = i;
        if (i >= s) {
           factor = 2*s - 1 - i;
        }
        return -factor;
    }
    /** Adds a row of the same tile.*/
    public static void addRow(TETile[][] world, Position p, int width, TETile t) {
        for (int xi = 0; xi < width; xi +=1) {
            int xcor = p.x + xi;
            int ycor = p.y;
            world[xcor][ycor] = TETile.colorVariant(t, 32, 32, 32, RANDOM);
        }
    }

    public static void addHexagon(TETile[][] world, Position p, int s, TETile t) {
        for (int rowth = 0; rowth < 2*s; rowth += 1) {
            int width = hexRowWidth(s, rowth);
            int xStart = p.x + hexRowOffset(s, rowth);
            int yStart = p.y + rowth;
            Position rowStartP = new Position(xStart, yStart);
            addRow(world, rowStartP, width, t);
        }
    }
}
