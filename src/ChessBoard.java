
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Taylor Meyer
 */
public class ChessBoard {
    
    public ChessBoard(ArrayList<ArrayList<Square>> matrix)
    {
        JFrame board = new JFrame();
        board.setLayout(new BorderLayout());
        board.setSize(1000, 1000);
        board.setResizable(false);
        board.getContentPane().setBackground(Color.DARK_GRAY);
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setTitle("CAT CHESS by Taylor Meyer & Tini Raden - BeachHacks 2018");
        
        //          Reading title image and adding it to north
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("cats_\\title.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageLabel titleLabel = new ImageLabel("Title");
        titleLabel.setSize(672, 226);
        Image dimg = img.getScaledInstance(titleLabel.getWidth(), titleLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        titleLabel.setIcon(imageIcon);
        JPanel north = new JPanel();
        north.setSize(672, 226);
        north.setBackground(Color.BLACK);
        north.add(titleLabel);
        
        
        
        LabelMouseListener mouse = new LabelMouseListener(matrix);
        
        
        //          Create the grid of playing squares
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(8, 8));
        for (int i = 7; i > -1; i--)
        {
            //System.out.println("Row # " + i);
            for (int j = 0; j < 8; j++)
            {
                Square sq = matrix.get(j).get(i);
                sq.addMouseListener(mouse);
                if (i == 1)
                {
                    int[] pos = new int[]{j, i};
                    WhitePawnLabel l = new WhitePawnLabel(pos);
                    l.getLabel().addMouseListener(mouse);
                    sq.add(l.getLabel());
                }
                if (i == 6)
                {
                    int[] pos = new int[]{j, i};
                    BlackPawnLabel l = new BlackPawnLabel(pos);
                    l.getLabel().addMouseListener(mouse);
                    sq.add(l.getLabel());
                }
                if (j == 0 || j == 7)
                {
                    if (i == 0)
                    {
                        int[] pos = new int[]{j, i};
                        WhiteRookLabel l = new WhiteRookLabel(pos);
                        l.getLabel().addMouseListener(mouse);
                        sq.add(l.getLabel());
                        
                    }
                    if (i == 7)
                    {
                        int[] pos = new int[]{j, i};
                        BlackRookLabel l = new BlackRookLabel(pos);
                        l.getLabel().addMouseListener(mouse);
                        sq.add(l.getLabel());
                    }
                }
                if (j == 1 || j == 6)
                {
                    if (i == 0)
                    {
                        int[] pos = new int[]{j, i};
                        WhiteKnightLabel l = new WhiteKnightLabel(pos);
                        l.getLabel().addMouseListener(mouse);
                        sq.add(l.getLabel());
                    }
                    if (i == 7)
                    {
                        int[] pos = new int[]{j, i};
                        BlackKnightLabel l = new BlackKnightLabel(pos);
                        l.getLabel().addMouseListener(mouse);
                        sq.add(l.getLabel());
                    }
                }
                if (j == 2 || j == 5)
                {
                    if (i == 0)
                    {
                        int[] pos = new int[]{j, i};
                        WhiteBishopLabel l = new WhiteBishopLabel(pos);
                        l.getLabel().addMouseListener(mouse);
                        sq.add(l.getLabel());
                    }
                    if (i == 7)
                    {
                        int[] pos = new int[]{j, i};
                        BlackBishopLabel l = new BlackBishopLabel(pos);
                        l.getLabel().addMouseListener(mouse);
                        sq.add(l.getLabel());
                    }
                }
                // Kings/Queens
                if (j == 3)
                {
                    if (i == 0)
                    {
                        int[] pos = new int[]{j, i};
                        WhiteKingLabel l = new WhiteKingLabel(pos);
                        l.getLabel().addMouseListener(mouse);
                        sq.add(l.getLabel());
                    }
                    if (i == 7)
                    {
                        int[] pos = new int[]{j, i};
                        BlackQueenLabel l = new BlackQueenLabel(pos);
                        l.getLabel().addMouseListener(mouse);
                        sq.add(l.getLabel());
                    }
                }
                if (j == 4)
                {
                    if (i == 0)
                    {
                        int[] pos = new int[]{j, i};
                        WhiteQueenLabel l = new WhiteQueenLabel(pos);
                        l.getLabel().addMouseListener(mouse);
                        sq.add(l.getLabel());
                    }
                    if (i == 7)
                    {
                        int[] pos = new int[]{j, i};
                        BlackKingLabel l = new BlackKingLabel(pos);
                        l.getLabel().addMouseListener(mouse);
                        sq.add(l.getLabel());
                    }
                }
                
                

                gridPanel.add(sq);
            }
        }
        
        //          Add the title panel to BorderLayout.NORTH
        board.add(north, BorderLayout.NORTH);
        //          Add the grid panel to BorderLayout.CENTER
        board.add(gridPanel, BorderLayout.CENTER);
        board.setVisible(true);
    }
    
}