package br.com.dexter.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.dexter.business.Calculadora;

@RestController(value="/calculadora")
public class CalculadoraController {
	
	@PostMapping() 
	public Object getResultado(@RequestBody Map<String, Object> json) {
		Calculadora calc = new Calculadora();
		calc.setExpressao(json.get("expressao").toString());
		return calc.getResultado();
	}
	
	@PostMapping("/calculadora/soma/{a}/{b}")
	public Object soma(@PathVariable int a, @PathVariable int b) {
		Calculadora calc = new Calculadora();
		calc.number(a).mais().number(b);
		return calc.getResultado();
	}
	
	@PostMapping("/calculadora/sub/{a}/{b}")
	public Object subtrair(@PathVariable int a, @PathVariable int b) {
		Calculadora calc = new Calculadora();
		calc.number(a).menos().number(b);
		return calc.getResultado();
	}
	
	@PostMapping("/calculadora/div/{a}/{b}")
	public Object dividir(@PathVariable int a, @PathVariable int b) {
		Calculadora calc = new Calculadora();
		calc.number(a).dividido().number(b);
		return calc.getResultado();
	}
	
	@PostMapping("/calculadora/multiplicar/{a}/{b}")
	public Object multiplicar(@PathVariable int a, @PathVariable int b) {
		Calculadora calc = new Calculadora();
		calc.number(a).vezes().number(b);
		return calc.getResultado();
	}

}
