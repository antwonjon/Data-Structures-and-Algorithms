/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.PriorityQueue;

/**
 *
 * @author AJ
 */
public class Convert {

    ArrayList<Node> unsorted = new ArrayList<>();
    PriorityQueue<Node> queue;
    ArrayList<Character> names;
    ArrayList<String> codes;
    String binaryString = "";

    private ArrayList<String> readFile(File file) {
        ArrayList<String> array = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);

            sc.useDelimiter("");
            while (sc.hasNextLine()) {
                String key = sc.next();
                array.add(key);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return array;
    }

    public void addFile(File file) {
        ArrayList<String> array = readFile(file);
        int position;
        // this function parses out the text file
        for (int i = 0; i < array.size(); i++) {
            position = searchUnsorted(array.get(i).charAt(0));

            if (position == -1) {
                //create a new node because its not in the arraylist unsorted
                unsorted.add(new Node(array.get(i).charAt(0)));
            } else {
                unsorted.get(position).add();
            }

        }
    }

    private int searchUnsorted(Character value) {
        for (int i = 0; i < unsorted.size(); i++) {
            if (value.equals(unsorted.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    private PriorityQueue addToPriority() {
        queue = new PriorityQueue();
        for (int i = 0; i < unsorted.size(); i++) {
            queue.add(unsorted.get(i));
        }

        return queue;
    }

    public void addToTree() {
        queue = addToPriority();
        Node temp1;
        Node temp2;
        Node newNode;
        while (queue.size() > 1) {
            temp1 = queue.poll();
            temp2 = queue.poll();
            newNode = new Node(null);
            newNode.setLeft(temp1);
            newNode.setRight(temp2);
            newNode.setFrequency(temp1.getFrequency() + temp2.getFrequency());
            queue.add(newNode);
        }
        Node.root = queue.peek();
    }

    public void makeTree() {
        codes = new ArrayList();
        names = new ArrayList();
        makesTree(Node.root, "");

    }

    //helper method
    private void makesTree(Node cur, String binary) {
        if (cur == null) {
            return;
        }
        if (cur.getName() != null) {
            codes.add(binary);
            names.add(cur.getName());
        }
        makesTree(cur.getLeft(), binary + 0);
        makesTree(cur.getRight(), binary + 1);
    }

    public void print() {
        for (int i = 0; i < codes.size(); i++) {
            System.out.println(names.get(i) + " " + codes.get(i));
        }
    }

    public void interpretToBinary(File file) {
        ArrayList<String> array = readFile(file);
        int position;
        // this function parses out the text file
        for (int i = 0; i < array.size(); i++) {
            position = searchNames(array.get(i).charAt(0));
            binaryString += codes.get(position);
        }
        saveBinary(binaryString, file);
    }

    private int searchNames(Character name) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i) == name) {
                return i;
            }
        }
        return -1;
    }

    public void saveBinary(String binaryString, File file) {

        try {
            PrintWriter outFile = new PrintWriter("101" + file);
            outFile.print(binaryString);
            outFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find that file");
        }
    }

    public void reAddBinary(String filename) {
        ArrayList<String> array = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("101" + filename));
            sc.useDelimiter("");
            int code;
            String newFile = "";
            Node cur = Node.root;
            while (sc.hasNextLine()) {
              
                code = Integer.parseInt(sc.next());
                if (code == 1) {
                    cur = cur.getRight();
                } else {
                    cur = cur.getLeft();
                }
                if (cur.isLeaf() == true) {
                    newFile += cur.getName();
                    cur = Node.root;
                }
            }
            saveCharacters(newFile, filename);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find that file");
        }
        
    }
    
     public void saveCharacters(String charString, String file) {

        try {
            PrintWriter outFile = new PrintWriter("ABC" + file);
            outFile.print(charString);
            outFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find that file");
        }
    }
}
    