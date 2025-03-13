package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Bacheca {
    ArrayList<Seggio> elenco=new ArrayList<>();
    int bianchetotali=0;
    int nulletotali=0;
    static final int ELETTORI=22500;
    int votantitotali=0;
    Bacheca(int seggi)
    {
        int i=0;
        while( i < seggi)
        {
            Seggio se=new Seggio("Seggio comunale n. " + (i+1));
            elenco.add(se);
            ++i;

        }
    }

    void btot(int x)
    {
        bianchetotali+=x;
    }
    void nulletot(int x)
    {
        nulletotali+=x;
    }
    void vottot(int v)
    {
        votantitotali+=v;
    }

    void updateSituazione() {
        Random r = new Random();  // Create the Random object once, before the loop
        for(Seggio s : elenco) {
            int t;
            do {
                t = r.nextInt(900);  // Generate random number between 0 and 899
            } while(t <= 400);  // Ensure t is greater than 400
            s.setAffluenza(t);  // Set the attendance for the Seggio object
        }
    }

    void updateSituazione2(int h,Sindaco ss, Sindaco s1, Sindaco s2,Stats s3)
    {
        int y=0;
        DescriptiveStatistics med1= new DescriptiveStatistics();
        DescriptiveStatistics med2= new DescriptiveStatistics();
        DescriptiveStatistics med3= new DescriptiveStatistics();

        Collections.shuffle(elenco);
        while(y<h)
        {
            Seggio se=elenco.getFirst();
            SeggioDefinitivo ds=new SeggioDefinitivo(se.nome);
            ds.Seggiodefinitivo(se);
            int c=ds.votanti/4;
            int p1;
            Random r=new Random();
            int p2,p3,pb,pn;
            if(ds.stats<0.33)
            {
                p1=c*2;
                p2=c;
                do {
                    p3=r.nextInt(c);
                }while(p3<85);


            }
            else if(ds.stats<0.66)
            {
                p2=c*2;
                p1=c;
                do {
                    p3=r.nextInt(c);
                }while(p3<85);
            }
            else
            {
                p3=c*2;
                p2=c;
                do {
                    p1=r.nextInt(c);
                }while(p1<75);

            }
            pb=ds.votanti-p1-p2-p3;
            pb=pb/3;
            elenco.remove(se);
            ds.pickres(p1,p2,p3,0,0,0,0,0,0,pb);
            ss.pref(p1);
            med1.addValue(p1);
            s1.pref(p2);
            med2.addValue(p2);
            s2.pref(p3);
            med3.addValue(p3);
            btot(pb);
            nulletot(ds.votanti-p1-p2-p3-pb);
            vottot(ds.votanti);
            elenco.addLast(ds);
            y++;
        }
        while(y<25)
        {
            Seggio se=elenco.get(y-18);
            vottot(se.votanti);
            y++;
        }
        double media=med1.getMean();
        double media2= med2.getMean();
        double media3=med3.getMean();
        double dev1=med1.getStandardDeviation();
        double dev2=med2.getStandardDeviation();
        double dev3=med3.getStandardDeviation();

        s3.Statscheck(media,media2,media3,dev1,dev2,dev3,h);


    }

    public void stampaseggi(Sindaco ss, Sindaco sb, Sindaco sc)
    {
        for(Seggio s:elenco)
        {
            if(s instanceof SeggioDefinitivo)
            {
                System.out.println(" ");
                s.stampaNome();
                System.out.println(" , affluenza h.21:00: " + (int)(s.affluenzap*100) + "%");
                System.out.println("RISULTATI DISPONIBILI PER ");
                System.out.println("" +
                        "" );
                ((SeggioDefinitivo) s).stamparesparzialisindaci(ss,sb,sc);
                System.out.println("" +
                        "" );





            }
            else
            {
                s.stampaNome();
                if(s.affluenza)System.out.println(" , affluenza h.21:00: " + (int)(s.affluenzap*100) + "%");
                else System.out.println("Nessun dato su affluenza riportato.");
            }
        }
    }

    public void stampaTotale(Sindaco ss,Sindaco s1,Sindaco s2)
    {
        System.out.println("Candidato Sindaco " + ss.nome + ": " + ss.preferenze + " voti");
        System.out.println("Candidato Sindaco " + s1.nome + ": " + s1.preferenze + " voti");
        System.out.println("Candidato Sindaco " + s2.nome + ": " + s2.preferenze + " voti");
        System.out.println("Schede BIANCHE: " + bianchetotali);
        System.out.println("Schede NULLE: " + nulletotali);
        System.out.println("             ");
        System.out.println("ELETTORI TOTALI: " + votantitotali + " su 22500, affluenza al " + ((double)votantitotali/22500)*100 + " %");
        System.out.println("SEZIONI SCRUTINATE 18/25");
    }





}


class Stats
{
    double med1;
    double med2;
    double med3;
    double dev1;
    double dev2;
    double dev3;

    int deg;
    TDistribution rmin;
    TDistribution rmax;

    Stats(){};

    public void  Statscheck(double med1, double med2, double med3, double dev1, double dev2, double dev3, int degg) {
        this.med1 = med1;
        this.med2 = med2;
        this.med3 = med3;
        this.dev1 = dev1;
        this.dev2 = dev2;
        this.dev3 = dev3;
        deg=degg;
        rmin= new TDistribution(0.9);
        rmax= new TDistribution(0.1);
    }

    void project()
    {
        //da usare per eventuali proiezioni

    }}

