/*Sathya Gadhiraju
 This game will start by having a short paragraph. The user will answer
questions based on this paragraph, by using an elephant's trunk to click
on the peanuts with the correct answer.
 4-21-14*/

import javax.swing.*; // Import libraries
import java.awt.*;
import java.applet.Applet;
import javax.swing.event.*;
import java.awt.event.*;

public class NuttyTrunk extends JApplet{ // Class header NuttyTrunk{
        public void init(){ // Method init(){
        MainPanel fsp= new MainPanel(); // Construct MainPanel
        setContentPane(fsp); // Set MainPanel
    }
}

class MainPanel extends JPanel implements ActionListener{// Class header for MainPanel which should extend JPanel and implement ActionListener{
        DisplayGame gameInstance; // Instance of the second panel which will be displayed on top of the first panel, when the user clicks the JButton.
        CardLayout cards; // This will be done using a card layout.
        InitialCard firstCard; // This is the first card, which displays both the paragraph and the JButton.
        GameIntroCard gameIntroCard; // Declaration of the GameIntroCard panel.
        InstructionPanel instructions; // Declaration of the instructions panel.

        MainPanel(){ // Make a MainPanel() constructor{
                cards = new CardLayout(); // Initialize the card layout.
                setLayout(cards); // Set a card layout for the panel before the game.
                gameIntroCard = new GameIntroCard(); // Initialize the GameIntroCard panel, which is the first card displayed.
                gameIntroCard.buttonStartGame.addActionListener(this); // Add action listener to the button, which starts the game, when it is selected.
                gameIntroCard.buttonInstructions.addActionListener(this); // Add action listener to the button, which goes to the instructions panel, when it is selected.
                add(gameIntroCard, "gameintro"); // Add the game intro card panel to the screen.
                firstCard= new InitialCard(); // Create an instance for the first panel, which holds the paragraph and JButton.
                firstCard.buttonAfterReadParagraph.addActionListener(this); // Add ActionListener to the JButton, which is in the first panel.
                add(firstCard, "paragraph"); // Add the first card to the card layout.
                gameInstance = new DisplayGame(); // Create an instance of the panel which displays the game questions, after the user selects the JButton.
                add(gameInstance, "actualGame"); // Add the second card to the card layout.
                instructions = new InstructionPanel(); // Initialize the InstructionPanel which displays how to play the game.
                instructions.buttonWhenClickedGoesToTheParagraph.addActionListener(this); // Add action listener to the button, which goes to display the paragraph when it is clicked.
                add(instructions, "instructions"); // Add the instructions panel to the screen.
                cards.first(this); // Display the first card.
                gameInstance.choices.goBackToParagraph.addActionListener(this); // Add action listener to the button, which allows the user to go and reread the paragraph.

        }


    public void actionPerformed(ActionEvent e){ // Event Handler header for ActionListener
        if (e.getSource() == gameIntroCard.buttonInstructions){ // If the instructions button is selected
                cards.show(this, "instructions"); // Display the panel with the instructions
        }
        else if (e.getSource() == gameIntroCard.buttonStartGame){ // If the button which says "Start game", is selected
            cards.show(this, "paragraph"); // Display the panel with the paragraph
        }
        else if(e.getSource() == firstCard.buttonAfterReadParagraph){ // If the button which the user should select, after they are done reading the paragraph is selected{
             gameInstance.moveButtons= true; // The buttons will move, because the moveButtons variable has been set to true.
             cards.show(this, "actualGame"); // Display the card which has the game questions.
        }
        else if(e.getSource()== instructions.buttonWhenClickedGoesToTheParagraph){ // If the button which goes to the paragraph panel, is selected
             cards.show(this, "paragraph"); // Display the panel with the paragraph.
        }
        else if(e.getSource()==gameInstance.choices.goBackToParagraph){ // If the button which goes to reread the paragraph, is selected
             gameInstance.moveButtons= false; // Make the moveButtons variable false, so the thread will not move the buttons.
             cards.show(this, "paragraph"); // Display the panel with the paragraph.
        }

    repaint(); // Call repaint();
        }
}

