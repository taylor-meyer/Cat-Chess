
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Container;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Taylor Meyer
 */
public class LabelMouseListener extends MouseAdapter {
    
    Component prevsource;
    Container prevcontainer;
    Component source;
    Container container;
    
    ArrayList<ArrayList<Square>> matrix;
    
    public LabelMouseListener(ArrayList<ArrayList<Square>> matrix)
    {
        prevsource = null;
        prevcontainer = null;
        source = null;
        container = null;
        this.matrix = matrix;
    }
    
    @Override
    public void mousePressed(MouseEvent me)
    {
        prevsource = source;
        prevcontainer = container;
        source = me.getComponent();
        container = source.getParent();
            
        System.out.println("Source: " + source);
        System.out.println("Container: " + container);
        System.out.println("**");
        System.out.println("PrevSource: " + prevsource);
        System.out.println("Container: " + prevcontainer);
        System.out.println("");
        System.out.println("");
        System.out.println("");

        // If you click on a pieec, and then an empty space
        if (prevsource instanceof ImageLabel && source instanceof Square)
        {
            ImageLabel wLabel = (ImageLabel)prevsource;
            ImageLabel lLabel = null;
            
            ChessPiece wPiece = ((ImageLabel)prevsource).getPiece();
            ChessPiece lPiece = null;
            
            Square wSquare = (Square)prevcontainer;
            Square lSquare = (Square)source;
            
            
                if (wPiece instanceof Pawn)
                {
                    if(!checkWhitePawn((Pawn)wPiece, lSquare, false))
                    {
                        //printMatrix();
                        clearAllInputs();
                        return;
                    }
                    else
                    {
                        move(wLabel, wSquare, lSquare);
                        //printMatrix();
                        kingLost(lPiece);
                        clearAllInputs();
                    }
                }
                if (wPiece instanceof Rook)
                {
                    if(!(checkWhiteRook((Rook)wPiece, lSquare)))
                    {
                        //printMatrix();
                        clearAllInputs();
                        return;
                    }
                    else
                    {
                        move(wLabel, wSquare, lSquare);
                        //printMatrix();
                        kingLost(lPiece);
                        clearAllInputs();
                    }
                }
                if (wPiece instanceof Knight)
                {
                    if(!(checkWhiteKnight((Knight)wPiece, lSquare)))
                    {
                        //printMatrix();
                        clearAllInputs();
                        return;
                    }
                    else
                    {
                        move(wLabel, wSquare, lSquare);
                        //printMatrix();
                        kingLost(lPiece);
                        clearAllInputs();
                    }
                }
                if (wPiece instanceof Bishop)
                {
                    if(!(checkWhiteBishop((Bishop)wPiece, lSquare)))
                    {
                        clearAllInputs();
                        return;
                    }
                    else
                    {
                        move(wLabel, wSquare, lSquare);
                        kingLost(lPiece);
                        clearAllInputs();
                    }
                }
                if (wPiece instanceof Queen)
                {
                    if(!(checkWhiteQueen((Queen)wPiece, lSquare)))
                    {
                        clearAllInputs();
                        return;
                    }
                    else
                    {
                        move(wLabel, wSquare, lSquare);
                        kingLost(lPiece);
                        clearAllInputs();
                    }
                }
                if (wPiece instanceof King)
                {
                    if(!(checkWhiteKing((King)wPiece, lSquare)))
                    {
                        //printMatrix();
                        clearAllInputs();
                        return;
                    }
                    else
                    {
                        move(wLabel, wSquare, lSquare);
                        //printMatrix();
                        kingLost(lPiece);
                        clearAllInputs();
                    }
                }
        }
        
        // If you click on a piece and then try to take another piece
        else if (prevsource instanceof ImageLabel && source instanceof ImageLabel)
        {
            ImageLabel wLabel = (ImageLabel)prevsource;
            ImageLabel lLabel = (ImageLabel)source;
            
            ChessPiece wPiece = ((ImageLabel)prevsource).getPiece();
            ChessPiece lPiece = ((ImageLabel)source).getPiece();
            
            Square wSquare = (Square)prevcontainer;
            Square lSquare = (Square)container;
            
            
            
                if (wPiece instanceof Pawn)
                {
                    if(!checkWhitePawn((Pawn)wPiece, lSquare, true))
                    {
                        //printMatrix();
                        clearAllInputs();
                        return;
                    }
                    else
                    {
                        move(wLabel, wSquare, lSquare);
                        //printMatrix();
                        kingLost(lPiece);
                        clearAllInputs();
                    }
                }
                if (wPiece instanceof Rook)
                {
                    if(!checkWhiteRook((Rook)wPiece, lSquare))
                    {
                        //printMatrix();
                        clearAllInputs();
                        return;
                    }
                    else
                    {
                        move(wLabel, wSquare, lSquare);
                        //printMatrix();
                        kingLost(lPiece);
                        clearAllInputs();
                    }
                }
                if (wPiece instanceof Knight)
                {
                    if(!(checkWhiteKnight((Knight)wPiece, lSquare)))
                    {
                        //printMatrix();
                        clearAllInputs();
                        return;
                    }
                    else
                    {
                        move(wLabel, wSquare, lSquare);
                        //printMatrix();
                        kingLost(lPiece);
                        clearAllInputs();
                    }
                }
                if (wPiece instanceof Bishop)
                {
                    if(!(checkWhiteBishop((Bishop)wPiece, lSquare)))
                    {
                        //printMatrix();
                        clearAllInputs();
                        return;
                    }
                    else
                    {
                        move(wLabel, wSquare, lSquare);
                        //printMatrix();
                        kingLost(lPiece);
                        clearAllInputs();
                    }
                }
                if (wPiece instanceof Queen)
                {
                    if(!checkWhiteQueen((Queen)wPiece, lSquare))
                    {
                        clearAllInputs();
                        return;
                    }
                    else
                    {
                        move(wLabel, wSquare, lSquare);
                        kingLost(lPiece);
                        clearAllInputs();
                    }
                }
                if (wPiece instanceof King)
                {
                    if(!(checkWhiteKing((King)wPiece, lSquare)))
                    {
                        //printMatrix();
                        clearAllInputs();
                        return;
                    }
                    if(checkWhiteKing((King)wPiece, lSquare))
                    {
                        move(wLabel, wSquare, lSquare);
                        //printMatrix();
                        kingLost(lPiece);
                        clearAllInputs();
                    }
                }
            
        }
    }
    
