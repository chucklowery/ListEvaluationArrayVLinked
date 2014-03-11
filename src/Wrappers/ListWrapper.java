package Wrappers;


import Operators.ListOperator;
import java.util.List;

public abstract class ListWrapper<T extends List> {

    T list;

    public abstract void construct(int size, Object toFill);

    public void apply(ListOperator op) {
        op.perform(list);
    }

    public boolean isNotEmpty() {
        return !list.isEmpty();
    }

    public void clear() {
        list = null;
    }

    protected void fill(int size, Object o) {
        for (int i = 0; i < size; i++) {
            list.add(o);
        }
    }
    
    public abstract String getName();
}
