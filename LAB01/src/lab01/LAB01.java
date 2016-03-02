/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01;

/**
 *
 * @author AJ
 */
public class LAB01 {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.insert(46);
        tree.insert(55);
        tree.insert(63);
        tree.insert(72);
        tree.insert(13);
        tree.insert(22);
        tree.insert(3);

        System.out.println("In Order");
        tree.inOrder();
        System.out.println("");
        System.out.println("Post Order");
        tree.postOrder();
        System.out.println("");
        System.out.println("Pre Order");
        tree.preOrder();
        
        
        tree.remove(63);
        System.out.println("");
        System.out.println("In Order");
        tree.inOrder();
        System.out.println("");
        System.out.println("Post Order");
        tree.postOrder();
        System.out.println("");
        System.out.println("Pre Order");
        tree.preOrder();
        System.out.println("");
    }

}
