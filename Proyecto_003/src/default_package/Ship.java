package default_package;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import interfaces.Deadble;
import interfaces.Drawable;
import interfaces.Movable;
import interfaces.Shoteable;

public class Ship implements Drawable, Deadble, Movable, Shoteable {
    private int x, y;
    private boolean dead;

    public Ship() {
    	 this.x = 400; 
         this.y = 500; 
         this.dead = false;
    }

	@Override
	public void shoteable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void movable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deadble() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawable(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.green); 
		g.fillPolygon(new Polygon(new int[] {x, x-20, x+20}, 
				new int[] {y, y+40, y+40}, 3)); 
	}

	@Override
	public void movable(String direction) {
		// TODO Auto-generated method stub
		
	}
}
