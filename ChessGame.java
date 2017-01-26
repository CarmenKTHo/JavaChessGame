
/**
 * This class is the chess game itself; it initializes a new game.
 * 
 * @author Carmen Ho
 * @version 3.0 (November 27, 2016)
 */
public class ChessGame
{
    private ChessBoard board;
    private String player1;
    private String player2;

    /**
     * Constructor for objects of class ChessGame
     */
    public ChessGame(String player1, String player2)
    {
        board = new ChessBoard();
        this.player1 = player1;
        this.player2 = player2;
        new King(player1, new ChessLocation(0, 4),this);
        new Queen(player1, new ChessLocation(0, 3),this);
        new Knight(player1, new ChessLocation(0, 1), this);
        new Knight(player1, new ChessLocation(0, 6), this);
        new Bishop(player1, new ChessLocation(0, 2),this);
        new Bishop(player1, new ChessLocation(0, 5),this);
        new Rook(player1, new ChessLocation(0, 0),this);
        new Rook(player1, new ChessLocation(0, 7),this);
        new Pawn(player1, new ChessLocation(1, 0),this);
        new Pawn(player1, new ChessLocation(1, 1),this);
        new Pawn(player1, new ChessLocation(1, 2),this);
        new Pawn(player1, new ChessLocation(1, 3),this);
        new Pawn(player1, new ChessLocation(1, 4),this);
        new Pawn(player1, new ChessLocation(1, 5),this);
        new Pawn(player1, new ChessLocation(1, 6),this);
        new Pawn(player1, new ChessLocation(1, 7),this);
        
        new King(player2, new ChessLocation(7, 4),this);
        new Queen(player2, new ChessLocation(7, 3),this);
        new Knight(player2, new ChessLocation(7, 1), this);
        new Knight(player2, new ChessLocation(7, 6), this);
        new Bishop(player2, new ChessLocation(7, 2),this);
        new Bishop(player2, new ChessLocation(7, 5),this);
        new Rook(player2, new ChessLocation(7, 0),this);
        new Rook(player2, new ChessLocation(7, 7),this);
        new Pawn(player2, new ChessLocation(6, 0),this);
        new Pawn(player2, new ChessLocation(6, 1),this);
        new Pawn(player2, new ChessLocation(6, 2),this);
        new Pawn(player2, new ChessLocation(6, 3),this);
        new Pawn(player2, new ChessLocation(6, 4),this);
        new Pawn(player2, new ChessLocation(6, 5),this);
        new Pawn(player2, new ChessLocation(6, 6),this);
        new Pawn(player2, new ChessLocation(6, 7),this);
    }

    /**
     * This method returns the chess board that is being used in this chess game
     * 
     * @return     the chess board being used in this chess game
     */
    public ChessBoard getBoard()
    {
        return board;
    }
    
    /**
     * This method returns player 1
     * 
     * @return     player 1
     */
    public String getPlayer1()
    {
        return player1;
    }
    
    /**
     * This method returns player 2
     * 
     * @return     player 2
     */
    public String getPlayer2()
    {
        return player2;
    }
}
