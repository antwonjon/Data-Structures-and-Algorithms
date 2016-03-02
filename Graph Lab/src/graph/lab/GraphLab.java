 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.lab;

import java.io.File;

/**
 *
 * @author AJ
 */
public class GraphLab {

    public static void main(String[] args) {
        File adjacencyFile = new File("graphLab.txt");
        File weightedFile = new File("weighted.txt");
        int graphSize = 5;
        Algorithms object = new Algorithms();
        object.addFile(weightedFile, graphSize);
        object.breadthSearch(0);
        object.depthSearch(0);
        object.floydW();
        object.floyd();
    }

}
