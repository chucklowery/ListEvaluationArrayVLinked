
import Operators.ListOperator;
import Timer.TimeKey;
import Timer.Timer;
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
    public static final int DEFAULT_EXECUTION_COUNT = 1;
    private int operationCount = DEFAULT_EXECUTION_COUNT;
    public static final Byte TO_STORE = new Byte("1");
    private Integer[] sizes;
    private ListOperator[] emptiers;
    private ListWrapper[] wrappers;
    Timer timer;

    public void run() {
        for (ListWrapper wrapper : wrappers) {
            for (ListOperator emptier : emptiers) {
                for (int size : sizes) {
                    System.gc();
                    timer.start(new TimeKeyImpl(size, emptier, wrapper));
                    wrapper.construct(size, TO_STORE);
                    for(int i = 0; i < operationCount; i++) {
                        wrapper.apply(emptier);
                    }
                    timer.stop();
                    wrapper.clear();
                }
            }
        }
    }

    public TestList() {
        timer = new Timer();
    }

    public void setOperationCount(int operationCount) {
        this.operationCount = operationCount;
    }

    public void setSizes(Integer... sizes) {
        this.sizes = sizes;
    }

    public void setEmptiers(ListOperator... emptiers) {
        this.emptiers = emptiers;
    }

    public void setWrappers(ListWrapper... wrappers) {
        this.wrappers = wrappers;
    }

    public void printResults() {
        Integer[] sortedSizes = Arrays.copyOf(sizes, sizes.length);
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

            result += String.format("%20.2f", (units.get(new TimeKeyImpl(size, emptier, wrapper)).getTime() / (float)1000000));
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
}
