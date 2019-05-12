import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Player extends Sprite {
  private static Color[] COLORS = {Color.BLUE, Color.MAGENTA };
  private String name;
  private int index;
  private Board board;
  private PlayerListener listener;
  private int currentPos = 0;
  
  public Player(String name, int index, Board board, PlayerListener listener) {
    this.name = name;
    this.index = index;
    this.board = board;
    this.listener = listener;
  }

  public void walk(int steps) {
    /*
    int next_position = Math.min(currentPos + steps, board.getFinishPos());
    System.out.println(this + " walks from " + currentPos + " to " + next_position);
    new WalkerThread(next_position).start();     
    */
    int next_position = Math.min(currentPos + steps, board.getFinishPos());
    //================================================================================
    if((next_position == 22) || (next_position == 45) || (next_position == 52) ){
      next_position = Math.min(currentPos + steps, board.getFinishPos());
      System.out.println(this + " walks from " + currentPos + " to " + next_position);
      new WalkerThread(next_position).start(); //===========

      next_position = Math.min(currentPos + steps + 3, board.getFinishPos());
      System.out.println(this +"BONUS + 3 walks from to " + next_position);
      //=================>show popup <======================================
      ImageIcon popup = new ImageIcon("C:/Users/janee/Desktop/board-game-master/src/bonus2.gif");
      JOptionPane.showMessageDialog(null,null,"BONUS +3!!",JOptionPane.INFORMATION_MESSAGE, popup);

      new WalkerThread(next_position).start(); 
    }
    else if((next_position == 7) || (next_position == 9) || (next_position == 27)){
      next_position = Math.min(currentPos + steps, board.getFinishPos());
      System.out.println(this + " walks from " + currentPos + " to " + next_position);
      new WalkerThread(next_position).start(); //===========

      next_position = Math.min(currentPos + (steps*2), board.getFinishPos());
      System.out.println(this + "BONUS x2 " + " walks from to " + next_position);
      //=================>show popup <======================================
      ImageIcon icon = new ImageIcon("C:/Users/janee/Desktop/board-game-master/src/bonus.gif");
      JOptionPane.showMessageDialog(null,null,"BONUSx2!!",JOptionPane.INFORMATION_MESSAGE, icon);

      new WalkerThread(next_position).start(); 
    } 
    else{
      next_position = Math.min(currentPos + steps, board.getFinishPos());
      System.out.println(this + " walks from " + currentPos + " to " + next_position);
      new WalkerThread(next_position).start(); 
    }
    //====================================================================================
  }

  public void doWalking(){
    listener.walking(this);
  }

  public void doWalkCompleted(){
    Integer tunnelOutPos = board.getTunnelOutPos(currentPos);
    if(tunnelOutPos != null){
      System.out.println(this + " enter tunnel from " + currentPos + " to " + tunnelOutPos.intValue());
      currentPos = tunnelOutPos.intValue();   
      listener.walking(this);
    }
    listener.walkCompleted(this);
    if (currentPos >= board.getFinishPos()) {      
      this.listener.hasWon(this);
    } 
    /*
    if (currentPos == 80) {      
      this.listener.hasWon(this);
    }
    */
  }
    
  @Override
  public void draw(Graphics2D g2d){
    if(currentPos > 0){
      g2d.setColor(COLORS[index]);
      Point ref = board.getRefLocationForPos(currentPos);
      g2d.fillOval(ref.x + 10 + (index * 40), ref.y + 30, 20, 20);
    }
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return getName();
  }  

  private class WalkerThread extends Thread {
    private int toPos;
    public WalkerThread(int toPos){
      this.toPos = toPos;
    } 
    public void run(){
      while(currentPos < toPos){
        currentPos ++;
        doWalking();
        try{ Thread.sleep(300); } catch(Exception e){}        
      }
      doWalkCompleted();
    }
  }
}