class GameIntroCard extends JPanel{ // Class header for the GameIntroCard panel
    JButton buttonStartGame; // Declare a JButton. When it is selected, the game begins.
    JButton buttonInstructions; // Declare a JButton. When it is selected, the instructions are shown.
    Elephant elephant; // Make an instance of the Elephant class.

    GameIntroCard(){ // Constructor
        setLayout(new BorderLayout()); // Make a BorderLayout
        elephant = new Elephant(true); // Initialize the instance. It is true, because you want to display the elephant only, without the green and blue background.
        add(elephant, BorderLayout.CENTER); // Add the elephant to the center of the panel.
        buttonStartGame = new JButton("Click to start the game!"); // Initialize the JButton which begins the game.
        add(buttonStartGame, BorderLayout.EAST); // Add this JButton to the east of the panel.
        buttonInstructions = new JButton("Click to read instructions!"); // Initialize the JButton which displays instructions.
        add(buttonInstructions, BorderLayout.WEST); // Add this JButton to the west of the panel.
    }

}

class InstructionPanel extends JPanel{ // Class header for the panel which displays the instructions.
    JButton buttonWhenClickedGoesToTheParagraph; // This JButton displays a paragraph when it is selected by the user.

    InstructionPanel(){ // Constructor
        setLayout(new BorderLayout()); // Make a BorderLayout
        buttonWhenClickedGoesToTheParagraph= new JButton("Click this button to start the game!"); // Initialize this JButton, and add text to it.
        buttonWhenClickedGoesToTheParagraph.setFont(new Font("Serif",Font.BOLD, 20)); // Put a bigger font for the String in the JButton.
        add(buttonWhenClickedGoesToTheParagraph, BorderLayout.EAST); // Add this to the east of the panel.
    }

    public void paintComponent(Graphics g){ // paintComponent(Graphics g)
                super.paintComponent(g); // super.paintComponent(g);
                Color colorForBackgroundInstructionPanel= new Color(40, 210, 240); // Make a new color for the background of the panel which shows the instructions.
                setBackground(colorForBackgroundInstructionPanel); // Put the background color for the panel which shows the instructions.
                Font fontToDisplayTheWordInstructions= new Font("Serif", Font.BOLD, 60); // Create a new font to show the word "Instructions".
                g.setFont(fontToDisplayTheWordInstructions); // Put the font as the custom font I made.
                g.drawString(" Instructions: ", 10, 70); // Display the word "Instructions" on the screen.
                Font fontForInstructions= new Font("Serif", Font.BOLD, 30); // Create a new font for the actual instructions.
                g.setFont(fontForInstructions); // Put the font for the instructions, which will be displayed on the screen.
                g.drawString(" First, read the paragraph about general ", 10, 150); // Display the instructions on the screen.
                g.drawString(" cell biology. Next, a question will be ", 10, 190);
                g.drawString(" displayed on the screen. Use the elephant's ", 10, 230);
                g.drawString(" trunk to select the correct answer. However, ", 10, 270);
                g.drawString(" the answers will be moving around, so you ", 10, 310);
                g.drawString(" have to select the correct answer fast. If ", 10, 350);
                g.drawString(" you select the correct answer, you get ten ", 10, 390);
                g.drawString(" points, and you can go to the next level. ", 10, 430);
                g.drawString(" Good luck!", 10, 470);
        }
}

class InitialCard extends JPanel{ // This is a class for the first card being displayed on the screen, which holds the paragraph and JButton.
        JButton buttonAfterReadParagraph;// Declare and construct a JButton, for the user to select when they are done reading the paragraph.

