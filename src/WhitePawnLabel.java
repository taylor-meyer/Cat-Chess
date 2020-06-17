
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;

/**
 *
 * @author Taylor Meyer
 */
public class WhitePawnLabel {
    
    private JLabel label;
    
    public WhitePawnLabel(int[] pos)
    {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("cats_\\wpawn.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        label = new ImageLabel("White Pawn", new Pawn(true, pos));
        label.setSize(100, 100);
        Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        label.setIcon(imageIcon);
    }
    
    public JLabel getLabel()
    {
        return label;
    }
}