package SnakeandLadder;
 
public  class Dice {
 
     int dices;
    public Dice(int dices)
    {
        this.dices = dices;
    }

    public  int Rolldices()
    {
        int value = (int) (Math.random()*(6*dices-1*dices+1))+1;

        return value;
    }
}
