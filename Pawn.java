
/**
 * Pawn class represents the Pawn piece in a chess game
 * 
 * @author Carmen Ho
 * @version 3.0 (November 27, 2016)
 */
public class Pawn extends ChessPiece
{
    // instance variables 
    public boolean firstMove;

    /**
     * Constructor for objects of class Pawn
     */
    public Pawn(String player, ChessLocation initialLocation, ChessGame game)
    {
        // initialise instance variables
        super(player, initialLocation, game);
        if(player.equals("Player1"))
        {
            id = 'P';
        }
        else
        {
            id = 'p';
        }
        firstMove = true; // It is the pawn's first move
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
        if(getPlayer().equals("Player1"))
        {
            if((getLocation().getRow()+1 == newLocation.getRow()))
                {
                    if(getLocation().getCol()-1 == newLocation.getCol() || getLocation().getCol()+1 == newLocation.getCol())
                    {
                        if(getGame().getBoard().isPieceAt(newLocation.getRow(), newLocation.getCol()))
                        {
                            if(getGame().getBoard().getSquareAt(newLocation.getRow(), newLocation.getCol()).getPiece().getPlayer().equals("Player2"))
                            {
                                validMove = true;
                            }
                        }
                    }
            }
            if(firstMove)
            {
                if((getLocation().getRow()+1 == newLocation.getRow()) || (getLocation().getRow()+2 == newLocation.getRow()))  
                {
                    if(getLocation().getCol() == newLocation.getCol() && checkLineOfSight(getLocation(), newLocation))
                    {
                        validMove = true;
                    }
                }
                else 
                {
                    validMove = false;
                }
            }
            else
            {
                if((getLocation().getRow()+1 == newLocation.getRow()))  
                {
                    if(getLocation().getCol() == newLocation.getCol())
                    {
                        validMove = true;
                    }
                }
                else 
                {
                    validMove = false;
                }
            }
        }
        else
        {
            if((getLocation().getRow()-1 == newLocation.getRow()))
                {
                    if(getLocation().getCol()-1 == newLocation.getCol() || getLocation().getCol()+1 == newLocation.getCol())
                    {
                        if(getGame().getBoard().isPieceAt(newLocation.getRow(), newLocation.getCol()))
                        {
                            if(getGame().getBoard().getSquareAt(newLocation.getRow(), newLocation.getCol()).getPiece().getPlayer().equals("Player1"))
                            {
                                validMove = true;
                            }
                        }
                    }
            }
            if(firstMove)
            {
                if((getLocation().getRow()-1 == newLocation.getRow()) || (getLocation().getRow()-2 == newLocation.getRow()))  
                {
                    if(getLocation().getCol() == newLocation.getCol() && checkLineOfSight(getLocation(), newLocation))
                    {
                        validMove = true;
                    }
                }
                else 
                {
                    validMove = false;
                }
            }
            else
            {
                if((getLocation().getRow()-1 == newLocation.getRow()))  
                {
                    if(getLocation().getCol() == newLocation.getCol())
                    {
                        validMove = true;
                    }
                }
                else 
                {
                    validMove = false;
                }
            }
        }
        
        return validMove;
    }
    
    /**
     * This method moves a piece to a new location by changing its location
     * 
     * @param  newLocation      the location the piece will be moved to
     */
    public boolean moveTo(ChessLocation newLocation)
    {
        if(checkValidMove(newLocation))
        {
            if(getGame().getBoard().isPieceAt(newLocation.getRow(), newLocation.getCol()) == false)
            {
                super.moveTo(newLocation);
                firstMove = false;
                return true;
            }
            else if(!(getGame().getBoard().getSquareAt(newLocation.getRow(), newLocation.getCol()).getPiece().getPlayer().equals(getPlayer())))
            {
                super.moveTo(newLocation);
                firstMove = false;
                return true;
            }
        }
        else
        {
            System.out.println();
            System.out.println("Error: Invalid move.");
            System.out.println();
        }
        return false;
    }

}
