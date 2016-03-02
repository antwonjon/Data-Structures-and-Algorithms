/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.io.File;

/**
 *
 * @author AJ
 */
public class Huffman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File file = new File("huffman.txt");
        String filezzz = "huffman.txt";
        Convert convert = new Convert();
        convert.addFile(file);
        convert.addToTree();
        convert.makeTree();
        convert.interpretToBinary(file);
        convert.reAddBinary(filezzz);
        
    }
    
}
