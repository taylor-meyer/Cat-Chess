
/**
 *
 * @author Taylor Meyer
 */
public class Queen extends ChessPiece {
    private int[] pos;
    public Queen(boolean white, int[] pos)
    {
        this.white = white;
        this.pos = pos;
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
