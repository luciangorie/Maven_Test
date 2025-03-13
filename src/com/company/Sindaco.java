package com.company;

import javafx.scene.paint.Color;
import java.util.ArrayList;

class Sindaco {
    String nome;
    int nascita;
    Color colore;
    int preferenze=0;
    ArrayList<Lista> liste= new ArrayList<Lista>();

    public Sindaco(String nome, int nascita, Color colore) {
        this.nome = nome;
        this.nascita = nascita;
        this.colore = colore;
    }

    public int getPreferenze() {
        return preferenze;
    }

    public void adder(String nome,Color cc)
    {
        liste.add(new Lista(nome,cc));
    }
    public void pref(int x)
    {
        preferenze+=x;
    }
}
