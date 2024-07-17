package SnakeandLadder;
import java.util.*;

public class Board {
    
    Queue<Players> players;
    Dice dice;
    Map<Integer,Integer>positons;
    int boardsize = 25;
    public Board( Queue<Players> players,Dice dice , Map<Integer,Integer>positons)
    {
        this.players = players;
        this.dice= dice;
        this.positons = positons;
    }


    public void game()
    {

        while(true){
             
         Players playerss = players.poll();
        int currentPosition = playerss.playersPosition;
      
        int nextpostion = dice.Rolldices();

        currentPosition +=nextpostion;
             
        if(currentPosition > boardsize){
        System.out.println(playerss.name +"Exceted the size of board");
        players.offer(playerss);
        }
        else if(currentPosition == boardsize){
        System.out.println(playerss.name+" won the game ");
        break;
        
        }
        else
        {
               
                 if(positons.containsKey(currentPosition))
                 {
                    int value = positons.get(currentPosition);
                    if(value > currentPosition)
                    {
                        System.out.println(playerss.name + " you have got ladder ");
                        playerss.playersPosition = value;
                    }
                    else{
                        System.out.println(playerss.name + " you have bitten by snake");
                        playerss.playersPosition = value;
                    }
                 }
                 else
                 {
                    playerss.playersPosition = currentPosition;
                 }
                 System.out.println(playerss.name + " u have moved to " + playerss.playersPosition);
                players.offer(playerss);
        }

        }

    }
}
