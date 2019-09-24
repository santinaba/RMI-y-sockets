package com.mycompany.Banco;
import java.rmi.*;
public interface InterfazBanco extends Remote {
    double CotizarDolar(String arg) throws RemoteException; 
}