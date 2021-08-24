import java.util.ArrayList;
import java.util.Iterator;
public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Empleado emp1 = new Empleado("Ada",5,true,1500000);
		Empleado emp2 = new Empleado("Laura",5,true,1085000);
//		Empleado emp3 = new Empleado("Carmen",5,true,1085000);
		
		ArrayList <Empleado> datos = new ArrayList<Empleado>();
		datos.add(emp1);
		datos.add(emp2);
//		datos.add(emp3);
		
		
//		ArrayList<Double> pago = new ArrayList<Double>();
//		ArrayList<Double> pagoParafiscales = new ArrayList<Double>();
//		ArrayList<Double>liquidacionSegSoc = new ArrayList<>();
//		ArrayList<Double>liquidacionPres = new ArrayList<>();
		ArrayList<Double>total = new ArrayList<>();
		
		
//		pago=(Empresa.liquidarNominaQuincenal(null));
//		pago=(Empresa.liquidarNominaEmp(datos));
//		pagoParafiscales=(Empresa.liquidarParafiscales(datos));
//		liquidacionSegSoc = (Empresa.liquidarSegSocialEmp(datos));
//		liquidacionPres = (Empresa.liquidarPrestacionesEmp(datos));
		total = Empresa.totalPagosOtorgadosAEmpleados(datos);
		
		for (double x : total) {
			System.out.println(x);
		}
		
//		double suma = 0;
//		
//		for (int i = 0; i<pago.size(); i++) {
//			suma = 0;
//			suma+=pago.get(i);
//			suma+=liquidacionPres.get(i);
//			total.add(suma);
//			
//			
//		}
		
//		for (double x : pago) {
//			for(double j:liquidacionPres) {
//				System.out.println(x);
//				System.out.println(j);
//			}
//			
//		}
		
		
		
//		for (double x : liquidacionSegSoc) {
//			System.out.println(x);
//		}

//		for (double x : liquidacionPres) {
//			System.out.println(x);
//		}
		
	}

}
