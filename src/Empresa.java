import java.util.*;
public class Empresa {
	ArrayList <Empleado> empleados = new ArrayList<>();
	
	public static ArrayList<Double> liquidarNominaEmp(ArrayList<Empleado> empleados){
		// ArrayList de empleados donde se almacenan datos de parametro
				ArrayList<Double> pagoNomina = new ArrayList<Double>();
				if(empleados == null) {
					return pagoNomina;
				}else {
					//Declaracion e inicio de variables
					double auxTrans = 106454;
					int valorH =0;
					double valorHExtra = 0;
					double salud = 0;
					double pension = 0;
					double totalSalario = 0;
					double totalSalarioMensual = 0;
//					double totalQuincena = 0;
					
					//foreach recorre el Array Empleado 		
					for (Empleado empleado : empleados) { // inicio de foreach
						
						// valor hora = salario / (30 dias * 8horas = 240)
						valorH = empleado.getSalario() / 240; 
						
						// hora extra 
						valorHExtra = valorH * empleado.getHorasExtra();
						
						// Salario mas horas extra			
						totalSalario = (empleado.getSalario() + valorHExtra);
						
						// calculo de salud			
						salud = totalSalario * 0.04;
						
						// calculo de pension			
						pension = totalSalario * 0.04;
						
						// Salario mensual descontando salud y pension
						totalSalarioMensual = (totalSalario - (salud + pension));
						
						// si tiene derecho a auxilio de transporte, se le agrega al salario mensual
						if(empleado.getAuxilioTrasporte()){
							totalSalarioMensual += auxTrans;
						} 
						
						 //se agrega al ArrayList<Double> pagoNomina cada salario de cada trabajador	
						pagoNomina.add((double)((int)totalSalarioMensual));
						
					}// fin foreach
					
					// Retorna el array de pago quincenal con valores a pagar
					return pagoNomina;
					
				} // fin else 
	}
	
	public static ArrayList<Double> liquidarParafiscales(ArrayList<Empleado> empleados){
				
		// ArrayList de empleados donde se almacenan datos de parametro
		ArrayList<Double> pagoParafiscales = new ArrayList<Double>();
		if(empleados == null) {
			return pagoParafiscales;
		}else {
			//Declaracion e inicio de variables
//			double auxTrans = 106454;
			double valorH =0;
			double valorHExtra = 0;
			double parafiscales = 0;
			double totalSalario = 0;
						
			//foreach recorre el Array Empleado 		
			for (Empleado empleado : empleados) { // inicio de foreach
				
				// valor hora = salario / (30 dias * 8horas = 240)
				valorH = empleado.getSalario() / 240.0; 
				
				// hora extra 
				valorHExtra = valorH * empleado.getHorasExtra();
				
				// Salario mas horas extra			
				totalSalario = (empleado.getSalario() + valorHExtra);
				
				// calcule de total parafiscales			
				parafiscales = (totalSalario * 0.04) + (totalSalario * 0.03) + (totalSalario * 0.02);
				
				 //se agrega al ArrayList<Double> pagoNomina cada salario de cada trabajador	
				pagoParafiscales.add(Math.round(parafiscales*100.0)/100.0);
				
			}// fin foreach
			
			// Retorna el array de pago quincenal con valores a pagar
			return pagoParafiscales;
			
		} // fin else 
	}
	
