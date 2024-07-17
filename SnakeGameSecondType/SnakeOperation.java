package SnakeGameSecondType;
 
import java.util.Queue;
import java.util.LinkedList;
import java.util.*;
 class Pair<k,v>
{
    public k key;
    public v value;

    public Pair(k key, v value)
    {
        this.key = key;
        this.value = value;
    }
    public k getKey()
    {
        return key;
    }

    public v getValue()
    {
        return value;
    }
}
public class SnakeOperation {

    public char[][]board;
    public Queue<Pair<Integer,Integer>>Snakelocations;
   // public Stack<Pair<Integer,Integer>>snakestack;
    public SnakeOperation(int n, int m) {
       this.board = new char[n][m];
       for(char[] onerow : board)
       {
           for(int j=0;j<onerow.length;j++)
           {
               onerow[j]='0';   
           }

       }
        this.Snakelocations = new LinkedList<>();
       // this.snakestack = new Stack<>();
        board[0][0]='.';
        board[1][2] = 'X';
        board[3][3] = 'X';
    }

    public void snakeMovings(int i, int j) {
        Scanner sc = new Scanner(System.in);
        Snakelocations.add(new Pair<>(i,j));
        
       // snakestack.add(new Pair<>(i,j));
        
        int currentrow=i,currentcol=j;
        //while loop
        while(true)
        {
            display();
            System.out.println("Enter the location");
            String next = sc.next();

            // int row = Snakelocations.peek().getKey();
            // int col = snakestack.peek().getValue();
            int row = currentrow,col= currentcol;

            if(next.equalsIgnoreCase("up"))
            row--;
            else if(next.equalsIgnoreCase("down"))
            row++;
            else if(next.equalsIgnoreCase("left"))
            col--;
            else if(next.equalsIgnoreCase("right"))
            col++;
            else{
            System.out.println("invalid locations");
            continue;
            }

            if(checklocations(row,col))
            {
                if(board[row][col]=='X')
                {
                    currentrow=row;
                    currentcol = col;
                    Snakelocations.add(new Pair<>(row, col));
                    board[row][col]='.';
                }
                else
                {
                   Pair<Integer,Integer>q = Snakelocations.poll();
                   board[q.getKey()][q.getValue()]='0';
                   Snakelocations.add(new Pair<>(row,col));
                   board[row][col]='.';
                   currentrow = row;
                   currentcol = col;


                }
            }
            else
            {
                System.out.println("Game over");
                break;
            }

        }
        sc.close();
    }

    private boolean checklocations(int row, int col) {
        
        if(row<0 || row>=board.length || col<0 || col>=board[0].length  || board[row][col]=='.')
        return false;

        return true;
    }

    public void display()
    {
        for(char[] onerow : board)
        {
            for(int j=0;j<onerow.length;j++)
            {
                System.out.print(onerow[j]+ " ");   
            }
            System.out.println();

        }

         
    }
    
}
