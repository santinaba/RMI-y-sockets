package com.mycompany.Banco;
import java.rmi.*;
public interface InterfazBancoCliente extends Remote {
    double Cotizar(String FInicio, String FFin, String FCotizacion) throws RemoteException;   
}