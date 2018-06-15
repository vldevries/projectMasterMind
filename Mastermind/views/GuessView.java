package Mastermind.views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Mastermind.Controller;
import Mastermind.GuessModel;
import Mastermind.Helper;

public class GuessView extends JPanel {

	public GuessModel model;
	public Controller controller;
	public JButton firstClick = new JButton("");
	public JButton secondClick = new JButton("");
	public JButton thirdClick = new JButton("");
	public JButton fourthClick = new JButton("");
	public JButton Submit = new JButton("Submit");
	public JButton reset = new JButton("Reset");
	int firstInt = 0;
	int secondInt = 0;
	int thirdInt = 0;
	int fourthInt = 0;
	public int[] dotList = new int[4];

	Helper helper = new Helper();

	public GuessView(GuessModel model, Controller controller) {
		this.model = model;
		this.controller = controller;
		setLayout(null);

		if (!model.isCorrect) {
			firstClick.setBounds(25, 40, 25, 25);
			secondClick.setBounds(75, 40, 25, 25);
			thirdClick.setBounds(125, 40, 25, 25);
			fourthClick.setBounds(175, 40, 25, 25);
			Submit.setBounds(225, 35, 75, 15);
			reset.setBounds(225, 55, 75, 15);

			firstClick.addActionListener(new plusActionListener(firstClick, firstInt));
			secondClick.addActionListener(new plusActionListener(secondClick, secondInt));
			thirdClick.addActionListener(new plusActionListener(thirdClick, thirdInt));
			fourthClick.addActionListener(new plusActionListener(fourthClick, fourthInt));

			Submit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Submit");
					model.Guess1 = helper.getCorrectIntByColor(firstClick.getBackground());
					model.Guess2 = helper.getCorrectIntByColor(secondClick.getBackground());
					model.Guess3 = helper.getCorrectIntByColor(thirdClick.getBackground());
					model.Guess4 = helper.getCorrectIntByColor(fourthClick.getBackground());
					controller.CheckModel(model);

					repaint();
				}
			});

			reset.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					firstInt = 0;
					secondInt = 0;
					thirdInt = 0;
					fourthInt = 0;

					firstClick.setBackground(helper.getCorrectColor(firstInt));
					secondClick.setBackground(helper.getCorrectColor(secondInt));
					thirdClick.setBackground(helper.getCorrectColor(thirdInt));
					fourthClick.setBackground(helper.getCorrectColor(fourthInt));

				}
			});

			add(firstClick);
			add(secondClick);
			add(thirdClick);
			add(fourthClick);
			add(Submit);
			add(reset);
		}

		setVisible(true);

	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g.setColor(Color.gray);

		g.fillRect(0, 0, getWidth(), getHeight());

		if (model.isGuessed) {
			System.out.println("Model is guessed");
			int firstX = 30;
			int secondX = 40;
			int firstY = 5;
			int secondY = 15;

			int x = 330;
			int y = 30;

			g.setColor(Color.black);
			g.drawRect(325, 25, 75, 50);
			g.setColor(Color.green);
			g.fillRect(325, 25, 75, 50);

			for (int i = 0; i < dotList.length; i++) {
				int dot = dotList[i];
				if (dot == 0) {
					g.setColor(Color.black);
					g.fillOval(x, y, 8, 8);
				} else if (dot == 1) {
					g.setColor(Color.white);
					g.fillOval(x, y, 8, 8);
				}

				if (x == 350) {
					y += 10;
					x = 330;
				} else {
					x += 20;
				}

			}

		}
	}

	public void setBullsAndCrows() {
		System.out.println("Bulls: " + model.bulls);
		System.out.println("Crows: " + model.crows);

		int[] dotList = new int[4];

		for (int i = 0; i < dotList.length; i++) {
			dotList[i] = 1;
		}

		for (int i = 0; i < model.bulls; i++) {
			dotList[i] = 0;
		}

		this.dotList = dotList;
	}

}

class plusActionListener implements ActionListener {

	private JButton button;
	private int number;
	private Helper helper = new Helper();

	public plusActionListener(JButton button, int number) {
		this.button = button;
		this.number = number;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		number++;

		if (number > 4) {
			number = 1;
		}

		button.setBackground(helper.getCorrectColor(number));
	}

}
