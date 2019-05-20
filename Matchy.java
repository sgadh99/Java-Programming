/*Sathya Gadhiraju
 Card game with repaint().
*/

import javax.swing.*;
import java.awt.*;
import java.applet.Applet;
import javax.swing.event.*;
import java.awt.event.*;

public class Matchy extends JApplet{
        public void init(){
                FirstSwingPanel fsp= new FirstSwingPanel();
                setContentPane(fsp);

        }
}

class FirstSwingPanel extends JPanel implements KeyListener{

        boolean moon= false;
        boolean heart= false;
        boolean smile= false;
        boolean tri= false;

        Image I= Toolkit.getDefaultToolkit().getImage("MatchImage.jpeg");
          FirstSwingPanel(){ //constructor

            addKeyListener(this);

         }
        public void paintComponent(Graphics g){
                super.paintComponent(g);

                g.drawImage(I, 0, 0, 200, 300, 0, 0, 80, 150, null);

                requestFocus();
                g.drawString("Type m for moon.", 230, 20);
                g.drawString("Type h for heart.", 230, 40);
                g.drawString("Type s for smile.", 230, 60);
                g.drawString("Type t for triangle.", 230, 80);
                if(moon==true){
                        g.drawImage(I, 0, 0, 200, 300, 0, 0, 80, 150, null);

                }
                else if(heart==true){
                        g.drawImage(I, 0, 0, 200, 300, 80, 150, 190, 150, null);

                }
                else if(smile==true){
                        g.drawImage(I, 0, 0, 200, 300, 190, 150, 300, 150, null);

                }
                else if(tri==true){
                        g.drawImage(I, 0, 0, 200, 300, 300, 150, 400, 150, null);

                }
        }
        public void keyPressed(KeyEvent e){

                if(e.getKeyChar()=='m'){
                moon=true;

        }
                else if(e.getKeyChar()=='h'){
                heart=true;


        }
                else if(e.getKeyChar()=='s'){
                smile=true;

        }
                else if(e.getKeyChar()=='t'){
                tri=true;


        }
        repaint();
        }
        public void keyReleased(KeyEvent e){
                }
        public void keyTyped(KeyEvent e){
                }

}

