package com.company;

import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.Graph;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    public Main() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Sindaco s1 = new Sindaco("Tommaso Bonomi", 2003, Color.AQUA);
        Sindaco s2 = new Sindaco("Lucian Gorie", 1989, Color.ORANGE);
        Sindaco s3 = new Sindaco("Anwar Qasim", 1990, Color.GRAY);
        s1.adder("per BONOMI il SINDACO", Color.AQUA);
        s1.adder("Nuovo Centrodestra", Color.ANTIQUEWHITE);
        s2.adder("Nuovi Orizzonti", Color.DARKGOLDENROD);
        s2.adder("Ci siamo!#Obiettivi in comune", Color.ORANGE);
        s3.adder("Qasim sindaco", Color.GRAY);
        Bacheca bacheca = new Bacheca(25);
        bacheca.updateSituazione();
        Stats stat = new Stats();
        bacheca.updateSituazione2(18, s1, s2, s3, stat);
        bacheca.stampaseggi(s1, s2, s3);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream custom = new PrintStream(output);
        System.setOut(custom);
        bacheca.stampaTotale(s1, s2, s3);
        System.out.println();
        System.setOut(System.out);
        Text tt = new Text();
        tt.setText(output.toString());
        Graph var10000 = new Graph() {
            public Set nodes() {
                return null;
            }

            public Set<EndpointPair> edges() {
                return null;
            }

            public boolean isDirected() {
                return false;
            }

            public boolean allowsSelfLoops() {
                return false;
            }

            public ElementOrder nodeOrder() {
                return null;
            }

            public ElementOrder incidentEdgeOrder() {
                return null;
            }

            public Set adjacentNodes(Object node) {
                return null;
            }

            public Set predecessors(Object node) {
                return null;
            }

            public Set successors(Object node) {
                return null;
            }

            public Set<EndpointPair> incidentEdges(Object node) {
                return null;
            }

            public int degree(Object node) {
                return 0;
            }

            public int inDegree(Object node) {
                return 0;
            }

            public int outDegree(Object node) {
                return 0;
            }

            public boolean hasEdgeConnecting(Object nodeU, Object nodeV) {
                return false;
            }

            public boolean hasEdgeConnecting(EndpointPair endpoints) {
                return false;
            }
        };
        BorderPane root = new BorderPane();
        root.setCenter(tt);
        primaryStage.setScene(new Scene(root, 400.0, 300.0));
        primaryStage.show();
    }
}

