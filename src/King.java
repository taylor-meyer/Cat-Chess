
/**
 *
 * @author Taylor Meyer
 */
public class King extends ChessPiece {
    private int[] pos;
    public King(boolean white, int[] pos)
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
