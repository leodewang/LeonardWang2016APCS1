import java.util.Arrays;

public class Split 
{

	public static void main(String[] args) 
	{
		//String.split();
		//It's a method that acts on a string, <StringName>.split(<String sp>);
		//Where sp is the string where the string splits
		//And it returns an array
		System.out.println(Arrays.toString("I like apples!".split(" "))); 
		//		it will split at spaces and return an array of ["I","like","apples!"]
		// Example 2: "I really like really red apples"split("really")
		//		it will split at the word "really" and return an array of ["I "," like "," apples!"]
		
		//play around with String.split! what happens if you "I reallyreally like apples".split("really") ?
		
		
		//Your task:
		/*Write a method that take in a string like "applespineapplesbreadlettustomatobaconmayohambreadcheese" describing a sandwich
		 * use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
		 * What if it's a fancy sandwich with multiple pieces of bread?
		*/
		splitBread("breadapplebreadyogurtyabreadhibread");
		
		//Your task pt 2:
		/*Write a method that take in a string like "apples pineapples bread lettus tomato bacon mayo ham bread cheese" describing a sandwich
		 * use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of the sandwich and ignores what's on the outside
		 * Again, what if it's a fancy sandwich with multiple pieces of bread?
		*/

		

	}


public static void splitBread(String breadStatement){
	int counter = 0;
	int numberOfBreads = 0;
	String search = "bread";
	String[] bread = breadStatement.split("bread");
//	while(breadStatement.contains("bread")){
//		breadStatement.replaceFirst("bread"," ");
//		System.out.println(breadStatement);
//		numberOfBreads++;
//	}	
	//doesnt work, cant get the numberOfBreads
//	for(int i = 1; i < numberOfBreads; i++){
//		System.out.println(bread[i-1]);
//	}
	//DOESNT WORK UNTIL WE CAN FIND HOW TO GET NUMBER OF BREADS
		if(bread.length == 2){
			String breadMiddleStatement = bread[1];
			System.out.println(breadMiddleStatement);
		}
		if(bread.length == 3){
			String breadMiddleStatement1 = bread[1];
			String breadMiddleStatement2 = bread[2];
			System.out.println(breadMiddleStatement1);
			System.out.println(breadMiddleStatement2);
		}
		if(bread.length == 4){
			String breadMiddleStatement1 = bread[1];
			String breadMiddleStatement2 = bread[2];
			String breadMiddleStatement3 = bread[3];
			System.out.println(breadMiddleStatement1);
			System.out.println(breadMiddleStatement2);
			System.out.println(breadMiddleStatement3);
		}
	//if there is no "bread" before this start here.
	//if there is no bread after this end here
}
}