    // Used to move pawns
    private boolean checkWhitePawn(Pawn pawn, Square destination, boolean piece)
    {
        int[] pawnPos = pawn.getPosition();
        int[] destinationPos = destination.getPosition();
        int[] finishPos;
        
        if (pawn.getFirstMove())
        {
            if (pawnPos[0] == destinationPos[0] && ((destinationPos[1] == pawnPos[1] + 1) ||
                    (destinationPos[1] == pawnPos[1] - 1)))
            {
                pawn.setFirstMove(false);
                finishPos = new int[]{pawnPos[0], destinationPos[1]};
                pawn.setPosition(finishPos);
                matrix.get(pawnPos[0]).get(pawnPos[1]).setHasPiece(false);
                matrix.get(finishPos[0]).get(finishPos[1]).setHasPiece(true);
                return true;
            }
            else if (pawnPos[0] == destinationPos[0] && ((destinationPos[1] == pawnPos[1] + 2) ||
                    (destinationPos[1] == pawnPos[1] - 2)))
            {
                pawn.setFirstMove(false);
                finishPos = new int[]{pawnPos[0], destinationPos[1]};
                pawn.setPosition(finishPos);
                matrix.get(pawnPos[0]).get(pawnPos[1]).setHasPiece(false);
                matrix.get(finishPos[0]).get(finishPos[1]).setHasPiece(true);
                return true;
            }
            else
                return false;
        }
        else
        {
            if (pawnPos[0] == destinationPos[0] && destinationPos[1] == pawnPos[1] + 1 && piece == false)
            {
                finishPos = new int[]{pawnPos[0], destinationPos[1]};
                pawn.setPosition(finishPos);
                matrix.get(pawnPos[0]).get(pawnPos[1]).setHasPiece(false);
                matrix.get(finishPos[0]).get(finishPos[1]).setHasPiece(true);
                return true;
            }
            if (pawnPos[0] == destinationPos[0] && destinationPos[1] == pawnPos[1] - 1 && piece == false)
            {
                finishPos = new int[]{pawnPos[0], destinationPos[1]};
                pawn.setPosition(finishPos);
                matrix.get(pawnPos[0]).get(pawnPos[1]).setHasPiece(false);
                matrix.get(finishPos[0]).get(finishPos[1]).setHasPiece(true);
                return true;
            }
            else if ((destinationPos[0] == pawnPos[0] - 1 || destinationPos[0] == pawnPos[0] + 1) &&
                    ((destinationPos[1] == pawnPos[1] + 1) || (destinationPos[1] == pawnPos[1] - 1))
                    && piece == true)
            {
                finishPos = new int[]{destinationPos[0], destinationPos[1]};
                pawn.setPosition(finishPos);
                matrix.get(pawnPos[0]).get(pawnPos[1]).setHasPiece(false);
                matrix.get(finishPos[0]).get(finishPos[1]).setHasPiece(true);
                return true;
            }
            else
                return false;
        }
    }
    
