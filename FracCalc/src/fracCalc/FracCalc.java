package fracCalc;
//FracCalc1
import java.util.Scanner;

public class FracCalc {
	public static void main(String[] args){
	String userInput = "";
	Scanner scan = new Scanner(System.in);
	while(userInput != "quit"){
	System.out.println("Put in your equation");
	userInput = scan.nextLine();
	System.out.println(produceAnswer(userInput));
	}
	}
	public static String produceAnswer(String input){ 
    	String[] splitString = input.split(" ");
    	String firstOperand = splitString[0];
    	String operator = splitString[1];
    	String secondOperand = splitString[2];
    	String [] splitFirstFraction = firstOperand.split("_");
    	String wholeNum;
    	if(splitFirstFraction.length == 2){
    		wholeNum = splitFirstFraction[0];
    	} else{
    		wholeNum = "0";
    	}
    	return secondOperand;        
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    

}

