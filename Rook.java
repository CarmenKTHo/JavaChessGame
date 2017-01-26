
/**
 * Rook class represents the Rook piece in a chess game
 * 
 * @author Carmen Ho
 * @version 3.0 (November 27, 2016)
 */
public class Rook extends ChessPiece
{
    /**
     * Constructor for objects of class Rook
     */
    public Rook(String player, ChessLocation initialLocation, ChessGame game)
    {
        // initialise instance variables
        super(player, initialLocation, game);
        if(player.equals("Player1"))
        {
            id = 'R';
        }
        else
        {
            id = 'r';
        }
        game.getBoard().placePieceAt(this, initialLocation);
    }

    /**
     * This method updates the piece's threatening locations
     * 
     * @param  newLocation     the location that this piece threatens
     */
    public void updateThreateningLocation(ChessLocation newLocation)
    {
       if(checkValidMove(newLocation))
       {
           getThreateningLocations().add(newLocation); 
       }
    }
    
    /**
     * This method determines whether or not the move is valid
     * 
     * @param  newLocation  the location that you want to move to
     */
    public boolean checkValidMove(ChessLocation newLocation)
    {
        // put your code here
        boolean validMove = false;
        if((newLocation.getRow() < 8) && (newLocation.getCol() < 8))
        {  
            int rowShift = 0;
            int colShift = 0;
            rowShift = newLocation.getRow() - getLocation().getRow();
            colShift = newLocation.getCol() - getLocation().getCol();
            if((Math.abs(rowShift) != 0) && colShift == 0 && checkLineOfSight(getLocation(), newLocation))
            {
                validMove = true;
            }
            else if((Math.abs(colShift) != 0) && rowShift == 0 && checkLineOfSight(getLocation(), newLocation))
            {
                validMove = true;
            }
            else
            {
            }
            
        }
        
        return validMove;
    }

}
