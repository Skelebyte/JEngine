package JEngine;

import java.util.ArrayList;

public class DArray<T> {

    static int capacity;
    static int count;

    ArrayList<T> internal = new ArrayList<>(1);

    public void init() {
        internal.add(null);
    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public void add(T element) {
        ArrayList<T> temp = internal;

        temp.add(element);
        System.out.println(temp);

        count += 1;
    }

    public T get(int index) {
        if(index > count || index < 0) {
            return null;
        }

        return internal.get(index);
    }

    public int count() {
        count = capacity;
        return count;
    }
}
