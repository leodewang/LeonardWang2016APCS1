package fracCalc;
import java.util.Arrays;
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
    	parseOperands(firstOperand);
    	parseOperands(secondOperand);
		return "s";
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static int[] parseOperands(String operand){
    	String [] splitFraction = operand.split("_");
    	String wholeNum;
    	String numerator; 
    	String denominator;
    	int []arrayForFraction = new int[3];
    	if(splitFraction.length == 2){
    		wholeNum = splitFraction[0];
    		String[] splitAgain = splitFraction[1].split("/");
    		if(splitAgain.length == 1){
    			numerator = splitAgain[0];
    			denominator = "1"; 
    		}else{
    			numerator = splitAgain[0];
    			denominator = splitAgain[1];
    		}
    	} else{
    		wholeNum = "0";
    		String[] splitAgain = splitFraction[0].split("/"); 
    		if(splitAgain.length == 1){
    			numerator = splitAgain[0];
    			denominator = "1"; 
    		}else{
    			numerator = splitAgain[0];
    			denominator = splitAgain[1];
    		}
    	}
    	arrayForFraction[0] = Integer.parseInt(wholeNum);
    	arrayForFraction[1] = Integer.parseInt(numerator);
    	arrayForFraction[2] = Integer.parseInt(denominator);
    	System.out.println(Arrays.toString(arrayForFraction));
    	return arrayForFraction;
    	
    }
    public static int[] toImproperFrac(int wholeNum, int numerator, int denominator){
		numerator = (wholeNum*denominator) + numerator;
		int [] numAndDem = new int[2];
		numAndDem[0] = numerator;
		numAndDem[1] = denominator;
		return numAndDem;
	}
    public static int[] addOrSubtractAnswer(int num1, int dem1, int num2, int dem2){
    	int[] numAndDem = new int[2];
    	int finalDem;
    	int finalNum;
    	if(dem1 != dem2){
    		finalDem = dem1*dem2;
    		finalNum = num1*dem2 + num2*dem1;
    	} else{
    		finalDem = dem1;
    		finalNum = num1 + num2;
    	}
    	numAndDem[0] = finalNum;
    	numAndDem[1] = finalDem;
    	return numAndDem;
    }
}

