
/**
 *
 * @author Taylor Meyer
 */
public class Rook extends ChessPiece {
    private int[] pos;
    public Rook(boolean white, int[] pos)
    {
        this.white = white;
        this.pos = pos;
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
