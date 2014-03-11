package Wrappers;


import java.util.ArrayList;

public class ArrayListWrapper extends ListWrapper<ArrayList> {

    @Override
    public void construct(int size, Object toFill) {
        list = new ArrayList(size);
        fill(size, toFill);
    }

    @Override
    public String getName() {
        return "Array";
    }

}
