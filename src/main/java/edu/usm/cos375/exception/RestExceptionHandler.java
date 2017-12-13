package edu.usm.cos375.exception;

import javax.persistence.NonUniqueResultException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonValue;

import edu.usm.cos375.annotation.RestAPIControllerAdvice;

@RestAPIControllerAdvice
public class RestExceptionHandler
{
	//Handle constraint violations.
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Message> handle(ConstraintViolationException e)
	{
		String m = "";
		for(ConstraintViolation<?> c : e.getConstraintViolations())
		{
			m = m +  c.getMessage() + "\n";
		}

		Message message = new Message(m);
		return new ResponseEntity<Message>(message, HttpStatus.BAD_REQUEST);
	}

//	//Handle the TransactionSystemException thrown when a database violation happens.
	@ExceptionHandler(TransactionSystemException.class)
	public ResponseEntity<Message> handle(TransactionSystemException e)
	{
		String m = ("An error occured while saving to the database.");
		Message message = new Message(m);
		return new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NonUniqueResultException.class)
	public ResponseEntity<Message> handle(NonUniqueResultException e){
		String m = ("An item with this external id already exists. Please enter a different id.");
		Message message = new Message(m);
		return new ResponseEntity<Message>(message, HttpStatus.CONFLICT);
	}
	
	@JsonRootName(value="message")
	public class Message {
		String message;
		
		public Message(String m) {
			this.message = m;
		}
		
		@JsonValue
		public String getMessage() {
			return this.message;
		}
	
		@JsonSetter("message")
	    public void setMessage(String m) {
	        this.message = m;
	    }
	}

}

