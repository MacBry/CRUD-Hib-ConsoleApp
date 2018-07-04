package com.mac.bry.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


import com.mac.bry.entity.Book;

public class BookValidator {
	
	private ValidatorFactory factory;
	private Validator validator;
	
	public BookValidator() {
		super();
		this.factory =  Validation.buildDefaultValidatorFactory();
		this.validator = factory.getValidator();
	}
	
	public void validBook (Book book) {
		final Set<ConstraintViolation<Book>> bookConstraint = validator.validate(book);
		if(bookConstraint.isEmpty()) {
			System.out.println("OK!");
		}
		else {
			bookConstraint.forEach(element -> System.out.println(element.getPropertyPath() + " - "+element.getMessage()));
		}
	}
	
	
}
