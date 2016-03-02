/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking;

/**
 *
 * @author AJ
 */
public class MagicSquare {

    Node[] square;
    Node[] number;
    int dimension;

    private void populateNumbas(int size) {
        number = new Node[size];
        for (int i = 0; i < size; i++) {
            number[i] = new Node(i + 1);
        }
    }

    public void function(int dimension) {
        int size = dimension * dimension;
        populateNumbas(size);
        square = new Node[size];
        for (int i = 0; i < size; i++) {
            square[i] = new Node(0);
        }
        this.dimension = dimension;
    }

    public void recursive() {
        recursive(0);
    }

    private void recursive(int position) {
        for (int i = 0; i < number.length; i++) {
            if (number[i].isUsed() == false) {

                number[i].setUsed(true);
                square[position].setNumber(number[i].getNumber());
                if (solutionValid(position) == true) {
                    if (solved(position) == true) {
                        for (int j = 0; j < square.length; j++) {
                            System.out.println("Position " + i + " is " + square[i]);
                        }
                    } else {
                        recursive(position + 1);
                    }
                }
                number[i].setUsed(false);
                square[position].setNumber(null);
            }
        }
    }

    private boolean solutionValid(int position) {
        if (rowFilled() == true) {
            if (square[position - 2] != null && square[position - 1] != null) {
                if (square[position - 2].getNumber() + square[position - 1].getNumber() + square[position].getNumber() == 15) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        if (columnFilled() == true) {
            if (square[position - 6].getNumber() + square[position - 3].getNumber() + square[position].getNumber() == 15) {
                return true;
            } else {
                return false;
            }
        }
        if (square[position - 4].getNumber() + square[position - 2].getNumber() + square[position].getNumber() == 15) {
            return true;
        }

        return false;
    }

    private boolean rowFilled() {
        if (square[0].getNumber() != 0 && square[1].getNumber() != 0 && square[2].getNumber() != 0) {//checking to see if row is filled
            return true;
        }
        if (square[3].getNumber() != 0 && square[4].getNumber() != 0 && square[5].getNumber() != 0) {//checking to see if row is filled
            return true;
        }
        if (square[6].getNumber() != 0 && square[7].getNumber() != 0 && square[8].getNumber() != 0) {//checking to see if row is filled
            return true;
        }
        return false;
    }

    private boolean columnFilled() {
        if (square[0].getNumber() != 0 && square[4].getNumber() != 0 && square[7].getNumber() != 0) {
            return true;
        }
        if (square[1].getNumber() != 0 && square[5].getNumber() != 0 && square[8].getNumber() != 0) {
            return true;
        }
        if (square[2].getNumber() != 0 && square[6].getNumber() != 0 && square[9].getNumber() != 0) {
            return true;
        }
        return false;
    }

    private boolean solved(int position) {
        if (square[position - 8].getNumber() + square[position - 4].getNumber() + square[position].getNumber() == 15) {
            return true;
        }
        return false;
    }

}
