import java.util.Arrays;

public class testSomeStuff {

	public static void main(String[] args) {
		int [] arr = {2, 4, 6, 8, 20};
		int counter = 0;
		for(int n:arr){
			if(n %4== 0){
				counter++;
			}
		}
		System.out.println(counter);
	
//	for(int i = 0; i < arr.length; i++){
//		arr[i] = arr[i] + 5;
//	}
//	System.out.println(Arrays.toString(arr));
}
}