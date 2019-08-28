package tech.hiyinyougen.demo.MyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author yinyg
 * @CreateTime 2019/8/27 10:14
 * @Description
 */
public class MyArrayList<E> implements Iterable<E> {

    private List<E> list;

    public MyArrayList() {
        list = new ArrayList<>();
    }

    public void add(E el) {
        list.add(el);
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator(list);
    }

    public class MyArrayListIterator<E> implements Iterator<E> {

        int indexPosition = 0;

        List<E> internalList;

        public MyArrayListIterator(List<E> internalList) {
            this.internalList = internalList;
        }

        @Override
        public boolean hasNext() {
            return indexPosition + 1 <= internalList.size();
        }

        @Override
        public E next() {
            E el = internalList.get(indexPosition);

            indexPosition++;

            return el;
        }
    }

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
