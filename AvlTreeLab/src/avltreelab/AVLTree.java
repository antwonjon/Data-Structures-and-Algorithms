/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltreelab;

import java.util.*;

public class AVLTree {

    private Node root;
    private boolean increase;
    private boolean decrease;
    private boolean addReturn;
    private Scanner stop;

    public AVLTree() {
        root = null;
        addReturn = false;
        increase = false;
        stop = new Scanner(System.in);
    }

    public boolean add(int item) {

        System.out.println("Starting to search for a a place to put " + item);
        increase = false;
        root = add(root, item);
        return addReturn;
    }

    private Node add(Node localRoot, int item) {

        if (localRoot == null) { // if the root is null
            addReturn = true;
            increase = true;
            System.out.println("Added " + item);
            return new Node(item);
        }
        System.out.println("Add called with " + localRoot.getItem() + " as the root.");
        if (item == localRoot.getItem()) {                                //item is alreday in tree
            increase = false;
            addReturn = false;
            return localRoot;
        } else if (item < localRoot.getItem()) {
            System.out.println("Branching left");                          // item < data
            localRoot.setLeft(add(localRoot.getLeft(), item));

            if (increase) {
                decrementBalance(localRoot);
                if (localRoot.balance < Node.LEFT_HEAVY) {
                    increase = false;
                    return rebalanceLeft(localRoot);
                }
            }
            return localRoot;                                            // Rebalance not needed.
        } else {
            System.out.println("Branching right");                         // item > data
            localRoot.setRight(add(localRoot.getRight(), item));
            if (increase) {
                incrementBalance(localRoot);
                if (localRoot.balance > Node.RIGHT_HEAVY) {
                    return rebalanceRight(localRoot);
                } else {
                    return localRoot;
                }
            } else {
                return localRoot;
            }
        }

    }

    private void decrementBalance(Node node) {
        node.balance--;
        if (node.balance == Node.BALANCED) {
            increase = false;
        }
    }

    private Node rebalanceRight(Node localRoot) {

        // Obtain reference to right child
        Node parent = localRoot.getRight();
        // See if right-left heavy
        if (parent.balance == Node.LEFT_HEAVY) {
            // Obtain reference to right-left child
            Node child = parent.getLeft();
            /* Adjust the balances to be their new values after
             the rotates are performed.
             */
            if (child.balance > Node.BALANCED) {
                localRoot.balance = Node.BALANCED;
                parent.balance = Node.RIGHT_HEAVY;
                child.balance = Node.LEFT_HEAVY;
            } else if (child.balance < Node.BALANCED) {
                localRoot.balance = Node.RIGHT_HEAVY;
                parent.balance = Node.BALANCED;
                child.balance = Node.LEFT_HEAVY;
            } else {
                localRoot.balance = Node.BALANCED;
                parent.balance = Node.BALANCED;
                child.balance = Node.BALANCED;
            }
            /**
             * After the rotates the overall height will be reduced thus
             * increase is now false, but decrease is now true.
             */
            increase = false;
            decrease = true;
            // Perform double rotation

            return rotateLeft(rotateRight(localRoot));
        }
        if (parent.balance == Node.BALANCED && localRoot.balance == Node.BALANCED) {
            /* In this case both the rightChild (the new root)
             and the root (new left child) will both be balanced
             after the rotate. Also the overall height will be
             reduced, thus increase will be false, but decrease
             will be true.
             */

        } else {
            /* After the rotate the rightChild (new root) will
             be left heavy, and the local root (new left child)
             will be right heavy. The overall height of the tree
             will not change, thus increase and decrease remain
             unchanged.
             */

        }
        // Now rotate the
        return rotateLeft(localRoot);
    }

    private Node rebalanceLeft(Node localRoot) {
        // Obtain reference to right child
        Node parent = localRoot.getLeft();
        // See if right-left heavy
        if (parent.balance == Node.RIGHT_HEAVY) {
            // Obtain reference to right-left child
            Node child = parent.getRight();
            /* Adjust the balances to be their new values after
             the rotates are performed.
             */
            if (child.balance < Node.BALANCED) {
                localRoot.balance = Node.BALANCED;
                parent.balance = Node.RIGHT_HEAVY;
                child.balance = Node.LEFT_HEAVY;
            } else if (child.balance > Node.BALANCED) {
                localRoot.balance = Node.RIGHT_HEAVY;
                parent.balance = Node.BALANCED;
                child.balance = Node.LEFT_HEAVY;
            } else {
                localRoot.balance = Node.BALANCED;
                parent.balance = Node.BALANCED;
                child.balance = Node.BALANCED;
            }
            /**
             * After the rotates the overall height will be reduced thus
             * increase is now false, but decrease is now true.
             */
            increase = false;
            decrease = true;
            // Perform double rotation

            return rotateRight(rotateLeft(localRoot));
        }
        if (parent.balance == Node.BALANCED && localRoot.balance == Node.BALANCED) {
            /* In this case both the rightChild (the new root)
             and the root (new left child) will both be balanced
             after the rotate. Also the overall height will be
             reduced, thus increase will be false, but decrease
             will be true.
             */

        } else {
            /* After the rotate the rightChild (new root) will
             be left heavy, and the local root (new left child)
             will be right heavy. The overall height of the tree
             will not change, thus increase and decrease remain
             unchanged.
             */

        }
        // Now rotate the
        return rotateLeft(localRoot);
    }

    private void incrementBalance(Node node) {
        node.balance++;
        if (node.balance > Node.BALANCED) {
            /* if now right heavy, the overall height has increased, but
             it has not decreased */
            increase = true;
            decrease = false;
        } else {
            /* if now balanced, the overall height has not increased, but
             it has decreased. */
            increase = false;
            decrease = true;
        }
    }

    private Node rotateRight(Node localRoot) {
        System.out.println("Rotating Right");
        //There is where you set up your references to get the proper rotation
        //see hint in rotateLeft
        Node parent = localRoot.getRight();
        if(parent.getLeft().getRight()!=null){
        parent.setLeft(parent.getLeft().getRight());
        }
        parent.getLeft().setRight(parent);        
        return parent;
    }

    private Node rotateLeft(Node localRoot) {
        System.out.println("Rotating Left");
        //// hint this was only three lines that I took out. 
        Node parent = localRoot.getLeft();
         if(parent.getRight().getLeft()!=null){
        parent.setLeft(parent.getRight().getLeft());
        }
        parent.getRight().setLeft(parent);        
        return parent;
    }

}