    InitialCard(){ // Constructor InitialCard(){
                setLayout(new BorderLayout()); // Use a BorderLayout to arrange the paragraph and the JButton
                buttonAfterReadParagraph = new JButton("Click this after you are done reading!"); // Initialize the JButton
                buttonAfterReadParagraph.setFont(new Font("Serif",Font.BOLD, 20)); // Set the font to be bigger.
                add(buttonAfterReadParagraph, BorderLayout.EAST);// Add the JButton to the south side of the panel using BorderLayout
        }

    public void paintComponent(Graphics g){ // Method paintComponent(Graphics g)
                super.paintComponent(g); // super.paintComponent(g);
                setBackground(Color.ORANGE); // Put the background as an orange color.
                Font fontForWordParagraph= new Font("Serif", Font.BOLD, 60); // Create a new font for the word, "Paragraph".
                g.setFont(fontForWordParagraph); // Put the font for the word, "Paragraph".
                g.drawString(" Paragraph: ", 10, 70); // Use drawString() to display the word.
                Font fontForParagraph= new Font("Serif", Font.BOLD, 30); // Create a new font for the paragraph.
                g.setFont(fontForParagraph); // Put the font for the paragraph, which will be displayed on the screen
                g.drawString(" Cells are the most basic, yet functional part of living", 10, 150); // Use drawString() to display the paragraph in the first panel.
                g.drawString(" organisms. Cells have organelles which can provide", 10,190);
                g.drawString(" energy, contain genetic information, make proteins,", 10, 230);
                g.drawString(" and so much more. There are two categories of cells:", 10, 270);
                g.drawString(" prokaryotes and eukaryotes. Prokaryotes lack a ", 10, 310);
                g.drawString(" nucleus, which has a cell's DNA. On the other side,", 10, 350);
                g.drawString(" eukaryotes have many more organelles, such as an", 10, 390);
                g.drawString(" endoplasmic reticulum, golgi apparatus, and a", 10, 430);
                g.drawString(" nucleus. Plants and animals are eukaryotes, while", 10,470);
                g.drawString(" bacteria are prokaryotes.", 10, 510);
   }
}

class Elephant extends JPanel{ // A class which draws the elephant.
    boolean drawElephantOnly; // Declare a boolean value. When it is true, it only displays the elephant.
    int mouseXCoordinate; // Declare a variable which stores the x-coordinates for the third point of the trunk, based on where the user's cursor is.
    int mouseYCoordinate; // Declare a variable which stores the y-coordinates for the third point of the trunk, based on where the user's cursor is.
        Elephant(boolean paramDrawElephantOnly){ // Pass another boolean value in the parameter.
        drawElephantOnly = paramDrawElephantOnly; // Make the boolean value which displays only the elephant, equal to the boolean value being passed in the parameter.
        mouseXCoordinate= 0; // Initialize the x-coordinate position to zero as a default position.
        mouseYCoordinate= 0; // Initialize the y-coordinate position to zero as a default position.
    }

