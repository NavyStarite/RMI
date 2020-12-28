/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.Server;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import login.Implement.LoginImplement;


/**
 *
 * @author Escuela
 */
public class LoginServer {
    public static void main(String[] args){
        try {
            // TODO code application logic here
            Registry reg = LocateRegistry.createRegistry(1099);
            LoginImplement lp = new LoginImplement();
            reg.rebind("login", lp);
            System.out.println("Server ready");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
