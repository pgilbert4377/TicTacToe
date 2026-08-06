import java.util.*;
public class TicTacToeGame
{
    String[][] board = new String[3][3];
    Scanner scan = new Scanner(System.in);
    boolean gameOver = false;
    String rowString;
    String columnString;
    int row;
    int column;
    int r;
    int col;
    int bestRow;
    int bestCol;
    int computerRow;
    int computerColumn;
    boolean twoOs = false;
    boolean twoXs = false;
    boolean valid = false;
    boolean compWin = false;
    boolean playerWin = false;
    int ex = 0;
    int oh = 0;
    public void main()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                board[i][j] = " ";
            }
        }
        printBoard();
        while(!gameOver)
        {
            bestRow = 4;
            valid = false;
            while(!valid)
            {
                try{
                    System.out.print("Enter row number (1-3): ");
                    rowString = scan.nextLine();
                    if(rowString.equals("1") || rowString.equals("2") || rowString.equals("3"))
                    {
                        row = Integer.parseInt(rowString) - 1;
                    }
                    else
                    {
                        throw new Exception("Not a valid row input!");
                    }
                    System.out.print("Enter column number (1-3): ");
                    columnString = scan.nextLine();
                    if(columnString.equals("1") || columnString.equals("2") || columnString.equals("3"))
                    {
                        column = Integer.parseInt(columnString) - 1;
                    }
                    else
                    {
                        throw new Exception("Not a valid column input!");
                    }
                    if(board[row][column].equals(" "))
                    {
                        board[row][column] = "X";
                        valid = true;
                    }
                    else
                    {
                        throw new Exception("Spot is already taken!");
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
            valid = false;
            printBoard();
            System.out.println();
            checkWin();
            if(gameOver)
            {
                break;
            }
            System.out.println("Computer's turn:");
            while(!valid)
            {
                r = 0;
                for(int i = 0; i < 3; i++)
                {
                    ex = 0;
                    oh = 0;
                    for(int j = 0; j < 3; j++)
                    {
                        if(board[i][j].equals("X"))
                        {
                            ex++;
                        }
                        else if(board[i][j].equals("O"))
                        {
                            oh++;
                        }
                    }
                    if(oh == 2 && ex == 0)
                    {
                        r = i;
                        twoOs = true;
                        break;
                    }
                    else if(ex == 2 && oh == 0)
                    {
                        r = i;
                        twoXs = true;
                    }
                }
                if(twoOs)
                {
                    for(int j = 0; j < 3; j++)
                    {
                        if(board[r][j].equals(" "))
                        {
                            board[r][j] = "O";
                            valid = true;
                            twoOs = false;
                            twoXs = false;
                            System.out.println("Placing O at 1");
                            break;
                        }
                    }
                }
                else if(twoXs)
                {
                    for(int j = 0; j < 3; j++)
                    {
                        if(board[r][j].equals(" "))
                        {
                            bestRow = r;
                            bestCol = j;
                            twoXs = false;
                            break;
                        }
                    }
                }
                if(valid)
                {
                    break;
                }
                for(int i = 0; i < 3; i++)
                {
                    r = 0;
                    ex = 0;
                    oh = 0;
                    for(int j = 0; j < 3; j++)
                    {
                        if(board[j][i].equals("X"))
                        {
                            ex++;
                        }
                        else if(board[j][i].equals("O"))
                        {
                            oh++;
                        }
                    }
                    if(oh == 2 && ex == 0)
                    {
                        r = i;
                        twoOs = true;
                        break;
                    }
                    else if(ex == 2 && oh == 0)
                    {
                        r = i;
                        twoXs = true;
                    }
                }
                if(twoOs)
                {
                    for(int j = 0; j < 3; j++)
                    {
                        if(board[j][r].equals(" "))
                        {
                            board[j][r] = "O";
                            valid = true;
                            twoOs = false;
                            twoXs = false;
                            System.out.println("Placing O at 2");
                            break;
                        }
                    }
                }
                else if(twoXs && bestRow == 4)
                {
                    for(int j = 0; j < 3; j++)
                    {
                        if(board[j][r].equals(" "))
                        {
                            bestRow = j;
                            bestCol = r;
                            twoXs = false;
                            break;
                        }
                    }
                }
                if(valid)
                {
                    break;
                }
                ex = 0;
                oh = 0;
                for(int i = 0; i < 3; i++)
                {
                    if(board[i][i].equals("X"))
                    {
                        ex++;
                    }
                    else if(board[i][i].equals("O"))
                    {
                        oh++;
                    }
                }
                if(oh == 2 && ex == 0)
                {
                    for(int i = 0; i < 3; i++)
                    {
                        if(board[i][i].equals(" "))
                        {
                            board[i][i] = "O";
                            valid = true;
                            System.out.println("Placing O at 3");
                            break;
                        }
                    }
                }
                else if(ex == 2 && oh == 0 && bestRow == 4)
                {
                    for(int i = 0; i < 3; i++)
                    {
                        if(board[i][i].equals(" "))
                        {
                            bestRow = i;
                            bestCol = i;
                        }
                    }
                }
                if(valid)
                {
                    break;
                }
                ex = 0;
                oh = 0;
                col = 0;
                for(int i = 2; i >= 0; i--)
                {
                    if(board[i][col].equals("X"))
                    {
                        ex++;
                    }
                    else if(board[i][col].equals("O"))
                    {
                        oh++;
                    }
                    col++;
                }
                if(oh == 2 && ex == 0)
                {
                    col = 0;
                    for(int i = 2; i >= 0; i--)
                    {
                        if(board[i][col].equals(" "))
                        {
                            board[i][col] = "O";
                            valid = true;
                            System.out.println("Placing O at 4");
                            break;
                        }
                        col++;
                    }
                }
                else if(ex == 2 && oh == 0 && bestRow == 4)
                {
                    col = 0;
                    for(int i = 2; i >= 0; i--)
                    {
                        if(board[i][col].equals(" "))
                        {
                            bestRow = i;
                            bestCol = col;
                        }
                        col++;
                    }
                }
                if(valid)
                {
                    break;
                }
                if(bestRow != 4)
                {
                    board[bestRow][bestCol] = "O";
                    System.out.println("Placing O at 5");
                    break;
                }
                while(!valid)
                {
                    computerRow = (int)(Math.random()*3);
                    computerColumn = (int)(Math.random()*3);
                    if(board[computerRow][computerColumn].equals(" "))
                    {
                        board[computerRow][computerColumn] = "O";
                        valid = true;
                        System.out.println("Placing O at 6");
                        break;
                    }
                }
            }
            printBoard();
            System.out.println();
            checkWin();
        }
        if(compWin)
        {
            System.out.println("Better luck next time");
        }
        else if(playerWin)
        {
            System.out.println("Congrats! You won!");
        }
        else
        {
            System.out.println("Tie game, you're both garbage!");
        }
        System.out.println("Game Over");
    }

    public void printBoard()
    {
        for(int i = 0; i < 3; i++)
        {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2] + " ");
            if(i < 2)
            {
                System.out.println("---+---+---");
            }
        }
    }

    public boolean checkWin()
    {
        boolean full = true;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(board[i][j].equals(" "))
                {
                    full = false;
                    break;
                }
            }
            if(!full)
            {
                break;
            }
        }
        for(int i = 0; i < 3; i++)
        {
            if(board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) && !board[i][0].equals(" "))
            {
                gameOver = true;
                if(board[i][0].equals("O"))
                {
                    compWin = true;
                }
                else if(board[i][0].equals("X"))
                {
                    playerWin = true;
                }
            }
            else if(board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) && !board[0][i].equals(" "))
            {
                gameOver = true;
                if(board[0][i].equals("O"))
                {
                    compWin = true;
                }
                else if(board[0][i].equals("X"))
                {
                    playerWin = true;
                }
            }
        }
        if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].equals(" "))
        {
            gameOver = true;
            if(board[1][1].equals("O"))
            {
                compWin = true;
            }
            else if(board[1][1].equals("X"))
            {
                playerWin = true;
            }
        }
        else if(board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && !board[0][2].equals(" "))
        {
            gameOver = true;
            if(board[1][1].equals("O"))
            {
                compWin = true;
            }
            else if(board[1][1].equals("X"))
            {
                playerWin = true;
            }
        }
        if(full)
        {
            gameOver = true;
        }
        return gameOver;
    }
}
