
/**
 * This class stores the row and the column as a location
 * 
 * @author Carmen Ho
 * @version 3.0 (November 27, 2016)
 */
public class ChessLocation
{
    // instance variables
    private int row;
    private int col;

    /**
     * Constructor for objects of class ChessLocation
     */
    public ChessLocation()
    {
        this.row = 0;
        this.col = 0;
    }
    
    public ChessLocation(int row)
    {
        this.row = row;
        this.col = 0;
    }
    
    public ChessLocation(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    /**
     * This method returns the row of the location. 
     * 
     * @return     the row of ChessLocation
     */
    public int getRow()
    {
        return row;
    }
    
    /**
     * This method returns the column of the location. 
     * 
     * @return     the column of ChessLocation
     */
    public int getCol()
    {
        return col;
    }
    
    /**
     * This method determines whether or not two ChessLocations are equal. 
     * 
     * @param   cp  the ChessLocation to be compared to
     * @return     true if the two locations are equal, false if they are not
     */
    public boolean equals(ChessLocation cp)
    {
        if(getRow() == cp.getRow() && getCol() == cp.getCol())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
