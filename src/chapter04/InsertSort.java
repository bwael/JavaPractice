package chapter04;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class InsertSort{
	
	public static List<Integer> insertSort(final List<Integer> numbers){
		final List<Integer> sortedList = new LinkedList<>();
		
		originalList: for(Integer number : numbers){
			for(int i = 0; i < sortedList.size(); i++){
				if(number < sortedList.get(i)){
					sortedList.add(i, number);
					continue originalList;
				}
			}
			sortedList.add(sortedList.size(), number);
		}
		return sortedList;
	}
	
	@Test
	public void testInsert(){
        final List<Integer> numbers = Arrays.asList(6, 4, 9, 5);
        final List<Integer> expected = Arrays.asList(4, 5, 6, 9);

        final List<Integer> actual = insertSort(numbers);
        assertEquals(expected, actual);
	}
}