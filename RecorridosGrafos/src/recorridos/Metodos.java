package recorridos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Metodos {

    boolean[] visitadosD;

    public Metodos(int nVertices) {
        visitadosD = new boolean[nVertices];
    }

    public LinkedList<Integer>[] toLinkedListMatress(int grafo[][]) {
        LinkedList<Integer> adjLists[] = new LinkedList[grafo.length];
        for (int j = 0; j < grafo.length; j++) {
            adjLists[j] = new LinkedList<Integer>();
        }
        for (int a = 0; a < grafo.length; a++) {
            for (int b = 0; b < grafo.length; b++) {
                if (grafo[a][b] == 1) {
                    adjLists[a].add(b);
                }
            }
        }
        return adjLists;
    }

    /**
     * @author kdeepsingh2002
     */
    public void DFS(int vi, int grafo[][]) {
        System.out.print(vi + " ");
        visitadosD[vi] = true;
        for (int i = 0; i < grafo[vi].length; i++) {
            if (grafo[vi][i] == 1 && (!visitadosD[i])) {
                DFS(i, grafo);
            }
        }
    }

    public void BFS(int vi, int grafo[][]) {
        int v;
        boolean visitados[] = new boolean[grafo.length];
        Queue<Integer> cola = new LinkedList();
        visitados[vi] = true;
        cola.add(vi);
        while (!cola.isEmpty()) {
            v = cola.remove();

            System.out.print(v + " ");
            for (int i = 0; i < grafo.length; i++) {
                if (grafo[v][i] == 1) {
                    if (!visitados[i]) {
                        visitados[i] = true;
                        cola.add(i);
                    }
                }
            }
        }
    }

    public boolean noDirigido(int grafo[][]) {
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo.length; j++) {
                if (grafo[i][j] != grafo[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