	public static ArrayList<Double>liquidarSegSocialEmp(ArrayList<Empleado> empleados){
		// ArrayList de empleados donde se almacenan datos de parametro
				ArrayList<Double> liquidacionSegSoc = new ArrayList<Double>();
				if(empleados == null) {
					return liquidacionSegSoc;
				}else {
					//Declaracion e inicio de variables
//					double auxTrans = 106454;
					double valorH =0;
					double valorHExtra = 0;
					double segSocial = 0;
					double totalSalario = 0;
								
					//foreach recorre el Array Empleado 		
					for (Empleado empleado : empleados) { // inicio de foreach
						
						// valor hora = salario / (30 dias * 8horas = 240)
						valorH = empleado.getSalario() / 240.0; 
						
						// hora extra 
						valorHExtra = valorH * empleado.getHorasExtra();
						
						// Salario mas horas extra			
						totalSalario = (empleado.getSalario() + valorHExtra);
						
						// calculo de total 			
						segSocial = (totalSalario * 0.085) + (totalSalario * 0.12) + (totalSalario * 0.00522);
						
						 //se agrega al ArrayList<Double> pagoNomina cada salario de cada trabajador	
						liquidacionSegSoc.add(Math.round(segSocial*100.0)/100.0);
						
					}// fin foreach
					
					// Retorna el array de pago
					return liquidacionSegSoc;
					
				} // fin else 
	}
	
		
public static ArrayList<Double>liquidarPrestacionesEmp(ArrayList<Empleado> empleados){
		// ArrayList de empleados donde se almacenan datos de parametro
				ArrayList<Double> liquidacionPresSoc = new ArrayList<Double>();
				if(empleados == null) {
					return liquidacionPresSoc;
				}else {
					//Declaracion e inicio de variables
					int  auxTrans = 106454;
					int valorH =0;
					double valorHExtra = 0;
					double segSocial = 0;
					double totalSalario = 0;
								
					//foreach recorre el Array Empleado 		
					for (Empleado empleado : empleados) { // inicio de foreach
						
						// valor hora = salario / (30 dias * 8horas = 240)
						valorH = empleado.getSalario() / 240; 
						
						// hora extra 
						valorHExtra = valorH * empleado.getHorasExtra();
						
						// Salario mas horas extra			
						totalSalario = (empleado.getSalario() + valorHExtra);
						
//						totalSalario -= (totalSalario * 0.08);
						
						if(empleado.getAuxilioTrasporte()) {
							totalSalario += auxTrans;
						}
						
						// calcule de total
						segSocial = (totalSalario *( 0.0833*2))+((totalSalario * (0.0833))*  0.12) + (empleado.getSalario() * 0.0416);
						
						 //se agrega al ArrayList<Double> pagoNomina cada salario de cada trabajador	
						liquidacionPresSoc.add(Math.round(segSocial*100.0)/100.0);
						
					}// fin foreach
					
					// Retorna el array de pago
					return liquidacionPresSoc;
					
				} // fin else 
	}
	
public static ArrayList<Double>totalPagosOtorgadosAEmpleados(ArrayList<Empleado>empleados){
	
	// declaracion de todos los arrays que se van a usar
	ArrayList <Double>  nomina = new ArrayList<>(); // array de liquidacion de nomina
	ArrayList <Double> prestaciones = new ArrayList<>(); // array de liquidacion de prestaciones sociales
	ArrayList <Double> total = new ArrayList<>(); // array para retornar el total a liquidar
	
	// variable donde almacenariemos la sumatoria de montos de empleado
	double suma ; 
	
	// if para validar si empleados es nulo se devuelve array vacio
	if(empleados == null) {
		return total;
	}else {
		// se llama el metodo de liquidacion de nomina y se guarda en array de nomina
		nomina = liquidarNominaEmp(empleados);
		
		// se llama el metodo de liquidacion de prestaciones y se guarda en array de prestaciones
		prestaciones = liquidarPrestacionesEmp(empleados);
		
		// for para tomar los valores por cada empleado y sumarlos
		for(int i =0; i < empleados.size();i++) { // la cantidad de iteraciones sera la misma del tamanio del array enmpleados
			
			// se inicia la variable en 0 para cada iteracion
			suma = 0;
			// se toma el valor de nomina del empleado[i] y se suma a la variable 
			suma += nomina.get(i);
			
			// se toma el valor de prestaciones del empleado[i] y se suma a la variable
			suma += prestaciones.get(i);
			
			// se agrega la suma de cada empleado a un indice del array de total
			total.add(suma);
		}
		// se retorna el array total con los montos
		return total;
	}
	
	
	
}

}// fin de clase
