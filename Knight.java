
/**
 * Knight class represents the Knight piece in a chess game
 * 
 * @author Carmen Ho
 * @version 3.0 (November 27, 2016)
 */
public class Knight extends ChessPiece
{

    /**
     * Constructor for objects of class Knight
     */
    public Knight(String player, ChessLocation initialLocation, ChessGame game)
    {
        super(player, initialLocation, game);
        if(player.equals("Player1"))
        {
            id = 'N';
        }
        else
        {
            id = 'n';
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
        //The following checks whether or not the proposed move is valid
        boolean validMove = false;
        if((newLocation.getRow() < 8) && (newLocation.getCol() < 8))
        {  
            if((newLocation.getRow() == getLocation().getRow()+2) || 
                (newLocation.getRow() == getLocation().getRow()-2))
            {
                if((newLocation.getCol() == getLocation().getCol()+1) ||
                    (newLocation.getCol() == getLocation().getCol()-1))
                    {
                        validMove = true;
                    }
            }
            else if((newLocation.getRow() == getLocation().getRow()+1) || 
                (newLocation.getRow() == getLocation().getRow()-1))
            {
                if((newLocation.getCol() == getLocation().getCol()+2) ||
                    (newLocation.getCol() == getLocation().getCol()-2))
                    {
                        validMove = true;
                    }
            }
            else
            {
            }
        }
        
        return validMove;
    }
    
}
