import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.UnexpectedException;

import javax.swing.JPanel;
import javax.swing.JTextField;


public class StiefoPanel extends JPanel implements KeyListener{

	private String message=null;
	private static int height=200;
	
	private void write(Graphics g, String m, Point lastPoint,int x, int currentBase,int lineBase) {
		System.out.println("write("+m+")");
		
		if (lastPoint!=null){
			g.setColor(Color.lightGray);
			g.drawLine(lastPoint.x-10,lastPoint.y-10,lastPoint.x+10,lastPoint.y+10);
			g.drawLine(lastPoint.x-10,lastPoint.y+10,lastPoint.x+10,lastPoint.y-10);
			g.setColor(Color.black);

		}
		if (m.length()<1) return;
		char c=m.charAt(0);
		m=m.substring(1);
		switch (c){
		case ' ': writeSpace(g,m,lastPoint,x,lineBase); break;
		case 'a': writeA(g,m,lastPoint,x,currentBase,lineBase); break;
//		case 'ö': writeÖ(g,m,position,lineBase); break;
		case 'b': writeB(g,m,lastPoint,x,						currentBase,lineBase); break;
//		case 'c': writeC(g,m,position,lineBase); break;
		case 'd': writeD(g,m,lastPoint,x,						currentBase,lineBase); break;
		case 'e': writeE(g,m,lastPoint,x,currentBase,lineBase); break;
//		case 'ä': writeÄ(g,m,position,lineBase); break;
//		case 'g': writeG(g,m,position,lineBase); break;
//		case 'h': writeH(g,m,position,lineBase); break;
		case 'i': writeI(g,m,lastPoint,x,currentBase,lineBase); break;
//		case 'ü': writeÜ(g,m,position,lineBase); break;
//		case 'k': writeK(g,m,position,lineBase); break;
//		case 'm': writeM(g,m,position,lineBase); break;
		case 'n': writeN(g,m,lastPoint,x,						currentBase,lineBase); break;
		case 'o': writeO(g,m,lastPoint,x,currentBase,lineBase); break;
		case 'r': writeR(g,m,lastPoint,x,						currentBase,lineBase); break;
//		case 'ß':
//		case 's': writeS(g,m,position,lineBase); break;
		case 't': writeT(g,m,lastPoint,x,						currentBase,lineBase); break;
		case 'u':  write(g,m,lastPoint,x+3*height/4,currentBase,lineBase); break;
//		case 'z': writeZ(g,m,position,lineBase); break;
		default: 	 write(g,m,lastPoint,x,						currentBase,lineBase);
						 break;
								
		}
	}
	
	private void writeSpace(Graphics g, String m, Point lastPoint,int x,int lineBase) {
		write(g,m,null,x+height/4,lineBase,lineBase);
	}


	public void paint(Graphics g) {
		super.paint(g);
		if (message==null || message.length()<1) return;
		System.out.println(message);
		int base=3*height/2;
		Point start=new Point(10,base);
		g.setColor(Color.lightGray);
		g.drawLine(start.x-20, base, start.x+800, base);
		g.drawLine(start.x-20, base-height/2, start.x+800, base-height/2);
		g.drawLine(start.x-20, base-height, start.x+800, base-height);
		int  i=10;		
		while (i<800){
			g.drawLine(i, base, i+height/4, base-height);
			i+=height/4;
		}
		g.setColor(Color.black);
		write(g,message,null,10,base,base);
	}
	
	private void writeZ(Graphics g, String m, Point p, int base) {
		g.drawLine(p.x, p.y,p.x-9*height/40, p.y+height/2);
		g.drawLine(p.x-9*height/40, p.y+height/2, p.x-12*height/40, p.y+height);
		Point n = new Point(p.x-12*height/40, p.y+height);		
		write(g,m,n,base);
	}

	private void writeD(Graphics g, String m, Point lastPosition, int x, int currentBase,int base) {
		if (lastPosition!=null) g.drawLine(lastPosition.x,lastPosition.y,x-2*height/13,currentBase-height/2);
		g.drawArc(x-height/6,currentBase-3*height/2,height/3,3*height/2,200,90);
		write(g,m,new Point(x+height/17,currentBase-height/20),x+height/4,currentBase,base);
	}

