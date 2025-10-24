package sven.examples.myeffectivejava.item01.factory;

/**
 * Static Factory Methods - returns an instance of the class.
 * 
<<<<<<< HEAD
 * Note: not the same as Gamma95 Factory Method.
=======
 * Note: not the same a Gamma95 Factory Method.
>>>>>>> 96270eee947c9afe596a897888026d6738d447ed
 * 
 * Advantages:
 * 
 * They have names. A well chosen name describes the object being returned and
 * makes it easier to read, whereas contructors only have arguments to indicate
 * the object being returned. Example BigInteger(int, int, Random), probably
 * returns a prime. However, BigInteger.probablePrime() (added in 1.4), is much
 * more clear.
 * 
 * Constructors are limited in allowing single constructors with a given
 * signature. Static Factories do not have this limitation.
 * 
 * They are not required to return a new object each time they are called. Good
 * for immutable objects. This is known as "instance-controled".
 * 
 * An object of any sub-type of the return-type may be returned. Important when
 * hiding implementation classes and using interface-based frameworks (item:
 * 20).
 * 
 * Disadvantages:
 * 
 * They can't be used by sub-classes like a constructor. This can also be a good
 * thing, as it encourages composition instead of inheritance.
 * 
 * They can be hard to find, since they don't stand out like a constructor.
 * 
 * Common Sense Names:
 * 
 * from - a type-conversion method
 * 
 * Date d = Date.from(instant)
 * 
 * of - an aggregation method that take multiple parameters and returns an
 * instance that aggregates them
 * 
 * Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING)
 * 
 * valueOf - more verbose alternative to 'from', 'of'
 * 
 * instance or getIntance - returns an instance that is described by its
 * parameters (if any) but cannot be said to have the same value
 * 
 * StackWalker luke = StackWalker.getInstance(options)
 * 
 * create or newInstance - like getInstance, except it guarantees a new
 * instance.
 * 
 * getType - like getInstance, but the factory method is in a different class.
 * Type is the type of the object returned by the factory method.
 * 
 * FileStore fs = Files.getFileStore(path)
 * 
 * newType - like getType, but guarantees a new instance.
 * 
 * BufferedReader br = Files.newBufferedReader(path)
 * 
 * type - concise alternative to getType and newType
 * 
 * List<Complaint> litany = Connections.list(legacyLitany)
 * 
 * Well-known API exception:
 * 
 * toString(): String
 * 
 * parseDouble(String s): Double; found in Boolean, Long, Integer, etc.
 */
public class StaticFactoryMethods {

	private static ConcreteSimpleInterface concreteSimpleInterface = ConcreteSimpleInterface.getInstance();

	/**
	 * Applying the naming pattern, this method would be (and is) found in the class
	 * Boolean.
	 * 
	 * The context of appearing in a different class type (as it does here), it
	 * should be names here as:
	 * 
	 * getBoolean(b)
	 * 
	 * @param b
	 * @return Boolean representing the primitive type.
	 */
	public static Boolean valueOf(boolean b) {
		return (b) ? Boolean.TRUE : Boolean.FALSE;
	}

	public static Boolean valueOf(String s) {
		return Boolean.valueOf(s);
	}

	/**
	 * Example of the 'getType' pattern that returns the instance returned by the
	 * interface's static factory method.
	 * 
	 * @return
	 */
	public static MyInterface getMyInterface() {
		return MyInterface.getInstance();
	}

	/**
	 * Example of the 'newType' pattern that returns the instance returned by the
	 * interface's static factory method.
	 * 
	 * @return SimpleInterface
	 */
	public static SimpleInterface newSimpleInterface() {
		return SimpleInterface.getInstance();
	}

	/**
	 * Example of the 'newType' pattern that returns a package-private
	 * implementation, which keeps the implementation hidden.
	 * 
	 * @return SimpleInterface
	 */
	public static SimpleInterface simpleInterface() {
		/*
		 * This is "instance-controled"
		 */
		return concreteSimpleInterface;
	}

}
