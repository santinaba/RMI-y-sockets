package com.mycompany.Banco;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class ServidorReserva
    extends UnicastRemoteObject
    implements InterfazBancoCliente
    {
        ServidorReserva() throws java.rmi.RemoteException{
	super();
    }
        public double Cotizar(String FInicio, String FFin, String FCotizacion) {
        String[][] PrecioHotel={{"26-09-19","30"},{"27-09-19","25"},{"28-09-19","25"},{"29-09-19","35"},{"26-09-19","40"}};
	double monto=0;
        for (int i=0;i<PrecioHotel.length;i++){
           if(PrecioHotel[i][0].equals(FCotizacion))
               monto=Double.parseDouble(PrecioHotel[i][1]);
        }
        String[] InicioS=FInicio.split("-");
        int [] inicioint = Convertir (InicioS);
        String[] FinS=FFin.split("-");
        int [] finint = Convertir (FinS);
        int Diasreserv = Calculardias(inicioint, finint);
        	InterfazBanco CotizarDolar;
        double Montodolar=0.0;
	try {
	    CotizarDolar=(InterfazBanco)Naming.lookup("rmi://localhost/CotizarDolar");
	    System.out.println();
            System.out.println("Dato no encontrado");
            Montodolar = CotizarDolar.CotizarDolar(FCotizacion);
	    System.out.println();
	}
	catch (Exception e){
	    e.printStackTrace();
	}
        return Montodolar*monto*Diasreserv;
    }

        private int [] Convertir (String [] InicioS){
        int inicio []= new int [InicioS.length]; 
            for (int i = 0; i < InicioS.length; i++) {
                inicio[i]=Integer.parseInt(InicioS [i]);
            }
            return inicio;
        }
               
        private int Calculardias ( int [] InicioS, int [] FinS){
            //suponiendo que los meses son iguales
            
            if(InicioS[0]<FinS[0])
                return FinS[0]-InicioS[0];
            else
                return 0;
        }
            public static void main(String args[]) { 
	try {
	    ServidorReserva ServidorReserva;
	    ServidorReserva=new ServidorReserva(); 
	    Naming.bind("Cotizar", ServidorReserva); 
            System.out.println("El servidor esta listo\n");
        }
	catch (Exception e){
	    e.printStackTrace();
	}
    }   
}