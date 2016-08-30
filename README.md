# State - Flying flies

The following program simulates flying flies in 2D space. Every fly has random initial position and constant velocity. After touching the window border the fly rebounds and for 2 seconds gets dizzy: it changes its color and slows its moving.

Change this program according to the State design pattern to move all the code dependent on the fly state to separate state classes. Fly begins with the normal state, changes it to the dizzy one after hitting the border and returns to the original one after 2 seconds.

Also add a third state of "freezing" following the "dizzy" one: after hitting the border and being 2 seconds "dizzy" the fly gets frozen for the following 2 seconds: it stops and changes color to yellow before returning to the normal state. Remark how it is easy to add new states.

```
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Fly {
	private final double k = 0.01;
	private double x, y; // fly position
	private double vx, vy; // fly velocity

	private int time=0;

	public Fly()	{
		x = Math.random();
		y = Math.random();
		vx = k*(Math.random() - Math.random());
		vy = k*(Math.random() - Math.random());
	}

	public void draw(Graphics g) {
		if (time>0)
			g.setColor(Color.red);
		else
			g.setColor(Color.black);
		Rectangle rc = g.getClipBounds();
		int a = (int)(x*rc.getWidth()),
			b = (int)(y*rc.getHeight());
		g.fillOval(a, b, 5, 5);
	}
	public void move() {
		if (time > 0) {
			x += vx/2;
			y += vy/2;
			-- time;
		} else {
			x += vx;
			y += vy;
		}
		if(x<0) { x = -x; vx = -vx; time+=100; }
		if(x>1) { x = 2-x;vx = -vx; time+=100;}
		if(y<0) { y = -y; vy = -vy; time+=100;}
		if(y>1) { y = 2-y;vy = -vy; time+=100;}
	}
}

public class FlyStates extends JPanel implements Runnable {
	private Fly[] ar;
	public FlyStates()	{
		this.setPreferredSize(new Dimension(640, 480));
		ar = new Fly[30];
		for(int i = 0; i < ar.length; ++i)
			ar[i] = new Fly();
	}

	public void paintComponent(Graphics g)	{
		super.paintComponent(g);
		for(int i = 0; i < ar.length; ++i)
			ar[i].draw(g);
	}

	public void run() {
		while (true) {
			for(int i = 0; i < ar.length; ++i)
				ar[i].move();
			repaint();
			try {
				Thread.currentThread().sleep(20);
			} catch(InterruptedException e){ e.printStackTrace();}
		}
	}

	public static void main(String[] args)	{
		JFrame frame = new JFrame("Flying flies");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FlyStates m = new FlyStates();
		frame.getContentPane().add(m);
		frame.pack();
		frame.setVisible(true);
		new Thread(m).start();
	}
}
```