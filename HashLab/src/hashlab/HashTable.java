/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashlab;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class HashTable {
    private Sets[] array = new Sets[5];
    private Scanner scan = new Scanner(System.in);
    public int size;

    public Sets[] addTextFile() {
        File file = new File("testText.txt");
        Sets[] array = new Sets[27];
        try {

            Scanner sc = new Scanner(file);
            int i = 0;
            while (sc.hasNextLine()) {
                int key = sc.nextInt();
                array[i].setKey(key);
                i++;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return array;
    }

    public Sets[] add() {
        if (((double) size / (double) array.length) < .8) { // if the load is less than 80%    
            addToArray();         
            size++;
        } else {
            array = rehash();
        }

        return array;
    }

    public void addToArray() {
        System.out.println("What name would you like to add?");
        String newName = scan.next();
        System.out.println("What number would you like to add?");
        int newNumber = Integer.parseInt(scan.next());
        addSearch(newNumber, newName);
        System.out.println("");

    }

    public void addSearch(int newNumber, String newName) {
        int index = newNumber % array.length;
        while (index < array.length && array[index] != null) {
            index++;
        }
        if (index >= array.length) {//this is for when the index runs over the edge of the array
            index = 0;
            while (array[index] != null) {
                index++;
            }
        }
        array[index] = new Sets(newNumber, newName);
    }

    public Sets[] rehash() {
        Sets[] newArray = new Sets[array.length * 2];
        size = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null || array[i].getKey() == -99) {  //checking for removed #'s
            } else {
                addSearch(array[i].getKey(), array[i].getValue());
                size++;
            }
        }
        return newArray;
    }

    public void printArray() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                System.out.print("");
            } else {
                System.out.println("Name: " + array[i].getValue());
                System.out.println("Number: " + array[i].getKey());
            }
        }
    }

    public boolean checkDone() {
        System.out.println("Are you ready to be done? Yes(y) or No(n)?");
        String flag = "";
        while (!flag.equals("y") && !flag.equals("n")) {
            flag = scan.next();
            if (flag.equals("y")) {
                return false;
            }
            if (flag.equals("n")) {
                return true;
            }
        }
        return true;
    }

    public String searchKey(int key) {
        int index = key % array.length;
        while (index < array.length && array[index] != null) {
            index++;
        }
        if (index >= array.length) {//this is for when the index runs over the edge of the array
            index = 0;
            while (array[index] != null) {
                index++;
            }
        }
        return array[index].getValue();
    }

    public void delete(int key) {
        int index = key % array.length;
        while (index < array.length && array[index] != null) {
            index++;
        }
        if (index >= array.length) {//this is for when the index runs over the edge of the array
            index = 0;
            while (array[index] != null) {
                index++;
            }
        }
        array[index].setKey(-99);
    }
}
