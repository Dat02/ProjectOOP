/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DinhDat.Overview;

import com.DinhDat.SortAlgorithm.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Admin
 */
public class SortingPanel extends JPanel {

    public final int MAX = 100;
    public JPanel arrayPanel[];
    public boolean successMove;

    private MyPanel myPanel;
    public final int SPWIDTH = 700;
    public final int SPHEIGHT = 500;
    public final int Margin = 100;
    public Thread thread;

    public int BOXWIDTH;
    public int BOXHEIGHT;

    public final int RIGHT = 0;
    public final int LEFT = 1;
    public final int UP = 2;
    public final int DOWN = 3;

    public static int count = 0;

    private List<Integer> sortingList;
    public static int sortSize;
    public int locationX[];
    public int locationY[];
    public static boolean downRun = true;
    public static boolean RightLeftRun = true;
    public static boolean UpRun = true;

    public boolean running = true;

    public SortingPanel(MyPanel myPanel) {
//        setLayout(new BorderLayout());

        this.myPanel = myPanel;
        setLayout(null);

        setBackground(Color.WHITE);
        sortingList = new ArrayList<>();

    }

    public void preDrawSortingPanel() {

//        System.out.println(getSortingList());
        arrayPanel = new JPanel[sortSize];
        locationX = new int[sortSize];
        locationY = new int[sortSize];

        removeAll();
        for (int i = 0; i < sortSize; i++) {

            arrayPanel[i] = new JPanel();
            arrayPanel[i].setLayout(new GridBagLayout());
            BOXWIDTH = 2 * SPWIDTH / (3 * sortSize);
            BOXHEIGHT = BOXWIDTH;
            arrayPanel[i].setLocation(Margin + i * SPWIDTH / sortSize, SPHEIGHT / 10);
            arrayPanel[i].setSize(BOXWIDTH, BOXHEIGHT);
            arrayPanel[i].setBorder(BorderFactory.createLineBorder(Color.white, 5));
            arrayPanel[i].setBackground(Color.blue);
//
            locationX[i] = arrayPanel[i].getLocation().x;
            locationY[i] = arrayPanel[i].getLocation().y;

            JLabel arrayLaybel = new JLabel();
            arrayLaybel.setFont(new Font("Verdana", Font.BOLD, 20));
            arrayLaybel.setText(sortingList.get(i).toString());

            arrayPanel[i].add(arrayLaybel);

            add(arrayPanel[i]);

        }
        repaint();
        validate();
    }

    public void startSort(String typeSort) {
        if (!running) {
            running = true;
        }
        thread = switch (typeSort) {
            case "Bubble" ->
                new Thread(new BubbleSort(this));
            case "Selection" ->
                new Thread(new SelectionSort(this));
            case "Merge" ->
                new Thread(new MergeSort(this));
            default ->
                new Thread(new BubbleSort(this));
        };
        thread.start();
    }

    public void stopSort() {
        if (running) {
            running = false;
        }
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(SortingPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(1);
    }

    public List<Integer> getSortingList() {
        return sortingList;
    }

    public void setSortingList(List<Integer> sortingList) {
        this.sortingList = sortingList;
    }

    public void goDown(int index) {

        System.out.println("D");
//        if (movingPanel[index][RIGHT] || movingPanel[index][LEFT]||movingPanel[index][UP]) return;
//        movingPanel[index][DOWN] = true;
//        while (arrayPanel[index].getLocation().y < 2 * SPHEIGHT / 3) {
        int xnow = arrayPanel[index].getLocation().x;
        int ynow = arrayPanel[index].getLocation().y;
        arrayPanel[index].setLocation(xnow, ynow + 10);
        if (ynow >= 2*SPHEIGHT/3) {
            arrayPanel[index].setLocation(xnow, 2*SPHEIGHT/3);
            downRun = false;
        }
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(SortingPanel.class.getName()).log(Level.SEVERE, null, ex);
//            }

//        }
    }

    public void goUp(int index) {

        int xnow = arrayPanel[index].getLocation().x;
        int ynow = arrayPanel[index].getLocation().y;
        arrayPanel[index].setLocation(xnow, ynow - 10);
        if (ynow <=SPHEIGHT / 10) {
            arrayPanel[index].setLocation(xnow,SPHEIGHT/10);
            UpRun = false;
        }

    }

    public void goRight(int index, int x) {

        int xnow = arrayPanel[index].getLocation().x;
        int ynow = arrayPanel[index].getLocation().y;
        arrayPanel[index].setLocation(xnow + 10, ynow);
        if (xnow >=x) {
            arrayPanel[index].setLocation(x, ynow);
            RightLeftRun = false;
        }

    }

    public void goLeft(int index, int x) {

        int xnow = arrayPanel[index].getLocation().x;
        int ynow = arrayPanel[index].getLocation().y;
        arrayPanel[index].setLocation(xnow - 10, ynow);
        if (xnow<=x){
            arrayPanel[index].setLocation(x, ynow);
        }
        
    }

}
