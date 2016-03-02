/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltreelab;


public class Node
{
  private int item;
  private Node left;
  private Node right;
  
  public static final int BALANCED = 0;
  public static final int RIGHT_HEAVY = 1;
  public static final int LEFT_HEAVY = -1;
  public int balance = 0;
  
  Node(int a)
  {
      item = a;
  }
  
  public int getItem()
  {
      return item;
  }
  
  public void setRight(Node i)
  {
     right = i;
   }
  public void setLeft(Node i)
  {
     left = i;
   }
   public Node getLeft()
   { 
       return left;
   }
   public Node getRight()
   {
      return right;
   }
  
}
