
import Operators.EmptyFromBack;
import Operators.EmptyFromFront;
import Operators.EmptyFromMiddle;
import Operators.EmptyFromQuarter;
import Wrappers.ArrayListWrapper;
import Wrappers.LinkedListWrapper;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static Integer[] generateSizes(int start, int count, double growthRate) {
        Integer[] toReturn = new Integer[count];
        int value = start;
        for (int i = 0; i < count; i++) {
            toReturn[i] = value;
            value *= growthRate;
        }
        Arrays.sort(toReturn, Collections.reverseOrder());
        return toReturn;
    }

    public static void main(String[] size) {
        Integer[] sizes = generateSizes(10000, 20, 1.25);

        System.out.println(Arrays.toString(sizes));
        
        TestList test = new TestList();
        // 2147000000, 156250000, 31250000, ,
        // 3125000, 1250000, 250000, 50000, 10000, 5000, 2000
        // 1250000, 625000, 250000, 125000, 50000, 25000, 10000, 5000, 2000
        test.setSizes(180000000);
        test.setEmptiers(new EmptyFromBack(), new EmptyFromFront(), new EmptyFromMiddle(), new EmptyFromQuarter());
        test.setWrappers(new ArrayListWrapper(), new LinkedListWrapper());
        test.run();
        test.printResults();
    }

}
