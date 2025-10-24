package sven.examples.myeffectivejava.item01.factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public interface MyInterface extends Collection<String> {

	/**
	 * Note: static methods became available to Java in version 8, so there is
	 * typically little reason to provide a non-instantiable companion class for an
	 * interface, as seen in the Collections class.
	 * 
	 * The Collections Framework API has 45 utility implementation of its
	 * interfaces, providing unmodifiable collection, synchronized collections, and
<<<<<<< HEAD
	 * the like. Nearly all of these implementation are exported via static factory
=======
	 * the like Nearly all of these implementation are exported via static factory
>>>>>>> 96270eee947c9afe596a897888026d6738d447ed
	 * methods in one non-instantiable class, java.util.Collections. The classes of
	 * the returned objects are all non-public.
	 * 
	 * Ex: Collections.unmodifiableCollection(collection): Collection<T>
	 * 
	 * Another use for Interface static methods is that they can provide alternate
	 * implementation class, from call to call, based on their input.
	 * 
	 * @return
	 */
	public static MyInterface getInstance() {
		/*
		 * I am not 100% sure why I have to cast here?
		 */
		// MyInterface instance = (MyInterface) new ArrayList<String>();
		// return instance;

		/*
		 * Or,
		 */
		return new MyInterface() {

			/*
			 * The delegate supports the List interface, which defines methods that are not
			 * defined in Collection. The @Override notices this and throws a compilation
			 * error where those implemented delegate-methods are not defined in Collection.
			 * 
			 * For example, this is clearly only related to a List
			 * 
			 * @Override public void add(int index, String element)
			 */
			private List<String> delegate = new ArrayList<>();

			@Override
			public void forEach(Consumer<? super String> action) {
				delegate.forEach(action);
			}

			@Override
			public int size() {
				return delegate.size();
			}

			@Override
			public boolean isEmpty() {
				return delegate.isEmpty();
			}

			@Override
			public boolean contains(Object o) {
				return delegate.contains(o);
			}

			@Override
			public Iterator<String> iterator() {
				return delegate.iterator();
			}

			@Override
			public Object[] toArray() {
				return delegate.toArray();
			}

			@Override
			public <T> T[] toArray(T[] a) {
				return delegate.toArray(a);
			}

			@Override
			public boolean add(String e) {
				return delegate.add(e);
			}

			@Override
			public boolean remove(Object o) {
				return delegate.remove(o);
			}

			@Override
			public boolean containsAll(Collection<?> c) {
				return delegate.containsAll(c);
			}

			@Override
			public boolean addAll(Collection<? extends String> c) {
				return delegate.addAll(c);
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				return delegate.removeAll(c);
			}

			@Override
			public boolean retainAll(Collection<?> c) {
				return delegate.retainAll(c);
			}

			@Override
			public <T> T[] toArray(IntFunction<T[]> generator) {
				return delegate.toArray(generator);
			}

			@Override
			public void clear() {
				delegate.clear();
			}

			@Override
			public boolean equals(Object o) {
				return delegate.equals(o);
			}

			@Override
			public int hashCode() {
				return delegate.hashCode();
			}

			@Override
			public boolean removeIf(Predicate<? super String> filter) {
				return delegate.removeIf(filter);
			}

			@Override
			public Spliterator<String> spliterator() {
				return delegate.spliterator();
			}

			@Override
			public Stream<String> stream() {
				return delegate.stream();
			}

			@Override
			public Stream<String> parallelStream() {
				return delegate.parallelStream();
			}

			@Override
			public String toString() {
				return "MyInterface delegate " + delegate.getClass();
			}

		};
	}

}
