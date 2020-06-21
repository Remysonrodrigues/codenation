package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {

		double salarioLiquido = 0;

		if (salarioBase == 1500.0) {
			salarioLiquido = calcularInss(salarioBase, 8.0);
		} else if (salarioBase > 1500.0 && salarioBase <= 4000.0) {
			salarioLiquido = calcularInss(salarioBase, 9.0);
		} else if (salarioBase > 4000.0) {
			salarioLiquido = calcularInss(salarioBase, 11.0);
		}

		return Math.round(salarioLiquido);
	}
	
	
	private double calcularInss(double salarioBase, double desconto) {

		salarioBase -= ( (salarioBase * desconto) / 100); 

		if (salarioBase > 3000.0 && salarioBase <= 6000.0) {
			salarioBase = calcularIrrf(salarioBase, 7.5);
		} else if (salarioBase > 6000.0) {
			salarioBase = calcularIrrf(salarioBase, 15.0);
		}

		return salarioBase; 
	}

	private double calcularIrrf(double salarioBase, double desconto) {
		
		return salarioBase -= ( (salarioBase * desconto) / 100); 
	}

}
