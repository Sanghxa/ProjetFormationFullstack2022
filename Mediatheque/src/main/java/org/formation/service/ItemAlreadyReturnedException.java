package org.formation.service;

public class ItemAlreadyReturnedException extends Exception {
	private static final long serialVersionUID = 1L;

	public ItemAlreadyReturnedException(String message) {
		super(message);

	}
}
