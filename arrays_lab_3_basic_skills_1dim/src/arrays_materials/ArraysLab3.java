package arrays_materials;

import java.util.Arrays;
//Leonard Wang, APCS1, 1st period
public class ArraysLab3 
{
	/*
	 * Write a method named sum that accepts two arrays of integers arr1 and arr2 
	 * and returns an array of integers, 
	 * in which every element is the sum of the elements at that index for the arrays arr1 and arr2. 
	 * You can assume arrays arr1 and arr2 have at least one element each and are the same length.
	 */
	public static int[] sum(int[] arr1, int[] arr2)
	{
		assert (arr1.length > 0);
		assert (arr2.length > 0);
		assert (arr1.length == arr2.length);
		int [] arr3 = new int[arr1.length];
		//Goes through the array and adds each index into a new array at that index
		for(int i = 0; i < arr3.length; i++){
			arr3[i] = arr1[i] + arr2[i];
		}
		return arr3;
		
	}
	
	/*
	 * Write a method named append that accepts an array of integers arr of length n 
	 * and an integer num, and returns an array of integers of length n+1 
	 * that consists of the elements of arr with num appended to the end.  
	 * You can assume array arr has at least one element.
	 */
	public static int[] append(int[] arr, int num)
	{
		assert (arr.length > 0);
		//Makes new array with a length one longer
		int[] arr1 = new int[arr.length+1];
		//Runs loop, if its the last number of the original array, it adds the requested num to it
		for(int i = 0; i < arr1.length; i++){
			if(i == arr1.length-1){
				arr1[i] = num;
			}else{
			arr1[i] = arr[i];
			}
		}
		return arr1;
	}
	
	/*
	 * Write a method named remove that accepts an array of integers arr and an integer idx 
	 * and returns an array of integers consisting of all of the elements of arr 
	 * except for the element at index idx (thus, the returned array has a length of arr.length � 1).  
	 * You can assume arr has at least two elements.
	 */
	public static int[] remove(int[] arr, int idx)
	{
		assert (arr.length >= 2);
		int [] arr1 = new int[arr.length-1];
		//Makes an array one less than its original length
		for(int i = 0 ;i < arr1.length; i++){
			//Runs through this loop and removes whatever index the user requested
			if(i >= idx){
				arr1[i] = arr[i+1];
			}else{
			arr1[i] = arr[i];
			}
		}
		return arr1;
	}
	
	/*
	 * Write a method sumEven that accepts an array of integers arr 
	 * and returns an integer containing the sum of the elements at the even indices of arr.  
	 * (That means elements at indices 0,2,4,6,8.)  You can assume arr has at least one element.
	 */
	public static int sumEven(int[] arr)
	{
		assert (arr.length > 0);
		int sum = 0;
		for(int i = 0; i < arr.length; i++){
			//Checks if it is even, if it is, adds the number to a counter variable, which is the sum in this case
			if(i%2==0){
				sum += arr[i];
			}
		}
		return sum;
	}
	
	/*
	 * Write a method rotateRight that accepts an array of integers arr 
	 * and does not return a value.  
	 * The rotateRight method moves each element of arr one index to the right 
	 * (element 0 goes to element 1, element 1 goes to element 2, �, element n-1 goes to element 0).  
	 * You can assume arr has at least one element.
	 */
	public static void rotateRight(int[] arr)
	{
		int [] arr2 = new int[arr.length];
		//Makes a copy of the original array
		for(int i = 0; i < arr.length; i++){
			arr2[i] = arr[i];
		}
		assert (arr.length > 0);
		for(int i = 0 ; i < arr2.length; i++){
			//Sets the first number to the end and everything else one to the right
			if(i == 0){
				arr[i] = arr2[arr2.length-1];
			} else{
				arr[i] = arr2[i-1];
			}
		}
	}

	/*
	 * Write a main method that will 
		Contain
			integer arrays a1, a2, sumArr, appendArr, removeArr
			int variables appendNum, removeIdx, sumOfEvens
		Carry out the following actions
			Declare array a1 containing the values (5, 10, 15, 20, 25, 30, 35, 40) 
			and array a2 containing the values (7, 14, 21, 28, 35, 42, 49, 56)
			Form sumArr by calling the sum method with a1 and a2 as inputs
			Declare int appendNum and set it to 200.
			Form appendArr by calling the append method with a1 and appendNum as inputs
			Declare int removeIdx and set it to 5.
			Form removeArr by calling remove with a2 and removeIdx
			Form sumOfEvens by calling sumEven with appendArr as the input
			Call rotateRight with a1 as the input
			On their own lines print out (use Arrays.toString to transform arrays into a printable strings) :
				sumArr
				appendArr
				removeArr
				sumOfEvens (an int you don�t need Arrays.toString)
				a1
	 */
	
	public static void main(String[] args) 
	{
		//Couples of tests
		int[] a1 = {5, 10, 15, 20, 25, 30, 35, 40};
		int [] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		int [] sumArr = sum(a1, a2);
		int appendNum = 200;
		int[] appendArr = append(a1, appendNum);
		int removeldx = 5;
		int[] removeArr = remove(a2, removeldx);
		int sumOfEvens = sumEven(appendArr);
		rotateRight(a1);
		System.out.println(Arrays.toString(sumArr));
		System.out.println(Arrays.toString(appendArr));
		System.out.println(Arrays.toString(removeArr));
		System.out.println(sumOfEvens);
		System.out.println(Arrays.toString(a1));
	}
}
