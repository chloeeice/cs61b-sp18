package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

public class Room {
    private Position p;
    private int width;
    private int height;

    /**
     * to draw a room filled with "FLOOR" inside.
     * @param tiles
     * @param p the bottom left position of the room created in tiles.
     * @param width the width of the room created in tiles.
     * @param height the height of the room created in tiles.
     */
    public static void drawRoom(TETile[][] tiles, Position p, int width, int height) {
        int startPosX = p.getX();
        int startPosY = p.getY();
        for (int x = startPosX; x < startPosX + height; x += 1) {
            for (int y = startPosY; y < startPosY + width; y += 1) {
                if (x == startPosX || x == startPosX + height -1 || y == startPosY || y == startPosY + width - 1) {
                    tiles[x][y] = Tileset.WALL;
                } else {
                    tiles[x][y] = Tileset.FLOOR;
                }
            }
        }
    }

    /**
     * to draw L-shaped hallway according to two Position objects.
     * the hallway is built by three pieces of L-shaped halls.
     * The middle hall is filled with "FLOOR", and the left and
     * right hall is filled with "WALL".
     * @param tiles
     * @param p1 the Position object representing one end of the middle hall.
     * @param p2 the Position object representing the other end of the middle hall.
     */
    public static void drawHallway(TETile[][] tiles, Position p1, Position p2) {
        drawLTiles(tiles, p1, p2, Tileset.FLOOR);
        drawLTiles(tiles, p1.move(0, -1), p2.move(-1, 0), Tileset.WALL);
        drawLTiles(tiles, p1.move(0, 1), p2.move(1, 0), Tileset.WALL);
    }

    /**
     * to draw a L-shaped hall.
     * @param tiles
     * @param p1 the Position object representing one end of the hall.
     * @param p2 the Position object representing the other end of the hall.
     * @param t the tile objects used to build the hall.
     */
    private static void drawLTiles(TETile[][] tiles, Position p1, Position p2, TETile t) {
        int Pos1X = p1.getX();
        int Pos1Y = p1.getY();
        int Pos2X = p2.getX();
        int Pos2Y = p2.getY();
        int startPosX = Math.min(Pos1X, Pos2X);
        int sizeX = Math.abs(Pos1X - Pos2X);
        int startPosY = Math.min(Pos1Y, Pos2Y);
        int sizeY = Math.abs(Pos1Y - Pos2Y) + 1;
        // to draw the horizontal line.
        for (int x = startPosX; x < startPosX + sizeX; x +=1) {
            tiles[x][Pos1Y] = t;
        }
        // to draw the vertical line.
        for (int y = startPosY; y < startPosY + sizeY; y +=1) {
            tiles[startPosX + sizeX][y] = t;
        }
    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(60, 30);

        // initialize tiles
        TETile[][] world = new TETile[60][30];
        for (int x = 0; x < 60; x += 1) {
            for (int y = 0; y < 30; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        Position p = new Position(2,4);
        Position p1 = new Position(4,8);
        Position p2 = new Position(7, 2);
        //drawRoom(world, p, 4, 5);
        //drawLTiles(world, p1, p2, Tileset.WATER);
        drawHallway(world, p1, p2);

        // draws the world to the screen
        ter.renderFrame(world);


    }


}
