import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Stiefo extends JFrame {

	public Stiefo(String title) {
		super(title);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		add(components());
		pack();
	}

	private Component components() {
		VerticalPanel mainPanel = new VerticalPanel();
		JTextField input = new JTextField(70);
		StiefoPanel drawArea = new StiefoPanel();
		input.addKeyListener(drawArea);
		drawArea.setPreferredSize(new Dimension(800, 600));
		drawArea.setSize(getPreferredSize());
		drawArea.setBackground(Color.white);
		mainPanel.add(input);
		mainPanel.add(drawArea);
		mainPanel.scale();
		pack();
		return mainPanel;
	}

	public static void main(String[] args) {
		Stiefo stiefo = new Stiefo("Stiefo von Srsoftware");
		stiefo.setVisible(true);
	}
}
