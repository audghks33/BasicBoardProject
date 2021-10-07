package com.audghks33.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class Printing {

	@Setter(onMethod_ = @Autowired)
	private Printer printer;
	
	
	@Test
	public void testPrint() {
		
		log.info(printer);
		log.info(printer.getPaper());
		
	}
	
}
