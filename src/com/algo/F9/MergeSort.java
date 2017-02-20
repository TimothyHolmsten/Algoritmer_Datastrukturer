package com.algo.F9;

/**
 * Created by timothy on 2017-02-14, com.algo.F9.
 */
public class MergeSort {
    public static int[] sort(int[] ints) {
        if (ints.length <= 1)
            return ints;
        int lengthA = ((ints.length / 2)); // Made this for debugging
        int[] a = new int[lengthA];
        int difference = ints.length - ((ints.length / 2));
        int[] b = new int[difference];
        int j = 0;
        for (int i = 0; i < ints.length; i++)
            if (i < (ints.length / 2))
                a[i] = ints[i];
            else
                b[j++] = ints[i];
        sort(a);
        sort(b);
        return merge(a, b, ints);
    }

    private static int[] merge(int[] a, int[] b, int[] c) {
        int indexA = 0, indexB = 0, indexC = 0;

        while (indexA < a.length && indexB < b.length)
            if (a[indexA] <= b[indexB]) {
                c[indexC++] = a[indexA];
                indexA++;
            } else {
                c[indexC++] = b[indexB];
                indexB++;
            }

        while (indexA < a.length) {
            c[indexC++] = a[indexA];
            indexA++;
        }
        while (indexB < b.length) {
            c[indexC++] = b[indexB];
            indexB++;
        }
        return c;
    }
}
