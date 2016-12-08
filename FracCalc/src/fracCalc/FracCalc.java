package fracCalc;
import java.util.Arrays;
//FracCalc1
import java.util.Scanner;

public class FracCalc {
	public static void main(String[] args){
		//Boolean variable to make loop run until user enters quit
		boolean testForWhile = true;
		String userInput = "";
		Scanner scan = new Scanner(System.in);
		while(testForWhile){
			System.out.println("Put in your equation");
			userInput = scan.nextLine();
			//check if the userinput is quit
			if(userInput.equals("quit")){
				testForWhile = false;
			}else{
				System.out.println(produceAnswer(userInput));
			}
		}
	}
	public static String produceAnswer(String input){ 
		//split the string based on the spaces
    	String[] splitString = input.split(" ");
    	String firstOperand = splitString[0];
    	String operator = splitString[1];
    	String secondOperand = splitString[2];
    	int [] operandOne = new int[3];
    	int [] operandTwo = new int[3];
    	int []result = new int[2];
    	//Sets the whole number, numerator, and denominator into an int Array
    	//Order is whole number first, then numerator, then denominator
    	operandOne = parseOperands(firstOperand);
    	operandTwo = parseOperands(secondOperand);
    	//change the int arrays into improper fractions, also int array
    	int []improperFracOperandOne = toImproperFrac(operandOne[0], operandOne[1], operandOne[2]);
    	int []improperFracOperandTwo = toImproperFrac(operandTwo[0], operandTwo[1], operandTwo[2]);
    	//check the operators to call different methods
    	if(operator.equals("/")){
    		result = divideAnswer(improperFracOperandOne[0], improperFracOperandOne[1], improperFracOperandTwo[0], improperFracOperandTwo[1]);
    	}else if(operator.equals("*")){
    		result = multiplyAnswer(improperFracOperandOne[0], improperFracOperandOne[1], improperFracOperandTwo[0], improperFracOperandTwo[1]);
    	} else if(operator.equals("+")){
    		result = addAnswer(improperFracOperandOne[0], improperFracOperandOne[1], improperFracOperandTwo[0], improperFracOperandTwo[1]);
    	} else{
    		result = subtractAnswer(improperFracOperandOne[0], improperFracOperandOne[1], improperFracOperandTwo[0], improperFracOperandTwo[1]);
    	}
    	//Uses the result and change it into a mixed number
    	int[] mixedNum = toMixedNum(result[0], result[1]);
    	//
    	if(mixedNum[1] < 0 && mixedNum[2] < 0){
    		mixedNum[1] = mixedNum[1] * -1;
    		mixedNum[2] = mixedNum[2] * -1;
    	}else if(mixedNum[0] >= 0 && mixedNum[1] > 0 && mixedNum[2] < 0){
    		mixedNum[2] = mixedNum[2] * -1;
    		mixedNum[1] = mixedNum[1] * -1;
    	}
    	if(mixedNum[0] == 0){
    		return simplifyResult(mixedNum[1], mixedNum[2]);
    	}else{
    		String wholeNum = mixedNum[0] + "";
    		if(simplifyResult(mixedNum[1], mixedNum[2]).equals("0")){
    			return wholeNum;
    		}else{
    			return wholeNum + "_" + simplifyResult(mixedNum[1], mixedNum[2]);
    		}
    	}
    		
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
    	return arrayForFraction;
    	
    }
    public static int[] toImproperFrac(int wholeNum, int numerator, int denominator){
    	if(wholeNum < 0){
    		numerator = wholeNum*denominator - numerator;
    	}else{
    		numerator = (wholeNum*denominator) + numerator;
    	}
		int [] numAndDem = new int[2];
		numAndDem[0] = numerator;
		numAndDem[1] = denominator;
		return numAndDem;
	}
    public static int[] addAnswer(int num1, int dem1, int num2, int dem2){
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

public static int[] subtractAnswer(int num1, int dem1, int num2, int dem2){
	dem2 = dem2*-1;
	return addAnswer(num1, dem1, num2, dem2);
}
public static int[] multiplyAnswer(int num1, int dem1, int num2, int dem2){
	int[] numAndDem = new int[2];
	int finalDem = dem1*dem2;
	int finalNum = num1*num2;
	numAndDem[0] = finalNum;
	numAndDem[1] = finalDem;
	return numAndDem;
}
public static int[] divideAnswer(int num1, int dem1, int num2, int dem2){
	int placeHolderForSecondNumerator = num2;
	num2 = dem2;
	dem2 = placeHolderForSecondNumerator;
	return multiplyAnswer(num1, dem1, num2, dem2);
}
public static int greatestCommonFactor(int num1, int num2){
	int biggerNum;
	int smallerNum;
	if(num1 < 0){
		num1 = num1*-1;
	}
	if(num2 < 0){
		num2 = num2*-1;
	}
	if(num1 < num2){
		biggerNum = num2;
		smallerNum = num1;
	} else{
		biggerNum = num1;
		smallerNum = num2;
	}
	if(biggerNum % smallerNum == 0){
		return smallerNum;
	}else{
		return greatestCommonFactor(smallerNum, biggerNum % smallerNum);
	}
}
public static String simplifyResult(int numerator, int denominator){
	if(numerator == 0){
		return "0";
	} 
	int gcf = greatestCommonFactor(numerator, denominator);
	numerator = numerator/gcf;
	denominator = denominator/gcf;
	if(denominator == 1){
		return numerator + "";
	}else{
		return numerator + "/" + denominator;
	}
}
public static int[] toMixedNum(int numerator, int denominator){
	int wholeNumber = numerator/denominator;
	numerator = numerator%denominator;
	if(wholeNumber < 0 && numerator < 0){
		numerator = numerator*-1;
	}
	if(wholeNumber < 0 && denominator < 0){
		denominator = denominator*-1;
	}
	int[] mixedNum = {wholeNumber, numerator, denominator};
	return mixedNum;
}
}

