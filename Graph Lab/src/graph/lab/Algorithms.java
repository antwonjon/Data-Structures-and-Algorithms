/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.lab;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.PriorityQueue;

/**
 *
 * @author AJ
 */
public class Algorithms {

    int[][] array2D;
    ArrayList<Integer> identified;
  
    

    private String[] readFile(File file, int size) {
        String[] array = new String[size];
        try {
            Scanner sc = new Scanner(file);
            size = 0;
            while (sc.hasNextLine()) {
                String key = sc.next();

                array[size] = key;
                size++;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return array;
    }

    public void addFile(File file, int size) {
        String[] array = readFile(file, size);
        array2D = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            int k = 1;
            for (int j = 0; j < array.length; j++) {
                if (Integer.valueOf(array[i].substring(j, k)) == 0 && array2D[i][i] != array2D[i][j]) {
                    array2D[i][j] = 999;
                } else {
                    array2D[i][j] = Integer.valueOf(array[i].substring(j, k));
                }
                k++;
            }
        }
    }

    public void breadthSearch(int row) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        identified = new ArrayList<>();
        boolean flag;
        queue.add(row);
        identified.add(row);
        do {
            for (int i = 0; i < array2D.length; i++) {
                flag = inIdentified(i);
                if (array2D[row][i] != 0 && array2D[row][i] != 999 && flag == false) {
                    queue.add(i);

                    identified.add(i);
                }
            }

            visited.add(row);
            queue.remove();
            if (queue.peek() == null) {
                break;
            }
            row = queue.peek();

        } while (!queue.isEmpty());
        System.out.println("Breadth First: ");
        print(visited);
    }

    public boolean inIdentified(int check) {
        boolean flag = false;
        for (int i = 0; i < identified.size(); i++) {
            if (check == identified.get(i)) {
                return flag = true;
            }
        }
        return flag;
    }

    public void print(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public void depthSearch(int row) {
        identified = new ArrayList<>();
        identified = dSHelper(row);
        System.out.println("");
        System.out.println("Depth First:");
        print(identified);
    }

    private ArrayList<Integer> dSHelper(int row) {
        identified.add(row);
        for (int i = 0; i < array2D.length; i++) {
            if (array2D[row][i] != 0 && array2D[row][i] != 999 && inIdentified(i) == false) {
                dSHelper(i);
            }
        }
        return identified;
    }
    
    public void dijkstra(int row){
        identified.add(row);
        
    }
    
    public void prim(int node){
        
    }
    
    public void floyd(){
        System.out.println("");
        System.out.println("Floyd");
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D.length; j++) {
                if(array2D[i][j]==999 || array2D[i][j]==0){
                }
                else{
                    System.out.println("Node " + i +" --> node " + j );
                }
            }
        }
        
        
    }
    
    public void floydW(){
        
        identified = new ArrayList<>();
        for (int k = 0; k < array2D.length; k++) {
            for (int i = 0; i < array2D.length; i++) {
                for (int j = 0; j < array2D.length; j++) {
                    if(array2D[i][j]>array2D[i][k]+array2D[k][j]){
                         if(inIdentified(j)==false){
                            identified.add(j);
                             System.out.println("Adding " + j);
                        }
                    }
                }
            }
        }
        System.out.println("");
        System.out.println("Floyd Warsall's:");
                
        print(identified);
    }
   
}
