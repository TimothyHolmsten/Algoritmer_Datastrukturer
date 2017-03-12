package com.algo.TEN1_160610.Uppg4;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        int X = Integer.MAX_VALUE;
        LinkedList<Edge>[] adjacencyList = new LinkedList[8];

        //h�r �r grafexemplet fr�n provet h�rdkodad (A=0, B=1, C=2, D=3, E=4, F=5, G=6, H=7)
        //din kod ska naturligtvis klara godtycklig graf representerad p� samma s�tt
        adjacencyList[0] = new LinkedList<Edge>();//lista med A's b�gar
        adjacencyList[0].add(new Edge(1, 2));//b�gen fr�n A till B har vikten 2
        adjacencyList[0].add(new Edge(5, 1));//b�gen fr�n A till F har vikten 1
        adjacencyList[1] = new LinkedList<Edge>();//lista med B's b�gar
        adjacencyList[1].add(new Edge(0, 2));//b�gen fr�n B till A har vikten 2
        adjacencyList[1].add(new Edge(2, 2));//osv
        adjacencyList[1].add(new Edge(3, 2));
        adjacencyList[1].add(new Edge(4, 4));
        adjacencyList[2] = new LinkedList<Edge>();
        adjacencyList[2].add(new Edge(1, 2));
        adjacencyList[2].add(new Edge(4, 3));
        adjacencyList[2].add(new Edge(7, 1));
        adjacencyList[3] = new LinkedList<Edge>();
        adjacencyList[3].add(new Edge(1, 2));
        adjacencyList[3].add(new Edge(4, 3));
        adjacencyList[3].add(new Edge(5, 1));
        adjacencyList[4] = new LinkedList<Edge>();
        adjacencyList[4].add(new Edge(1, 4));
        adjacencyList[4].add(new Edge(2, 3));
        adjacencyList[4].add(new Edge(3, 3));
        adjacencyList[4].add(new Edge(6, 7));
        adjacencyList[5] = new LinkedList<Edge>();
        adjacencyList[5].add(new Edge(0, 1));
        adjacencyList[5].add(new Edge(3, 1));
        adjacencyList[5].add(new Edge(6, 5));
        adjacencyList[6] = new LinkedList<Edge>();
        adjacencyList[6].add(new Edge(4, 7));
        adjacencyList[6].add(new Edge(5, 5));
        adjacencyList[6].add(new Edge(7, 6));
        adjacencyList[7] = new LinkedList<Edge>();
        adjacencyList[7].add(new Edge(2, 1));
        adjacencyList[7].add(new Edge(6, 6));
        System.out.println(prim(adjacencyList));

        //f�rbindelsematris - anv�nd denna om du inte klarar f�rbindelselistan f�r maximalt 2p
        /*int[][] w = {
                        {	X, 2, X, X, X, 1, X, X},
						{	2, X, 2, 2, 4, X, X, X},
						{	X, 2, X, X, 3, X, X, 1},
						{	X, 2, X, X, 3, 1, X, X},
						{	X, 4, 3, 3, X, X, 7, X},
						{	1, X, X, 1, X, X, 5, X},
						{	X, X, X, X, 7, 5, X, 6},
						{	X, X, 1, X, X, X, 6, X}};*/


    }

    /*
    I think this is prims...
     */
    private static int prim(LinkedList<Edge>[] adjacencyList) {
        int node = 0;
        int currentNode = 0;
        int min = Integer.MAX_VALUE;
        int totalCost = 0;
        for (LinkedList<Edge> list : adjacencyList) {
            min = Integer.MAX_VALUE;
            for (Edge edge : list)
                if (edge.weight < min) {
                    min = edge.weight;
                    node = edge.connectedNode;
                }
            for (Edge edge : adjacencyList[node])
                if (edge.connectedNode == currentNode) {
                    adjacencyList[node].remove(edge);
                    break;
                }
            totalCost += min;
        }
        return totalCost;
    }

    //i denna implementation h�r ett edge-object till en nod (den vars nods lista den ligger i).
    //den representerar d� b�gen fr�n denna nod till connectedNode och har vikten weight
    private static class Edge {
        private int connectedNode, weight;

        public Edge(int cN, int w) {
            connectedNode = cN;
            weight = w;
        }
    }

}