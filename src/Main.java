
import Operators.EmptyFromBack;
import Operators.EmptyFromFront;
import Operators.EmptyFromMiddle;
import Operators.EmptyFromQuarter;
import Wrappers.ArrayListWrapper;
import Wrappers.LinkedListWrapper;

public class Main {
    public static void main(String[] size) {
        TestList test = new TestList();
        test.setOperationCount(500);
        test.setSizes(150625000, 78125000, 15625000, 3125000, 1250000, 250000, 50000, 10000);
        test.setEmptiers(new EmptyFromBack(), new EmptyFromFront(), new EmptyFromMiddle(), new EmptyFromQuarter());
        test.setWrappers(new ArrayListWrapper(), new LinkedListWrapper());
        test.run();
        test.printResults();
    }

}
