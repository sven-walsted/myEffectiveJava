package sven.examples.myeffectivejava.item01.factory;

/**
 * Package-private class
 */
final class ConcreteSimpleInterface implements SimpleInterface {

	static ConcreteSimpleInterface getInstance() {
		return new ConcreteSimpleInterface();
	}

	@Override
	public String toString() {
		return "ConcreteSimpleInterface implementation " + hashCode();
	}

}
