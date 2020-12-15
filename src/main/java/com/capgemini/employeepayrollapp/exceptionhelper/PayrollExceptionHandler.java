package com.capgemini.employeepayrollapp.exceptionhelper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.capgemini.employeepayrollapp.dto.ResponseDTO;
import com.capgemini.employeepayrollapp.exception.EmployeeException;

@ControllerAdvice
public class PayrollExceptionHandler extends ResponseEntityExceptionHandler {
	
//	@Override
//	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
//			MethodArgumentNotValidException exception, HttpHeaders headers, 
//			  HttpStatus status, 
//			  WebRequest request) {
//		List<ObjectError> errList = exception.getBindingResult().getAllErrors();
//		List<String> errMessages = errList.stream().map(error -> error.getDefaultMessage())
//				.collect(Collectors.toList());
//		ResponseDTO responseDTO = new ResponseDTO("Exception occured", errMessages);
//		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
//	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		List<ObjectError> errList = exception.getBindingResult().getAllErrors();
		List<String> errMessages = errList.stream().map(error -> error.getDefaultMessage())
				.collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO("Exception occured method argument not valid ", errMessages);
		
		return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ResponseDTO> handleEmployeeException(EmployeeException empException) {
		ResponseDTO responseDTO = new ResponseDTO("Exception occured", empException.getMessage());
		return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
	}
}
