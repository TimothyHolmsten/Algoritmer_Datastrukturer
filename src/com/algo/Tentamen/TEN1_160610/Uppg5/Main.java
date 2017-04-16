package com.algo.Tentamen.TEN1_160610.Uppg5;

/**
 * Created by timothy on 2017-03-03, com.algo.Tentamen.TEN1_160610.Uppg5.
 */


import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        //representation av br‰dlayouten d‰r varje rad och kolumn representerar en plats
        //0=A,1=B,2=C,3=D,4=E,5=F,6=G,7=H,8=I,9=J,10=K,11=L,12=M,13=N,14=O
        // -1 pÂ sk‰rninngspunkten mellan tvÂ platser betyder att det inte gÂr att hoppa mellan dessa
        // Ex 4 pÂ sk‰rningspunkten betyder att om man hoppar mellan platserna sÂ ska kulan pÂ E tas bort
        //						  A  B  C  D  E  F  G  H  I  J  K  L  M  N  O
        int[][] boardlayout = {{-1, -1, -1, 1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, 3, -1, 4, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, 4, -1, 5, -1, -1, -1, -1, -1},
                {1, -1, -1, -1, -1, 4, -1, -1, -1, -1, 6, -1, 7, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 7, -1, 8, -1},
                {2, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, 8, -1, 9},
                {-1, 3, -1, -1, -1, -1, -1, -1, 7, -1, -1, -1, -1, -1, -1},
                {-1, -1, 4, -1, -1, -1, -1, -1, -1, 8, -1, -1, -1, -1, -1},
                {-1, 4, -1, -1, -1, -1, 7, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, 5, -1, -1, -1, -1, 8, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, 6, -1, -1, -1, -1, -1, -1, -1, -1, 11, -1, -1},
                {-1, -1, -1, -1, 7, -1, -1, -1, -1, -1, -1, -1, -1, 12, -1},
                {-1, -1, -1, 7, -1, 8, -1, -1, -1, -1, 11, -1, -1, -1, 13},
                {-1, -1, -1, -1, 8, -1, -1, -1, -1, -1, -1, 12, -1, -1, -1},
                {-1, -1, -1, -1, -1, 9, -1, -1, -1, -1, -1, -1, 13, -1, -1}};
        String name = JOptionPane.showInputDialog("Ange tom plats:");
        char tomChar = name.charAt(0);
        //representation av br‰dets tillstÂnd igen med A=0, ...O=14
        boolean[] board = new boolean[15];//false=kula, true=tom
        board[tomChar - 'A'] = true;
        String moves = "";
        solveSolitare(boardlayout, board, 14, moves);
        System.out.println("Lˆsning saknas");
    }

    private static void solveSolitare(int[][] boardlayout, boolean[] board, int nrBallsLeft, String moves) {
        if (nrBallsLeft == 1) {
            System.out.println(moves);
            System.exit(0);
        }
        for (int jumpTo = 0; jumpTo < board.length; jumpTo++) {
            if (board[jumpTo]) {
                for (int jumpFrom = 0; jumpFrom < board.length; jumpFrom++) {
                    if (boardlayout[jumpTo][jumpFrom] != -1 && !board[jumpFrom]) {
                        if (!board[boardlayout[jumpTo][jumpFrom]]) {
                            board[boardlayout[jumpTo][jumpFrom]] = true;
                            board[jumpFrom] = true;
                            board[jumpTo] = false;
                            solveSolitare(boardlayout, board, nrBallsLeft - 1, moves + (": " + ((char) (jumpFrom + 'A')) + "-" + ((char) (jumpTo + 'A'))));
                            board[boardlayout[jumpTo][jumpFrom]] = false;
                            board[jumpFrom] = false;
                            board[jumpTo] = true;
                        }
                    }
                }
            }
        }

    }

}