    public void paintComponent(Graphics g){ // Draw the elephant using paintComponent()
           super.paintComponent(g); // For the paintComponent() method
           if (drawElephantOnly == false){ // If the boolean value is false, then include the background also
                   setBackground(Color.GREEN.brighter()); // The background will be a light green color.
                   g.setColor(Color.BLUE.brighter().brighter().brighter()); // The color for the sky.
                   g.fillRect(0, 0, 2000, 190); // Make and color in a rectangle which represents the blue sky.
           }
           else{ // If the boolean value is true, only display the elephant
                   Color colorForIntroCardBackground= new Color(190, 190, 255); // Create a new color, which will be the background color for the first card being displayed.
                   setBackground(colorForIntroCardBackground); // Put the background color for this first card.
                   g.setColor(Color.YELLOW.darker()); // Put the color as a dark yellow for the rectangle.
                   g.fillRect(0, 165, 1300, 200); // Color in the rectangle with this dark yellow color.
                   g.setColor(Color.BLACK); // Put the color as a black, for the text.
                   Font fontToDisplayName= new Font("Serif", Font.BOLD, 80); // Create a new font to display the name "Nutty Trunk"
                   g.setFont(fontToDisplayName); // Put the font to show the name of the game.
                   g.drawString("Nutty Trunk", 50, 230); // Display the name of the game.
                   Color colorForBoxForSlogan= new Color(110, 240, 165); // Create a new color for the small sentence under the name.
                   g.setColor(colorForBoxForSlogan); // Put this color for the small sentence.
                   g.fillRect(0, 265, 1300, 100); // Make a rectangle, in which the small sentence will be in.
                   Font fontToDisplaySlogan= new Font("Serif", Font.ITALIC, 30); // Create a new font for showing the small sentence.
                   g.setFont(fontToDisplaySlogan); // A font for the small sentence.
                   g.setColor(Color.BLACK); // Put the color as a black for this text for the slogan.
                   g.drawString("A beginner's game for cell biology!", 40, 330); // Make it appear on the screen.

           }

           g.setColor(Color.GRAY); // Put the color as gray, for the head, outer ears, and body.
           g.fillOval(600, 230, 200,200); // Head
           g.fillOval(550, 230, 90, 90); // Upper left ear
           g.fillOval(570, 285, 110, 140); // Lower left ear
           g.fillOval(750, 230, 90, 90); // Upper right ear
           g.fillOval(730, 300, 110, 130); // Lower right ear
           g.fillOval(575, 390, 250, 250); // body
           g.fillRect(620, 600, 50, 80); // left leg
           g.fillRect(720, 600, 50, 80); // right leg
           g.setColor(Color.PINK); // Put the color as pink, for the inner ears.
           g.fillOval(575, 245, 45, 70); // pink part of upper left ear
           g.fillOval(580, 300, 55, 110); // pink part of lower left ear
           g.fillOval(780, 245, 45, 70); // pink part of upper right ear
           g.fillOval(770, 305, 55, 110); // pink part of lower right ear
           g.setColor(Color.WHITE); // Put the color as white, for the eyes.
           g.fillOval(660, 270, 20, 40); // left white eye
           g.fillOval(720, 270, 20, 40); // right white eye
           g.setColor(Color.BLACK); // Put the color as black, for the irises of the eye.
           g.fillOval(665, 277, 10, 25); // black part of left eye
           g.fillOval(725, 277, 10, 25); // black part of right eye
           Color colorForTrunk= new Color(110, 110, 110); // Make a new gray color for the trunk, so it can be visible when it is overlapping the body.
           g.setColor(colorForTrunk); // Put the new gray color for the trunk.
           if (drawElephantOnly == false && mouseXCoordinate !=0 && mouseYCoordinate !=0){ // If you display more than just the elephant, and the positions of the mouse are not default (zero)
			   
                  int drawTrunkXCoordinates[]= {680, 720, mouseXCoordinate}; // Draw the x-coordinates of the non-fixed points, which will appear in the game panel.
                  int drawTrunkYCoordinates[]= {335, 335, mouseYCoordinate}; // Draw the y-coordinates of the non-fixed points, which will appear in the game panel.
                  g.fillPolygon(drawTrunkXCoordinates, drawTrunkYCoordinates, 3); // Display the trunk in the game panel.
		       
		   }
		   else { 
			   int drawTrunkXCoordinates[]= {680, 720, 850}; // Draw the fixed x-coordinates, which will appear in the intro panel.
               int drawTrunkYCoordinates[]= {335, 335, 500}; // Draw the fixed y-coordinates, which will appear in the intro panel.
               g.fillPolygon(drawTrunkXCoordinates, drawTrunkYCoordinates, 3); // Display the trunk in the intro panel.                         
		   }
	   }
   }


class Answers extends JPanel{ // This class is to display the JButtons with the possible answers.
    JButton answers[]; // This is an array of possible JButtons for answering the question.
    int rightIndex; // The index of the correct answer, in the answers array (above).
    JButton rightAnswer; // Declare the JButton is the right answer to the question.
    JLabel displayQuestion; // Declare a JLabel to display the question in the north

