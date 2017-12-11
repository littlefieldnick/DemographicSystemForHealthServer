package edu.usm.cos375.exception;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NonUniqueResultException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import edu.usm.cos375.annotation.RestAPIControllerAdvice;
import edu.usm.cos375.exception.RestExceptionHandler.ErrorItem;
import edu.usm.cos375.exception.RestExceptionHandler.ErrorResponse;

@RestAPIControllerAdvice
public class RestExceptionHandler
{
	//Handle constraint violations.
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> handle(ConstraintViolationException e)
	{
		ErrorResponse errors = new ErrorResponse();
		for(ConstraintViolation<?> c : e.getConstraintViolations())
		{
			ErrorItem error = new ErrorItem();
			error.setCode(c.getMessageTemplate());
			error.setMessage(c.getMessage());
			errors.addError(error);
		}

		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

//	//Handle the TransactionSystemException thrown when a database violation happens.
	@ExceptionHandler(TransactionSystemException.class)
	public ResponseEntity<ErrorResponse> handle(TransactionSystemException e)
	{
		ErrorResponse errors = new ErrorResponse();
		ErrorItem error = new ErrorItem();
		Throwable t = e.getCause();
		error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		error.setMessage(t.getLocalizedMessage());
		errors.addError(error);

		return new ResponseEntity<ErrorResponse>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NonUniqueResultException.class)
	public ResponseEntity<ErrorResponse> handle(NonUniqueResultException e){
		ErrorResponse errors = new ErrorResponse();
		ErrorItem error = new ErrorItem();
		error.setMessage(e.getMessage());
		error.setCode(HttpStatus.CONFLICT.toString());
		errors.addError(error);
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		
	}

	public static class ErrorItem
	{
		private String code;
		private String message;

		@XmlAttribute
		public String getCode()
		{
			return code;
		}

		public void setCode(String code)
		{
			this.code = code;
		}

		@XmlValue
		public String getMessage()
		{
			return message;
		}

		public void setMessage(String message)
		{
			this.message = message;
		}
	}

	@XmlRootElement(name = "errors")
	public static class ErrorResponse
	{
		private List<ErrorItem> errors = new ArrayList<ErrorItem>();

		@XmlElement(name="error")
		public List<ErrorItem> getErrors()
		{
			return errors;
		}

		public void setErrors(List<ErrorItem> errors)
		{
			this.errors = errors;
		}

		public void addError(ErrorItem error)
		{
			this.errors.add(error);
		}
	}
}
