package sven.examples.myeffectivejava.item01.factory;

public interface SimpleInterface {

	public static SimpleInterface getInstance() {
		return new SimpleInterface() {
		};
	}

}
