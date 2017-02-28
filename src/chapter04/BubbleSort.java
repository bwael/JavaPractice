package chapter04;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class BubbleSort{
	
	public void bubbleSort(int[] numbers){
		boolean numSwitched;
		do{
			numSwitched = false;
			for(int i = 0; i < numbers.length - 1; i++){
				if(numbers[i+1] < numbers[i]){
					int temp = numbers[i+1];
					numbers[i + 1] = numbers[i];
					numbers[i] = temp;
					numSwitched = true;
				}
			}
		}while(numSwitched);
	}
	
	@Test
	public void testBubble(){
		final int[] numbers = { -3, -5, -7, 8, 3, 0, 4};
		final int[] excepted = { -7, -5, -3, 0, 3, 4, 8};
		bubbleSort(numbers);
		assertArrayEquals(numbers, excepted);
	}
}