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
    public static int[][] matrizTemp1 = new int[4][4];
    public static int[][] matrizTemp2 = new int[4][4];
    public static int[][] matrizTemp3 = new int[4][4];
    public static int[][] matrizTemp4 = new int[4][4];
    public static int[][] matrizTemp5 = new int[4][4];
    public static int[][] matrizTemp6 = new int[4][4];
    public static int[][] matrizTemp7 = new int[4][4];
    public static int[][] matrizTemp8 = new int[4][4];
    //public static Queen bruno = new Queen();
    //public static Queen miguel = new Queen();
    public static Queen q1 = new Queen();
    public static Queen q2 = new Queen();
    public static Queen q3 = new Queen();
    public static Queen q4 = new Queen();

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
        
        copiarMatriz(q1, matrizPosicoes, matrizTemp1);
        
        verificaColuna(q1);
        verificaLinha(q1);
        verificaDiagonal1(q1);
        verificaDiagonal2(q1);
        lerTabuleiro(matrizPosicoes);
        
//        System.out.println("TESTE LER");
//        lerTabuleiro(q1.getMatrizMemoria());

        //insercaoBase(q1, matrizPosicoes, matrizTemp);
        System.out.println("Segunda Rainha: ");
        insercaoBase(q2, matrizPosicoes, matrizTemp2);
        System.out.println("Terceira Rainha: ");        
        insercaoBase(q3, matrizPosicoes, matrizTemp3);
        System.out.println("Quarta Rainha: ");        
        insercaoBase(q4, matrizPosicoes, matrizTemp4);       
       
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

    public static void verificaColuna(Queen q) {
        int c = q.getColuna();
        for (int l = 0; l < matrizPosicoes.length; l++) {
            if (matrizPosicoes[l][c] != 1) {
                matrizPosicoes[l][c] = 2;
            }
        }
    }

    public static void verificaLinha(Queen q) {
        int l = q.getLinha();
        for (int c = 0; c < matrizPosicoes.length; c++) {
            if (matrizPosicoes[l][c] != 1) {
                matrizPosicoes[l][c] = 2;
            }
        }
    }

    public static void verificaDiagonal1(Queen q) {
        int l = q.getLinha();
        int c = q.getColuna();
        try {
            for (int i = l; i < matrizPosicoes.length; i++) {
                if (matrizPosicoes[l][c] != 1) {
                    matrizPosicoes[l][c] = 2;
                }
                l++;
                c++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }

    public static void verificaDiagonal2(Queen q) {
        int l = q.getLinha();
        int c = q.getColuna();
        try {
            for (int i = l; i < matrizPosicoes.length; i++) {
                if (matrizPosicoes[l][c] != 1) {
                    matrizPosicoes[l][c] = 2;
                }
                l--;
                c++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            
        }

    }

    public static void inserirRainha(Queen q, int matriz[][]) {
        int l = 0;
        int c = 0;

        try {
            while (matriz[l][c] != 0 && c < matriz.length) {
                
                while (matriz[l][c] != 0 && l < matriz.length-1) {
                    l++;
                }
                if(matriz[l][c] == 0) {
                    break;
                }
                l = 0;
                c++;
            }
            q.setLinha(l);
            q.setColuna(c);
            matriz[l][c] = 1;

        } catch (ArrayIndexOutOfBoundsException e) {
            //verAnterior(c);
            System.out.println("ERROU");
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
    
    public static void apagaQueenTabuleiro(Queen r, int a[][]){
        int coluna = r.getColuna();
        int linha = r.getLinha();
        //matrizTemp 
        a[linha][coluna] = 2;
    }
    
    public static void copiarMatriz(Queen q, int a[][], int b[][]) {
        for (int c = 0; c < a.length; c++) {
            for (int l = 0; l < a.length; l++) {
               b[l][c] = a[l][c];
            }
        }
         q.setMatrizMemoria(b);
//         System.out.println("TABELA B");
//         lerTabuleiro(b);
    }
    
    public static void insercaoBase(Queen q, int a[][], int b[][]) {
        //inserirRainha(q, a);
        mostrarVazios(q, a);
        copiarMatriz(q, a, b);
        verificaColuna(q);
        verificaLinha(q);
        verificaDiagonal1(q);
        verificaDiagonal2(q);
        lerTabuleiro(a);
       // mostrarVazios(q, a);
    }
    
    
    
    public static void mostrarVazios(Queen q, int matriz[][]){
        
        int c = q.getColuna() + 1;
        int countConflito = 0;
        try {
            for(int l = 0; l < matriz.length; l++){
                if (matriz[l][c] == 0){
                    //COLOCAR RAINHA NESSE LUGAR

                    q.setLinha(l);
                    q.setColuna(c);
                    matriz[l][c] = 1;
                    break;
                }else{
                    countConflito ++;
                    if(countConflito >= matriz.length){
                        matrizPosicoes = matrizTemp2;
                        System.out.println("LInha"+q2.getLinha()+"Coluna"+q2.getColuna());
                        apagaQueenTabuleiro(q2, matrizPosicoes);
                        
                        insercaoBase(q2, matrizPosicoes, matrizTemp2);
                        lerTabuleiro(matrizPosicoes);
                        
                        //AVISAR QUE DEU CONFLITO
                        //System.out.println("AVISAR QUE DEU CONFLITO");
                        
                        
                                              
                        //break;
                    }
                }
            }         
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("BUGOU");
        }

    }
    
    
    
}

    