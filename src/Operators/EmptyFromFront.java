package Operators;

import java.util.List;

public class EmptyFromFront implements ListOperator {

    @Override
    public void perform(List<?> toEmpty) {
        toEmpty.remove(0);
    }

    @Override
    public String getName() {
        return "Front (0)";
    }
}