    // Use to move Rooks
    private boolean checkWhiteRook(Rook rook, Square destination)
    {
        int[] rookPos = rook.getPosition();
        int[] destinationPos = destination.getPosition();
        int[] finishPos;
        
        if (rookPos[0] == destinationPos[0] && rookPos[1] == destinationPos[1])
        {
            return false;          
        }
        else if (rookPos[0] != destinationPos[0] && rookPos[1] != destinationPos[1])
        {
            return false;
        }
        else
        {
            if (rookPos[0] == destinationPos[0])
            {
                for (int i = rookPos[1]+1; i < destinationPos[1]; i++)
                {
                    if (this.matrix.get(rookPos[0]).get(i).hasPiece())
                        return false;
                }
                for (int i = rookPos[1]-1; i > destinationPos[1]; i--)
                {
                    if (this.matrix.get(rookPos[0]).get(i).hasPiece())
                        return false;
                }
                for (int i = rookPos[1]+1; i < destinationPos[1]; i++)
                {
                    if (this.matrix.get(rookPos[0]).get(i).hasPiece())
                        return false;
                }
                for (int i = rookPos[1]-1; i > destinationPos[1]; i--)
                {
                    if (this.matrix.get(rookPos[0]).get(i).hasPiece())
                        return false;
                }
                finishPos = new int[]{destinationPos[0], destinationPos[1]};
                rook.setPosition(finishPos);
                this.matrix.get(rookPos[0]).get(rookPos[1]).setHasPiece(false);
                this.matrix.get(destinationPos[0]).get(destinationPos[1]).setHasPiece(true);
                return true;
            }
            if (rookPos[1] == destinationPos[1])
            {
                for (int i = rookPos[0]+1; i < destinationPos[0]; i++)
                {
                    if (this.matrix.get(i).get(rookPos[1]).hasPiece())
                        return false;
                }
                for (int i = rookPos[0]-1; i > destinationPos[0]; i--)
                {
                    if (this.matrix.get(i).get(rookPos[1]).hasPiece())
                        return false;
                }
                finishPos = new int[]{destinationPos[0], destinationPos[1]};
                rook.setPosition(finishPos);
                this.matrix.get(rookPos[0]).get(rookPos[1]).setHasPiece(false);
                this.matrix.get(destinationPos[0]).get(destinationPos[1]).setHasPiece(true);
                return true;
            }
        }
        return false;
    }
    