    Answers(String question, String inputStrings[], int right, DisplayGame parent){ // Constructor

                displayQuestion= new JLabel(question);// Initialize the JLabel for displaying the question
                displayQuestion.setFont(new Font("Serif", Font.PLAIN, 30)); // Put a different font for the question, to make it bigger.
                add(displayQuestion); // Add the question to the panel.
                answers = new JButton[inputStrings.length]; // Create an array of how many answers will be there. Also, it will show how many JButtons will be there, according to how many answers are displayed.
                rightIndex = (int)(Math.random()*inputStrings.length); // Make sure the location of the right answer is random. The index of the correct answer is random. Use Math.random().
                rightAnswer = new JButton(inputStrings[right]); // Initialize the JButton for the right answer.
                answers[rightIndex] = rightAnswer; // Assign the correct answer JButton to the right place in the array.

        for (int i=0,ai=0; i<(inputStrings.length-1); i++, ai++){ // Use for loop to create JButtons for wrong answers. i= index, ai= answer index (JButton index)
                        if (ai==rightIndex){// If the index holds the right answer,
                                ai++; // Increment to the next index.
                        }
                        answers[ai] = new JButton(inputStrings[i]); // Create a JButton and assign it to the array.
                }

        for (int i=0; i<answers.length; i++){ // Use for loop to add DisplayGame class as ActionListener to JButtons. Also add the JButtons to the panel.
                answers[i].addActionListener(parent); // Add parent(DisplayGame), which has ActionListener, to the JButton.
            add(answers[i]); // Add the JButtons to the panel.
        }
        }

    public void paintComponent(Graphics g){ // Use this method to put a background color.
                super.paintComponent(g); // For the paintComponent() method
        setBackground(Color.ORANGE); // The background color will be orange.
    }
}

class Scores extends JPanel{ // This class is to display the score and level.
        JLabel displayScore;// Declare a JLabel to show the score of the user in the east
    JLabel displayLevel; // Declare a JLabel to show the level in the east.

    Scores(){ // Constructor Scores()
                displayScore= new JLabel("Score: "); // Initialize the score.
                displayLevel= new JLabel("Level: "); // Initialize the level.
                displayScore.setFont(new Font("Serif", Font.BOLD, 26)); // Put a bigger font for the text for the JLabel.
                displayLevel.setFont(new Font("Serif", Font.BOLD, 26)); // Put a bigger font for the text for the JLabel.
                add(displayScore); // Add the score to the panel.
                add(displayLevel); // Add the level to the panel.
    }

    public void paintComponent(Graphics g){ // Use this method to put a background color.
                super.paintComponent(g); // For the paintComponent() method
                setBackground(Color.ORANGE); // The background color will be orange.
    }
}

class Choices extends JPanel{ // This class is to display a JButton, which will direct the user back to the panel with the paragraph.
    JButton goBackToParagraph; // Declare a JButton which allows the user to reread the paragraph, if they need to.

    Choices(){ // Constructor Choices()
                goBackToParagraph= new JButton("Click to reread the paragraph!"); // Initialize this JButton, and add text to it.
                add(goBackToParagraph); // Add the JButton to the panel.
    }

    public void paintComponent(Graphics g){ // Use this method to put a background color.
        super.paintComponent(g); // For the paintComponent() method
        setBackground(Color.ORANGE); // The background color will be orange.
    }
}

class ResultCorrect extends JPanel{ // A class to display "Correct", if the user answers the question right. It also asks the user if they want to play again.
    JLabel result; // A JLabel for displaying "Correct!"
    JButton playAgain; // A JButton. When it is selected, the user can play again.

    ResultCorrect(DisplayGame gamePanel){ // Constructor. The parameter has gamePanel for ActionListener. gamePanel has the logic for ActionListener. gamePanel is an instance for the DisplayGame class.
        result = new JLabel("Correct!"); // A JLabel will pop up, and say "Correct!"
        result.setFont(new Font("Courier New", Font.ITALIC, 12)); // Put a different font for the "Correct!"
        add(result); // Add the JLabel to the panel.
        playAgain = new JButton("Next question!"); // Initialize the JButton, which should say "Play Again"
        add(playAgain); // Add the JButton to the panel.
        playAgain.addActionListener(gamePanel); // Add ActionListener to the JButton, using the instance created in DisplayGame.
    }

