package Mastermind;

import java.awt.Color;

import javax.swing.border.LineBorder;

import Mastermind.views.GuessView;

public class Helper {

	public Color getCorrectColor(int guess) {
		switch (guess) {
		case 1:
			return Color.red;
		case 2:
			return Color.blue;
		case 3:
			return Color.green;
		case 4:
			return Color.yellow;
		case 0:
			return Color.gray;
		default:
			return Color.gray;

		}
	}

	public int getCorrectIntByColor(Color color) {

		if (color == Color.red) {
			return 1;
		}
		if (color == Color.blue) {
			return 2;
		}
		if (color == Color.green) {
			return 3;
		}
		if (color == Color.yellow) {
			return 4;
		}
		if (color == Color.gray) {
			return 0;
		}
		return 0;

	}

	public void setViewEditable(GuessView view, boolean bool) {
		view.secondClick.setEnabled(bool);
		view.thirdClick.setEnabled(bool);
		view.fourthClick.setEnabled(bool);
		view.Submit.setEnabled(bool);
		view.reset.setEnabled(bool);

		if (bool) {
			view.firstClick.setEnabled(bool);
			LineBorder border = new LineBorder(Color.black, 2);
			view.firstClick.setBorder(border);
			view.secondClick.setBorder(border);
			view.thirdClick.setBorder(border);
			view.fourthClick.setBorder(border);
			view.Submit.setBorder(new LineBorder(Color.green, 2));
			view.reset.setBorder(new LineBorder(Color.red, 2));
			view.add(view.Submit);
			view.add(view.reset);
			view.repaint();
		}

		if (!bool) {
			view.firstClick.setBorder(null);
			view.secondClick.setBorder(null);
			view.thirdClick.setBorder(null);
			view.fourthClick.setBorder(null);
			view.remove(view.Submit);
			view.remove(view.reset);
		}
	}

}