    // Used to move knights
    private boolean checkWhiteKnight(Knight knight, Square destination)
    {
        int[] knightPos = knight.getPosition();
        int[] destinationPos = destination.getPosition();
        int[] finishPos;
        
        if(knightPos[0] == destinationPos[0])
        {
            return false;
        }
        
        if (destinationPos[0] < (knightPos[0] - 2))
        {
            return false;
        }
        if (destinationPos[0] > knightPos[0] + 2)
        {
            return false;
        }
        if (destinationPos[1] < (knightPos[1] - 2))
        {
            return false;
        }
        if (destinationPos[1] > knightPos[1] + 2)
        {
            return false;
        }
        if (destinationPos[0] == (knightPos[0] - 1) && (destinationPos[1] == (knightPos[1] + 2) || destinationPos[1] == (knightPos[1] - 2)))
        {
            finishPos = new int[]{destinationPos[0], destinationPos[1]};
            knight.setPosition(finishPos);
            this.matrix.get(knightPos[0]).get(knightPos[1]).setHasPiece(false);
            this.matrix.get(destinationPos[0]).get(destinationPos[1]).setHasPiece(true);
            return true;
        }
        
        if (destinationPos[0] == (knightPos[0] + 1) && (destinationPos[1] == (knightPos[1] + 2) || destinationPos[1] == (knightPos[1] - 2)))
        {
            finishPos = new int[]{destinationPos[0], destinationPos[1]};
            knight.setPosition(finishPos);
            this.matrix.get(knightPos[0]).get(knightPos[1]).setHasPiece(false);
            this.matrix.get(destinationPos[0]).get(destinationPos[1]).setHasPiece(true);
            return true;
        }
        if (destinationPos[0] == (knightPos[0] - 2) && (destinationPos[1] == (knightPos[1] + 1) || destinationPos[1] == (knightPos[1] - 1)))
        {
            finishPos = new int[]{destinationPos[0], destinationPos[1]};
            knight.setPosition(finishPos);
            this.matrix.get(knightPos[0]).get(knightPos[1]).setHasPiece(false);
            this.matrix.get(destinationPos[0]).get(destinationPos[1]).setHasPiece(true);
            return true;
        }
        
        if (destinationPos[0] == (knightPos[0] + 2) && (destinationPos[1] == (knightPos[1] + 1) || destinationPos[1] == (knightPos[1] - 1)))
        {
            finishPos = new int[]{destinationPos[0], destinationPos[1]};
            knight.setPosition(finishPos);
            this.matrix.get(knightPos[0]).get(knightPos[1]).setHasPiece(false);
            this.matrix.get(destinationPos[0]).get(destinationPos[1]).setHasPiece(true);
            return true;
        }
        return false;
    }
    
    // Used to move bishops
    private boolean checkWhiteBishop(Bishop bishop, Square destination)
    {
        int[] bishopPos = bishop.getPosition();
        int[] destinationPos = destination.getPosition();
        int[] finishPos;
        
        int rise = destinationPos[1] - bishopPos[1];
        int run = destinationPos[0] - bishopPos[0];
        
        if (Math.abs(rise) == Math.abs(run))
        {
            if (rise > 0 && run > 0)
            {
                for (int i = 0; i < Math.abs(run); i++)
                {
                    if (this.matrix.get(bishopPos[0]+i+1).get(bishopPos[1]+i+1) == destination)
                        break;
                    if (this.matrix.get(bishopPos[0]+i+1).get(bishopPos[1]+i+1).hasPiece())
                        return false;
                }
            }
            if (rise > 0 && run < 0)
            {
                for (int i = 0; i < Math.abs(run); i++)
                {
                    if (this.matrix.get(bishopPos[0]-i-1).get(bishopPos[1]+i+1) == destination)
                        break;
                    if (this.matrix.get(bishopPos[0]-i-1).get(bishopPos[1]+i+1).hasPiece())
                        return false;
                }
            }
            if (rise < 0 && run < 0)
            {
                for (int i = 0; i < Math.abs(run); i++)
                {
                    if (this.matrix.get(bishopPos[0]-i-1).get(bishopPos[1]-i-1) == destination)
                        break;
                    if (this.matrix.get(bishopPos[0]-i-1).get(bishopPos[1]-i-1).hasPiece())
                        return false;
                }
            }
            if (rise < 0 && run > 0)
            {
                for (int i = 0; i < Math.abs(run); i++)
                {
                    if (this.matrix.get(bishopPos[0]+i+1).get(bishopPos[1]-i-1) == destination)
                        break;
                    if (this.matrix.get(bishopPos[0]+i+1).get(bishopPos[1]-i-1).hasPiece())
                        return false;
                }
            }
            finishPos = new int[]{destinationPos[0], destinationPos[1]};
            bishop.setPosition(finishPos);
            this.matrix.get(bishopPos[0]).get(bishopPos[1]).setHasPiece(false);
            this.matrix.get(destinationPos[0]).get(destinationPos[1]).setHasPiece(true);
            return true;
        }
        return false;
    }
    
