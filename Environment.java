/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.app.nqueens;

import sim.engine.SimState;

public class Environment extends SimState {

    public int n = 4; //the number of agents
    public static int[][] matrizPosicoes = new int[4][4];
    public static int[][] matrizTemp = new int[4][4];
    public static Queen bruno = new Queen();
    public static Queen miguel = new Queen();
    public static Queen q1 = new Queen();

    public Environment(long seed) { //The constructor method
        super(seed);
        // TODO Auto-generated constructor stub
    }

    public int getn() { //A pair of set and get methods for changing
        //the number of particles/agents in a simulation
        return n;
    }

    public void setn(int i) {
        if (i > 0) {
            n = i;
        }
    }

    /**
     * @return the matrizPosicoes
     */
    public int[][] getMatrizPosicoes() {
        return matrizPosicoes;
    }

    /**
     * @param matrizPosicoes the matrizPosicoes to set
     */
    public void setMatrizPosicoes(int[][] matrizPosicoes) {
        this.matrizPosicoes = matrizPosicoes;
    }

    public static void main(String[] args) {
        System.out.println("Primeira Rainha: ");
        q1.setLinha(0);
        q1.setColuna(0);
        matrizPosicoes[0][0] = 1;
        lerTabuleiro(matrizPosicoes);
        
        percorreColuna(q1);
        System.out.println(q1.getColunaAntiga());
        
        verificaColuna(q1.getColuna());
        verificaLinha(q1.getLinha());
        verificaDiagonel1(q1.getLinha(), q1.getColuna());
        verificaDiagonel2(q1.getLinha(), q1.getColuna());
           
//        System.out.println("TEMP2");
//        copiarTabuleiro(matrizPosicoes, matrizTemp);
//        System.out.println("FIM-TEMP2");
        
        

        System.out.println("Segunda Rainha: ");
        inserirRainha(bruno);
        lerTabuleiro(matrizPosicoes);
        verificaColuna(1);
        verificaLinha(2);
        verificaDiagonel1(2, 1);
        verificaDiagonel2(2, 1);
        
        

        System.out.println("Terceira Rainha: ");
        lerTabuleiro(matrizPosicoes);
        inserirRainha(miguel);
        System.out.println();
        lerTabuleiro(matrizPosicoes);
        
        
       
    }

    public void start() {
        super.start();

        for (int i = 0; i < n; i++) {//for loop for creating each particle
            //one at a time
            Queen q = new Queen();//create a new particle

            schedule.scheduleRepeating(q); //It places the particle in
            //a list of all the particles.  Then on each time step, the
            //list is randomly shuffled and the Environment calls each
            //particle's step method one at a time.
        }

    }

    public static void verificaColuna(int c) {
        for (int l = 0; l < matrizPosicoes.length; l++) {
            if (matrizPosicoes[l][c] != 1) {
                matrizPosicoes[l][c] = 2;
            }
        }
    }

    public static void verificaLinha(int l) {
        for (int c = 0; c < matrizPosicoes.length; c++) {
            if (matrizPosicoes[l][c] != 1) {
                matrizPosicoes[l][c] = 2;
            }
        }
    }

    public static void verificaDiagonel1(int l, int c) {
        try {
            for (int i = l; i < matrizPosicoes.length; i++) {
                if (matrizPosicoes[l][c] != 1) {
                    matrizPosicoes[l][c] = 2;
                }
                l++;
                c++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //System.out.println("FUUUUUUUUUUU");
        }
    }

    public static void verificaDiagonel2(int l, int c) {
        try {
            for (int i = l; i < matrizPosicoes.length; i++) {
                if (matrizPosicoes[l][c] != 1) {
                    matrizPosicoes[l][c] = 2;
                }
                l--;
                c++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //System.out.println("FUUUUUUUUUUU");
        }

    }

    public static void verVazios() {
        for (int c = 0; c < matrizPosicoes.length; c++) {
            for (int l = 0; l < matrizPosicoes.length; l++) {
                if (matrizPosicoes[l][c] == 0) {
                    //System.out.println("L= " + l + " C = " + c);
                    //mVazios[c][l] = l;
                }
            }
            System.out.println("");
        }
    }

    public static void inserirRainha(Queen q) {
        int l = 0;
        int c = 0;

        try {
            while (matrizPosicoes[l][c] != 0 && matrizPosicoes[l][c] < matrizPosicoes.length) {
                c++;
                while (matrizPosicoes[l][c] != 0 && matrizPosicoes[l][c] < matrizPosicoes.length) {
                    l++;
                }
            }
            //System.out.println("L= " + l + " C = " + c);

            q.setLinha(l);
            q.setColuna(c);
            matrizPosicoes[l][c] = 1;

        } catch (ArrayIndexOutOfBoundsException e) {
            //System.out.println("L= " + l + " C = " + c);

            //zeraTabuleiro();
            verAnterior(c);
            System.out.println();
            //System.out.println("Zerou o tabuleiro: ");
        }

    }

    public static void zeraTabuleiro() {
        System.out.println();
        for (int m = 0; m < matrizPosicoes.length; m++) {
            for (int b = 0; b < matrizPosicoes[0].length; b++) {
                System.out.print(" " + matrizPosicoes[m][b]);
                matrizPosicoes[m][b] = 0;

            }
            System.out.println();
        }
    }

    public static void verAnterior(int c) {
        for (int l = 0; l < matrizPosicoes.length; l++) {
            if(matrizPosicoes[l][c] == 1){
                System.out.println("L= " + l + " C = " + c);
            }
        }
    }

    public static void lerTabuleiro( int matriz[][]) {
        for (int l = 0; l < matriz.length; l++) {
            for (int c = 0; c < matriz[0].length; c++) {
                System.out.print(" " + matriz[l][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void copiarTabuleiro(int a[][], int b[][]){
        b = a.clone();
        lerTabuleiro(b);
    }
    
    public static void percorreColuna(Queen r){
        int coluna = r.getColuna();
        int vetor[] = new int[4];
        
        for (int l = 0; l < matrizPosicoes.length; l++) {
            
                //System.out.print(" " + matrizPosicoes[l][coluna]);
                vetor[l] = matrizPosicoes[l][coluna];
                //System.out.println("VETORRRRRRRR"+ vetor);
                //r.recebeColuna(vetor);
        }
        System.out.println();
    }
}