
/**
 * Queen class represents the Queen piece in a chess game
 * 
 * @author Carmen Ho
 * @version 3.0 (November 27, 2016)
 */
public class Queen extends ChessPiece
{
    /**
     * Constructor for objects of class Queen
     */
    public Queen(String player, ChessLocation initialLocation, ChessGame game)
    {
        // initialise instance variables
        super(player, initialLocation, game);
        if(player.equals("Player1"))
        {
            id = 'Q';
        }
        else
        {
            id = 'q';
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
     * This method determines whether or not the move is valid.
     * 
     * @param  newLocation  the location that you want to move to
     */
    public boolean checkValidMove(ChessLocation newLocation)
    {
        // put your code here
        boolean validMove = false;
        
        if(checkLineOfSight(getLocation(), newLocation))
        {
            if((Math.abs(newLocation.getRow()-getLocation().getRow()) != 0) && (Math.abs(newLocation.getCol()-getLocation().getCol()) != 0))
            {
                if(Math.abs(newLocation.getRow()-getLocation().getRow()) == Math.abs(newLocation.getCol()-getLocation().getCol()))
                {
                    validMove = true;
                }
            }
            else
            {
                validMove = true;
            }
        }
        
        return validMove;
    }
}
