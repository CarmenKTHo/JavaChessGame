import java.util.ArrayList;

/**
 * ChessPiece is the superclass of all the chess pieces. 
 * 
 * @author Carmen Ho
 * @version 3.0 (November 27, 2016)
 */
public abstract class ChessPiece implements ChessPieceInterface
{
    // instance variables 
    private ChessGame game;
    private String player;
    private ChessLocation location;
    private ArrayList<ChessLocation> threateningLocations;
    protected char id;

    /**
     * Constructor for objects of class ChessPiece
     */
    public ChessPiece(String owner, ChessLocation initialLocation, ChessGame game)
    {
        // initialise instance variables
        this.player = owner;
        this.location = initialLocation;
        this.game = game;
        threateningLocations = new ArrayList<>();
        game.getBoard().placePieceAt(this, initialLocation);
    }

    /**
     * This abstract method forces the pieces to have an updateThreateningLocation
     * method to update their threatening locations
     * 
     * @param  newLocation     the location that this piece threatens
     */
    public abstract void updateThreateningLocation(ChessLocation newLocation);
    
    /**
     * This method checks if the move is valid
     * @param  newLocation     the location one wants to move to
     */
    public boolean checkValidMove(ChessLocation newLocation)
    {
        boolean validMove = true;
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
                location = newLocation;
                return true;
            }
            else if(!(getGame().getBoard().getSquareAt(newLocation.getRow(), newLocation.getCol()).getPiece().getPlayer().equals(getPlayer())))
            {
                location = newLocation;
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
    
    /**
     * This method returns the array list of threatening locations
     * 
     * @return     the array list of threatening locations
     */
    public ArrayList<ChessLocation> getThreateningLocations()
    {
        return threateningLocations;
    }
    
    /**
     * This method returns game that the piece is in
     * 
     * @return     the ChessGame that the piece is in
     */
    public ChessGame getGame()
    {
        return game;
    }
    
    /**
     * This method returns the location of the piece
     * 
     * @return     the ChessLocation of the location of the piece
     */
    public ChessLocation getLocation()
    {
        return location;
    }
    
    /**
     * This method returns the ID of the piece
     * 
     * @return     the ID of the piece
     */
    public char getID()
    {
        return id;
    }
    
    /**
     * This method returns the player of the piece
     * 
     * @return     the player of the piece
     */
    public String getPlayer()
    {
        return player;
    }
    
     /**
     * This method checks if there is a piece in between the start and end location
     * and returns true if there is not a piece in the way.
     * 
     * @param  start    the start location  
     * @param  end      the end location
     * @return     false if there is a piece in the way
     */
    protected boolean checkLineOfSight(ChessLocation start, ChessLocation end)
    {
        int rowShift = 0;
        int colShift = 0;
        rowShift = end.getRow() - start.getRow();
        colShift = end.getCol() - start.getCol();
        
        if(rowShift == 0 && colShift == 0)
        {
            return true;
        }
        else if(Math.abs(rowShift) == 1 && Math.abs(colShift) == 1)
        {
            return true;
        }
        else if(rowShift == 0 && colShift > 1)
        {
            for(int j = 1; j < colShift; j++)
            {
                if(game.getBoard().isPieceAt(start.getRow(), j)) // if there's a piece there
                {
                    return false; // line of sight is not clear of pieces
                }
            }
        }
        else if(rowShift == 0 && colShift < -1)
        {
            for(int j = 1; j < Math.abs(colShift); j++)
            {
                if(game.getBoard().isPieceAt(start.getRow(), start.getCol() - j))
                {
                    return false;
                }
            }
        }
        else if(colShift == 0 && rowShift > 1)
        {
            for(int i = 1; i < rowShift; i++)
            {
                if(game.getBoard().isPieceAt(start.getRow() + i, start.getCol()))
                {
                    return false;
                }
            }
        }
        else if(colShift == 0 && rowShift < -1)
        {
            for(int i = 1; i < Math.abs(rowShift); i++)
            {
                if(game.getBoard().isPieceAt(start.getRow() - i, start.getCol()))
                {
                    return false;
                }
            }
        }
        else if(rowShift < -1 && colShift > 1 && (Math.abs(rowShift) == Math.abs(colShift)))
        {
            for(int i = 1; i < Math.abs(rowShift); i++)
            {
                if(game.getBoard().isPieceAt(start.getRow() - i, start.getCol() + i))
                {
                    return false;
                }
            }
        }
        else if(rowShift < -1 && colShift < -1 && (Math.abs(rowShift) == Math.abs(colShift)))
        {
            for(int i = 1; i < Math.abs(rowShift); i++)
            {
                if(game.getBoard().isPieceAt(start.getRow() - i, start.getCol() - i))
                {
                    return false;
                }
            }
        }
        else if(rowShift > 1 && colShift < -1 && (Math.abs(rowShift) == Math.abs(colShift)))
        {
            for(int i = 1; i < Math.abs(rowShift); i++)
            {
                if(game.getBoard().isPieceAt(start.getRow() + i, start.getCol() - i))
                {
                    return false;
                }
            }
        }
        else if(rowShift > 1 && colShift > 1 && (Math.abs(rowShift) == Math.abs(colShift)))
        {
            for(int i = 1; i < Math.abs(rowShift); i++)
            {
                if(game.getBoard().isPieceAt(start.getRow() + i, start.getCol() + i))
                {
                    return false;
                }
            }
        }
        return true;
    }

}
