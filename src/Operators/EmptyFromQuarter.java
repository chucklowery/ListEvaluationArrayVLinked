package Operators;

import java.util.List;

public class EmptyFromQuarter implements ListOperator {

    @Override
    public void perform(List<?> toEmpty) {
        toEmpty.remove(toEmpty.size() / 4);
    }

    @Override
    public String getName() {
        return "Quarter (Size / 4)";
    }
}
