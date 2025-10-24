package sven.examples.myeffectivejava.harness;

import sven.examples.myeffectivejava.item01.factory.SimpleInterface;
import sven.examples.myeffectivejava.item01.factory.StaticFactoryMethods;

public class Item01 {

	public static void main(String[] args) {
		System.out.println("SimpleInterface.getInstance: " + SimpleInterface.getInstance());
		System.out.println("SimpleInterface.getInstance: " + SimpleInterface.getInstance());
		System.out.println("StaticFactoryMethods.newSimpleInterface: " + StaticFactoryMethods.newSimpleInterface());
		System.out.println("StaticFactoryMethods.simpleInterface (instance-controlled): "
				+ StaticFactoryMethods.simpleInterface());
		System.out.println("StaticFactoryMethods.simpleInterface (instance-controlled): "
				+ StaticFactoryMethods.simpleInterface());
		System.out.println("StaticFactoryMethods.getMyInterface: " + StaticFactoryMethods.getMyInterface());

		// Package-private
		// ConcreteSimpleInterface concreteSimpleInterface = ...
	}

}
