/*Sathya Gadhiraju
 3-6-14
 This program is interactive, and uses many components to look like a play
center.*/

import javax.swing.*;
import java.awt.*;
import java.applet.Applet;
import javax.swing.event.*;
import java.awt.event.*;

public class PlayCenter extends JApplet{
        public void init(){
                FirstSwingPanel fsp= new FirstSwingPanel();
                setContentPane(fsp);
        }
}
class FirstSwingPanel extends JPanel implements ChangeListener{
        public JSlider x;
        FirstSwingPanel(){
        setBackground(Color.RED);
        setLayout(new GridLayout(2, 2, 10, 10));
        JPanelOne one= new JPanelOne(); // 1st actual panel class JPanelOne which has the blue, green, red panels
        add(one);
        one.setBackground(Color.CYAN);
        JPanel x= new JPanel(); //2nd actual panel
        add(x);
        JPanel y= new JPanel(); // 3rd actual panel
        add(y);
        JPanel z= new JPanel(); //4th actual panel
        add(z);

        x= new JSlider(JSlider.HORIZONTAL, 25, 500, 50);
        add(x);
        x.addChangeListener(this);

        public void stateChanged(ChangeEvent e){
            f= x.getValue();
            repaint();
        }
}

class JPanelOne extends JPanel implements MouseListener{
JPanelOne(){
        CardLayout cards= new CardLayout();
        setLayout(cards);
        JPanel two= new JPanel();
        two.setBackground(Color.BLUE);
        add(two, "blue");
        JPanel three= new JPanel();
        three.setBackground(Color.GREEN);
        add(three, "green");
        JPanel four= new JPanel();
        four.setBackground(Color.RED);
        add(four, "red");
        cards.first(this);
}
        public void mousePressed(MouseEvent e){
        }
         public void mouseClicked(MouseEvent e){
         }
         public void mouseEntered(MouseEvent e){
         }
         public void mouseExited(MouseEvent e){
         }
         public void mouseReleased(MouseEvent e){
         }

         public void mouseMoved(MouseEvent e) {
         }
         public void mouseDragged(MouseEvent e) {
         }
}
}