    public void paintComponent(Graphics g){ // Use this method to put a background color.
        super.paintComponent(g); // For the paintComponent() method
        setBackground(Color.ORANGE); // The background color will be orange.
    }
}

class ResultWrong extends JPanel{ // A class to display "Wrong answer!" if the user answers the question wrong.
    JLabel result2; // A Jlabel for displaying "Wrong answer.!"
    JButton tryAgain; // A Jbutton. When it is selected, the user will have to answer the question again.

    ResultWrong(DisplayGame gamePanel){ // Constructor. The parameter has gamePanel for ActionListener. gamePanel has the logic for ActionListener. gamePanel is an instance for the DisplayGame class.
        result2 = new JLabel("Wrong answer."); // A JLabel will pop up, and say "Wrong answer."
        result2.setFont(new Font("Courier New", Font.ITALIC, 12)); // Put a different font for the "Try again"
        add(result2); // Add to the panel.
        tryAgain = new JButton("Try again!"); // Initialize the JButton, which should say "Try again"
        add(tryAgain); // Add it to the panel.
        tryAgain.addActionListener(gamePanel); // Add ActionListener to the JButton, using the instance created in DisplayGame.
    }

    public void paintComponent(Graphics g){ // Use this method to put a background color.
        super.paintComponent(g); // For the paintComponent() method
        setBackground(Color.ORANGE); // The background color will be orange.
    }
}

class DisplayGame extends JPanel implements Runnable, ActionListener, MouseMotionListener{ //Class header for showing the actual game{

        Answers answers; // Declare an Answers panel, to display the possibleanswers to the question.
        Scores scores; // Declare a Scores panel, to calculate the score each time the user answers a question correctly.
        Elephant elephant; // Declare a Elephant panel, where I will use paintComponent() to draw the elephant.
        ResultCorrect resultCorrect; // Declare a panel which says "Correct", when the user selects the right answer.
        ResultWrong resultWrong; // Declare a panel which says "Try again", when the user selects the wrong answer.
        Choices choices; // Declare a panel with a JButton, which allows the user to go back to read the paragraph.
        JLabel instructions; // Declare a JLabel to display the instructions, when the JCheckBox is selected
        BorderLayout layout; // Declare layout variable to store Border Layout
        Thread animationThread; // Declare a variable for a thread, to move the JButtons. The JButtons represent possible answer choices.
        boolean moveButtons; // Declare a variable for the thread, which determines whether the JButtons will be moved or not.

    DisplayGame() {// Make a class constructor{
                moveButtons = false; // Set moveButtons as false, because there is nothing moving right now.
                layout = new BorderLayout(); // Initialize BorderLayout
                setLayout(layout);// Use BorderLayout

                String ans[] = {"Nucleus", "Prokaryote", "Eukaryote", "Golgi Apparatus", "Cells"}; // Create a String array of answers.
                answers = new Answers("Question: What do all living organisms have?", ans, 4, this); // Create answers object. First- String array name,Second- Index of right answer (it will be randomized later), Third- "this" for ActionListener
                add(answers, BorderLayout.NORTH); // Add the possible answers to the center of the panel using BorderLayout.

                scores = new Scores(); // Initialize the Scores panel.
                add(scores, BorderLayout.EAST); // Add the scores to the east of the panel using BorderLayout.

                elephant = new Elephant(false); // Initialize the Elephant panel.
                add(elephant, BorderLayout.CENTER); // Add the elephant to the center of the main panel using Border Layout.
                addMouseMotionListener(this); // Put a MouseMotionListener to move the trunk to where the cursor is.
                

                resultCorrect = new ResultCorrect(this); // Initialize the ResultCorrect panel.
                resultWrong = new ResultWrong(this); // Intitialize the ResultWrong panel.

                choices= new Choices(); // Initialize a Choices panel.
                add(choices, BorderLayout.SOUTH); // Add the choices to the south part of the panel using BorderLayout.

                animationThread = new Thread(this); // Initialize the thread instance.
                animationThread.start(); // Begin the thread. The JButtons do not move yet; it will move when the moveButtons variable is set to true.

    }

