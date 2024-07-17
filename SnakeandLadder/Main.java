package SnakeandLadder;
import java.util.*;
 

/**
 * Main
 */
public class Main {

    
    public static void main(String[] args) {
        
        Queue<Players>players = new LinkedList<>();
        Dice dice  = new Dice(1);
        Map<Integer,Integer>positons= new HashMap<>();
        players.offer(new Players("Manoj") );
        players.offer(new Players("Rahul") );
        players.offer(new Players("Parthiban"));
        players.offer(new Players("Kathir") );
        positons.put(1,10);
        positons.put(20,10);
        
        Board board = new Board(players,dice,positons);
        board.game();
    }
}