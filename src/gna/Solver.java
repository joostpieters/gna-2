package gna;

import java.util.*;

import libpract.PriorityFunc;

public class Solver {
	/**
	 * Finds a solution to the initial board.
	 *
	 * @param priority is either PriorityFunc.HAMMING or PriorityFunc.MANHATTAN
	 */
	public Queue<Board> solution = new LinkedList<Board>();
	public Solver(Board initial, PriorityFunc priority) {
		// Use the given priority function (either PriorityFunc.HAMMING
		// or PriorityFunc.MANHATTAN) to solve the puzzle.
		if (priority == PriorityFunc.HAMMING) {
			Comparator<Board> comparator = new Comparator<Board>() {
				@Override
				public int compare(Board o1, Board o2) {
					return o1.hamming - o2.hamming;
				}
			};
			PriorityQueue<Board> queue = new PriorityQueue<Board>(100,comparator);
			queue.add(initial);
			loop(queue);
		} else if (priority == PriorityFunc.MANHATTAN) {
			Comparator<Board> comparator = new Comparator<Board>() {
				@Override
				public int compare(Board o1, Board o2) {
					return o1.manhattan - o2.manhattan;
				}
			};
			PriorityQueue<Board> queue = new PriorityQueue<Board>(100,comparator);
			queue.add(initial);
			loop(queue);
		} else {
			throw new IllegalArgumentException("Priority function not supported");
		}
	}
	Set<Board> seen = new HashSet<Board>();
	Board vorige = new Board(new int[][]{{0,0,0},{ 0,0,0},{ 0,0,0}});
	public void loop(PriorityQueue<Board> queue) {
		if (queue.peek().manhattan != 0) {
			//loop(queue);
			vorige = queue.peek();
			solution.add(vorige);
			queue.poll();
			for (Board buur : vorige.neighbors()) {
				if (seen.contains(buur)) {
					//System.out.println("skip");
				}else {
					queue.add(buur);
					seen.add(buur);
				}
			}
				//System.out.println(vorige.toString());
				//System.out.println(vorige.manhattan);
			System.out.println(queue.size());
				//System.out.println(queue);
				loop(queue);
		}
		else {
			System.out.println("klaar");
		}

		/**
		 * Returns a List of board positions as the solution. It should contain the initial
		 * Board as well as the solution (if these are equal only one Board is returned).
		 */

	}
}



