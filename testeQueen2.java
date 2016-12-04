/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.app.nqueens;

/**
 *
 * @author bruno
 */
public class testeQueen2 {
    
    public static int col;
    public static int row;
    public static int N = 4;
    public static int varTeste = 0;
    public static int[][] matrizPosicoes = new int[4][4];
    
    
    public boolean isColumnSafe(int chessBoard[][], int col){

        int i;
        for(i=0; i<N; i++){
                if(chessBoard[i][col] == 1) {
                    return false;
                }
        }
        return false;

    }
    
    public boolean isRowSafe(int chessBoard[][], int row){

            int i;
            for(i=0; i<N; i++){
                    if(chessBoard[row][i] == 1) return false;
            }
            return true;

    }
    public boolean isDiagonalSafe(int chessBoard[][], int row, int col){

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

public boolean isSafe(int chessBoard[][], int row, int col){

        boolean columnSafe = isColumnSafe(chessBoard, col);
        boolean rowSafe = isRowSafe(chessBoard, row);
        boolean diagonalSafe  = isDiagonalSafe(chessBoard, row, col);

        return columnSafe && rowSafe && diagonalSafe;

}

public void placeQueen(int chessBoard[][], int i, int j){

        chessBoard[i][j] =1;
}
public void removeQueen(int chessBoard[][], int i, int j){

        chessBoard[i][j] =0;
}

public int solveQueens(int chessBoard[][], int col){

        int i;
        if(col >=N) return 1;

        for(i = 0; i<N; i++){
             if(isSafe(chessBoard, i, col)){
                   placeQueen(chessBoard, i, col);
                   if(solveQueens(chessBoard,col+1) == 1) {
                       varTeste = 32;
                       return 1;
                   }

                   removeQueen(chessBoard,i,col);
             }
        }
        varTeste = 67;
        return 0;
}     

    public static void main(String[] args) {
     testeQueen2 m = new testeQueen2();
     m.solveQueens(matrizPosicoes, col);
        System.out.println("Teste: " +varTeste);
    }
    
}