    // Used to move Queens
    private boolean checkWhiteQueen(Queen queen, Square destination)
    {
        int[] queenPos = queen.getPosition();
        int[] destinationPos = destination.getPosition();
        int[] finishPos;
        
        int rise = destinationPos[1] - queenPos[1];
        int run = destinationPos[0] - queenPos[0];
        
        if (queenPos[0] == destinationPos[0])
        {
            for (int i = queenPos[1]+1; i < destinationPos[1]; i++)
            {
                if (this.matrix.get(queenPos[0]).get(i).hasPiece())
                    return false;
            }
            for (int i = queenPos[1]-1; i > destinationPos[1]; i--)
            {
                if (this.matrix.get(queenPos[0]).get(i).hasPiece())
                    return false;
            }
            finishPos = new int[]{destinationPos[0], destinationPos[1]};
            queen.setPosition(finishPos);
            this.matrix.get(queenPos[0]).get(queenPos[1]).setHasPiece(false);
            this.matrix.get(destinationPos[0]).get(destinationPos[1]).setHasPiece(true);
            return true;
        }
        
        if (queenPos[1] == destinationPos[1])
        {
            for (int i = queenPos[0]+1; i < destinationPos[0]; i++)
            {
                if (this.matrix.get(i).get(queenPos[1]).hasPiece())
                    return false;
            }
            for (int i = queenPos[0]-1; i > destinationPos[0]; i--)
            {
                if (this.matrix.get(i).get(queenPos[1]).hasPiece())
                    return false;
            }
            finishPos = new int[]{destinationPos[0], destinationPos[1]};
            queen.setPosition(finishPos);
            this.matrix.get(queenPos[0]).get(queenPos[1]).setHasPiece(false);
            this.matrix.get(destinationPos[0]).get(destinationPos[1]).setHasPiece(true);
            return true;
        }
        
        if (Math.abs(rise) == Math.abs(run))
        {
            if (rise > 0 && run > 0)
            {
                for (int i = 0; i < Math.abs(run); i++)
                {
                    if (this.matrix.get(queenPos[0]+i+1).get(queenPos[1]+i+1) == destination)
                        break;
                    if (this.matrix.get(queenPos[0]+i+1).get(queenPos[1]+i+1).hasPiece())
                        return false;
                }
            }
            if (rise > 0 && run < 0)
            {
                for (int i = 0; i < Math.abs(run); i++)
                {
                    if (this.matrix.get(queenPos[0]-i-1).get(queenPos[1]+i+1) == destination)
                        break;
                    if (this.matrix.get(queenPos[0]-i-1).get(queenPos[1]+i+1).hasPiece())
                        return false;
                }
            }
            if (rise < 0 && run < 0)
            {
                for (int i = 0; i < Math.abs(run); i++)
                {
                    if (this.matrix.get(queenPos[0]-i-1).get(queenPos[1]-i-1) == destination)
                        break;
                    if (this.matrix.get(queenPos[0]-i-1).get(queenPos[1]-i-1).hasPiece())
                        return false;
                }
            }
            if (rise < 0 && run > 0)
            {
                for (int i = 0; i < Math.abs(run); i++)
                {
                    if (this.matrix.get(queenPos[0]+i+1).get(queenPos[1]-i-1) == destination)
                        break;
                    if (this.matrix.get(queenPos[0]+i+1).get(queenPos[1]-i-1).hasPiece())
                        return false;
                }
            }
            finishPos = new int[]{destinationPos[0], destinationPos[1]};
            queen.setPosition(finishPos);
            this.matrix.get(queenPos[0]).get(queenPos[1]).setHasPiece(false);
            this.matrix.get(destinationPos[0]).get(destinationPos[1]).setHasPiece(true);
            return true;
        }
        return false;
    }
    
