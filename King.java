import java.util.ArrayList;

/**
 * King class represents the King piece in a chess game
 * 
 * @author Carmen Ho
 * @version 3.0 (November 27, 2016)
 */
public class King extends ChessPiece
{
    /**
     * Constructor for objects of class King
     */
    public King(String player, ChessLocation initialLocation, ChessGame game)
    {
        // initialise instance variables
        super(player, initialLocation, game);
        if(player.equals("Player1"))
        {
            id = 'K';
        }
        else
        {
            id = 'k';
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
        int rowShift = 0;
        int colShift = 0;
        rowShift = newLocation.getRow() - getLocation().getRow();
        colShift = newLocation.getCol() - getLocation().getCol();
        
        if(Math.abs(rowShift) == Math.abs(colShift) && Math.abs(rowShift) == 1)
        {
            validMove = true;
        }
        else if(Math.abs(rowShift) == 1 && colShift == 0)
        {
            validMove = true;
        }
        else if(Math.abs(colShift) == 1 && rowShift == 0)
        {
            validMove = true;
        }
        else
        {
        }

        return validMove;
    }
    
    /**
     * This method checks which piece is threatening the King at a new location
     * 
     * @param  destLocation     the location the King want to move to
     * @return  the Piece threatening the King
     */
    public ChessPiece locationInDanger(ChessLocation destLocation)
    {
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(getGame().getBoard().isPieceAt(i,j))
                {
                    getGame().getBoard().getSquareAt(i, j).getPiece().getThreateningLocations().clear();                  
                }
            }
        }
        
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(getGame().getBoard().isPieceAt(i,j))
                {
                    if(!getGame().getBoard().getSquareAt(i, j).getPiece().getPlayer().equals(getPlayer()))
                    {
                        getGame().getBoard().getSquareAt(i, j).getPiece().updateThreateningLocation(destLocation);
                    }
                }
            }
        }
        
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(getGame().getBoard().isPieceAt(i,j))
                {
                    if(!getGame().getBoard().getSquareAt(i, j).getPiece().getPlayer().equals(getPlayer()))
                    {
                        if(!getGame().getBoard().getSquareAt(i, j).getPiece().getThreateningLocations().isEmpty())
                        {
                            int size = getGame().getBoard().getSquareAt(i, j).getPiece().getThreateningLocations().size();
                            if(destLocation.getRow() == getGame().getBoard().getSquareAt(i, j).getPiece().getThreateningLocations().get(size-1).getRow())
                            {
                                if(destLocation.getCol() == getGame().getBoard().getSquareAt(i, j).getPiece().getThreateningLocations().get(size-1).getCol())
                                {
                                    return getGame().getBoard().getSquareAt(i, j).getPiece();
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
    
    /**
     * This method determines if the King has any moves left
     * 
     * @return  true if there are moves left
     */
    public boolean anyMovesLeft()
    {
        boolean move = false;
        if(locationInDanger(new ChessLocation(getLocation().getRow(), getLocation().getCol()-1)) == null)
        {
            move = true;
        }
        else if(locationInDanger(new ChessLocation(getLocation().getRow()-1, getLocation().getCol()-1)) == null)
        {
            move = true;
        }
        else if(locationInDanger(new ChessLocation(getLocation().getRow()-1, getLocation().getCol())) == null)
        {
            move = true;
        }
        else if(locationInDanger(new ChessLocation(getLocation().getRow()-1, getLocation().getCol()+1)) == null)
        {
            move = true;
        }
        else if(locationInDanger(new ChessLocation(getLocation().getRow(), getLocation().getCol()+1)) == null)
        {
            move = true;
        }
        else if(locationInDanger(new ChessLocation(getLocation().getRow()+1, getLocation().getCol()+1)) == null)
        {
            move = true;
        }
        else if(locationInDanger(new ChessLocation(getLocation().getRow()+1, getLocation().getCol())) == null)
        {
            move = true;
        }
        else if(locationInDanger(new ChessLocation(getLocation().getRow()+1, getLocation().getCol()-1)) == null)
        {
            move = true;
        }
        return move;
    }
    
    /**
     * This method returns the piece that is keeping the King in check
     * 
     * @return      piece that is threatening the King
     */
    public ChessPiece check()
    {
        return locationInDanger(getLocation());
    }
}

