
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;

/**
 *
 * @author Taylor Meyer
 */
public class WhiteRookLabel {
    
    private JLabel label;
    
    public WhiteRookLabel(int[] pos)
    {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("cats_\\wrook.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        label = new ImageLabel("White Rook", new Rook(true, pos));
        label.setSize(100, 100);
        Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        label.setIcon(imageIcon);
        //label.addMouseListener(new LabelMouseListener());
    }
    
    public JLabel getLabel()
    {
        return label;
    }
}