    // Used to move kings
    private boolean checkWhiteKing(King king, Square destination)
    {
        int[] kingPos = king.getPosition();
        int[] destinationPos = destination.getPosition();
        int[] finishPos;
        
        int rise = destinationPos[1] - kingPos[1];
        int run = destinationPos[0] - kingPos[0];
        
        if (kingPos[0] == destinationPos[0] && destinationPos[1] == kingPos[1] - 1)
        {
            finishPos = new int[]{destinationPos[0], destinationPos[1]};
            king.setPosition(finishPos);
            this.matrix.get(kingPos[0]).get(kingPos[1]).setHasPiece(false);
            this.matrix.get(destinationPos[0]).get(destinationPos[1]).setHasPiece(true);
            return true;
        }
        
        if ((destinationPos[0] == kingPos[0] - 1) && (destinationPos[1] == kingPos[1] - 1))
        {
            finishPos = new int[]{destinationPos[0], destinationPos[1]};
            king.setPosition(finishPos);
            this.matrix.get(kingPos[0]).get(kingPos[1]).setHasPiece(false);
            this.matrix.get(destinationPos[0]).get(destinationPos[1]).setHasPiece(true);
            return true;
        }
        
        if ((destinationPos[0] == kingPos[0] - 1) && (destinationPos[1] == kingPos[1] - 1))
        {
            finishPos = new int[]{destinationPos[0], destinationPos[1]};
            king.setPosition(finishPos);
            this.matrix.get(kingPos[0]).get(kingPos[1]).setHasPiece(false);
            this.matrix.get(destinationPos[0]).get(destinationPos[1]).setHasPiece(true);
            return true;
        }
        
        if ((destinationPos[0] == kingPos[0]) && (destinationPos[1] == kingPos[1] + 1 || destinationPos[1] == kingPos[1] - 1))
        {
            finishPos = new int[]{destinationPos[0], destinationPos[1]};
            king.setPosition(finishPos);
            this.matrix.get(kingPos[0]).get(kingPos[1]).setHasPiece(false);
            this.matrix.get(destinationPos[0]).get(destinationPos[1]).setHasPiece(true);
            return true;
        }
        if ((destinationPos[1] == kingPos[1]) && (destinationPos[0] == kingPos[0] + 1 || destinationPos[0] == kingPos[0] - 1))
        {
            finishPos = new int[]{destinationPos[0], destinationPos[1]};
            king.setPosition(finishPos);
            this.matrix.get(kingPos[0]).get(kingPos[1]).setHasPiece(false);
            this.matrix.get(destinationPos[0]).get(destinationPos[1]).setHasPiece(true);
            return true;
        }
        
        if (Math.abs(run) == Math.abs(rise))
        {
            finishPos = new int[]{destinationPos[0], destinationPos[1]};
            king.setPosition(finishPos);
            this.matrix.get(kingPos[0]).get(kingPos[1]).setHasPiece(false);
            this.matrix.get(destinationPos[0]).get(destinationPos[1]).setHasPiece(true);
            return true;
        }
        return false;
    }
    
    // Move a piece and clear the JPanel
    private void move(ImageLabel wLabel, Square wSquare, Square lSquare)
    {
        
        lSquare.removeAll();
        wSquare.removeAll();
        
        lSquare.add(wLabel);
        
        lSquare.revalidate();
        wSquare.revalidate();
        
        lSquare.repaint();
        wSquare.repaint();
        
        clearAllInputs();
    }
    
    // If a king is taken, show a new frame and exit
    private void kingLost(ChessPiece l)
    {
        if (l instanceof King)
        {
            JFrame exitFrame = new JFrame();
            exitFrame.setLayout(new FlowLayout());
            JPanel pnl = new JPanel();
            pnl.setLayout(new FlowLayout());
            JLabel lbl = new JLabel("Game Over :)");
            lbl.setSize(800, 300);
            lbl.setFont(new Font("Serif", Font.BOLD, 80));
            pnl.add(lbl);
            pnl.setSize(800, 300);
            exitFrame.add(pnl);
            exitFrame.setSize(800, 300);
            exitFrame.setResizable(false);
            exitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            exitFrame.setVisible(true);
        }
    }
    
    // Clear what the mouse found
    private void clearAllInputs()
    {
        this.prevsource = null;
        this.prevcontainer = null;
        this.source = null;
        this.container = null;
    }
    
    // Used this for testing
    private void printMatrix()
    {
        System.out.println("****************PRINT MATRIX ****************");
        for (int i = 0; i < 8; i++)
        {
            System.out.println("Column index: " + i);
            for (int j = 0; j < 8; j++)
            {
                System.out.print("Row index: " + j);
                if (this.matrix.get(i).get(j).hasPiece())
                    System.out.println("  : YES THERE IS A PIECE HERE");
                else
                    System.out.println("");
            }
        }
    }
};