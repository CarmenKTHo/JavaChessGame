
/**
 * This interface ensures that the ChessPiece class has the
 * moveTo method.
 * 
 * @author Carmen Ho
 * @version version 3.0 (November 27, 2016)
 */
public interface ChessPieceInterface
{
    /**
     * This method is used for moving the ChessPieces.
     * 
     * @param  ChessPiece   location
     * @return boolean      true if the piece was moved
     */
    public boolean moveTo(ChessLocation location);
}
