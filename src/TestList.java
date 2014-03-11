
import Operators.EmptyFromBack;
import Operators.EmptyFromFront;
import Operators.EmptyFromMiddle;
import Operators.EmptyFromQuarter;
import Operators.ListOperator;
import Timer.TimeKey;
import Timer.Timer;
import Wrappers.ArrayListWrapper;
import Wrappers.LinkedListWrapper;
import Wrappers.ListWrapper;
import java.util.Arrays;
import java.util.Map;

/**
 * Test Runtime performance of list data structures
 * <p> This code was prompted by the following 
 * <a href="https://www.youtube.com/watch?v=YQs6IC-vgmo">https://www.youtube.com/watch?v=YQs6IC-vgmo</a>
 * @author Chuck Lowery <chuck.lowery @ gmail.com>
 */
public class TestList {

    public static final Byte TO_STORE = new Byte("1");
    private int[] sizes;

    private ListOperator[] emptiers;
    private ListWrapper[] wrappers;
    Timer timer;

    public void run() {

        for (ListWrapper wrapper : wrappers) {
            for (ListOperator emptier : emptiers) {
                for (int size : sizes) {
                    wrapper.construct(size, TO_STORE);
                    timer.start(new TimeKeyImpl(size, emptier, wrapper));
                    wrapper.apply(emptier);
                    timer.stop();
                    wrapper.clear();
                }
            }
        }
    }

    public TestList() {
        timer = new Timer();
    }

    public void setSizes(int... sizes) {
        this.sizes = sizes;
    }

    public void setEmptiers(ListOperator... emptiers) {
        this.emptiers = emptiers;
    }

    public void setWrappers(ListWrapper... wrappers) {
        this.wrappers = wrappers;
    }

    public void printResults() {
        int[] sortedSizes = Arrays.copyOf(sizes, sizes.length);
        Arrays.sort(sortedSizes);

        Map<TimeKey, Timer.Unit> results = timer.getResults();
        for (ListWrapper wrapper : wrappers) {
            System.out.println("\n\n" + wrapper.getName());
            System.out.println(topRow());
            for (int size : sortedSizes) {
                System.out.println(printResultRow(wrapper, size, results));
            }

        }
    }

    private String printResultRow(ListWrapper wrapper, int size, Map<TimeKey, Timer.Unit> units) {
        String result = String.format("%-10s", size);
        for (ListOperator emptier : emptiers) {

            result += String.format("%20s", units.get(new TimeKeyImpl(size, emptier, wrapper)).getTime());
        }
        return result;
    }

    private String topRow() {
        String result = String.format("%10s", "");
        for (ListOperator emptier : emptiers) {
            result += String.format("%20s", emptier.getName());
        }
        return result;
    }

    public static void main(String[] size) {
        TestList test = new TestList();
        // 2147000000, 156250000, 31250000, 6250000, 
        test.setSizes(1250000, 250000, 50000, 10000, 2000);
        test.setEmptiers(new EmptyFromBack(), new EmptyFromFront(), new EmptyFromMiddle(), new EmptyFromQuarter());
        test.setWrappers(new ArrayListWrapper(), new LinkedListWrapper());
        test.run();
        test.printResults();
    }
}
