/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DinhDat.SortAlgorithm;

import com.DinhDat.Overview.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Admin
 */
public class BubbleSort implements Runnable {

    SortingPanel sortingPanel;
    private List<Integer> sortList;
    public boolean swapped[];
    public static double amountsOfTick = 60.0; // tick like update like fps

    Thread t1, t2, t3;

    public BubbleSort(SortingPanel sortingPanel) {
        this.sortingPanel = sortingPanel;
        sortList = sortingPanel.getSortingList();
        swapped = new boolean[sortList.size()];
    }

    boolean time = false;

    @Override
    public void run() {
//        long lasttime = System.nanoTime();
//        
//        double ns = 1000000000 / amountsOfTick;
//        double delta = 0;
//        long ticks = 0;
//        long timer = System.currentTimeMillis();
//        

        NowSort();

//        while (sortingPanel.running) {
//            
//            long now = System.nanoTime();
//            delta += (now - lasttime) / ns;
//            lasttime = now;
//
//            if (delta >= 1) {
//                NowSort();
//                delta--;
//                ticks++;
//            }
////            if (System.currentTimeMillis() - timer > 1000) {
////                System.out.println("Ticks: " + ticks);
////                timer = System.currentTimeMillis();
////                ticks = 0;
////            }
//        sortingPanel.repaint(); 
////            
//        }
//        sortingPanel.stopSort();
    }

    private void NowSort() {

        for (int i = 0; i < sortList.size(); i++) {
            for (int j = 0; j < sortList.size() - 1 - i; j++) {
                NowSwap(j, j + 1);
            }
        }

    }

    public void NowSwap(int i, int j) {
        int a = sortList.get(i);
        int b = sortList.get(j);

        if (a > b) {
//            sortingPanel.goDown(i);
//            sortingPanel.goDown(j);
            ThreadGoDown(i, j);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
            }
//            sortingPanel.goRight(i, sortingPanel.locationX[j]);
//            sortingPanel.goLeft(j, sortingPanel.locationX[i]);
//            sortingPanel.goUp(i);
//            sortingPanel.goUp(j); 
            ThreadGoRightLeft(i, j);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
            }
            ThreadGoUp(i, j);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
            }
            sortList.set(i, b);
            sortList.set(j, a);

//            System.out.println(sortList.get(i));
//            System.out.println(sortList.get(j));
            JPanel tempPanel = sortingPanel.arrayPanel[i];
            sortingPanel.arrayPanel[i] = sortingPanel.arrayPanel[j];
            sortingPanel.arrayPanel[j] = tempPanel;
        }
        
        else {
            ThreadGoDown(i, j);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
            }
            ThreadGoUp(i, j);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }


    public void ThreadGoDown(int i, int j) {

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                long lasttime = System.nanoTime();

                double ns = 1000000000 / amountsOfTick;
                double delta = 0;
                while (SortingPanel.downRun) {

                    long now = System.nanoTime();
                    delta += (now - lasttime) / ns;
                    lasttime = now;

                    if (delta >= 1) {
                        System.out.println("1");
                        sortingPanel.goDown(i);
                        sortingPanel.goDown(j);
                        delta--;
                    }
                    sortingPanel.repaint();
                }
                try {
                    SortingPanel.downRun = true;
                    t1.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        t1.start();
    }

    public void ThreadGoRightLeft(int i, int j) {

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                long lasttime = System.nanoTime();

                double ns = 1000000000 / amountsOfTick;
                double delta = 0;
                while (SortingPanel.RightLeftRun) {

                    long now = System.nanoTime();
                    delta += (now - lasttime) / ns;
                    lasttime = now;

                    if (delta >= 1) {
                        System.out.println("1");
                        sortingPanel.goRight(i, sortingPanel.locationX[j]);
                        sortingPanel.goLeft(j, sortingPanel.locationX[i]);
                        delta--;
                    }
                    sortingPanel.repaint();
                }

                try {
                    SortingPanel.RightLeftRun = true;
                    t2.join();

                } catch (InterruptedException ex) {
                    Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        t2.start();
    }

    public void ThreadGoUp(int i, int j) {

        t3 = new Thread(new Runnable() {

            @Override
            public void run() {

                long lasttime = System.nanoTime();

                double ns = 1000000000 / amountsOfTick;
                double delta = 0;
                while (SortingPanel.UpRun) {

                    long now = System.nanoTime();
                    delta += (now - lasttime) / ns;
                    lasttime = now;

                    if (delta >= 1) {
                        System.out.println("1");
                        sortingPanel.goUp(i);
                        sortingPanel.goUp(j);
                        delta--;
                    }
                    sortingPanel.repaint();
                }

                try {
                    SortingPanel.UpRun = true;
                    t3.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        t3.start();
    }

}
