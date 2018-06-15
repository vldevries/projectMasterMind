package Mastermind.views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Mastermind.GuessModel;
import Mastermind.Helper;

public class CorrectView extends JPanel {

	public GuessModel model;
	Helper helper = new Helper();
	public JLabel label = new JLabel("Correct geantwoord!!");

	public CorrectView(GuessModel model) {
		this.model = model;
		setLayout(null);
		label.setForeground(Color.white);
		label.setBounds(250, 20, 200, 30);
		label.setVisible(false);
		label.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		add(label);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(4));

		g.setColor(Color.darkGray);

		g.fillRect(0, 0, getWidth(), getHeight());

		if (model.isGuessed) {
			g.setColor(Color.black);
			g.drawOval(25, 25, 25, 25);
			g.setColor(helper.getCorrectColor(model.Guess1));
			g.fillOval(25, 25, 25, 25);

			g.setColor(Color.black);
			g.drawOval(75, 25, 25, 25);
			g.setColor(helper.getCorrectColor(model.Guess2));
			g.fillOval(75, 25, 25, 25);

			g.setColor(Color.black);
			g.drawOval(125, 25, 25, 25);
			g.setColor(helper.getCorrectColor(model.Guess3));
			g.fillOval(125, 25, 25, 25);

			g.setColor(Color.black);
			g.drawOval(175, 25, 25, 25);
			g.setColor(helper.getCorrectColor(model.Guess4));
			g.fillOval(175, 25, 25, 25);
		}
	}

}
