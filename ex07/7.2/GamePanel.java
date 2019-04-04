import javax.swing.*;
import java.awt.*;
import java.awt.color.*;
import java.awt.geom.Line2D;


public class GamePanel extends JPanel {
	public GamePanel(){
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.blue);
		g2d.fillRect(0,0,500,300);  //400,180
				
		g2d.setColor(Color.GRAY); 	//building
		g2d.fillRect(50,100,80,100);
		
		g2d.setColor(Color.white); 	//window of building
		g2d.fillRect(65,110,20,15);
		g2d.setColor(Color.white); 	//window of building
		g2d.fillRect(96,110,20,15);
		g2d.setColor(Color.white); 	//window of building
		g2d.fillRect(65,135,20,15);
		g2d.setColor(Color.white); 	//window of building
		g2d.fillRect(96,135,20,15);
		g2d.setColor(Color.white); 	//door of building
		g2d.fillRect(75,165,30,32);
		
		g2d.setColor(Color.GRAY); 	//home
		g2d.fillRect(290,150,100,70);
		g2d.setColor(Color.GREEN);
		g2d.fillPolygon(new int[] {270, 410, 340}, new int[] {150, 150, 110}, 3); //Fills triangle
		g2d.setColor(Color.white); 	//door of home
		g2d.fillRect(340,165,30,32);
		g2d.setColor(Color.white); 	//window of home
		g2d.fillRect(305,165,20,15);

		g2d.setColor(Color.DARK_GRAY); 		//Road
		g2d.fillRect(0,200,500,300);

		g2d.setColor(Color.YELLOW);
		g2d.fillOval(185, 25, 37, 37);

		g2d.setColor(Color.BLACK);			//footbad 
		g2d.setStroke(new BasicStroke(8f));
		g2d.draw(new Line2D.Double(0, 200, 500, 200));

		g2d.setColor(Color.ORANGE);			//line
		g2d.draw(new Line2D.Double(0, 231, 100, 231));
		g2d.draw(new Line2D.Double(150, 231, 250, 231));
		g2d.draw(new Line2D.Double(300, 231, 400, 231));
		g2d.draw(new Line2D.Double(450, 231, 500, 231));
	}
}
