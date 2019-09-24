package com.mycompany.Banco;
import com.mycompany.Banco.InterfazBanco;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.Scanner;

public class Cliente{
    public static void main(String args[]){
	InterfazBanco CotizarDolar;
        Scanner sc =new Scanner(System.in);
        String cadena="";
	try {
	    CotizarDolar=(InterfazBanco)Naming.lookup("rmi://localhost/CotizarDolar");
            System.out.println("Introduce una fecha Ej. 27-09-19");
            cadena=sc.nextLine();
	    System.out.println();
	    if (CotizarDolar.CotizarDolar(cadena)==0)
            System.out.println("Dato no encontrado");
            else
            System.out.println("El valor del dolar es: "+CotizarDolar.CotizarDolar(cadena));
	    System.out.println();
        }
	catch (Exception e){
	    e.printStackTrace();
	}
        InterfazBancoCliente Cotizar;
        sc =new Scanner(System.in);
        String caden="";
	String Finicio="";
	String FFin="";
	String Cotizacion="";
        try{
            Cotizar=(InterfazBancoCliente)Naming.lookup("rmi://localhost/Cotizar");
            System.out.println("Introduce una fecha de inicio Ej. 26-09-19");
            cadena=sc.nextLine();
            System.out.println();
            System.out.println("Introduce una fecha de fin Ej. 26-09-19");
            cadena=sc.nextLine();
            System.out.println();
            System.out.println("Introduce una fecha de cotizacion Ej. 26-09-19");
            cadena=sc.nextLine();
            System.out.println();
            System.out.println("El monto del hospdaje es de: "+Cotizar.Cotizar(Finicio, FFin, Cotizacion)+"Bs");
        }
        catch (Exception e){
	    e.printStackTrace();
	}
    }
}