	private void writeH(Graphics g, String m, Point p, int base) {
		g.drawLine(p.x, p.y,p.x-3*height/40, p.y+height/2);
		g.drawLine(p.x-3*height/40, p.y+height/2, p.x-12*height/40, p.y+height);
		Point n = new Point(p.x-12*height/40, p.y+height);		
		write(g,m,n,base);
	}

	private void writeR(Graphics g, String m, Point lastPoint,int x, int currentBase, int base) {
//		if (m.length()>0){
//			switch (m.charAt(0)){
//			case 'r':
//				writeR(g,m.substring(1),p,base);
//				return;
//			}
//		}

		
		if (lastPoint!=null) g.drawLine(lastPoint.x,lastPoint.y,x-5*height/88,currentBase-5*height/11);
		g.drawArc(x-height/8,currentBase-height/2,height/4,height,30,85);
		g.drawArc(x+11*height/120,currentBase-height,height/4,height,210,85);
		write(g,m,new Point(x+15*height/56,currentBase-height/18),x+height/2,currentBase,base);
		
//		g.drawArc(p.x-height/80, p.y-height/40, height/8, height/8, 20, 115);
//		g.drawLine(p.x+9*height/80, p.y+height/40, p.x+11*height/80, p.y+19*height/40);
//		g.drawArc(p.x+11*height/80, p.y+16*height/40, height/8, height/8, 200, 115);
//		Point n=new Point(p.x+10*height/40,p.y+height/2);
//		write(g,m,n,base);			
	}

	private void write(Graphics g, String m, Point n, int base) {
		throw new NullPointerException("Use of old dummy method");
		
	}

	public void setMessage(String m){
		message=m.toLowerCase();
		repaint();
	}


	private void writeT(Graphics g, String m, Point lastPoint, int x, int currentBase,int base) {
		if (m.length()>0){
			switch (m.charAt(0)){
			case 't':
				writeT(g,m.substring(1),lastPoint,x,currentBase,base);
				return;
			case 'z':
//				writeZ(g,m.substring(1),p,base);
				return;
			}
		}

		if (lastPoint!=null) g.drawLine(lastPoint.x,lastPoint.y,x+height/8,currentBase-height/2);
		g.drawLine(x+height/8,currentBase-height/2,x,currentBase);
		write(g,m,new Point(x,currentBase),x+height/2,currentBase,base);
	}


	private void writeO(Graphics g, String m, Point lastPoint,int x, int currentBase,int lineBase) {
		if (m.length()>0){
			switch (m.charAt(0)){
			case 'o':
				writeO(g,m.substring(1),lastPoint,x,currentBase,lineBase);
			return;
//			case 'i':
//			case 'y':
//				writeEU(g,m.substring(1),p,base);
//			return;
			case 'h':
				if (m.length()>1){
					switch (m.charAt(1)){
					case 'a':
					case 'e':
					case 'i':
					case 'o':
					case 'u':
						break;
					default: m=m.substring(1);
						break;
					}
				} else m=m.substring(1);
			}
		}
		write(g,m,lastPoint,x+5*height/8,currentBase+height/2,lineBase);
	}

	private void writeI(Graphics g, String m, Point lastPoint,int x, int currentBase,int lineBase) {
		if (m.length()>0){
			switch (m.charAt(0)){
			case 'e':
			case 'i':
					writeI(g,m.substring(1),lastPoint,x,currentBase,lineBase);
				return;
			case 'h':
				if (m.length()>1){
					switch (m.charAt(1)){
					case 'a':
					case 'e':
					case 'i':
					case 'o':
					case 'u':
						break;
					default: m=m.substring(1);
						break;
					}
				} else m=m.substring(1);
			}
		}

		write(g,m,lastPoint,x+height/8,		currentBase+height/2,lineBase);
	}

	private void writeÜ(Graphics g, String m, Point p, int base) {
		if (m.length()>0){
			switch (m.charAt(0)){
			case 'h':
				if (m.length()>1){
					switch (m.charAt(1)){
					case 'a':
					case 'e':
					case 'i':
					case 'o':
					case 'u':
						break;
					default: m=m.substring(1);
						break;
					}
				} else m=m.substring(1);
			}
		}

		Point n = new Point(p.x+height/2,p.y);
		g.drawLine(p.x, p.y, n.x, n.y);
		g.drawOval(p.x+height/4, p.y+height/10, 3,3);
		write(g,m,n,base);
	}

