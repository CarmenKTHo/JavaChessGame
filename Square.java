
/**
 * Square class represents a single square on the chess board, 
 * on which a piece can be placed.
 * 
 * @author Carmen Ho
 * @version 3.0 (November 27, 2016)
 */
public class Square
{
    // instance variables
    private ChessLocation location;
    private boolean occupied;
    private ChessPiece piece;

    /**
     * Constructor for objects of class Square
     */
    
    public Square(int row, int col)
    {
        // initialise instance variables
        this.location = new ChessLocation(row, col);
        this.occupied = false;
        this.piece = null;
    }
    
    public Square()
    {
        // initialise instance variables
        this.location = null;
        this.occupied = false;
        this.piece = null;
    }

    /**
     * This method returns the location of the Square
     * 
     * @return     the ChessLocation of the location of the Square
     */
    public ChessLocation getLocation()
    {
        // put your code here
        return location;
    }
    
    /**
     * This method returns whether or not the Square is occupied
     * 
     * @return     true if there is a piece in the Square, false if there isn't
     */
     public boolean isOccupied()
    {
        // put your code here
        return occupied;
    }
    
    /**
     * This method returns the piece within the Square
     * 
     * @return     the ChessPiece within the Square
     */
    public ChessPiece getPiece()
    {
        // put your code here
        return piece;
    }
    
    /**
     * This method places a ChessPiece into the Square
     * 
     * @param   piece   the piece to be placed   
     */
    public void placePiece(ChessPiece piece)
    {
        this.piece = piece;
        occupied = true;
    }
    
    /**
     * This method clears the Square of any pieces
     */
    public void clearSquare()
    {
        piece = null;
        occupied = false;
    }
}
