package gna;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import libpract.PriorityFunc;



import static org.junit.Assert.*;
import org.junit.Test;

/**
 * A number of JUnit tests for Solver.
 *
 * Feel free to modify these to automatically test puzzles or other functionality
 */
public class UnitTests {
  
  @Test
  public void test() {
    //int[][] bord = new int[][]
    Board board1 = new Board(new int[][]{{7,0,8},{ 3,4,5},{ 6,1,2}});
    Board board2 = new Board(new int[][]{{7,8,5},{ 3,4,2},{ 6,0,1}});
    Board board3 = new Board(new int[][]{{7,8,5},{ 3,0,4},{ 6,1,2}});
    Board board4 = new Board(new int[][]{{1,6,3},{ 4,0,2},{ 5,8,7}});
    Board board5 = new Board(new int[][]{{1,6,3},{ 4,5,2},{ 0,8,7}});
    System.out.println(board1.manhattan());
    System.out.println(board2.manhattan());
    System.out.println(board3.manhattan());

    //Solver solver = new Solver(board1,PriorityFunc.MANHATTAN);
    //System.out.println(solver);

    /*PriorityQueue<Board> queue = new PriorityQueue<>(100, comparator);
    queue.add(board1);
    System.out.println(board1.hamming());
    System.out.println(queue.peek().hamming());
    System.out.println(queue);
    queue.add(board2);
    System.out.println(board2.hamming());
    System.out.println(queue.peek().hamming());
    System.out.println(queue);
    queue.add(board3);
    System.out.println(board3.hamming());
    System.out.println(queue.peek().hamming());
    System.out.println(queue);
    queue.add(board4);
    System.out.println(board4.hamming());
    System.out.println(queue.peek().hamming());
    System.out.println(queue);
    queue.add(board5);
    System.out.println(board5.hamming());
    System.out.println(queue.peek().hamming());
    System.out.println(queue);

    queue.poll();
    System.out.println(queue.peek().hamming());
    System.out.println(queue);
    queue.poll();
    System.out.println(queue.peek().hamming());
    System.out.println(queue);
    queue.poll();
    System.out.println(queue.peek().hamming());
    System.out.println(queue);
    queue.poll();
    System.out.println(queue.peek().hamming());
    System.out.println(queue);*/






  }
}
