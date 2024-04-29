package default_package;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import interfaces.Deadble;
import interfaces.Drawable;
import interfaces.Shoteable;

public class Enemies implements Drawable, Deadble, Shoteable {

    @Override
    public void shoteable() {
       
    }

    @Override
    public void deadble() {
       
    }

    @Override
    public void drawable(Graphics g) {
        
     
        int[] xPoints = {40, 40, 60, 80, 80};
        int[] yPoints = {40, 80, 60, 80, 40};
        
        
        Polygon polygon = new Polygon(xPoints, yPoints, 5);
        
      
        g.setColor(Color.RED);
        g.fillPolygon(polygon);
        
       
    }

	@Override
	public void movable(String direction) {
		// TODO Auto-generated method stub
		
	}
    
}
