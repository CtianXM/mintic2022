import java.util.ArrayList;
public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Empleado emp1 = new Empleado("Ada",5,true,1500000);
		Empleado emp2 = new Empleado("Laura",5,true,1085000);
//		Empleado emp3 = new Empleado("Carmen",5,true,1085000);
		
		ArrayList <Empleado> datos = new ArrayList<Empleado>();
		ArrayList<Double> pago = new ArrayList<Double>();
		ArrayList<Double> pagoParafiscales = new ArrayList<Double>();
		
		datos.add(emp1);
		datos.add(emp2);
//		datos.add(emp3);
		
		
//		pago=(Empresa.liquidarNominaQuincenal(null));
		pago=(Empresa.liquidarNominaEmp(datos));
		pagoParafiscales=(Empresa.liquidarParafiscales(datos));
		
		for (double x : pago) {
			System.out.println(x);
		}

	}

}
