/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

/**
 *
 * @author AJ
 */
public class Node<E extends Comparable> implements Comparable<Node> {

    private int frequency;
    private Character name;
    private Node left;
    private Node right;
    public static Node root;
    
    public Node(Character name) {
        this.name = name;
        this.frequency = 1;
    }

    public void add() {
        this.frequency += 1;
    }
    
    public int compareTo(Node node){
        if(node.getFrequency()>this.getFrequency()){
            return -1;
        }
        else if(node.getFrequency()<this.getFrequency()){
            return 1;
        }
       return 0;
    }

    public Character getName() {
        return name;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setName(Character name) {
        this.name = name;
    }
    
    public int getFrequency() {
        return frequency;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    
    public boolean isLeaf(){
        if(getLeft()==null && getRight()==null){
            return true;
        }
        return false;
    }
}
