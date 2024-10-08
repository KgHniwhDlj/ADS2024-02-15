package by.it.group351001.radzetskii.lesson09;

import javax.lang.model.element.Element;
import java.util.*;

public class ListC<E> implements List<E> {

    //Создайте аналог списка БЕЗ использования других классов СТАНДАРТНОЙ БИБЛИОТЕКИ
    private static int capacity=10;
    private int size=0;
    private E[] myList;

    public ListC() {
        this(capacity);
    }
    public ListC(int newSize){
        if (newSize>capacity){
            capacity=2*newSize;
        }
        myList=  (E[]) new Object[newSize];
    }
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    //////               Обязательные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    @Override
    public String toString() {
        StringBuilder stringBuilder= new StringBuilder();
        stringBuilder.append('[');
        for (int i=0;i<size;i++) {
            stringBuilder.append(myList[i]);
            if (i!=size-1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');

        return stringBuilder.toString();
    }

    @Override
    public boolean add(E e) {
        if (size == myList.length) {
            E[] newList = (E[]) new Object[size * 2];
            System.arraycopy(myList, 0, newList, 0, size);
            myList = newList;
        }
        myList[size]=e;
        size++;
        return true;
    }

    @Override
    public E remove(int index) {
        if (index<0 || index>=size){
            return null;
        }

        E res=(E)myList[index];
        for (int i=index+1;i<size;i++){
            myList[i-1]=myList[i];
        }
        size--;
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int index, E element) {
        if ((index < 0) || (index >= size())) {
            return;
        }

        if (size == myList.length) {
            E[] newList = (E[]) new Object[size * 2];
            System.arraycopy(myList, 0, newList, 0, size);
            myList = newList;
        }
        size++;
        for (int i = size() - 1; i > index; i--) {
            myList[i] = myList[i - 1];
        }
        myList[index]=element;

    }

    @Override
    public boolean remove(Object o) {
        for (int i=0;i<size();i++){
            if (Objects.equals(o,get(i))){
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size()) {
        return null;
        }
        E elem = (E) myList[index];

        myList[index]=element;
        return elem;
    }


    @Override
    public boolean isEmpty() {
        if (size()==0){
            return true;
        }
        return false;
    }


    @Override
    public void clear() {
        myList = (E[]) new Object[capacity];

        size = 0;
    }

    @Override
    public int indexOf(Object o) {
        for (int i=0;i<size();i++){
            if (Objects.equals(o,get(i))){
               return i;
            }
        }
        return -1;
    }

    @Override
    public E get(int index) {
        if  (index < 0 || index >= size()){
        return null;}
        return (E)myList[index];
    }

    @Override
    public boolean contains(Object o) {
        for (int i=0;i<size();i++){
            if (o.equals(myList[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i=size()-1;i>=0;i--){
            if (Objects.equals(o,get(i))){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element:c){
            if (!contains(element)){
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {

            boolean flag=false;
            for  (Object elem : c ){
                add((E)elem);
                flag=true;
            }

        return flag;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        boolean flag=false;
        for (Object element:c){
            add(index,(E) element);
            index++;
            flag=true;
        }
        return flag;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean flag = false;

        for (int i = 0; i < size; i++) {
            if (c.contains(myList[i])) {
                remove(i);
                i--;
                flag = true;
            }
        }

        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean flag = false;

        for (int i = 0; i < size; i++) {
            if (!c.contains(myList[i])) {
                remove(i);
                i--;
                flag = true;
            }
        }

        return flag;
    }

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    //////               Опциональные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    ////////        Эти методы имплементировать необязательно    ////////////
    ////////        но они будут нужны для корректной отладки    ////////////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    @Override
    public Iterator<E> iterator() {
        return null;
    }

}