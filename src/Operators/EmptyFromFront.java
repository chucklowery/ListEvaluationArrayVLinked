package Operators;


import java.util.List;

public class EmptyFromFront implements ListOperator {

    @Override
    public void perform(List<?> toEmpty) {
        while (toEmpty.size() > 0) {
            toEmpty.remove(0);
        }
    }
    
    @Override
    public String getName() {
        return "Front (0)";
    }
}
