package Operators;

import java.util.List;

public class EmptyFromMiddle implements ListOperator {

    @Override
    public void perform(List<?> toEmpty) {
        toEmpty.remove(toEmpty.size() / 2);
    }

    @Override
    public String getName() {
        return "Middle (Size /2)";
    }
}
