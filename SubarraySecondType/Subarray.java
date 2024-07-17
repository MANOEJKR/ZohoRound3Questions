package SubarraySecondType;

import java.util.*;
public class Subarray {
    
  //  @SuppressWarnings("removal")
    public static void main(String[] args) {
        
        int []que={35,145,67,1004,88,456,2034};
        int validnumber=8,windowsize=3;
        List<List<Integer>>allsubarray = new ArrayList<>();
        List<Integer>maxunitdigits = new ArrayList<>();
        List<List<Integer>>vaildsubarray = new ArrayList<>();
        List<List<Integer>>invalidsubarray = new ArrayList<>();
        int start=0,end=0;
        List<Integer>temp = new ArrayList<>();
        while(end<que.length)
        {
                temp.add(que[end]);

                if(temp.size()==windowsize)
                {
                    maxunitdigits.add(calculatemaxunitdigits(temp,windowsize,validnumber,vaildsubarray,invalidsubarray));
 
                   List<Integer> deepCopyListOne = new ArrayList<>(temp);
                    allsubarray.add(deepCopyListOne);  

                    temp.remove(0);
                    
                }
                end++;
        }

        for(int i=0;i<maxunitdigits.size();i++)
        {
            System.out.println(allsubarray.get(i) + " " + maxunitdigits.get(i));
        }

        System.out.println("validsubarray");
        for(List<Integer> list: vaildsubarray)
        System.out.println(list);

        System.out.println();
        System.out.println("Invalidsubarray");
        for(List<Integer> list: invalidsubarray)
        System.out.println(list);

    }

     

    private static Integer calculatemaxunitdigits(List<Integer> temp,int windowsize,int validnumber,List<List<Integer>>validsubarray , List<List<Integer>>invalidsubarray) {
        
        int position=1;
        int reversednumber=0;
        Integer ans=0;
        boolean checkvalidnumber=false;
        while(position<=10)
        {
            int maxx=-1;
            for(int i=0;i<temp.size();i++)
            {
                maxx=Math.max(maxx,unitdigit(temp.get(i),position));
            }
            if(maxx!=-1)
                reversednumber = reversednumber*10+maxx;
            else
            { 
                 break;
            }  
            position++;
            
        }
                 while(reversednumber>0)
                {
                    ans=ans*10+(Integer)reversednumber%10;
                    reversednumber/=10;
                }

                for (int num : temp) {
                    if (containsValidNumber(num, validnumber)) {
                        checkvalidnumber = true;
                        break;
                    }
                }
        
                List<Integer> deepCopyListOne = new ArrayList<>(temp);
                if (checkvalidnumber) {
                    validsubarray.add(deepCopyListOne);
                } else {
                    invalidsubarray.add(deepCopyListOne);
                }
                
                return ans;
       
    }
    private static boolean containsValidNumber(int number, int validnumber) {
        while (number > 0) {
            int last = number % 10;
            if (last == validnumber) {
                return true;
            }
            number /= 10;
        }
        return false;
    }
    private static int unitdigit(Integer number, int position) {
        int count=0;

        while(number>0)
        {
            count++;
            int last=number%10;
            number/=10;
            
            if(count==position)
            return last;
        }
        return -1;
    }
}
