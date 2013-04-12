
import java.awt.Component;
import java.awt.Dimension;


	/**
	 * ein Abkömmling von JPanel, der eine automatische Anordnung der Unterlemente untereinander ermöglicht
	 * @author Stephan Richter
	 *
	 */
public class VerticalPanel extends ScalablePanel {

  private static final long serialVersionUID = -3284460780727609981L;
	
	public VerticalPanel(String string) {
		super(string);
  }

	public VerticalPanel() {
		super();
  }

	/**
	 * skaliert das gesamte Panel so, dass alle hinzugefügten Komponenten sichtbar bleiben
	 */
	public void scale(){
		Component[] components = getComponents();
		int maxWidth=0;
		int height=top;
		for (Component c:components){
			if (c instanceof ScalablePanel) {
				ScalablePanel scalablePanel = (ScalablePanel) c;
				scalablePanel.scale();	      
      }

			c.setSize(c.getPreferredSize());
			c.setLocation(space, height);
			if (c.getWidth()>maxWidth) maxWidth=c.getWidth();
			height+=c.getHeight()+space;
		}
		
		setPreferredSize(new Dimension(maxWidth+space+space,height+space));
		setSize(getPreferredSize());
	}
}
