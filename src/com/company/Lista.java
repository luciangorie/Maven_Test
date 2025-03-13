package com.company;

import javafx.scene.paint.Color;

class Lista {
    String nome;
    Color colore;
    int preferenze;

    public Lista(String nome, Color colore) {
        this.nome = nome;
        this.colore = colore;
    }

    public int getPreferenze() {
        return preferenze;
    }
}
