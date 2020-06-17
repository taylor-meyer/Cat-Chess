
/**
 *
 * @author Taylor Meyer
 */
public class Pawn extends ChessPiece {
    private boolean firstMove = true;
    public Pawn(boolean white, int[] pos)
    {
        this.white = white;
        this.pos = pos;
    }    
    public boolean getFirstMove()
    {
        return firstMove;
    }    
    public void setFirstMove(boolean firstMove)
    {
        this.firstMove = firstMove;
    }    
    public boolean isWhite()
    {
        return white;
    }     
    public int[] getPosition()
    {
        return this.pos;
    }    
    public void setPosition(int[] pos)
    {
        this.pos = pos;
    }
}
