
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Taylor Meyer
 */
public class ImageLabel extends JLabel{
    private Image _myimage;
    private ChessPiece piece;
    
    public ImageLabel(String text)
    {
        super(text);
        this.piece = null;
    }

    public ImageLabel(String text, ChessPiece piece)
    {
        super(text);
        this.piece = piece;
    }
    
    public ChessPiece getPiece()
    {
        return piece;
    }

    public void setIcon(Icon icon) {
        super.setIcon(icon);
        if (icon instanceof ImageIcon)
        {
            _myimage = ((ImageIcon) icon).getImage();
        }
    }

    @Override
    public void paint(Graphics g){
        g.drawImage(_myimage, 0, 0, this.getWidth(), this.getHeight(), null);
    }
}
