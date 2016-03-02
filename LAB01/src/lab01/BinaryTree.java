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
import java.util.ArrayList;

public class BinaryTree {

    Node root;


    public BinaryTree() {
        root = null;
    }

    public void insert(int newValue) {
        if (root == null) {
            root = new Node(newValue);
        } else {
            Node currentNode = root;
            boolean placed = false;
            while (!placed) {
                if (newValue < currentNode.getValue()) {
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(new Node(newValue));
                        currentNode.getLeft().setParent(currentNode);
                        placed = true;
                    } else {
                        currentNode = currentNode.getLeft();
                    }
                } else {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(new Node(newValue));
                        currentNode.getRight().setParent(currentNode);
                        placed = true;
                    } else {
                        currentNode = currentNode.getRight();
                    }
                }
            }
        }
    }

    public Node search(int value, Node n) {
        if (n == null) {
            return null;
        } else if (value == n.getValue()) {
            return n;
        } else if (value < n.getValue()) {
            return search(value, n.getLeft());
        } else if (value > n.getValue()) {            
            return search(value, n.getRight());

        }
        return null;
    }

    public boolean remove(int value) {
        Node rn = search(value, root);
        return remove(rn);
    }

    private boolean remove(Node rn) {
        if (rn == null) {
            return false;
        }
        if (rn.getLeft() == null || rn.getRight() == null) {
            if (rn.getLeft() != null) {
                if (rn == root) {
                    root = rn.getLeft();
                    root.setParent(null);
                } else if (rn.getParent().getRight() == rn) {
                    rn.getParent().setRight(rn.getLeft());
                } else {
                    rn.getParent().setLeft(rn.getLeft());
                }
                rn.getLeft().setParent(rn.getParent());
            } else if (rn.getRight() != null) {
                if (rn == root) {
                    root = rn.getRight();
                    root.setParent(null);
                } else if (rn.getParent().getRight() == rn) {
                    rn.getParent().setRight(rn.getRight());
                } else {
                    rn.getParent().setLeft(rn.getRight());
                }
                rn.getRight().setParent(rn.getParent());

            } else {
                if (rn == root) {
                    root = null;
                } else if (rn.getParent().getRight() == rn) {
                    rn.getParent().setRight(null);
                } else {
                    rn.getParent().setLeft(null);
                }
            }
        } else {
            Node left = rn.getLeft();
            Node next = left;
            while (next.getRight() != null) {
                next = next.getRight();
            }

            rn.setValue(next.getValue());
            remove(next);

        }

        return true;
    }
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node current) {
        if (current.getLeft() != null) {
            inOrder(current.getLeft());
        }
        System.out.print(" " + current.getValue());

        if (current.getRight() != null) {
            inOrder(current.getRight());
        }

    }
    
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node current) {
        System.out.print(" " + current.getValue());
        if (current.getLeft() != null) {
            preOrder(current.getLeft());
        }

        if (current.getRight() != null) {
            preOrder(current.getRight());
        }
    }
    
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node current) {

        if (current.getLeft() != null) {
            postOrder(current.getLeft());
        }

        if (current.getRight() != null) {
            postOrder(current.getRight());
        }
        System.out.print(" " + current.getValue());
    }
}
