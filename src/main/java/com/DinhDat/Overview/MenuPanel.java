/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DinhDat.Overview;
package com.DinhDat.SortAlgorithm;


import com.DinhDat.SortAlgorithm.BubbleSort;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 *
     * @author Admin
 */
public class MenuPanel extends JPanel{

    public static String Sorts[] = {"Selection", "Bubble", "Merge"};
    
    private JComboBox<String> selection;
    private JSlider speed;
    private JLabel speedLabel;
    private final int MAX_SPEED = 1000;
    private final int MIN_SPEED = 1;
    private final int DEFAULT_SPEED = 20;
    private JButton stopButton;
    private JButton startButton;
    
    private SortingPanel sortingPanel;
    Thread thread;
    
    public MenuPanel(SortingPanel sortingPanel) {
        
        this.sortingPanel = sortingPanel;
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        flowLayout.setHgap(MyPanel.WIDTH/10);
        setLayout(flowLayout);
        speedLabel = new JLabel("Speed");
        speed = new JSlider(MIN_SPEED,MAX_SPEED,DEFAULT_SPEED);
        speed.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

                            BubbleSort.amountsOfTick = speed.getValue();
			}
		});
        stopButton = new JButton("Stop");
        selection = new JComboBox<>();
        for (String s:Sorts) selection.addItem(s);
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
              String typeSort = (String)selection.getSelectedItem();
              System.out.println(typeSort);
              sortingPanel.startSort(typeSort);
                
            }
        });
        
        
        add(speedLabel);
        add(speed);
        add(stopButton);
        add(startButton);
        add(selection);
        
    }
    
    
    
}
