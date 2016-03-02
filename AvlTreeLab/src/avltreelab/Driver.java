/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltreelab;


import java.util.*;

public class Driver
{
	public static void main(String [] args)
	{
	   AVLTree avl = new AVLTree();
	   Scanner scan = new Scanner(System.in);
	   int start = 0;
	   do{
	     System.out.println("Add what? (-1 to quit)");
	     start = scan.nextInt();
	     scan.nextLine();
	     boolean ans = avl.add(start);
	     if(!ans)
	        System.out.println(start + " not added");
	    } while(start != -1);
	    
	    System.out.println("Goodbye");
	}
}

