package default_package;

import javax.swing.*;
import java.awt.*;

public class Panel extends JFrame {
	private Ship ship;
	private Enemies enemies;
	public Panel() {
		this.setSize(800,600); 
		this.setTitle("GALAXIA GAME");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ship= new Ship();
		enemies= new Enemies();
	}
	
	@Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK); 
        g.fillRect(0, 0, getWidth(), getHeight()); 
        
        int yLinea = (int) (getHeight() * 0.80);
        g.setColor(Color.RED);
        g.drawLine(0, yLinea, getWidth(), yLinea);
        ship.drawable(g);
        enemies.drawable(g);
    }
}