	private void writeN(Graphics g, String m, Point lastPoint,int x, int currentBase,int base) {
		if (m.length()>0){
			switch (m.charAt(0)){
//			case 'd':
//			case 't':
//				g.drawArc(p.x-3*height/40, p.y-height/40, height/5, 41*height/40, 310, 160);
//				g.drawLine(p.x+4*height/43,p.y+35*height/40,p.x+3*height/43,p.y+height);
//				write(g,m.substring(1),new Point(p.x+3*height/43,p.y+height),base);
//				return;
//			case 'g':
//			case 'k':
//				g.drawArc(p.x-height/40, p.y-2*height/40, height/4, height/4, 20, 115);
//				g.drawLine(p.x+9*height/40, p.y+2*height/40, p.x+11*height/40, p.y+height);
//				Point n=new Point(p.x+10*height/40,p.y+height);
//				write(g,m.substring(1),n,base);
//				return;
			case 'n':
				writeN(g,m.substring(1),lastPoint,x,currentBase,base);
				return;
			}
		}
		/* this seems odd
		 * if (p.y==base){
			Point newPos = new Point(p.x+height/4, p.y-height/2);
			g.drawLine(p.x, p.y, newPos.x, newPos.y);
			p=newPos;
		} */

		if (lastPoint!=null) g.drawLine(lastPoint.x,lastPoint.y,x-height/9,currentBase-5*height/11);
		g.drawArc(x-height/4,currentBase-height/2,height/2,height,0,115);
		write(g,m,new Point(x+height/4,currentBase),x+height/2,currentBase,base);
		
	}

	private void writeM(Graphics g, String m, Point p,int base) {
		if (m.length()>0){
			switch (m.charAt(0)){
			case 'm':
				writeM(g,m.substring(1),p,base);
				return;
			}
		}

		g.drawArc(p.x-4*height/43, p.y-height/40, height/4, 43*height/40, 244, 225);
		write(g,m,new Point(p.x-height/40,p.y+height),base);
		
	}

	private void writeS(Graphics g, String m, Point p,int base) {
		if (m.length()>0){
			switch (m.charAt(0)){
			case 's':
				writeS(g,m.substring(1),p,base);
				return;
			}
		}

		g.drawArc(p.x-4*height/50, p.y-height/70, height/4, 10*height/40, 300, 175);
		write(g,m,new Point(p.x+4*height/40,p.y+9*height/40),base);	
	}

	private void writeG(Graphics g, String m, Point p,int base) {
		Point n=new Point(p.x+height/2,p.y+height/2);
		g.drawLine(p.x, p.y, n.x, n.y);
		write(g,m,n,base);
		
	}


	private void writeU(Graphics g, String m, Point p,int base) {
		if (m.length()>0){
			switch (m.charAt(0)){
			case 'u':
				writeU(g,m.substring(1),p,base);
				return;
			case 'h':
				if (m.length()>1){
					switch (m.charAt(1)){
					case 'a':
					case 'e':
					case 'i':
					case 'o':
					case 'u':
						break;
					default: m=m.substring(1);
						break;
					}
				} else m=m.substring(1);
			}
		}

		Point n=new Point(p.x+11*height/8,p.y-height/2);
		g.drawLine(p.x, p.y, n.x, n.y);
		write(g,m,n,base);
	}


	private void writeC(Graphics g, String m, Point p,int base) {
		if (m.length()>0){
			char c=m.charAt(0);		
			switch (c){
				case 'h': writeCH(g,m.substring(1),p,base); return;
				case 'k': writeK(g,m.substring(1),p,base); return;
			}
		}	
		write(g,m,p,base);		
	}


