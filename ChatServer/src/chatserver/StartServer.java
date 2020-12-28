package chatserver;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;

public class StartServer {

    public static void main(String[] args) {
        
        
        try {
            Registry reg=LocateRegistry.createRegistry(8080);
            //System.setSecurityManager(new RMISecurityManager());
            //java.rmi.registry.LocateRegistry.createRegistry(1099);

            ChatServerInt b = new ChatServer();
            reg.rebind("rmi://localhost/myabc", b);
            System.out.println("[System] Servidor listo.");
        } catch (Exception e) {
            System.out.println("Chat Server failed: " + e);
        }
    }
}
