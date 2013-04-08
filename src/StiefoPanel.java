import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextField;


public class StiefoPanel extends JPanel implements KeyListener{

	private String message=null;
	private static int height=50;
	
	public void setMessage(String m){
		message=m.toLowerCase();
		repaint();
	}


	public void paint(Graphics g) {
		super.paint(g);
		if (message==null || message.length()<1) return;
		System.out.println(message);
		int base=400;
		Point start=new Point(20,base);
		g.setColor(Color.lightGray);
		g.drawLine(start.x-20, start.y, start.x+800, start.y);
		g.drawLine(start.x-20, start.y+height/2, start.x+800, start.y+height/2);
		g.drawLine(start.x-20, start.y+height, start.x+800, start.y+height);
		g.setColor(Color.black);
		switch (message.charAt(0)){
		case 'a': start=new Point(20,base+height); break;
		case 'e': start=new Point(20,base+height/2); break;
		}
		
		write(g,message,start,base);
	}
	
	private void write(Graphics g, String m, Point p,int base) {
		System.out.println("write("+m+")");
		if (m.length()<1) return;
		char c=m.charAt(0);
		m=m.substring(1);
		switch (c){
		case ' ': writeSpace(g,m,p,base); break;
		case 'a': writeA(g,m,p,base); break;
		case 'b': writeB(g,m,p,base); break;
		case 'c': writeC(g,m,p,base); break;
		case 'e': writeE(g,m,p,base); break;
		case 'g': writeG(g,m,p,base); break;
		case 'k': writeK(g,m,p,base); break;
		case 'n': writeN(g,m,p,base); break;
		case 'o': writeO(g,m,p,base); break;
		case 'u': writeU(g,m,p,base); break;
		default: write(g,m,p,base);
						 break;
								
		}
	}
	private void writeO(Graphics g, String m, Point p, int base) {
		Point n = new Point(p.x+2*height/3,p.y);
		g.drawLine(p.x, p.y, n.x, n.y);
		write(g,m,n,base);
	}


	private void writeSpace(Graphics g, String m, Point p,int base) {
		int y=base;
		if (m.length()>0) {
			switch (m.charAt(0)){
			case 'a': y+=height; break;
			case 'e':
			case 'n': y+=height/2; break;
			}
		}		
		write(g,m,new Point(p.x+height/2,y),base);		
	}


	private void writeN(Graphics g, String m, Point p,int base) {
		if (m.length()>0){
			switch (m.charAt(0)){
			case 'g':
			case 'k':
				g.drawArc(p.x-height/40, p.y-2*height/40, height/4, height/4, 20, 115);
				g.drawLine(p.x+9*height/40, p.y+2*height/40, p.x+11*height/40, p.y+height);
				Point n=new Point(p.x+20*height/40,p.y+height);
				write(g,m.substring(1),n,base);
				return;
			case 'n':
				writeN(g,m.substring(1),p,base);
				return;
			}
		}
		g.drawArc(p.x-4*height/40, p.y, height/4, 23*height/40, 310, 155);
		write(g,m,new Point(p.x+2*height/20,p.y+height/2),base);
		
	}


	private void writeG(Graphics g, String m, Point p,int base) {
		Point n=new Point(p.x+height/2,p.y+height/2);
		g.drawLine(p.x, p.y, n.x, n.y);
		write(g,m,n,base);
		
	}


	private void writeU(Graphics g, String m, Point p,int base) {
		Point n=new Point(p.x+17*height/10,p.y-height);
		g.drawLine(p.x, p.y, n.x, n.y);
		write(g,m,n,base);
	}


	private void writeC(Graphics g, String m, Point p,int base) {
		if (m.length()<2) return;
		char c=m.charAt(0);		
		switch (c){
		case 'h': writeCH(g,m.substring(1),p,base); break;
		case 'k': writeK(g,m.substring(1),p,base); break;
		default: write(g,m.substring(1),p,base);
		}
	}


	private void writeCH(Graphics g, String m, Point p,int base) {
		if (m.length()>0 && m.charAt(0)=='t'){
			g.drawArc(p.x-height/40, p.y-2*height/40, height/4, height/4, 20, 115);
			g.drawLine(p.x+9*height/40, p.y+2*height/40, p.x+11*height/40, p.y+38*height/40);
			g.drawArc(p.x+11*height/40, p.y+32*height/40, height/4, height/4, 200, 115);
			Point n=new Point(p.x+20*height/40,p.y+height);
			write(g,m,n,base);			
		} else {
			g.drawArc(p.x-9*height/40, p.y-6*height/30, height/4, height/4, 315, 230);
			g.drawLine(p.x-9*height/40, p.y-3*height/40, p.x-9*height/40, p.y+35*height/40);
			g.drawArc(p.x-24*height/40, p.y+27*height/40, 3*height/8, 3*height/8, 315, 45);
			Point n=new Point(p.x-12*height/40,p.y+height);
			write(g,m,n,base);
		}
	}


	private void writeK(Graphics g, String m, Point p,int base) {
		Point n=new Point(p.x+7*height/30,p.y+height);
		g.drawArc(p.x-height/30, p.y-height/30, height/4, height/4, 320, 175);
		g.drawArc(p.x, p.y+24*height/30, height/4, height/4, 150, 165);
		g.drawLine(p.x+6*height/30, p.y+5*height/30, p.x, p.y+26*height/30);
		write(g,m,n,base);
	}


	private void writeB(Graphics g, String m, Point p,int base) {
		Point n = new Point(p.x, p.y+height);
		g.drawLine(p.x, p.y, n.x, n.y);
		write(g,m,n,base);
	}


	private void writeA(Graphics g, String m, Point p,int base) {
		Point newPos = new Point(p.x+height, p.y-height);
		g.drawLine(p.x, p.y, newPos.x, newPos.y);
		write(g,m,newPos,base);
	}
	
	private void writeE(Graphics g, String m, Point p,int base) {
		Point newPos = new Point(p.x+height/2, p.y-height/2);
		g.drawLine(p.x, p.y, newPos.x, newPos.y);
		write(g,m,newPos,base);
	}
	@Override
	public void keyPressed(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {
		Object source=e.getSource();
		if (source instanceof JTextField) {
			JTextField tf = (JTextField) source;
			setMessage(tf.getText()+e.getKeyChar());
		}
	}
}
