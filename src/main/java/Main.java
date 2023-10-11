import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

class EnhancedListInJava<T> implements List<T> {

    private final List<T> delegate;

    EnhancedListInJava(List<T> delegate) {
        this.delegate = delegate;
    }

    @NotNull
    public Iterator<T> iterator() {
        return delegate.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        List.super.forEach(action);
    }

    public Spliterator<T> spliterator() {
        return delegate.spliterator();
    }

    public int size() {
        return delegate.size();
    }

    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    public boolean contains(Object o) {
        return delegate.contains(o);
    }

    @NotNull
    public Object[] toArray() {
        return delegate.toArray();
    }

    @NotNull
    @Override
    public <T1> T1[] toArray(@NotNull T1[] a) {
        return delegate.toArray(a);
    }

    @Override
    public <T1> T1[] toArray(IntFunction<T1[]> generator) {
        return List.super.toArray(generator);
    }

    @Override
    public boolean add(T t) {
        return delegate.add(t);
    }

    public boolean remove(Object o) {
        return delegate.remove(o);
    }

    public boolean containsAll(@NotNull Collection<?> c) {
        return delegate.containsAll(c);
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends T> c) {
        return delegate.addAll(c);
    }

    public boolean removeAll(@NotNull Collection<?> c) {
        return delegate.removeAll(c);
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return List.super.removeIf(filter);
    }

    public boolean retainAll(@NotNull Collection<?> c) {
        return delegate.retainAll(c);
    }

    public void clear() {
        delegate.clear();
    }

    public boolean equals(Object o) {
        return delegate.equals(o);
    }

    public int hashCode() {
        return delegate.hashCode();
    }

    public Stream<T> stream() {
        return delegate.stream();
    }

    public Stream<T> parallelStream() {
        return delegate.parallelStream();
    }

    public boolean addAll(int index, @NotNull Collection<? extends T> c) {
        return delegate.addAll(index, c);
    }

    public void replaceAll(UnaryOperator<T> operator) {
        delegate.replaceAll(operator);
    }

    public void sort(Comparator<? super T> c) {
        delegate.sort(c);
    }

    public T get(int index) {
        return delegate.get(index);
    }

    public T set(int index, T element) {
        return delegate.set(index, element);
    }

    public void add(int index, T element) {
        delegate.add(index, element);
    }

    public T remove(int index) {
        return delegate.remove(index);
    }

    public int indexOf(Object o) {
        return delegate.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return delegate.lastIndexOf(o);
    }

    @NotNull
    public ListIterator<T> listIterator() {
        return delegate.listIterator();
    }

    @NotNull
    public ListIterator<T> listIterator(int index) {
        return delegate.listIterator(index);
    }

    @NotNull
    public List<T> subList(int fromIndex, int toIndex) {
        return delegate.subList(fromIndex, toIndex);
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

