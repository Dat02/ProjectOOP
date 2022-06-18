/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DinhDat.SortAlgorithm;

import com.DinhDat.Overview.SortingPanel;

/**
 *
 * @author Admin
 */
public class SelectionSort implements Runnable{

    
    SortingPanel sortingPanel;

    public SelectionSort(SortingPanel sortingPanel) {
        this.sortingPanel = sortingPanel;
    }
    
    
    
    @Override
    public void run() {
        long lasttime = System.nanoTime();
        final double amountsOfTick = 70.0; // tick like update
        double ns = 1000000000 / amountsOfTick;
        double delta = 0;
        
        while (sortingPanel.running) {
            long now = System.nanoTime();
            delta += (now - lasttime) / ns;
            lasttime = now;
            if (delta >= 1) { 
//                update();
                delta--;
            }
            sortingPanel.repaint();
        }
        sortingPanel.stopSort();
    }
    
    
}
