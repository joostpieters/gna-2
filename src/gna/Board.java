package gna;

import java.util.*;

public class Board
{
	private int[][] tiles;
	public int manhattan, hamming;
	// construct a board from an N-by-N array of tiles
	public Board( int[][] tiles ) {
		this.tiles = new int[tiles.length][tiles[0].length];
		for (int i = 0; i < tiles.length; i++)
			this.tiles[i] = Arrays.copyOf(tiles[i], tiles[i].length);
		this.manhattan = manhattan();
		this.hamming = hamming();
		}
	// return number of blocks out of place
	public int hamming() {
		int wrong = 0;
		for (int x = 0; x < tiles.length ; x++) {
			for (int y = 0; y < tiles[x].length ; y++) {
				if ((3*x) + y + 1 != tiles[x][y]) {
					if (tiles[x][y] != 0) {
						wrong += 1;
					}
				}
			}

		}
		return wrong;
	}

	// return sum of Manhattan distances between blocks and goal
	public int manhattan() {
		int wrong = 0;
		int leng = tiles.length;
		int max = leng * leng;
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles[x].length; y++) {
				int current = tiles[x][y];
				int currentrow = tiles.length;
				int targetx, targety;
				if( current != 0){
					if (current <= leng){
						targetx = 0;
						targety = current -1;
					}else{
						while (current < (currentrow - 1) * leng)
							currentrow -= 1;
						targetx = currentrow - 1;
						targety = leng - (((currentrow * leng) - current) + 1);
					}
					wrong += Math.abs(targetx - x) + Math.abs(targety - y);
				}
			}
		}
		return wrong;
	}



	// Does this board equal y. Two boards are equal when they both were constructed
	// using tiles[][] arrays that contained the same values.
	@Override
	public boolean equals(Object y)
	{
		if ( !(y instanceof Board) )
			return false;

		Board other = (Board)y;
		return Arrays.deepEquals(tiles, other.tiles);
	}

	// Since we override equals(), we must also override hashCode(). When two objects are
	// equal according to equals() they must return the same hashCode. More info:
	// - http://stackoverflow.com/questions/27581/what-issues-should-be-considered-when-overriding-equals-and-hashcode-in-java/27609#27609
	// - http://www.ibm.com/developerworks/library/j-jtp05273/
    @Override
    public int hashCode()
	{
		return Arrays.deepHashCode(tiles);
	}

	// return a Collection of all neighboring board positions
	public Collection<Board> neighbors() {
		List<Board> neighbours = new ArrayList<Board>();
		for (int x = 0; x < tiles.length ; x++) {
			for (int y = 0; y < tiles[x].length ; y++) {
				if (tiles[x][y] == 0){
					if ( x + 1 <= tiles.length - 1){
						Board bord1 = new Board(tiles);
						int temp;
						temp = bord1.tiles[x][y];
						bord1.tiles[x][y] = bord1.tiles[x+1][y];
						bord1.tiles[x+1][y] = temp;
						boolean b = neighbours.add(bord1);
					}if ( x - 1 >= 0){
						Board bord2 = new Board(tiles);
						int temp;
						temp = bord2.tiles[x][y];
						bord2.tiles[x][y] = bord2.tiles[x-1][y];
						bord2.tiles[x-1][y] = temp;
						neighbours.add(bord2);
					}if ( y + 1 <= tiles.length - 1){
						Board bord3 = new Board(tiles);
						int temp;
						temp = bord3.tiles[x][y];
						bord3.tiles[x][y] = bord3.tiles[x][y+1];
						bord3.tiles[x][y+1] = temp;
						neighbours.add(bord3);
					}if ( y - 1 >= 0){
						Board bord4 = new Board(tiles);
						int temp;
						temp = bord4.tiles[x][y];
						bord4.tiles[x][y] = bord4.tiles[x][y-1];
						bord4.tiles[x][y-1] = temp;
						neighbours.add(bord4);
					}
				}
				}
			}

		return(neighbours);
	}
	// return a string representation of the board
	public String toString(){
		StringBuilder string =new StringBuilder(); //new char[tiles.length * tiles.length];
		for (int x = 0; x < tiles.length ; x++) {
			for (int y = 0; y < tiles[x].length ; y++) {
				string.append(tiles[x][y]);
			}
		}
		return string.toString();
	}


	// is the initial board solvable?
	public boolean isSolvable()
	{
		throw new RuntimeException("not implemented"); // TODO
	}

}

