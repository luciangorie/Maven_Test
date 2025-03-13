package com.company;


import java.util.Random;

class Seggio {

    String nome;
    static final int ELETTORI=900;
    int votanti=0;
    double affluenzap;
    double stats;
    boolean affluenza=false;
    void setAffluenza(int el)
    {
        votanti=el;
        affluenza=true;
        affluenzap=(double)el/(double)ELETTORI;
    }

    public Seggio(String nome) {
        this.nome = nome;
        Random r=new Random();
        stats=r.nextDouble(1.0);
    }

    void stampaNome()
    {
        System.out.print(nome);
    }
}

class SeggioDefinitivo extends Seggio
{
    int preferenze[]= new int[3];
    int liste[]=new int[6];
    int bianche=0;
    int nulle=0;

    public SeggioDefinitivo(String nome) {
        super(nome);
    }

    void Seggiodefinitivo(Seggio s)
    {
        votanti=s.votanti;
        affluenza=true;
        affluenzap=s.affluenzap;
    }
    void pickres(int a,int b, int c,int d,int e,int f, int g, int h,int i,int bb)
    {
        preferenze[0]=a;
        preferenze[1]=b;
        preferenze[2]=c;
        liste[0]=d;
        liste[1]=e;
        liste[2]=f;
        liste[3]=g;
        liste[4]=h;
        liste[5]=i;
        bianche=bb;
        nulle=votanti-a-b-c-bb;
    }

    void stamparesparzialisindaci(Sindaco s1, Sindaco s2, Sindaco s3)
    {
        System.out.println("Candidato Sindaco " + s1.nome + ": " + preferenze[0] + " voti");
        System.out.println("Candidato Sindaco " + s2.nome + ": " + preferenze[1] + " voti");
        System.out.println("Candidato Sindaco " + s3.nome + ": " + preferenze[2] + " voti");
        System.out.println("Schede BIANCHE: " + bianche);
        System.out.println("Schede NULLE: " + nulle);
        System.out.println("ELETTORI TOTALI: " + votanti + " su 900");

    }
}


