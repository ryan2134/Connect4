public class Board {

    public static final byte PLAYER1 = 1;//This number is assigned to a cell containing a piece owned by player 1
    public static final byte PLAYER2 = 2;//This number is assigned to a cell containing a piece owned by player 2
    public static final byte EMPTY_CELL = 0;//Empty cell
    public static final byte SOLID_CELL = 10;//A cell out of the board

    public static final int ROWS =6;//Change those numbers to resize the board
    public static final int COLS =7;

    private int freeplaces = ROWS*COLS;
    private byte[][] vals= new byte[ROWS][COLS];

    private Board sBoard;

    private Player player1;
    private Player player2;



    public byte getCell(int row,int col){

        if ((row<0)||(row>=ROWS)||(col<0)||(col>=COLS)) return SOLID_CELL;

        return vals[row][col];
    }

    public boolean placePiece(int col, Player player){
        byte p=0;
        if (player==player1) p = PLAYER1;
        else p=PLAYER2;
        return placePiece(col,p);
    }

    /**
     * Creates a copy of the board, using only the data but without displaying it on
     * the screen.
     * It is used by some players to understand wich moves would allow the opponent
     * to win.
     * @return The copied board
     */
    public Board copy(){
        Board tmp = new Board();
        tmp.freeplaces = this.freeplaces;
        tmp.player1 = this.player1;
        tmp.player2 = this.player2;

        byte[][] bVals = new byte[ROWS][COLS];
        for (int r=0;r<ROWS;r++){
            for (int c=0;c<COLS;c++){
                bVals[r][c]=vals[r][c];
            }
        }

        tmp.vals = bVals;


        return tmp;
    }

}
