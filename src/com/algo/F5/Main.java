package com.algo.F5;

import com.algo.F5.Redovisning.Info;
import com.algo.F5.Redovisning.Uppgift5;

import java.util.ArrayList;

/**
 * Created by timothy on 2017-01-30, com.algo.F5.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            arrayList.add(i * 2);
        }
        System.out.println(RecursiveStaticHighestInt.calculate(arrayList, 0));

        System.out.println(RecursiveStaticExponent.calculate(8, 5));

        System.out.println(SquareRoot.squareRoot(9, 1, 0.001));

        //System.out.println(CoinMachine.coinMachine(109, 0, 1, 0));

        //Becad becad = new Becad();
        //System.out.println(becad.becad("BECAD"));
        Uppgift5 uppgift5 = new Uppgift5();
        String string = "BEACD";
        Info info = uppgift5.solve(string);
        System.out.println(String.format("Ordning: %s Tar %d steg: %s", string, info.getSteps(), info.getCharacterArrayList()));
    }
}
