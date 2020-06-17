
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;

/**
 *
 * @author Taylor Meyer
 */
public class Square extends JPanel {
    
    private boolean white;
    private boolean hasPiece;
    private int[] pos;
    
    // Overloaded constructor
    public Square(boolean white, int[] pos)
    {
        //System.out.println("square constructor");
        this.white = white;
        this.pos = pos;
        
        this.setSize(100, 100);
        
        //this.addMouseListener(new LabelMouseListener());
        
        if (this.white)
        {
            this.setBackground(Color.white);
            //System.out.println("Setting color to white");
        }
        else
        {
            this.setBackground(Color.black);
            //System.out.println("Setting color to black");
        }
    }
    
    // Returns color of the square (NOT THE PIECE)
    public char getColor()
    {
        if (white)
            return 'w';
        else
            return 'b';
    }
    
    public int[] getPosition()
    {
        return this.pos;
    }
    
    // Returns the chess piece on this square
    public boolean hasPiece()
    {
        return hasPiece;
    }
    
    public void setHasPiece(boolean b)
    {
        this.hasPiece = b;
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 100);
    }
}
