/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package checkers;

import checkers.bot.fernandezprudencio.*;
import checkers.bot.gray.GrayRandomBot;
import checkers.exception.BadMoveException;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Optional;

import static org.junit.Assert.*;

public class AppTest {
	@Test
	public void countPiecesTest() {
		CheckersBoard initBoard = CheckersBoard.initBoard();
		assertEquals(12, initBoard.countPiecesOfPlayer(CheckersBoard.Player.BLACK));
		assertEquals(12, initBoard.countPiecesOfPlayer(CheckersBoard.Player.RED));
	}

	@Test
	public void moveTest() {
		CheckersBoard initBoard = CheckersBoard.initBoard();
		try {
			initBoard.processMove(CheckersMove.builder().fromPosition(2, 1).toPosition(3, 0).build());
		} catch (BadMoveException ex) {
			assertEquals("You must move YOUR pieces!", ex.getMessage());
		}
		try {
			initBoard.processMove(CheckersMove.builder().fromPosition(5, 0).toPosition(-1, 4).build());
		} catch (BadMoveException ex) {
			assertEquals("All coordinates must be between [0-7]!", ex.getMessage());
		}
		try {
			initBoard.processMove(CheckersMove.builder().fromPosition(6, 1).toPosition(5, 0).build());
		} catch (BadMoveException ex) {
			assertEquals("You can only move into empty spaces!", ex.getMessage());
		}
		try {
			initBoard.processMove(CheckersMove.builder().fromPosition(5, 2).toPosition(3, 4).build());
		} catch (BadMoveException ex) {
			assertEquals("You can only capture your opponent's pieces!", ex.getMessage());
		}
		try {
			initBoard.processMove(CheckersMove.builder().fromPosition(5, 0).toPosition(3, 6).build());
			fail("An invalid move was accepted!");
		} catch (BadMoveException ex) {
			assertEquals("You can only move 1 space away, or capture 2 spaces away!", ex.getMessage());
		}
	}
	//Successful till now
	@Test
	public void successorsTest() throws BadMoveException {
		FernandezPrudencioBot player3 = new FernandezPrudencioBot();
		CheckersBoard initBoard = CheckersBoard.initBoard();
		NodeBoard rootBoard = new NodeBoard(initBoard);
		//rootBoard.board.printBoard();
		LinkedList<NodeBoard> s = new LinkedList<NodeBoard>(player3.successors(rootBoard));
		//s.forEach(ss -> ss.board.printBoard());
		for (NodeBoard n: s) {
			LinkedList<NodeBoard> s2 = new LinkedList<NodeBoard>(player3.successors(n));
			//s2.forEach(ss -> ss.board.printBoard());
		}
	}
	@Test
	public void whatIsTheInitialPlayerOops() throws BadMoveException {
		FernandezPrudencioBot player3 = new FernandezPrudencioBot();
		CheckersBoard initBoard = CheckersBoard.initBoard();
		NodeBoard rootBoard = new NodeBoard(initBoard);
		//rootBoard.board.printBoard();
		//System.out.println("Initial player: "+rootBoard.initialPlayer);
		LinkedList<NodeBoard> s = new LinkedList<NodeBoard>(player3.successors(rootBoard));
		//s.forEach(ss -> System.out.println("Initial player: "+ss.initialPlayer));
		LinkedList<NodeBoard> s2 = new LinkedList<NodeBoard>(player3.successors(s.removeFirst()));
		//s2.forEach(ss -> System.out.println("Initial player: "+ss.initialPlayer));
		LinkedList<NodeBoard> s3 = new LinkedList<NodeBoard>(player3.successors(s2.removeFirst()));
		//s3.forEach(ss -> System.out.println("Initial player: "+ss.initialPlayer));
		LinkedList<NodeBoard> s4 = new LinkedList<NodeBoard>(player3.successors(s3.removeFirst()));
		//s4.forEach(ss -> System.out.println("Initial player: "+ss.initialPlayer));
		LinkedList<NodeBoard> s5 = new LinkedList<NodeBoard>(player3.successors(s4.removeFirst()));
		//s5.forEach(ss -> System.out.println("Initial player: "+ss.initialPlayer));
		LinkedList<NodeBoard> s6 = new LinkedList<NodeBoard>(player3.successors(s5.removeFirst()));
		//s6.forEach(ss -> System.out.println("Initial player: "+ss.initialPlayer));
		}

		@Test
	public void moveDoneinCheckingAllMoves() throws BadMoveException {
		FernandezPrudencioBot player3 = new FernandezPrudencioBot();
		CheckersBoard initBoard = CheckersBoard.initBoard();
		NodeBoard rootBoard = new NodeBoard(initBoard);
		LinkedList<NodeBoard> s = new LinkedList<NodeBoard>(player3.successors(rootBoard));
		LinkedList<NodeBoard> s2 = new LinkedList<NodeBoard>(player3.successors(s.removeFirst()));
		LinkedList<NodeBoard> s3 = new LinkedList<NodeBoard>(player3.successors(s2.removeFirst()));
		//System.out.println(s3.getFirst().getMoveDone().getEndCol() +" "+s3.getFirst().getMoveDone().getEndRow());
	}


}
