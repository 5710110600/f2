import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import javax.swing.JTextField;  //ed

public class ControlPanel extends JPanel implements GameControlListener{
  private GameController gc;
  private JButton playButton;
  private JLabel playerLabel;
  private JLabel diceLabel1;
  private JLabel diceLabel2;
  //private JLabel showScoreLabel;  //ed
  

  public ControlPanel(){
    gc = GameController.getInstance();
    gc.addControlListener(this);

    JButton exitButton = new JButton("Exit");
    exitButton.addActionListener(new ActionListener(){    
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(1);
      }
    });

    playButton = new JButton("Play");
    playButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        gc.takeTurn();
        //showScoreLabel = new JLabel("", SwingConstants.CENTER);   //ed
      }
    });
    diceLabel1 = new JLabel("", SwingConstants.CENTER);   //
    diceLabel1.setFont(diceLabel1.getFont().deriveFont(14.0f)); //

    diceLabel2 = new JLabel("", SwingConstants.CENTER);   //
    diceLabel2.setFont(diceLabel2.getFont().deriveFont(14.0f)); //

    playerLabel = new JLabel("", SwingConstants.CENTER);
    playerLabel.setFont(playerLabel.getFont().deriveFont(14.0f));
    updatePlayerLabel();
    setLayout(new GridLayout(0, 1));
    add(exitButton);
    add(playerLabel);
    add(diceLabel1);
    add(diceLabel2);
    //add(showScoreLabel);  //ed
    add(playButton);    
  }

  public void changeGamePlayEnabled(boolean enabled){
    playButton.setEnabled(enabled);
    updatePlayerLabel();
  }

  private void updatePlayerLabel(){
    playerLabel.setText(gc.getCurrentPlayer().toString()+" : walk   " + Integer.toString(gc.d1.getFace() + gc.d2.getFace()));
    diceLabel1.setText("dice1: " + gc.d1.getFace()); 
    diceLabel2.setText("dice2: " + gc.d2.getFace()); 
  }
}