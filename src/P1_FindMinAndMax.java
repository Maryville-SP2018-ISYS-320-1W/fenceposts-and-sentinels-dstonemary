/*
	ISYS 320
	Name(s):
	Date: 
*/

import java.util.Scanner;

public class P1_FindMinAndMax {

	public static void main(String[] args) {
        Scanner console = new Scanner( System.in );
        System.out.print("Type a number (or -1 to stop): ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int temp = 0;
        while(console.hasNextInt()){
        	temp = console.nextInt();
        	if(temp == -1)
        		break;
        	else{
        		if(temp >= max)
        			max = temp;
        		else
        			if(temp <= min)
        				min = temp;
        		 System.out.print("Type a number (or -1 to stop): ");
        	}
        		
        }
        System.out.println( "Maximum was " + max );
        System.out.println( "Minimum was " + min );
    }

}
