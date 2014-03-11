package Wrappers;

import java.util.LinkedList;

public class LinkedListWrapper extends ListWrapper<LinkedList> {

    @Override
    public void construct(int size, Object toFill) {
        list = new LinkedList();
        fill(size, toFill);
    }

    @Override
    public String getName() {
        return "Linked";
    }

}
