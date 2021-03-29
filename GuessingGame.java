import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

class GuessingGame implements ActionListener {
  JFrame frame;
  JTextField guessField;
  JButton guessButton, playAgainButton;
  JLabel promptLabel, directLabel, guessLabel;
  Random random;
  int randomNumber;

  GuessingGame() {
    random = new Random();
    randomNumber = random.nextInt(100) + 1;

    frame = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240, 120);

    guessField = new JTextField(10);
    guessField.setActionCommand("myTF");
    guessButton = new JButton("Guess");
    playAgainButton = new JButton("Play Again");

    guessField.addActionListener(this);
    guessButton.addActionListener(this);
    playAgainButton.addActionListener(this);

    promptLabel = new JLabel("Enter your guess: ");
    directLabel = new JLabel("");
    guessLabel = new JLabel("");

    frame.add(promptLabel);
    frame.add(guessField);
    frame.add(guessButton);
    frame.add(directLabel);
    frame.add(guessLabel);
    frame.add(playAgainButton);

    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae) {
    if(ae.getActionCommand().equals("Guess"))
      guessNumber();
    else if(ae.getActionCommand().equals("Play Again"))
      reset();
    else if(ae.getActionCommand().equals("myTF")) {
      directLabel.setText("You pressed Enter. Please press the Guess Button.");
      frame.setSize(400, 120);
    }
  }

  public void guessNumber() {
    frame.setSize(240, 140);

    int guess = Integer.parseInt(guessField.getText());

    if (guess > randomNumber)
      directLabel.setText("Too high!");
    else if (guess < randomNumber)
      directLabel.setText("Too low!");
    else
      directLabel.setText("You got it!");

    guessLabel.setText("Last guess was " + String.valueOf(guess));
  }

  public void reset() {
    frame.setSize(240, 120);
    randomNumber = random.nextInt(100) + 1;
    guessField.setText("");
    promptLabel = new JLabel("Enter your guess: ");
    directLabel.setText("");
    guessLabel.setText("");
  }
}