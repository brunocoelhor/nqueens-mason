/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.app.nqueens;

// ----------------------------------------------------------------
// The Eight Queens problem:
//    Place 8 queens on a chess board such that no queen
//    attacks any other queen...
//
// Solution: backtracking...
// ----------------------------------------------------------------

class Queens
{
   int NSols = 0;                         // Count # solutions found
   int[][] board = { {0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0} };

   int[][] attacked = { {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0} };

   // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   // Solve(row): try to place a queen at row "row"
   // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   void Solve(int row)
   {
      int col;

      PrintState();     // Uncomment this to see how algorithm work

      // ******************************************
      // Check if all queens are placed
      // ******************************************
      if (row == 8)
       { // ----------- This case stops the recursion
         PrintSol();
         NSols++;
	 return;
       }

      // ----------------------------------------------------
      // Try every column to place queen in row "row":
      // ----------------------------------------------------
      for (col = 0; col < 8; col++)
      {  if ( ! Attacked(row, col) )
         {
            PutQueen(row, col);           // Make Move
            Solve(row+1);                 // Solve smaller problem
            RemoveQueen(row, col);        // Undo Move
         }
      }
   }

   // **********************************************************
   // Attacked(x,y): Check if square (x,y) is attacked...
   // **********************************************************
   boolean Attacked(int x, int y)
   {
      return (attacked[x][y] > 0);
   }

   // **********************************************************
   // PutQueen(x,y): Put a queen on square (x,y)
   // **********************************************************
   void PutQueen(int x, int y)
   {
      int i, j;

      // Mark square ocupied by queen
      board[x][y] = 1;            // Mark position of queen...

      // Mark all squares attacked by queen
      attacked[x][y]++;            // New queen will attack (x,y)

      for (j = 0; j <= 7; j++)  // New queen will attack the row x
         if (j != y)
            attacked[x][j]++;

      for (i = 0; i <= 7; i++)  // New queen will attack the column y
         if (i != x)
            attacked[i][y]++;

      // New queen will attack the diagonals through (x,y)
      i = x-1; j = y-1;
      while ( (i >= 0) && (j >= 0) )
       { attacked[i][j]++;
         i--; 
         j--;
       }

      i = x+1; j = y+1;
      while ( (i < 8) && (j < 8) )
       { attacked[i][j]++;
         i++; 
         j++;
       }

      i = x-1; j = y+1;
      while ( (i >= 0) && (j < 8) )
       { attacked[i][j]++;
         i--;
         j++;
       }

      i = x+1; j = y-1;
      while ( (i < 8) && (j >= 0) )
       { attacked[i][j]++;
         i++;
         j--;
       }
   }

   // **********************************************************
   // RemoveQueen(x,y): Remove a queen from square (x,y)
   // **********************************************************
   void RemoveQueen(int x, int y)
   {
      int i, j;

      // Unmark position occupied by queen
      board[x][y] = 0;

      // Unmark squares that were attacked by queen
      attacked[x][y]--;            // Queen was attacking (x,y)

      for (j = 0; j <= 7; j++)  // Queen was attacking the row x
         if (j != y)
            attacked[x][j]--;

      for (i = 0; i <= 7; i++)  // Queen was attacking the column y
         if (i != x)
            attacked[i][y]--;

      // Queen was attacking the diagonals through (x,y)
      i = x-1; j = y-1;
      while ( (i >= 0) && (j >= 0) )
       { attacked[i][j]--;
         i--; 
         j--;
       }

      i = x+1; j = y+1;
      while ( (i < 8) && (j < 8) )
       { attacked[i][j]--;
         i++; 
         j++;
       }

      i = x-1; j = y+1;
      while ( (i >= 0) && (j < 8) )
       { attacked[i][j]--;
         i--;
         j++;
       }

      i = x+1; j = y-1;
      while ( (i < 8) && (j >= 0) )
       { attacked[i][j]--;
         i++;
         j--;
       }
   }

   // Print solution found....
   void PrintSol()
   {
      int i, j;

      for (i = 0; i < 8; i++)
       { for (j = 0; j < 8; j++)
            System.out.print(board[i][j]+" ");
         System.out.println();
       }
      System.out.println("-----------------------");
   }

   // Print current state....
   void PrintState()
   {
      int i, j;

      for (i = 0; i < 8; i++)
       { for (j = 0; j < 8; j++)
            System.out.print(board[i][j]+" ");
         System.out.print("         ");
         for (j = 0; j < 8; j++)
            System.out.print(attacked[i][j]+" ");
         System.out.println();
       }
      System.out.println("-----------------------");
   }


}
   
public class TesteQueens
{
   public static void main(String[] s)
   {
      Queens x = new Queens();

      x.Solve(0);    // Solve starts by trying to place a queen in row 0
      System.out.println("There are " + x.NSols + " solutions");
   }
}
