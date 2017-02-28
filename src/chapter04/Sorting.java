package chapter04;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import static org.junit.Assert.assertArrayEquals;

public class Sorting{
	
	@Test
	public void sortInts(){
		final int[] numbers = { -3, -5, -7, 8, 3, 0, 4};
		final int[] excepted = { -7, -5, -3, 0, 3, 4, 8};
		Arrays.sort(numbers);
		assertArrayEquals(numbers, excepted);
	}
	
    @Test
    public void sortObjects() {
        final String[] strings = {"z", "x", "y", "abc", "zzz", "zazzy"};
        final String[] expected = {"abc", "x", "y", "z", "zazzy", "zzz"};

        Arrays.sort(strings);
        assertArrayEquals(expected, strings);
    }
	
    private static class NotComparable {
        private int i;
        private NotComparable(final int i) {
            this.i = i;
        }
    }

    @Test
    public void sortNotComparable() {
        final List<NotComparable> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(new NotComparable(i));
        }

        try {
            Arrays.sort(objects.toArray());
        } catch (Exception e) {
            // correct behavior ¨C cannot sort
            return;
        }

        fail();
    }
    
	@Test
    public void custumSorting(){
    	final List<Integer> numbers = Arrays.asList(4, 8, 5, 3, 1, 6, 7);
    	final List<Integer> expected = Arrays.asList(8, 7, 6, 5, 4, 3, 1);
    	
    	Collections.sort(numbers, new ReverseNumericalOrder());
    	assertEquals(expected, numbers);
    }
    
}