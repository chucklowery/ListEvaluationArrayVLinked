package Operators;

import java.util.List;

public class EmptyFromBack implements ListOperator {

    @Override
    public void perform(List<?> toEmpty) {
        int index = toEmpty.size() > 2 ? toEmpty.size() - 3 : toEmpty.size() - 1;
        toEmpty.remove(index);
    }

    @Override
    public String getName() {
        return "Back (Size - 1)";
    }
}
