/*Sathya Gadhiraju
 1-27-14
 This program is where you draw a mouse.*/

import java.awt.*;
import java.applet.Applet;
import javax.swing.*;
import java.awt.event.*;
public class Mousey extends JApplet{
        public void init(){
                FirstSwingPanel fsp= new FirstSwingPanel();
                setContentPane(fsp);

        }
}
class FirstSwingPanel extends JPanel implements MouseListener{
        boolean awake = false;
        FirstSwingPanel(){

                addMouseListener(this);

        }
        public void mousePressed(MouseEvent e){
                }
                public void mouseClicked(MouseEvent e){
                }
                public void mouseEntered(MouseEvent e){
                        awake= true;
                        repaint();
                }
                public void mouseExited(MouseEvent e){
                        awake = false;
                        repaint();
                }
                public void mouseReleased(MouseEvent e){
                }
                public void keyPressed(KeyEvent e){
                }
                public void keyReleased(KeyEvent e){
                }
                public void keyTyped(KeyEvent e){
                        int x= e.getKeyCode();

                        if(x=='B' || x=='b'){
                                g.drawLine(80, 100, 110, 100);
                                g.fillArc(110, 90, 100, 80, 180, 180);
                }
        }



        public void paintComponent(Graphics g){
                super.paintComponent(g); // super connects this to parent class
        if(awake){
                g.drawLine(80, 100, 110, 100);
                g.fillArc(110, 60, 100, 80, 180, -180);
                g.setColor(Color.DARK_GRAY);
                g.fillArc(170, 50, 30, 30, 90, -300 );
                g.setColor(Color.CYAN);
                g.drawString("O", 190, 90);
        }
        else {

        g.fillRect(100, 100, 100,10);
        g.drawString("Zzz...", 150, 60);
        }

        }
}
