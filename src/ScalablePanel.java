

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public abstract class ScalablePanel extends JPanel {

  private static final long serialVersionUID = 452899977348673704L;
  protected static final int space=5;
  protected int top=space;
	/**
	 * erzeugt ein neues, leeres Panel mit Beschriftung
	 * @param string die Beschriftung, die im Rahmen um das Panel erscheinen soll
	 */
	public ScalablePanel(String string) {
		super();
		init();
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),string)); // Rahmen um Feld Erzeugen
		top+=15;
	}
	
	/**
	 * erzeugt ein neues, leeres Panel
	 */
	public ScalablePanel(){
		super();
		init();
	}
	
	/**
	 * schaltet das Java-eigene automatische Layout ab
	 */
	private void init() {
		this.setLayout(null);
/*		Random rand=new Random();
		setBackground(new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat())); //*/
	}
	
	public abstract void scale();
}
