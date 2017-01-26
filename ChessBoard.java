import java.util.ArrayList;

/**
 * ChessBoard initializes all of the board's squares and acts
 * as a base on which the game pieces to move around.
 * 
 * @author Carmen Ho
 * @version 3.0 (November 27, 2016)
 */
public class ChessBoard
{
    //Creates a 2D array for the board
    private Square[][] board = new Square[8][8];

    /**
     * Constructor for objects of class ChessBoard
     */
    public ChessBoard()
    {
        int i = 0;
        int j = 0; 
        
        //Initializes the board with empty squares
        for(i = 0; i < 8; i++){
            for(j = 0; j < 8; j++) {
                board[i][j] = new Square(i, j);
            }
        }
    }

    /**
     * This method prints the board onto the terminal window, showing 
     * ' _ ' for unoccupied squares and the piece's ID for a square occupied 
     * by a piece. 
     * 
     */
    
    public void printBoard()
    {
        int i = 0;
        int j = 0;
        
        //The following loop checks if there's a piece with a location that is different from the location of the square it's in. 
        //If so, the piece is placed at the location that it possesses, and is removed from the square it was in.
        for(i = 0; i < 8; i++){
            for(j = 0; j < 8; j++){
                if(getSquareAt(i, j).getPiece() != null)
                {
                    if((getSquareAt(i, j).getPiece().getLocation().getRow() != i)
                    || (getSquareAt(i, j).getPiece().getLocation().getCol() != j))
                    {
                        placePieceAt((getSquareAt(i, j).getPiece()), getSquareAt(i, j).getPiece().getLocation());
                        removePiece(new ChessLocation(i, j));
                    }
                } 
                
            }
        }   
        
        //The following loop prints out every square, with a ' _ ' if it's empty 
        //and a piece's ID if it's occupied by a piece. 
        for(i = 0; i <= 8; i++){
            for(j = 0; j < 8; j++){
                if(i == 0 && j == 0)
                {
                    for(int z = 0; z < 8; z++)
                    {
                        if(z == 0) 
                        {
                            System.out.print("   " + z + " ");
                        }
                        else
                        {
                            System.out.print(" " + z + " ");
                        }
                    }
                }
                else if((i > 0) && j == 0)
                {
                    System.out.print((i-1) + " ");
                }
                if (i > 0)
                {
                    if (getSquareAt(i-1, j).getPiece() != null)
                    {
                        System.out.print(" " + 
                        getSquareAt(i-1, j).getPiece().getID() + " ");
                    } 
                    else 
                    {
                        System.out.print(" _ ");
                    }
                }
            }
            System.out.println();
        }   

    }
    
    /**
     * This method returns the Square at a particular coordinate
     * 
     * @param  row   the row index of the desired square
     * @param  col   the column index of the desired square
     * @return     the Square at the indices [row][col] in the 2D array
     */
    public Square getSquareAt(int row, int col)
    {
        return board[row][col];
    }
  
    /**
     * This method returns true if there is a piece at the 
     * indicated square and false if there isn't. 
     * 
     * @param  row   the row index of the desired square
     * @param  col   the column index of the desired square
     * @return     boolean that's true if there is a piece and false if there isn't
     */
    public boolean isPieceAt(int row, int col)
    {
         if(getSquareAt(row, col).getPiece() == null)
         {
             return false;
         }
         else
         {
             return true;
         }
    }
    
    /**
     * This method places a piece at the indicated ChessLocation
     * 
     * @param  piece   the piece to be placed
     * @param  location     the location at which the piece is placed
     */
    public void placePieceAt(ChessPiece piece, ChessLocation location)
    {
        // put your code here
        int i = location.getRow();
        int j = location.getCol();
        
        getSquareAt(i, j).placePiece(piece);
        

    }
    
    /**
     * This method removes a piece from a specified square.
     * 
     * @param  location     the location of the square with the piece to be removed
     */
    public void removePiece(ChessLocation location) 
    {
        int i = location.getRow();
        int j = location.getCol();

        getSquareAt(i, j).clearSquare();
    }

}