	private void writeCH(Graphics g, String m, Point p,int base) {
		if (m.length()>0 && m.charAt(0)=='t'){
			g.drawArc(p.x-height/40, p.y-2*height/40, height/4, height/4, 20, 115);
			g.drawLine(p.x+9*height/40, p.y+2*height/40, p.x+11*height/40, p.y+38*height/40);
			g.drawArc(p.x+11*height/40, p.y+32*height/40, height/4, height/4, 200, 115);
			Point n=new Point(p.x+20*height/40,p.y+height);
			write(g,m.substring(1),n,base);			
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


	private void writeB(Graphics g, String m, Point lastPoint, int x, int currentBase,int lineBase) {		
		g.drawLine(x+height/4, currentBase-height,x, currentBase);
		if (lastPoint!=null) g.drawLine(lastPoint.x, lastPoint.y, x+height/4, currentBase-height);
		write(g,m,new Point(x,currentBase),x+height/4,currentBase,lineBase);
	}


	private void writeA(Graphics g, String m, Point lastPoint,int x, int currentBase,int lineBase) {
		if (m.length()>0){
			switch (m.charAt(0)){
			case 'a':
				writeA(g,m.substring(1),lastPoint,x,currentBase,lineBase);
				return;
//			case 'u':
//				writeAU(g,m.substring(1),p,base);
//				return;
//			case 'i':
//			case 'y':
//				writeEI(g,m.substring(1),p,base);
//				return;
			case 'h':
				if (m.length()>1){
					switch (m.charAt(1)){
					case 'a':
					case 'e':
					case 'i':
					case 'o':
					case 'u':
						break;
					default: m=m.substring(1);
						break;
					}
				} else m=m.substring(1);
			}
		}

		write(g,m,lastPoint,x+3*height/8,currentBase-height/2,lineBase);
	}
	
	private void writeÖ(Graphics g, String m, Point p,int base) {
		if (m.length()>0){
			switch (m.charAt(0)){
			case 'h':
				if (m.length()>1){
					switch (m.charAt(1)){
					case 'a':
					case 'e':
					case 'i':
					case 'o':
					case 'u':
						break;
					default: m=m.substring(1);
						break;
					}
				} else m=m.substring(1);
			}
		}

		Point newPos = new Point(p.x+height, p.y-3*height/2);
		g.drawLine(p.x, p.y, newPos.x, newPos.y);
		write(g,m,newPos,base);
	}

	private void writeAU(Graphics g, String m, Point p, int base) {
		Point n=new Point(p.x+17*height/10,p.y-height/2);
		g.drawLine(p.x, p.y, n.x, n.y);
		g.drawOval(p.x+8*height/10, p.y+height/10, 5, 5);
		write(g,m,n,base);
	
	}

	private void writeE(Graphics g, String m, Point lastPoint,int x, int currentBase,int lineBase) {
		if (m.length()>0){
			switch (m.charAt(0)){
			case 'e':
				writeE(g,m.substring(1),lastPoint,x,currentBase,lineBase);
				return;
			case 'i':
//			case 'y':
//				writeEI(g,m.substring(1),p,base);
//				return;
//			case 'u':
//				writeEU(g,m.substring(1),p,base);
//				return;
			case 'h':
				if (m.length()>1){
					switch (m.charAt(1)){
					case 'a':
					case 'e':
					case 'i':
					case 'o':
					case 'u':
						break;
					default: m=m.substring(1);
						break;
					}
				} else m=m.substring(1);
			}
		}
		write(g,m,lastPoint,x+height/4,	currentBase,lineBase);
	}

	private void writeÄ(Graphics g, String m, Point p,int base) {
		if (m.length()>0){
			switch (m.charAt(0)){
			case 'e':
			case 'ä':
					writeÄ(g,m.substring(1),p,base);
				return;
			case 'i':
			case 'y':
				writeEI(g,m.substring(1),p,base);
				return;
			case 'u':
				writeEU(g,m.substring(1),p,base);
				return;
			case 'h':
				if (m.length()>1){
					switch (m.charAt(1)){
					case 'a':
					case 'e':
					case 'i':
					case 'o':
					case 'u':
						break;
					default: m=m.substring(1);
						break;
					}
				} else m=m.substring(1);
			}
		}
		

			Point newPos = new Point(p.x+height/2, p.y-height/2);
			g.drawLine(p.x, p.y, newPos.x, newPos.y);
			g.drawOval(p.x+height/4, p.y, 5, 5);
			write(g,m,newPos,base);
	}

	
	private void writeEU(Graphics g, String m, Point p, int base) {
		Point n=new Point(p.x+17*height/10,p.y-3*height/2);
		g.drawLine(p.x, p.y, n.x, n.y);
		write(g,m,n,base);
	}

	private void writeEI(Graphics g, String m, Point p, int base) {		
		Point n=new Point(p.x+17*height/10,p.y-height);
		g.drawLine(p.x, p.y, n.x, n.y);
		write(g,m,n,base);
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
