package com.robestone.jjump.swing;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;

import com.robestone.jjump.Costume;
import com.robestone.jjump.GameRunner;
import com.robestone.jjump.ImageCostume;
import com.robestone.jjump.MoveDecider;
import com.robestone.jjump.OvalCostume;
import com.robestone.jjump.Paintable;
import com.robestone.jjump.PolygonCostume;
import com.robestone.jjump.PolygonPaintable;
import com.robestone.jjump.Room;
import com.robestone.jjump.Rule;
import com.robestone.jjump.Screen;
import com.robestone.jjump.SimpleRoomMoveDecider;
import com.robestone.jjump.Sprite;
import com.robestone.jjump.TextCostume;

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
		Costume costume = sprite.getCostumes().getCostume();
		Rectangle baseRectangle = null;
		if (costume instanceof PolygonCostume) {
			PolygonCostume pc = (PolygonCostume) costume;
			int top = 0;
			int bottom = 0;
			for (int y: pc.getYPoints()) {
				if (y < top) {
					top = y;
				}
				if (y > bottom) {
					bottom = y;
				}
			}
			int left = 0;
			int right = 0;
			for (int x: pc.getXPoints()) {
				if (x < left) {
					left = x;
				}
				if (x > right) {
					right = x;
				}
			}
			baseRectangle = new Rectangle(pc.getX(), pc.getY(), right - left, bottom - top);
		} else if (costume instanceof TextCostume) {
			TextCostume tc = (TextCostume) costume;
			Rectangle2D r2d = tc.getFont().getStringBounds(tc.getText(), tc.getX(), tc.getY(), tc.getFontRenderContext());
			baseRectangle = new Rectangle(r2d.getBounds());
		} else if (costume instanceof OvalCostume) {
			OvalCostume os = (OvalCostume) costume;
			baseRectangle = new Rectangle(os.getX(), os.getY(), os.getWidth(), os.getHeight());
		} else if (costume instanceof ImageCostume) {
			ImageCostume is = (ImageCostume) costume;
			Image image = getImage(is);
			baseRectangle = new Rectangle(is.getX(), is.getY(), image.getWidth(this), image.getHeight(this));
		} else {
			throw new IllegalArgumentException("I don't recognize: " + costume);
		}
		int x = sprite.getX();
		int y = sprite.getY();
		baseRectangle.x += x;
		baseRectangle.y += y;
		return baseRectangle;
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
				// TODO FIX
				paintPolygon(null, (PolygonPaintable) paintable, g2);
			}
		}
		
		List<Rule> rules = gameRunner.getRules();
		for (int i = 0; i < rules.size(); i++) {
			Rule rule = rules.get(i);
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
		Costume costume = sprite.getCostumes().getCostume();
		if (costume instanceof PolygonCostume) {
			paintPolygon(sprite, (PolygonCostume) costume, g2);
		} else if (costume instanceof OvalCostume) {
			paintOval(sprite, (OvalCostume) costume, g2);
		} else if (costume instanceof TextCostume) {
			paintText(sprite, (TextCostume) costume, g2);
		} else if (costume instanceof ImageCostume) {
			paintImageCostume(sprite, (ImageCostume) costume, g2);
		}
	}
	private void paintImageCostume(Sprite sprite, ImageCostume costume, Graphics2D g2) {
		Image img1 = getImage(costume);
		g2.drawImage(img1, sprite.getX() + costume.getX(), sprite.getY() + costume.getY(), this);
	}
	private void paintOval(Sprite sprite, OvalCostume costume, Graphics2D g2) {
		g2.setPaint(costume.getFillColor());
	    g2.fillOval(sprite.getX() + costume.getX(), sprite.getY() + costume.getY(), costume.getWidth(), costume.getHeight());
		g2.setPaint(costume.getBorderColor());
		g2.setStroke(new BasicStroke(costume.getBorderThickness()));
	    g2.drawOval(sprite.getX() + costume.getX(), sprite.getY() + costume.getY(), costume.getWidth(), costume.getHeight());
	}
	private void paintPolygon(Sprite sprite, PolygonPaintable costume, Graphics2D g2) {
		int xd = sprite.getX() + costume.getX();
		int yd = sprite.getY() + costume.getY();
		List<Integer> x = costume.getXPoints();
		List<Integer> y = costume.getYPoints();
		int[] xa = new int[x.size()];
		int[] ya = new int[x.size()];
		for (int i = 0; i < x.size(); i++) {
			xa[i] = x.get(i) + xd;
			ya[i] = y.get(i) + yd;
		}
		g2.setPaint(costume.getBorderColor());
		g2.setStroke(new BasicStroke(costume.getBorderThickness()));
		g2.drawPolygon(xa, ya, xa.length);

		g2.setPaint(costume.getFillColor());
		g2.fillPolygon(xa, ya, xa.length);
	}
	private void paintText(Sprite sprite, TextCostume costume, Graphics2D g2) {
		g2.setPaint(costume.getBorderColor());
		g2.setStroke(new BasicStroke(costume.getBorderThickness()));
		g2.setFont(costume.getFont());
		g2.drawString(costume.getText(), sprite.getX() + costume.getX(), sprite.getY() + costume.getY());
	}
	private Image getImage(ImageCostume costume) {
		URL imageUrl = ClassLoader.getSystemClassLoader().getResource(costume.getImageName());
		Image image = Toolkit.getDefaultToolkit().getImage(imageUrl);
		return image;
	}
	public Paintable getPaintable() {
		return null;
	}
}
