package default_package;

import java.awt.Graphics;

import javax.swing.JFrame;

import interfaces.Deadble;
import interfaces.Drawable;
import interfaces.Movable;
import interfaces.Shoteable;

public class Container {
	
	
	
	public void movable(Movable m,String direction) {
		
	}
	
    public void shoteable(Shoteable s) {
    	s.shoteable();
	}
    public void deadble(Deadble d) {
    	d.deadble();
	
}
    public void drawable(Drawable d, Graphics g) {
		d.drawable(g);
	}
	

	

}
