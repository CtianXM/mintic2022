// reto_1;
import java.util.ArrayList;

public class Empleado {

	private int id;
	private String nombre;
	private int horasExtra;
	private boolean auxilioTransporte;
	private int salario;

	//Constructor 
	public Empleado(String nombre, int horasExtra, boolean auxilioTransporte, int salario) {

//		this.id = id;
		this.nombre = nombre;
		this.horasExtra = horasExtra;
		this.auxilioTransporte = auxilioTransporte;
		this.salario = salario;

	}

	// ***********************************                getters              *********************************************
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getHorasExtra() {
		return horasExtra;
	}

	public int getSalario() {
		return salario;
	}
		
	public boolean getAuxilioTrasporte() {  // get boolean
		return auxilioTransporte;
	}
	
		
// ***********************************                    setters          ***********************************************
	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setHorasExtra(int horasExtra) {
		this.horasExtra = horasExtra;
	}

	public void setAuxilioTrasporte(boolean auxilioTrasporte) {
		this.auxilioTransporte = auxilioTrasporte;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	//Metodo liqudar nomina
	public static ArrayList<Double> liquidarNominaQuincenal(ArrayList<Empleado> empleados) {
		
		// ArrayList de empleados donde se almacenan datos de parametro
		ArrayList<Double> pagoQuincenal = new ArrayList<Double>();
		if(empleados == null) {
			return pagoQuincenal;
		}else {
			//Declaracion e inicio de variables
			double auxTrans = 106454;
			int valorH =0;
			double valorHExtra = 0;
			double salud = 0;
			double pension = 0;
			double totalSalario = 0;
			double totalSalarioMensual = 0;
			double totalQuincena = 0;
			
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
				
				// se divide entre 2 para pagar quincena
				totalQuincena = totalSalarioMensual / 2;
				
				//se agrega al ArrayList<Double> pagoQuincenal cada salario de cada trabajador	

				pagoQuincenal.add(totalQuincena);
				
			}// fin foreach
			
			// Retorna el array de pago quincenal con valores a pagar
			return pagoQuincenal;
			
		} // fin else 
		
		
	} // fin metodo liquidarNominaQuincenal
	
	
	
	
}// fin de clase Empleado