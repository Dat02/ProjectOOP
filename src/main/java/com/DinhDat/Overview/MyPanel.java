/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DinhDat.Overview;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class MyPanel extends  JPanel{
    
    public static final int WIDTH = 900;
    public static final int HEIGHT = 600;
    
    // input Component
    private InputPanel inputPanel;
    private SortingPanel sortingPanel;
    private MenuPanel menuPanel;
    private MainFrame mainFrame;
    public MyPanel(MainFrame mainFrame) {
        
        this.mainFrame = mainFrame;
        
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        
        sortingPanel = new SortingPanel(this);
        inputPanel = new InputPanel(sortingPanel);
        menuPanel = new MenuPanel(sortingPanel);
        
       
        add(inputPanel,BorderLayout.NORTH);
        add(sortingPanel,BorderLayout.CENTER);
        add(menuPanel,BorderLayout.SOUTH);
    }
    
   
    
    
 
}
