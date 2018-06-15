package Mastermind;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class App extends JFrame {

	public static JFrame frame;

	public static void main(String args[]) {
		frame = new App();
		frame.setSize(500, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Mastermind");
		setFrontScreen();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private static Font fnt = new Font("Apple Casual", Font.BOLD, 12);

	public static void setFrontScreen() {
		JPanel panel = new JPanel();
		JTextArea textArea = new JTextArea();
		panel.setLayout(new BorderLayout());
		JButton startButton = new JButton("Start MasterMind");
		textArea.setText("\n "
				+ " Hier komt een uitleg over Master Mind \n \t - Je begint onderaan omdat dit ook zo is in het echt. \n \t - Je klikt op de buttons met een zwart kadertje eromheen. \n \t - De kleur zal veranderen en dit zal jouw keuze zijn. \n \t - Als je op submit klikt zal de applicatie berekenen of je keuze klopt.");
		textArea.setFont(fnt);
		textArea.setEditable(false);
		panel.add(startButton, BorderLayout.SOUTH);
		panel.add(textArea, BorderLayout.CENTER);
		frame.setContentPane(panel);
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new Controller());
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}
