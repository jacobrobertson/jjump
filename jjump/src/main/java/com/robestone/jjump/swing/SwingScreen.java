package com.robestone.jjump.swing;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.net.URL;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;

import com.robestone.jjump.GameRunner;
import com.robestone.jjump.ImageSprite;
import com.robestone.jjump.MoveDecider;
import com.robestone.jjump.OvalSprite;
import com.robestone.jjump.Paintable;
import com.robestone.jjump.PolygonPaintable;
import com.robestone.jjump.PolygonSprite;
import com.robestone.jjump.Room;
import com.robestone.jjump.Rule;
import com.robestone.jjump.Screen;
import com.robestone.jjump.SimpleRoomMoveDecider;
import com.robestone.jjump.Sprite;

public class SwingScreen extends JComponent implements Screen {

	private JFrame frame;
	private GameRunner gameRunner;
	private SwingSensor sensor = new SwingSensor();
	private MoveDecider moveDecider;
	
	public void init(GameRunner gameRunner) {
		frame = new JFrame("JJump");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.setBounds(100, 100, 1000, 500);
		frame.setVisible(true);
		frame.addKeyListener(sensor);
		
		this.gameRunner = gameRunner;
		this.moveDecider = new SimpleRoomMoveDecider(this, gameRunner);
	}
	public MoveDecider getMoveDecider() {
		return moveDecider;
	}
	public SwingSensor getSensor() {
		return sensor;
	}
	
	public int getWidth(Sprite sprite) {
		return getBounds(sprite).width;
	}

	public int getHeight(Sprite sprite) {
		return getBounds(sprite).height;
	}
	public Rectangle getBounds(Sprite sprite) {
		if (sprite instanceof PolygonSprite) {
			PolygonSprite ps = (PolygonSprite) sprite;
			int top = 0;
			int bottom = 0;
			for (int y: ps.getYPoints()) {
				if (y < top) {
					top = y;
				}
				if (y > bottom) {
					bottom = y;
				}
			}
			int left = 0;
			int right = 0;
			for (int x: ps.getXPoints()) {
				if (x < left) {
					left = x;
				}
				if (x > right) {
					right = x;
				}
			}
			return new Rectangle(ps.getX(), ps.getY(), right - left, bottom - top);
		} else if (sprite instanceof OvalSprite) {
			OvalSprite os = (OvalSprite) sprite;
			return new Rectangle(os.getX(), os.getY(), os.getWidth(), os.getHeight());
		} else if (sprite instanceof ImageSprite) {
			ImageSprite is = (ImageSprite) sprite;
			Image image = getImage(is);
			return new Rectangle(is.getX(), is.getY(), image.getWidth(this), image.getHeight(this));
		} else {
			throw new IllegalArgumentException("I don't recognize: " + sprite);
		}
	}

	public void paintCycle() {
		frame.repaint();
	}
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		paintBackground(g2);
		
		for (Room room: gameRunner.getRooms()) {
			Paintable paintable = room.getPaintable();
			if (paintable instanceof PolygonPaintable) {
				paintPolygon((PolygonPaintable) paintable, g2);
			}
		}
		
		List<Rule> rules = gameRunner.getRules();
		for (Rule rule: rules) {
			if (rule instanceof Sprite) {
				Sprite sprite = (Sprite) rule;
				if (sprite.isVisible()) {
					paintSprite(sprite, g2);
				}
			}
		}
		
		g2.finalize();
	}
	private void paintBackground(Graphics2D g2) {
		// TODO get actual backgrounds from game
		g2.drawRect(0, 0, frame.getWidth(), frame.getHeight());
	}
	private void paintSprite(Sprite sprite, Graphics2D g2) {
		if (sprite instanceof PolygonSprite) {
			paintPolygon((PolygonSprite) sprite, g2);
		} else if (sprite instanceof OvalSprite) {
			paintOval((OvalSprite) sprite, g2);
		} else if (sprite instanceof ImageSprite) {
			paintImageSprite((ImageSprite) sprite, g2);
		}
	}
	private void paintImageSprite(ImageSprite sprite, Graphics2D g2) {
		Image img1 = getImage(sprite);
		g2.drawImage(img1, sprite.getX(), sprite.getY(), this);
	}
	private void paintOval(OvalSprite sprite, Graphics2D g2) {
		g2.setPaint(sprite.getFillColor());
	    g2.fillOval(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
		g2.setPaint(sprite.getBorderColor());
		g2.setStroke(new BasicStroke(sprite.getBorderThickness()));
	    g2.drawOval(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
	}
	private void paintPolygon(PolygonPaintable sprite, Graphics2D g2) {
		int xd = sprite.getX();
		int yd = sprite.getY();
		List<Integer> x = sprite.getXPoints();
		List<Integer> y = sprite.getYPoints();
		int[] xa = new int[x.size()];
		int[] ya = new int[x.size()];
		for (int i = 0; i < x.size(); i++) {
			xa[i] = x.get(i) + xd;
			ya[i] = y.get(i) + yd;
		}
		g2.setPaint(sprite.getBorderColor());
		g2.setStroke(new BasicStroke(sprite.getBorderThickness()));
		g2.drawPolygon(xa, ya, xa.length);

		g2.setPaint(sprite.getFillColor());
		g2.fillPolygon(xa, ya, xa.length);
	}
	
	private Image getImage(ImageSprite sprite) {
		URL imageUrl = ClassLoader.getSystemClassLoader().getResource(sprite.getCostume());
		Image image = Toolkit.getDefaultToolkit().getImage(imageUrl);
		return image;
	}
	public Paintable getPaintable() {
		return null;
	}
}
