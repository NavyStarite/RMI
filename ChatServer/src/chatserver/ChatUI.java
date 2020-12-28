package chatserver;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import login.Interface.LoginInterface;
import rmiinicio.Inicio;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatUI extends javax.swing.JFrame{

    private ChatClient client;
    private ChatServerInt server;
    Registry reg;
    
    LoginInterface i;
    Inicio in;
    //String user=in.obtenernombre(null);
    public void doConnect() {
        //Validaciones
        if (connect.getText().equals("Conectarse")) {
            
            if (name.getText().length() < 2) {
                JOptionPane.showMessageDialog(frame, "Necesitas un nombre valido.");
                return;
            }/*
            if (ip.getText().length() < 2) {
                JOptionPane.showMessageDialog(frame, "You need to type an IP.");
                return;
            }*/
            try {
                client = new ChatClient(name.getText());
                client.setGUI(this);
                reg=LocateRegistry.getRegistry("localhost",8080);
                server = (ChatServerInt) reg.lookup("rmi://localhost/myabc");//"rmi://" + ip.getText() + "/myabc"
                server.login(client);
                updateUsers(server.getConnected());
                connect.setText("Desconectarse");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(frame, "ERROR, no pudimos obtener la conexion....");
            }
        } else {
            updateUsers(null);
            connect.setText("Connect");
        }
    }

    public void sendText() {
        if (connect.getText().equals("Connect")) {
            JOptionPane.showMessageDialog(frame, "Necesitas conectarte primero.");
            return;
        }
        String st = tf.getText();
        st = "[" + name.getText() + "] " + st;
        tf.setText("");
        //Remove if you are going to implement for remote invocation
        try {
            server.publish(st);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeMsg(String st) {
        tx.setText(tx.getText() + "\n" + st);
    }

    public void updateUsers(Vector v) {
        DefaultListModel listModel = new DefaultListModel();
        if (v != null) {
            for (int i = 0; i < v.size(); i++) {
                try {
                    String tmp = ((ChatClientInt) v.get(i)).getName();
                    listModel.addElement(tmp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        lst.setModel(listModel);
    }

    public static void main(String[] args) {
        System.out.println("Hello World !");
        ChatUI c = new ChatUI();
    }

    public ChatUI() {
        
        frame = new JFrame("Chat Grupal");
        JPanel main = new JPanel();
        JPanel top = new JPanel();
        JPanel cn = new JPanel();
        JPanel bottom = new JPanel();
        ip = new JTextField();
        tf = new JTextField();
        name = new JTextField();
        try {
            name.setText(i.getName());//-----------usuario de login aqui es domde se debe mandar el usuatio
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        tx = new JTextArea();
        connect = new JButton("Conectarse");
        JButton bt = new JButton("Enviar");
        lst = new JList();
        main.setLayout(new BorderLayout(5, 5));//
        top.setLayout(new GridLayout(1, 0, 5, 5));
        cn.setLayout(new BorderLayout(5, 5));
        bottom.setLayout(new BorderLayout(5, 5));
        top.add(new JLabel("Nombre: "));
        top.add(name);
        //top.add(new JLabel("Server Address: "));
        //top.add(ip);
        top.add(connect);
        cn.add(new JScrollPane(tx), BorderLayout.CENTER);
        cn.add(lst, BorderLayout.EAST);
        bottom.add(tf, BorderLayout.CENTER);
        bottom.add(bt, BorderLayout.EAST);
        main.add(top, BorderLayout.NORTH);
        main.add(cn, BorderLayout.CENTER);
        main.add(bottom, BorderLayout.SOUTH);
        main.setBorder(new EmptyBorder(10, 600, 10, 10));//Aqui cambias los bordes o cordenadas
        //Events
        connect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doConnect();
            }
        });
        bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendText();
            }
        });
        tf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendText();
            }
        });

        frame.setContentPane(main);//Aqui agregas el Jpanel al frame y creo que ya estaria
        frame.setSize(900, 500);
        frame.setVisible(true);
    }
    JTextArea tx;
    JTextField tf, ip, name;
    JButton connect;
    JList lst;
    JFrame frame;
}

