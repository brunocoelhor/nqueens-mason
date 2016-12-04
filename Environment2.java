/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.app.nqueens;

import sim.engine.SimState;

public class Environment2 /*extends SimState*/ {
    
    public static int N = 4; //the number of agents
    public int l = 0;
    public int c = 0;
    public static int[][] matrizPosicoes = new int[4][4];
    public static int[][] matrizTemp1 = new int[4][4];
    public static int[][] matrizTemp2 = new int[4][4];
    public static int[][] matrizTemp3 = new int[4][4];
    public static int[][] matrizTemp4 = new int[4][4];
    public static int[][] matrizTemp5 = new int[4][4];
    public static int[][] matrizTemp6 = new int[4][4];
    public static int[][] matrizTemp7 = new int[4][4];
    public static int[][] matrizTemp8 = new int[4][4];

//    public static Queen q1 = new Queen();
//    public static Queen q2 = new Queen();
//    public static Queen q3 = new Queen();
//    public static Queen q4 = new Queen();
//    public static Queen q5 = new Queen();
//    public static Queen q6 = new Queen();
//    public static Queen q7 = new Queen();
//    public static Queen q8 = new Queen();
    
    public static void main(String[] args) {
//        System.out.println("Primeira Rainha: ");
//        q1.setLinha(0);
//        q1.setColuna(0);
//        matrizPosicoes[0][0] = 1; 
//        copiarMatriz(q1, matrizPosicoes, matrizTemp1);   
//        verificaConflitos(q1);
//        lerTabuleiro(matrizPosicoes);
//           
//        System.out.println("Segunda Rainha: ");
//        q2.setLinha(2);
//        q2.setColuna(1);
//        matrizPosicoes[2][1] = 1; 
//        copiarMatriz(q2, matrizPosicoes, matrizTemp1);   
//        verificaConflitos(q2);
//        lerTabuleiro(matrizPosicoes);
    //testeQueen2 m = new testeQueen2();
     //m.solveQueens(matrizPosicoes, col)
             
     Queen q1 = new Queen();
     //q1.posicionarQueen(q1, matrizPosicoes, 0);
     
        inserirQueen(q1, matrizPosicoes, 0, 0);
        verificaConflitos(q1);
        lerTabuleiro(matrizPosicoes);
    }
    
    
    public static void insercaoBase(Queen q, int a[][], int b[][]) {

    }
    
    public static void inserirQueen(Queen q, int a[][], int l, int c){
        q.contadorMais();
        a[l][c] = 1;
    }
    
    public static void removerQueen(Queen q, int a[][], int l, int c){
        q.ContadorMenos();
        a[l][c] = 0;
    }
    
    public static void mostrarVazios(Queen q, int matriz[][]){
        int i;
        int col = q.getColuna();
        
        if (col >= N ){
            
        }
        
    }
    
    //NÃO FUNCIONA
//    public static void posicionarQueen(Queen q, int a[][], int col){
//
//        int i;
//        int var;
//        
//        if(col >=N) var = 1;
//
//        for(i = 0; i<N; i++){
//             if(isSafe(a, i, col)){
//                   inserirQueen(q, a, i, col);
//                   if(posicionarQueen(q, a, col+1) == 1) {
//                       System.out.println("Linha" +i);
//                       System.out.println("Coluna" +col);
//                       var = 1;
//                   }
//
//                   removerQueen(q, a, i, col);
//             }
//        }
//        var = 0;
//    }  
    
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
    public static void verificaDiagonal(Queen q) {
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
    public static void verificaConflitos(Queen q){
        verificaColuna(q);
        verificaLinha(q);
        verificaDiagonal(q);
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
        a[linha][coluna] = 2;
    }
    public static void copiarMatriz(Queen q, int a[][], int b[][]) {
        for (int c = 0; c < a.length; c++) {
            for (int l = 0; l < a.length; l++) {
               b[l][c] = a[l][c];
            }
        }
         q.setMatrizMemoria(b);
    }
    
    
    
    
    public static boolean isColumnSafe(int chessBoard[][], int col){

        int i;
        for(i=0; i<N; i++){
                if(chessBoard[i][col] == 1) {
                    return false;
                }
        }
        return false;

    }
    public static boolean isRowSafe(int chessBoard[][], int row){

            int i;
            for(i=0; i<N; i++){
                    if(chessBoard[row][i] == 1) return false;
            }
            return true;

    }
    public static boolean isDiagonalSafe(int chessBoard[][], int row, int col){

            int i,j;

            /* Check the left upper diagonal */

            for(i=row, j = col; i>=0 && j>=0; i--, j--){
                    if(chessBoard[i][j]==1) return false;
            }

            /*check left lower diagonal */
            for(i=row, j = col; i<N && j>=0; i++, j--){
                    if(chessBoard[i][j]==1) return false;
            }
            return true;

    }
    public static boolean isSafe(int chessBoard[][], int row, int col){

        boolean columnSafe = isColumnSafe(chessBoard, col);
        boolean rowSafe = isRowSafe(chessBoard, row);
        boolean diagonalSafe  = isDiagonalSafe(chessBoard, row, col);

        return columnSafe && rowSafe && diagonalSafe;

}
    
      
//    public Environment2(long seed) {
//        super(seed);
//    }
    
}
