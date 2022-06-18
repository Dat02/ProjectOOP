/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DinhDat.Overview;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class MainFrame extends JFrame{

    private MyPanel myPanel; 
    
    public MainFrame() {
        
        myPanel = new MyPanel(this);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(false);
        add(myPanel);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
       
    }
     
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
    }
    
}
