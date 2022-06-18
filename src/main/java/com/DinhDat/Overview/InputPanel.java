/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DinhDat.Overview;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class InputPanel extends JPanel{
    
    private JLabel inputLabel;
    private JTextField inputTextField;
    private JButton submitButton;
    
    private SortingPanel sortingPanel;

    public InputPanel(SortingPanel sortingPanel) {
        
        this.sortingPanel = sortingPanel;
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        flowLayout.setHgap(MyPanel.WIDTH/5);
        inputLabel = new JLabel("Nhap day so");
        inputLabel.setLocation(10, 10);
        inputTextField = new JTextField();
        inputTextField.setPreferredSize(new Dimension(200,20));
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                String s = inputTextField.getText();
                String[] parts = s.split(" ");
                ArrayList<Integer> tempList = new ArrayList<>();
                for (String tempString:parts){
                    tempList.add(Integer.parseInt(tempString));
                }
                sortingPanel.setSortingList(tempList);
                System.out.println(tempList);
                SortingPanel.sortSize = tempList.size();
                sortingPanel.preDrawSortingPanel();
            }
            
        });
        
        setLayout(flowLayout);
        add(inputLabel);
        add(inputTextField);
        add(submitButton);
    }
    
    
    
    
}
