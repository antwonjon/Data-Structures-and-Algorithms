/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

public class Driver
{
    public static void main (String [] args)
    {
        LinkedList<Song> list = 
            new LinkedList<Song>(new Song("??", "ZZZ", 0));
        Song song;
        Node<Song> node;
        
        song = new Song("I Cant Get No Satisfaction", "Rolling Stones", 1965);
        node = new Node<Song>(song);
        list.addInOrder(node);
        
        song = new Song("A Hard Day's Night", "Beatles", 1964);
        node = new Node<Song>(song);
        list.addInOrder(node);
        
        song = new Song("Jumpin' Jack Flash", "Rolling Stones", 1968);
        node = new Node<Song>(song);
        list.addInOrder(node);
        
        song = new Song("Not Fade Away", "Rolling Stones", 1964);
        node = new Node<Song>(song);
        list.addInOrder(node);
        
        song = new Song("Michelle", "Beatles", 1965);
        node = new Node<Song>(song);
        list.addInOrder(node);
        
        System.out.println("Forwards Print\n");
        list.print();
        
        System.out.println("\nRemove item\n");
        song = new Song("A Hard Day's Night", "Beatles", 1964);
        node = new Node<Song>(song);
        list.remove(node);
        System.out.println("Forwards Print - 2\n");
        list.print();
        
        System.out.println("\nBackwards Print\n");
        list.printBackwards();
    }
}