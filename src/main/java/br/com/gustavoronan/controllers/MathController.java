package br.com.gustavoronan.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {
	
	@RequestMapping("/sum/{numberOne}/{numberTwo}")	
	public Double sum(
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo
			) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			
			throw new IllegalArgumentException("Por favor insira um valor");
		}
		
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
		
	}
	
	@RequestMapping("/division/{numberOne}/{numberTwo}")	
	public Double division(
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo
			) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			
			throw new IllegalArgumentException("Por favor insira um valor");
		}
		
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
		
	}
	
	@RequestMapping("/multiplication/{numberOne}/{numberTwo}")	
	public Double multiplication(
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo
			) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			
			throw new IllegalArgumentException("Por favor insira um valor");
		}
		
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
		
	}

	@RequestMapping("/subtraction/{numberOne}/{numberTwo}")	
	public Double subtraction(
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo
			) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			
			throw new IllegalArgumentException("Por favor insira um valor");
		}
		
		return convertToDouble(numberOne) - convertToDouble(numberTwo);
		
	}
	
	
	
	private Double convertToDouble(String strNumber) {
		if(strNumber == null || strNumber.isEmpty()) {
			throw new IllegalArgumentException();
		}
		String number = strNumber.replace(",", ".");
		return Double.parseDouble(number);	
		
		}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null || strNumber.isEmpty()) {
			return false;
		}
		String number = strNumber.replace(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}



}
