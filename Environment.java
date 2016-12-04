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
    //public static Queen bruno = new Queen();
    //public static Queen miguel = new Queen();
    public static Queen q1 = new Queen();
    public static Queen q2 = new Queen();
    public static Queen q3 = new Queen();

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
        insercaoBase(q1, matrizPosicoes, matrizTemp);
        insercaoBase(q2, matrizPosicoes, matrizTemp);
        insercaoBase(q3, matrizPosicoes, matrizTemp);
        
       
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
    
    public static void apagaQueenTabuleiro(Queen r){
        int coluna = r.getColuna();
        int linha = r.getLinha();
         
        matrizTemp[linha][coluna] = 2;
    }
    
    public static void copiarMatriz(Queen q, int a[][], int b[][]) {
        for (int c = 0; c < a.length; c++) {
            for (int l = 0; l < a.length; l++) {
               b[l][c] = a[l][c];
            }
        }
         q.setMatrizMemoria(b);            
    }
    
    public static void insercaoBase(Queen q, int a[][], int b[][]) {
        inserirRainha(q, a);
        lerTabuleiro(a);
        verificaColuna(q);
        verificaLinha(q);
        verificaDiagonal1(q);
        verificaDiagonal2(q);
        mostrarVazios(q, a);
        lerTabuleiro(a);
    }
    

    
    public static void mostrarVazios(Queen q, int matriz[][]){
        int c = q.getColuna() + 1;
        System.out.println("MOSTRAR VAZIOS");
        try {
            for(int l = 0; l < matriz.length; l++){
                if (matriz[l][c] == 0){
                    System.out.println("Linha"+ l + "Coluna"+ c);
                }else{
                    System.out.println("Sem Vazios");
                }
            }         
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("BUGOU");
        }

    }
    
    
    
}

    