/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmisd;

import javax.swing.JFrame;

/**
 *GamePanel game = new GamePanel();
        game.setBounds(0,0,500, 500);
        JFrame frame= new JFrame();
        frame.add(game);
        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);
 * @author Escuela
 */


public class ThreadsGame {


    public static void main(String [] Args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Pato " + i);

                    try {
                        //Code here
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
        thread2.start();
    }

    
}
