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
					double valorH =0;
					double valorHExtra = 0;
					double salud = 0;
					double pension = 0;
					double totalSalario = 0;
					double totalSalarioMensual = 0;
//					double totalQuincena = 0;
					
					//foreach recorre el Array Empleado 		
					for (Empleado empleado : empleados) { // inicio de foreach
						
						// valor hora = salario / (30 dias * 8horas = 240)
						valorH = empleado.getSalario() / 240.0; 
						
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
	
}
