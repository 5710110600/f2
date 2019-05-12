import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class GameController implements PlayerListener {
  private Board board;
  public static Dice d1 = new Dice();
  public static Dice d2 = new Dice();

  private Player p1;
  private Player p2;
  private Player currentPlayer;
  private Player winner = null;
  private List<Sprite> players = new ArrayList<>();

  private List<GameSpriteListener> spriteListeners = new ArrayList<>();
  private List<GameControlListener> controlListeners = new ArrayList<>();

  private static GameController instance;
  public static GameController getInstance(){
    if(instance == null){
      instance = new GameController();
    }
    return instance;
  }

  private GameController() {
    board = new Board(80);   //ed 80

    p1 = new Player("P1", 0, board, this);
    p2 = new Player("P2", 1, board, this);
    currentPlayer = p1;
    
    players.add(p1);
    players.add(p2);    
  }

  private void rollDice() {
    d1.roll();
    d2.roll();
  }

  public void takeTurn() {
    if(winner != null)
      return;

    rollDice();
    //currentPlayer.checkk(d1.getFace() + d2.getFace());
    currentPlayer.walk(d1.getFace() + d2.getFace());
    System.out.println("dice1 =" + d1.getFace());
    System.out.println("dice2 =" + d2.getFace());
  }

  private void changeTurn() {
    if(d1.getFace() != d2.getFace()){
      if (currentPlayer == p1)
        currentPlayer = p2;
      else
        currentPlayer = p1;
    }
  }
  
  @Override
  public void walking(Player owner){
    notifyGamePlayEnabled(false);
    for(GameSpriteListener listener : spriteListeners){
      listener.spriteUpdated();
    }
  }

  @Override
  public void walkCompleted(Player onwer) {        
    changeTurn();
    d1.resetFace();
    d2.resetFace();
    notifyGamePlayEnabled(true);
  }
  
  @Override
  public void hasWon(Player owner) {
    if (winner == null) { // first winner only
      winner = owner;
      if(winner.getName() == "P1")
        JOptionPane.showMessageDialog(null,"Player1 winner!!!" );
      else
        JOptionPane.showMessageDialog(null,"Player2 winner!!!" );
    }
  }

  public Player getWinner() {
    return winner;
  }

  public Player getCurrentPlayer() {
    return currentPlayer;
  }

  public List<Sprite> getSprites(){
    return players;
  }

  public void addSpriteListener(GameSpriteListener listener){
    spriteListeners.add(listener);
  }

  public void addControlListener(GameControlListener listener){
    controlListeners.add(listener);
  }

  public void notifyGamePlayEnabled(boolean enabled){
    for(GameControlListener listener : controlListeners){
      listener.changeGamePlayEnabled(enabled);
    }
  }

}