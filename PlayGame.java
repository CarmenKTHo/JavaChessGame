import java.util.Scanner;
/**
 * PlayGame displays the game menu, initialized a new game, and receives & executes commands from the user.
 * 
 * @author Carmen Ho 
 * @version 3.0 (November 27, 2016)
 */
public class PlayGame
{

    /**
     * Constructor for objects of class PlayGame
     */
    public PlayGame()
    {
    }
    
    /**
     * This method runs the game by calling the main() method
     */
    public static void main (String[] args)
    {
        main();
    }
    
    /**
     * This method provides a brief intro to the game of chess.
     */
    public static void intro ()
    {
        //The following print statements give a brief overview of chess
        System.out.println("Welcome to a game of Chess!");
        System.out.println("This is a game where each team");
        System.out.println("attempts to defeat the opponent by");
        System.out.println("moving one's own pieces (using row and");
        System.out.println("column indices (eg. (2, 5))) to eliminate");
        System.out.println("the other team's King piece.");
        System.out.println("Enjoy!");
        System.out.println();
    }
    
    /**
     * This method runs the game and asks the user for information in order to move the pieces, taking
     * turns between two players. It stops when a player's king is captured.
     * It also stops the game when the user enters 'quit', restarts when the user enters 'restart'.
     */
    public static void main ()
    {
        intro();
        
        ChessGame chessGame = new ChessGame("Player1", "Player2");
        chessGame.getBoard().printBoard();
        System.out.println();
           
        Scanner sc = new Scanner(System.in);
        String action;
        System.out.println("Player1's turn.");
        System.out.println("What would you like to do? (move, quit, or restart)");
        action = sc.nextLine();
        
        int turn = 0;
        
        while(!action.equals("quit") && !action.equals("restart")){
            
            String player; 
            if((turn % 2) == 0)
            {
                player = "Player1";
            }
            else
            {
                player = "Player2";
            }
            
            if(action.equalsIgnoreCase("move"))
            {
                for(int i = 0; i < 8; i++)
                {
                   for(int j = 0; j < 8; j++)
                   {
                       if(chessGame.getBoard().getSquareAt(i, j).getPiece() instanceof King)
                       {
                           if(chessGame.getBoard().getSquareAt(i, j).getPiece().getPlayer().equals(player))
                           {
                               King king = (King)chessGame.getBoard().getSquareAt(i, j).getPiece();
                               if(king.check() != null)
                               {
                                   System.out.println();
                                   System.out.println("Check. This piece is threatening your king: " + king.check().getID() + " at (" 
                                   + king.check().getLocation().getRow() + "," + king.check().getLocation().getCol() + ")");
                                   System.out.println();
                               }
                           }
                       }
                   }
                }
                
                
                /* A loop that continuously asks the user for coordinates in order
                 * to move the piece.
                 */ 
                System.out.println("Move from (eg. 2, 5): ");
                String input = sc.nextLine();
                int srcRowNum = 0;
                int srcColNum = 0;
                if(input.matches("0, 0") || input.matches("0, 1") || input.matches("0, 2") || input.matches("0, 3") || input.matches("0, 4") || input.matches("0, 5")
                 || input.matches("0, 6") || input.matches("0, 7") || input.matches("1, 0") || input.matches("1, 1") || input.matches("1, 2") || input.matches("1, 3")
                 || input.matches("1, 4") || input.matches("1, 5") || input.matches("1, 6") || input.matches("1, 7") || input.matches("2, 0") || input.matches("2, 1")
                 || input.matches("2, 2") || input.matches("2, 3") || input.matches("2, 4") || input.matches("2, 5") || input.matches("2, 6") || input.matches("2, 7")
                 || input.matches("3, 0") || input.matches("3, 1") || input.matches("3, 2") || input.matches("3, 3") || input.matches("3, 4") || input.matches("3, 5")
                 || input.matches("3, 6") || input.matches("3, 7") || input.matches("4, 0") || input.matches("4, 1") || input.matches("4, 2") || input.matches("4, 3")
                 || input.matches("4, 4") || input.matches("4, 5") || input.matches("4, 6") || input.matches("4, 7") || input.matches("5, 0") || input.matches("5, 1")
                 || input.matches("5, 2") || input.matches("5, 3") || input.matches("5, 4") || input.matches("5, 5") || input.matches("5, 6") || input.matches("5, 7")
                 || input.matches("6, 0") || input.matches("6, 1") || input.matches("6, 2") || input.matches("6, 3") || input.matches("6, 4") || input.matches("6, 5")
                 || input.matches("6, 6") || input.matches("6, 7") || input.matches("7, 0") || input.matches("7, 1") || input.matches("7, 2") || input.matches("7, 3")
                 || input.matches("7, 4") || input.matches("7, 5") || input.matches("7, 6") || input.matches("7, 7"))   
                {
                    String substring1 = input.substring(0, 1);
                    String substring2 = input.substring(3);
                    srcRowNum = Integer.parseInt(substring1);
                    srcColNum = Integer.parseInt(substring2);
                }
                else
                {
                    System.out.println("Invalid location. Move from (eg. 2, 5): ");
                    input = sc.nextLine();
                    while(!(input.matches("0, 0") || input.matches("0, 1") || input.matches("0, 2") || input.matches("0, 3") || input.matches("0, 4") || input.matches("0, 5")
                     || input.matches("0, 6") || input.matches("0, 7") || input.matches("1, 0") || input.matches("1, 1") || input.matches("1, 2") || input.matches("1, 3")
                     || input.matches("1, 4") || input.matches("1, 5") || input.matches("1, 6") || input.matches("1, 7") || input.matches("2, 0") || input.matches("2, 1")
                     || input.matches("2, 2") || input.matches("2, 3") || input.matches("2, 4") || input.matches("2, 5") || input.matches("2, 6") || input.matches("2, 7")
                     || input.matches("3, 0") || input.matches("3, 1") || input.matches("3, 2") || input.matches("3, 3") || input.matches("3, 4") || input.matches("3, 5")
                     || input.matches("3, 6") || input.matches("3, 7") || input.matches("4, 0") || input.matches("4, 1") || input.matches("4, 2") || input.matches("4, 3")
                     || input.matches("4, 4") || input.matches("4, 5") || input.matches("4, 6") || input.matches("4, 7") || input.matches("5, 0") || input.matches("5, 1")
                     || input.matches("5, 2") || input.matches("5, 3") || input.matches("5, 4") || input.matches("5, 5") || input.matches("5, 6") || input.matches("5, 7")
                     || input.matches("6, 0") || input.matches("6, 1") || input.matches("6, 2") || input.matches("6, 3") || input.matches("6, 4") || input.matches("6, 5")
                     || input.matches("6, 6") || input.matches("6, 7") || input.matches("7, 0") || input.matches("7, 1") || input.matches("7, 2") || input.matches("7, 3")
                     || input.matches("7, 4") || input.matches("7, 5") || input.matches("7, 6") || input.matches("7, 7"))) 
                    {
                        System.out.println("Invalid location. Move from (eg. 2, 5): ");
                        input = sc.nextLine();
                    }
                    String substring1 = input.substring(0, 1);
                    String substring2 = input.substring(3);
                    srcRowNum = Integer.parseInt(substring1);
                    srcColNum = Integer.parseInt(substring2);
                }
                
                //This continually asks the user for a new source location if the first location given does not contain a piece
                while(chessGame.getBoard().getSquareAt(srcRowNum, srcColNum).getPiece() == null
                || !chessGame.getBoard().getSquareAt(srcRowNum, srcColNum).getPiece().getPlayer().equals(player))
                { 
                    System.out.println();
                    if(chessGame.getBoard().getSquareAt(srcRowNum, srcColNum).getPiece() == null)
                    {
                        System.out.println("Error: There is no piece at the source location.");
                    }
                    else
                    {
                        System.out.println("Error: You cannot move an opponent's piece.");
                    }
                    System.out.println();
                    
                    System.out.println("Move from (eg. 2, 5): ");
                    input = sc.nextLine();
                    srcRowNum = 0;
                    srcColNum = 0;
                    if(input.matches("0, 0") || input.matches("0, 1") || input.matches("0, 2") || input.matches("0, 3") || input.matches("0, 4") || input.matches("0, 5")
                     || input.matches("0, 6") || input.matches("0, 7") || input.matches("1, 0") || input.matches("1, 1") || input.matches("1, 2") || input.matches("1, 3")
                     || input.matches("1, 4") || input.matches("1, 5") || input.matches("1, 6") || input.matches("1, 7") || input.matches("2, 0") || input.matches("2, 1")
                     || input.matches("2, 2") || input.matches("2, 3") || input.matches("2, 4") || input.matches("2, 5") || input.matches("2, 6") || input.matches("2, 7")
                     || input.matches("3, 0") || input.matches("3, 1") || input.matches("3, 2") || input.matches("3, 3") || input.matches("3, 4") || input.matches("3, 5")
                     || input.matches("3, 6") || input.matches("3, 7") || input.matches("4, 0") || input.matches("4, 1") || input.matches("4, 2") || input.matches("4, 3")
                     || input.matches("4, 4") || input.matches("4, 5") || input.matches("4, 6") || input.matches("4, 7") || input.matches("5, 0") || input.matches("5, 1")
                     || input.matches("5, 2") || input.matches("5, 3") || input.matches("5, 4") || input.matches("5, 5") || input.matches("5, 6") || input.matches("5, 7")
                     || input.matches("6, 0") || input.matches("6, 1") || input.matches("6, 2") || input.matches("6, 3") || input.matches("6, 4") || input.matches("6, 5")
                     || input.matches("6, 6") || input.matches("6, 7") || input.matches("7, 0") || input.matches("7, 1") || input.matches("7, 2") || input.matches("7, 3")
                     || input.matches("7, 4") || input.matches("7, 5") || input.matches("7, 6") || input.matches("7, 7"))   
                    {
                        String substring1 = input.substring(0, 1);
                        String substring2 = input.substring(3);
                        srcRowNum = Integer.parseInt(substring1);
                        srcColNum = Integer.parseInt(substring2);
                    }
                    else
                    {
                        System.out.println("Invalid location. Move from (eg. 2, 5): ");
                        input = sc.nextLine();
                        while(!(input.matches("0, 0") || input.matches("0, 1") || input.matches("0, 2") || input.matches("0, 3") || input.matches("0, 4") || input.matches("0, 5")
                         || input.matches("0, 6") || input.matches("0, 7") || input.matches("1, 0") || input.matches("1, 1") || input.matches("1, 2") || input.matches("1, 3")
                         || input.matches("1, 4") || input.matches("1, 5") || input.matches("1, 6") || input.matches("1, 7") || input.matches("2, 0") || input.matches("2, 1")
                         || input.matches("2, 2") || input.matches("2, 3") || input.matches("2, 4") || input.matches("2, 5") || input.matches("2, 6") || input.matches("2, 7")
                         || input.matches("3, 0") || input.matches("3, 1") || input.matches("3, 2") || input.matches("3, 3") || input.matches("3, 4") || input.matches("3, 5")
                         || input.matches("3, 6") || input.matches("3, 7") || input.matches("4, 0") || input.matches("4, 1") || input.matches("4, 2") || input.matches("4, 3")
                         || input.matches("4, 4") || input.matches("4, 5") || input.matches("4, 6") || input.matches("4, 7") || input.matches("5, 0") || input.matches("5, 1")
                         || input.matches("5, 2") || input.matches("5, 3") || input.matches("5, 4") || input.matches("5, 5") || input.matches("5, 6") || input.matches("5, 7")
                         || input.matches("6, 0") || input.matches("6, 1") || input.matches("6, 2") || input.matches("6, 3") || input.matches("6, 4") || input.matches("6, 5")
                         || input.matches("6, 6") || input.matches("6, 7") || input.matches("7, 0") || input.matches("7, 1") || input.matches("7, 2") || input.matches("7, 3")
                         || input.matches("7, 4") || input.matches("7, 5") || input.matches("7, 6") || input.matches("7, 7"))) 
                        {
                            System.out.println("Invalid location. Move from (eg. 2, 5): ");
                            input = sc.nextLine();
                        }
                        String substring1 = input.substring(0, 1);
                        String substring2 = input.substring(3);
                        srcRowNum = Integer.parseInt(substring1);
                        srcColNum = Integer.parseInt(substring2);
                    }
                }
                
                System.out.println("Move to (eg. 3, 4): ");
                input = sc.nextLine();
                int destRowNum = 0;
                int destColNum = 0;
                if(input.matches("0, 0") || input.matches("0, 1") || input.matches("0, 2") || input.matches("0, 3") || input.matches("0, 4") || input.matches("0, 5")
                 || input.matches("0, 6") || input.matches("0, 7") || input.matches("1, 0") || input.matches("1, 1") || input.matches("1, 2") || input.matches("1, 3")
                 || input.matches("1, 4") || input.matches("1, 5") || input.matches("1, 6") || input.matches("1, 7") || input.matches("2, 0") || input.matches("2, 1")
                 || input.matches("2, 2") || input.matches("2, 3") || input.matches("2, 4") || input.matches("2, 5") || input.matches("2, 6") || input.matches("2, 7")
                 || input.matches("3, 0") || input.matches("3, 1") || input.matches("3, 2") || input.matches("3, 3") || input.matches("3, 4") || input.matches("3, 5")
                 || input.matches("3, 6") || input.matches("3, 7") || input.matches("4, 0") || input.matches("4, 1") || input.matches("4, 2") || input.matches("4, 3")
                 || input.matches("4, 4") || input.matches("4, 5") || input.matches("4, 6") || input.matches("4, 7") || input.matches("5, 0") || input.matches("5, 1")
                 || input.matches("5, 2") || input.matches("5, 3") || input.matches("5, 4") || input.matches("5, 5") || input.matches("5, 6") || input.matches("5, 7")
                 || input.matches("6, 0") || input.matches("6, 1") || input.matches("6, 2") || input.matches("6, 3") || input.matches("6, 4") || input.matches("6, 5")
                 || input.matches("6, 6") || input.matches("6, 7") || input.matches("7, 0") || input.matches("7, 1") || input.matches("7, 2") || input.matches("7, 3")
                 || input.matches("7, 4") || input.matches("7, 5") || input.matches("7, 6") || input.matches("7, 7"))   
                {
                    String substring1 = input.substring(0, 1);
                    String substring2 = input.substring(3);
                    destRowNum = Integer.parseInt(substring1);
                    destColNum = Integer.parseInt(substring2);
                }
                else
                {
                    System.out.println("Invalid location. Move to (eg. 3, 4): ");
                    input = sc.nextLine();
                    while(!(input.matches("0, 0") || input.matches("0, 1") || input.matches("0, 2") || input.matches("0, 3") || input.matches("0, 4") || input.matches("0, 5")
                     || input.matches("0, 6") || input.matches("0, 7") || input.matches("1, 0") || input.matches("1, 1") || input.matches("1, 2") || input.matches("1, 3")
                     || input.matches("1, 4") || input.matches("1, 5") || input.matches("1, 6") || input.matches("1, 7") || input.matches("2, 0") || input.matches("2, 1")
                     || input.matches("2, 2") || input.matches("2, 3") || input.matches("2, 4") || input.matches("2, 5") || input.matches("2, 6") || input.matches("2, 7")
                     || input.matches("3, 0") || input.matches("3, 1") || input.matches("3, 2") || input.matches("3, 3") || input.matches("3, 4") || input.matches("3, 5")
                     || input.matches("3, 6") || input.matches("3, 7") || input.matches("4, 0") || input.matches("4, 1") || input.matches("4, 2") || input.matches("4, 3")
                     || input.matches("4, 4") || input.matches("4, 5") || input.matches("4, 6") || input.matches("4, 7") || input.matches("5, 0") || input.matches("5, 1")
                     || input.matches("5, 2") || input.matches("5, 3") || input.matches("5, 4") || input.matches("5, 5") || input.matches("5, 6") || input.matches("5, 7")
                     || input.matches("6, 0") || input.matches("6, 1") || input.matches("6, 2") || input.matches("6, 3") || input.matches("6, 4") || input.matches("6, 5")
                     || input.matches("6, 6") || input.matches("6, 7") || input.matches("7, 0") || input.matches("7, 1") || input.matches("7, 2") || input.matches("7, 3")
                     || input.matches("7, 4") || input.matches("7, 5") || input.matches("7, 6") || input.matches("7, 7"))) 
                    {
                        System.out.println("Invalid location. Move to (eg. 3, 4): ");
                        input = sc.nextLine();
                    }
                    String substring1 = input.substring(0, 1);
                    String substring2 = input.substring(3);
                    destRowNum = Integer.parseInt(substring1);
                    destColNum = Integer.parseInt(substring2);
                }
                
                while(!chessGame.getBoard().getSquareAt(srcRowNum, srcColNum).getPiece().moveTo(new ChessLocation(destRowNum, destColNum)))
                {
                    if(chessGame.getBoard().isPieceAt(destRowNum, destColNum)){
                        if(chessGame.getBoard().getSquareAt(srcRowNum, srcColNum).getPiece().getPlayer().equals(chessGame.getBoard().getSquareAt(destRowNum, destColNum).getPiece().getPlayer()))
                        {
                            System.out.println("There is a friendly piece at the destination location.");
                            System.out.println();
                        }
                    }
                    
                    System.out.println("Please try again."); 
                    
                    System.out.println();
                    chessGame.getBoard().printBoard();
                    System.out.println();
                    
                    System.out.println("Move from (eg. 2, 5): ");
                    input = sc.nextLine();
                    srcRowNum = 0;
                    srcColNum = 0;
                    if(input.matches("0, 0") || input.matches("0, 1") || input.matches("0, 2") || input.matches("0, 3") || input.matches("0, 4") || input.matches("0, 5")
                     || input.matches("0, 6") || input.matches("0, 7") || input.matches("1, 0") || input.matches("1, 1") || input.matches("1, 2") || input.matches("1, 3")
                     || input.matches("1, 4") || input.matches("1, 5") || input.matches("1, 6") || input.matches("1, 7") || input.matches("2, 0") || input.matches("2, 1")
                     || input.matches("2, 2") || input.matches("2, 3") || input.matches("2, 4") || input.matches("2, 5") || input.matches("2, 6") || input.matches("2, 7")
                     || input.matches("3, 0") || input.matches("3, 1") || input.matches("3, 2") || input.matches("3, 3") || input.matches("3, 4") || input.matches("3, 5")
                     || input.matches("3, 6") || input.matches("3, 7") || input.matches("4, 0") || input.matches("4, 1") || input.matches("4, 2") || input.matches("4, 3")
                     || input.matches("4, 4") || input.matches("4, 5") || input.matches("4, 6") || input.matches("4, 7") || input.matches("5, 0") || input.matches("5, 1")
                     || input.matches("5, 2") || input.matches("5, 3") || input.matches("5, 4") || input.matches("5, 5") || input.matches("5, 6") || input.matches("5, 7")
                     || input.matches("6, 0") || input.matches("6, 1") || input.matches("6, 2") || input.matches("6, 3") || input.matches("6, 4") || input.matches("6, 5")
                     || input.matches("6, 6") || input.matches("6, 7") || input.matches("7, 0") || input.matches("7, 1") || input.matches("7, 2") || input.matches("7, 3")
                     || input.matches("7, 4") || input.matches("7, 5") || input.matches("7, 6") || input.matches("7, 7"))   
                    {
                        String substring1 = input.substring(0, 1);
                        String substring2 = input.substring(3);
                        srcRowNum = Integer.parseInt(substring1);
                        srcColNum = Integer.parseInt(substring2);
                    }
                    else
                    {
                        System.out.println("Invalid location. Move from (eg. 2, 5): ");
                        input = sc.nextLine();
                        while(!(input.matches("0, 0") || input.matches("0, 1") || input.matches("0, 2") || input.matches("0, 3") || input.matches("0, 4") || input.matches("0, 5")
                         || input.matches("0, 6") || input.matches("0, 7") || input.matches("1, 0") || input.matches("1, 1") || input.matches("1, 2") || input.matches("1, 3")
                         || input.matches("1, 4") || input.matches("1, 5") || input.matches("1, 6") || input.matches("1, 7") || input.matches("2, 0") || input.matches("2, 1")
                         || input.matches("2, 2") || input.matches("2, 3") || input.matches("2, 4") || input.matches("2, 5") || input.matches("2, 6") || input.matches("2, 7")
                         || input.matches("3, 0") || input.matches("3, 1") || input.matches("3, 2") || input.matches("3, 3") || input.matches("3, 4") || input.matches("3, 5")
                         || input.matches("3, 6") || input.matches("3, 7") || input.matches("4, 0") || input.matches("4, 1") || input.matches("4, 2") || input.matches("4, 3")
                         || input.matches("4, 4") || input.matches("4, 5") || input.matches("4, 6") || input.matches("4, 7") || input.matches("5, 0") || input.matches("5, 1")
                         || input.matches("5, 2") || input.matches("5, 3") || input.matches("5, 4") || input.matches("5, 5") || input.matches("5, 6") || input.matches("5, 7")
                         || input.matches("6, 0") || input.matches("6, 1") || input.matches("6, 2") || input.matches("6, 3") || input.matches("6, 4") || input.matches("6, 5")
                         || input.matches("6, 6") || input.matches("6, 7") || input.matches("7, 0") || input.matches("7, 1") || input.matches("7, 2") || input.matches("7, 3")
                         || input.matches("7, 4") || input.matches("7, 5") || input.matches("7, 6") || input.matches("7, 7"))) 
                        {
                            System.out.println("Invalid location. Move from (eg. 2, 5): ");
                            input = sc.nextLine();
                        }
                        String substring1 = input.substring(0, 1);
                        String substring2 = input.substring(3);
                        srcRowNum = Integer.parseInt(substring1);
                        srcColNum = Integer.parseInt(substring2);
                    }
                    
                    //This continually asks the user for a new source location if the first location given does not contain a piece
                    while(chessGame.getBoard().getSquareAt(srcRowNum, srcColNum).getPiece() == null
                    || !chessGame.getBoard().getSquareAt(srcRowNum, srcColNum).getPiece().getPlayer().equals(player))
                    { 
                        System.out.println();
                        if(chessGame.getBoard().getSquareAt(srcRowNum, srcColNum).getPiece() == null)
                        {
                            System.out.println("Error: There is no piece at the source location.");
                        }
                        else
                        {
                            System.out.println("Error: You cannot move an opponent's piece.");
                        }
                        System.out.println();
                        
                        System.out.println("Move from (eg. 2, 5): ");
                        input = sc.nextLine();
                        srcRowNum = 0;
                        srcColNum = 0;
                        if(input.matches("0, 0") || input.matches("0, 1") || input.matches("0, 2") || input.matches("0, 3") || input.matches("0, 4") || input.matches("0, 5")
                         || input.matches("0, 6") || input.matches("0, 7") || input.matches("1, 0") || input.matches("1, 1") || input.matches("1, 2") || input.matches("1, 3")
                         || input.matches("1, 4") || input.matches("1, 5") || input.matches("1, 6") || input.matches("1, 7") || input.matches("2, 0") || input.matches("2, 1")
                         || input.matches("2, 2") || input.matches("2, 3") || input.matches("2, 4") || input.matches("2, 5") || input.matches("2, 6") || input.matches("2, 7")
                         || input.matches("3, 0") || input.matches("3, 1") || input.matches("3, 2") || input.matches("3, 3") || input.matches("3, 4") || input.matches("3, 5")
                         || input.matches("3, 6") || input.matches("3, 7") || input.matches("4, 0") || input.matches("4, 1") || input.matches("4, 2") || input.matches("4, 3")
                         || input.matches("4, 4") || input.matches("4, 5") || input.matches("4, 6") || input.matches("4, 7") || input.matches("5, 0") || input.matches("5, 1")
                         || input.matches("5, 2") || input.matches("5, 3") || input.matches("5, 4") || input.matches("5, 5") || input.matches("5, 6") || input.matches("5, 7")
                         || input.matches("6, 0") || input.matches("6, 1") || input.matches("6, 2") || input.matches("6, 3") || input.matches("6, 4") || input.matches("6, 5")
                         || input.matches("6, 6") || input.matches("6, 7") || input.matches("7, 0") || input.matches("7, 1") || input.matches("7, 2") || input.matches("7, 3")
                         || input.matches("7, 4") || input.matches("7, 5") || input.matches("7, 6") || input.matches("7, 7"))   
                        {
                            String substring1 = input.substring(0, 1);
                            String substring2 = input.substring(3);
                            srcRowNum = Integer.parseInt(substring1);
                            srcColNum = Integer.parseInt(substring2);
                        }
                        else
                        {
                            System.out.println("Invalid location. Move from (eg. 2, 5): ");
                            input = sc.nextLine();
                            while(!(input.matches("0, 0") || input.matches("0, 1") || input.matches("0, 2") || input.matches("0, 3") || input.matches("0, 4") || input.matches("0, 5")
                             || input.matches("0, 6") || input.matches("0, 7") || input.matches("1, 0") || input.matches("1, 1") || input.matches("1, 2") || input.matches("1, 3")
                             || input.matches("1, 4") || input.matches("1, 5") || input.matches("1, 6") || input.matches("1, 7") || input.matches("2, 0") || input.matches("2, 1")
                             || input.matches("2, 2") || input.matches("2, 3") || input.matches("2, 4") || input.matches("2, 5") || input.matches("2, 6") || input.matches("2, 7")
                             || input.matches("3, 0") || input.matches("3, 1") || input.matches("3, 2") || input.matches("3, 3") || input.matches("3, 4") || input.matches("3, 5")
                             || input.matches("3, 6") || input.matches("3, 7") || input.matches("4, 0") || input.matches("4, 1") || input.matches("4, 2") || input.matches("4, 3")
                             || input.matches("4, 4") || input.matches("4, 5") || input.matches("4, 6") || input.matches("4, 7") || input.matches("5, 0") || input.matches("5, 1")
                             || input.matches("5, 2") || input.matches("5, 3") || input.matches("5, 4") || input.matches("5, 5") || input.matches("5, 6") || input.matches("5, 7")
                             || input.matches("6, 0") || input.matches("6, 1") || input.matches("6, 2") || input.matches("6, 3") || input.matches("6, 4") || input.matches("6, 5")
                             || input.matches("6, 6") || input.matches("6, 7") || input.matches("7, 0") || input.matches("7, 1") || input.matches("7, 2") || input.matches("7, 3")
                             || input.matches("7, 4") || input.matches("7, 5") || input.matches("7, 6") || input.matches("7, 7"))) 
                            {
                                System.out.println("Invalid location. Move from (eg. 2, 5): ");
                                input = sc.nextLine();
                            }
                            String substring1 = input.substring(0, 1);
                            String substring2 = input.substring(3);
                            srcRowNum = Integer.parseInt(substring1);
                            srcColNum = Integer.parseInt(substring2);
                        }
                    }
                    
                    
                    System.out.println("Move to (eg. 3, 4): ");
                    input = sc.nextLine();
                    destRowNum = 0;
                    destColNum = 0;
                    if(input.matches("0, 0") || input.matches("0, 1") || input.matches("0, 2") || input.matches("0, 3") || input.matches("0, 4") || input.matches("0, 5")
                     || input.matches("0, 6") || input.matches("0, 7") || input.matches("1, 0") || input.matches("1, 1") || input.matches("1, 2") || input.matches("1, 3")
                     || input.matches("1, 4") || input.matches("1, 5") || input.matches("1, 6") || input.matches("1, 7") || input.matches("2, 0") || input.matches("2, 1")
                     || input.matches("2, 2") || input.matches("2, 3") || input.matches("2, 4") || input.matches("2, 5") || input.matches("2, 6") || input.matches("2, 7")
                     || input.matches("3, 0") || input.matches("3, 1") || input.matches("3, 2") || input.matches("3, 3") || input.matches("3, 4") || input.matches("3, 5")
                     || input.matches("3, 6") || input.matches("3, 7") || input.matches("4, 0") || input.matches("4, 1") || input.matches("4, 2") || input.matches("4, 3")
                     || input.matches("4, 4") || input.matches("4, 5") || input.matches("4, 6") || input.matches("4, 7") || input.matches("5, 0") || input.matches("5, 1")
                     || input.matches("5, 2") || input.matches("5, 3") || input.matches("5, 4") || input.matches("5, 5") || input.matches("5, 6") || input.matches("5, 7")
                     || input.matches("6, 0") || input.matches("6, 1") || input.matches("6, 2") || input.matches("6, 3") || input.matches("6, 4") || input.matches("6, 5")
                     || input.matches("6, 6") || input.matches("6, 7") || input.matches("7, 0") || input.matches("7, 1") || input.matches("7, 2") || input.matches("7, 3")
                     || input.matches("7, 4") || input.matches("7, 5") || input.matches("7, 6") || input.matches("7, 7"))   
                    {
                        String substring1 = input.substring(0, 1);
                        String substring2 = input.substring(3);
                        destRowNum = Integer.parseInt(substring1);
                        destColNum = Integer.parseInt(substring2);
                    }
                    else
                    {
                        System.out.println("Invalid location. Move to (eg. 3, 4): ");
                        input = sc.nextLine();
                        while(!(input.matches("0, 0") || input.matches("0, 1") || input.matches("0, 2") || input.matches("0, 3") || input.matches("0, 4") || input.matches("0, 5")
                         || input.matches("0, 6") || input.matches("0, 7") || input.matches("1, 0") || input.matches("1, 1") || input.matches("1, 2") || input.matches("1, 3")
                         || input.matches("1, 4") || input.matches("1, 5") || input.matches("1, 6") || input.matches("1, 7") || input.matches("2, 0") || input.matches("2, 1")
                         || input.matches("2, 2") || input.matches("2, 3") || input.matches("2, 4") || input.matches("2, 5") || input.matches("2, 6") || input.matches("2, 7")
                         || input.matches("3, 0") || input.matches("3, 1") || input.matches("3, 2") || input.matches("3, 3") || input.matches("3, 4") || input.matches("3, 5")
                         || input.matches("3, 6") || input.matches("3, 7") || input.matches("4, 0") || input.matches("4, 1") || input.matches("4, 2") || input.matches("4, 3")
                         || input.matches("4, 4") || input.matches("4, 5") || input.matches("4, 6") || input.matches("4, 7") || input.matches("5, 0") || input.matches("5, 1")
                         || input.matches("5, 2") || input.matches("5, 3") || input.matches("5, 4") || input.matches("5, 5") || input.matches("5, 6") || input.matches("5, 7")
                         || input.matches("6, 0") || input.matches("6, 1") || input.matches("6, 2") || input.matches("6, 3") || input.matches("6, 4") || input.matches("6, 5")
                         || input.matches("6, 6") || input.matches("6, 7") || input.matches("7, 0") || input.matches("7, 1") || input.matches("7, 2") || input.matches("7, 3")
                         || input.matches("7, 4") || input.matches("7, 5") || input.matches("7, 6") || input.matches("7, 7"))) 
                        {
                            System.out.println("Invalid location. Move to (eg. 3, 4): ");
                            input = sc.nextLine();
                        }
                        String substring1 = input.substring(0, 1);
                        String substring2 = input.substring(3);
                        destRowNum = Integer.parseInt(substring1);
                        destColNum = Integer.parseInt(substring2);
                    }
                }
    
                chessGame.getBoard().printBoard();
                System.out.println();

                int numKings = 0;
                for(int i = 0; i < 8; i++)
                {
                   for(int j = 0; j < 8; j++)
                   {
                       if(chessGame.getBoard().getSquareAt(i, j).getPiece() instanceof King)
                       {
                           numKings++;
                       }
                   }
                }
                if(numKings == 1)
                {
                    break;
                }
                
                turn++;
                
                if((turn%2) == 0)
                {
                    System.out.println("Player1's turn.");
                }
                else
                {
                    System.out.println("Player2's turn.");
                }
                
                System.out.println("What would you like to do? (move, quit, or restart)");
                Scanner sq = new Scanner(System.in);
                action = sq.nextLine();
            }
            else
            {
                System.out.println("Unable to process your request.");
                System.out.println("What would you like to do? (move, quit, or restart)");
                Scanner sq = new Scanner(System.in);
                action = sq.nextLine();
            }
        }
        if(action.equalsIgnoreCase("quit")) 
        {
            sc.close();
            if((turn%2) == 0)
            {
                System.out.println();
                System.out.println("Player1 surrenders! Player 2 wins!");
            }
            else if((turn%2) != 0)
            {
                System.out.println();
                System.out.println("Player2 surrenders! Player 1 wins!");
            }
            System.out.println("Thanks for playing!");
        }
        else if(action.equalsIgnoreCase("restart"))
        {
            sc.close();
            System.out.println("Thanks for playing!");
            System.out.println();
            System.out.println();
            main();
        }
        else
        {
            if((turn%2) == 0)
            {
                System.out.println("Player1 won!");
            }
            else
            {
                System.out.println("Player2 won!");
            }
            System.out.println("Thanks for playing!");
            System.out.println();
        }
    }
}