    public void actionPerformed(ActionEvent e){ // Event Handler method to see if the user clicked on the correct button{
                if (e.getSource() == resultWrong.tryAgain){ // If the user selects the wrong button
                        remove(layout.getLayoutComponent(BorderLayout.NORTH)); // On the screen, get rid of the components in the north side of the BorderLayout, so "Try again" can be displayed.
                        add(answers, BorderLayout.NORTH); // Add it again so it will be randomized.
                        moveButtons = true; // Set the variable to true, so the JButtons will move.
                }
                else if (e.getSource() == resultCorrect.playAgain){ // If the user selects the right button
                        remove(layout.getLayoutComponent(BorderLayout.NORTH)); // On the screen, get rid of the components in the north side of the BorderLayout, so "Correct" can be displayed.
                        add(answers, BorderLayout.NORTH); // Add answers again.
                        moveButtons = true; // Set the variable to true, so the JButtons will move.
                }
                else if(answers.rightAnswer == e.getSource()){ // If the user selects the correct button{
                        moveButtons = false; // Set the variable to false, so the JButtons will not move.
                        remove(layout.getLayoutComponent(BorderLayout.NORTH)); // Get rid of the current panel, which holds the questions. It puts "Correct", on the screen.
                        add(resultCorrect, BorderLayout.NORTH); // Add this to the screen.
                }
                else{ // If the user selects the incorrect button.
                        moveButtons = false; // Set the variable to false, so the JButtons will not move.
                        remove(layout.getLayoutComponent(BorderLayout.NORTH)); // Get rid of the current panel, which holds the questions. It puts "Try again", on the screen.
                        add(resultWrong, BorderLayout.NORTH); // Add this to the screen.
                }
                
                // Note to Mrs.Frazier: Please check my bibliography page for the use of the remove() method.

        revalidate(); // In the layout, it "refreshes" the panels.
        repaint(); // Call repaint()
        }
        
                       
		 public void mouseMoved(MouseEvent e) { // A method in MouseMotionListener
			 elephant.mouseXCoordinate = e.getX(); // Get the cursor's x-coordinate and set it to the mouseXCoordinate variable in the elephant object.            
			 elephant.mouseYCoordinate = e.getY(); // Get the cursor's y-coordinate and set it to the mouseYCoordinate variable in the elephant object.           
			 repaint(); // repaint() so the trunk can be drawn to a new position of the user's cursor.
		 }
		 public void mouseDragged(MouseEvent e) { // A method in MouseMotionListener.
		 }

    public void run() { // This method will execute the thread.
        while (true){ // A loop which will run.
                try { // Use a try-catch block.
                Thread.sleep(800); // Put the thread to sleep.
                if (moveButtons){ // If the moveButtons variable is true
                                  String ans[] = {"Nucleus", "Prokaryote", "Eukaryote", "Golgi Apparatus", "Cells"}; // Create a String array of answers.
                                  answers = new Answers("Question: What do all living organisms have?", ans, 4, this); // Create answers object. First- String array name, Second- Index of right answer (it will be randomized later), Third- "this" for ActionListener
                                  remove(layout.getLayoutComponent(BorderLayout.NORTH)); // Remove the existing answers object.
                                  add(answers, BorderLayout.NORTH); // Add a new answers object.
                }

            }catch (InterruptedException e) { // Catch the exception with a try-catch block.
                  break; // Exit the loop.
            }
            revalidate(); // In the layout, it "refreshes" the panels.
            repaint(); // Call repaint().
        }
    }
}
