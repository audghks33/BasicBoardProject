package com.audghks33.exception;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {

	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		
		log.error(".....................excep....:" + ex.getMessage());
		model.addAttribute("exception", ex);
		log.error(model);
		return "error_page";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handled404(NoHandlerFoundException ex) {
		return "custom404";
	}
}