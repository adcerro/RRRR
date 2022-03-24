/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recorridos;

/**
 *
 * @author aland
 */
public class ListaEnlazada {

    nodo ptr;

    ListaEnlazada() {
        ptr = null;
    }

    public void add(nodo n) {
        if (ptr == null) {
            ptr = n;
        } else {
            nodo p = ptr;
            while (p.link != null) {
                p = p.link;
            }
            p.link = n;
        }
    }

    public nodo get(int dato) {
        nodo p = ptr;
        while (p != null && p.dato != dato) {
            p = p.link;
        }
        if (p.dato == dato) {
            return p;
        } else {
            return null;
        }
    }
 public boolean contains(int dato) {
        nodo p = ptr;
        while (p != null && p.dato != dato) {
            p = p.link;
        }
        if (p != null) {
            return true;
        } else {
            return false;
        }
    }

}
