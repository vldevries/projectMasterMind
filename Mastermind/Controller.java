package Mastermind;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import Mastermind.views.CorrectView;
import Mastermind.views.GuessView;

public class Controller extends JPanel {

	public static GuessView[] guessViews = new GuessView[8];
	public GuessModel[] guessModels = new GuessModel[8];
	static CorrectView correctView;
	static GuessModel correctModel;
	static int numberOfGuesses = 0;
	static GuessView currentView;

	Helper helper = new Helper();

	public Controller() {
		setLayout(new GridLayout(9, 1));

		correctModel = new GuessModel((int) (4 * Math.random()) + 1, (int) (4 * Math.random()) + 1,
				(int) (4 * Math.random()) + 1, (int) (4 * Math.random()) + 1, true);

		System.out.println(correctModel.Guess1 + " | " + correctModel.Guess2 + " | " + correctModel.Guess3 + " | "
				+ correctModel.Guess4);

		correctView = new CorrectView(correctModel);
		add(correctView);
		setBackground(Color.LIGHT_GRAY);
		for (int i = 0; i < guessModels.length; i++) {
			guessModels[i] = new GuessModel();
			guessViews[i] = new GuessView(guessModels[i], this);
			helper.setViewEditable(guessViews[i], false);
		}

		currentView = guessViews[guessViews.length - 1];

		helper.setViewEditable(currentView, true);

		for (int j = 0; j < guessViews.length; j++) {
			add(guessViews[j]);
		}

		setVisible(true);

	}

	public void CheckModel(GuessModel model) {

		model.checkCorrectAmount(correctModel);

		if (model.bulls == 4) {
			model.isCorrect = true;
			model.isGuessed = true;
			CorrectlyAnswered();
		} else {
			model.isCorrect = false;
			model.isGuessed = true;
			currentView.setBullsAndCrows();
		}

		if (model.bulls != 4) {
			numberOfGuesses++;
			helper.setViewEditable(currentView, false);
			currentView = guessViews[guessViews.length - (numberOfGuesses + 1)];
			helper.setViewEditable(currentView, true);
		}

	}

	public void CorrectlyAnswered() {
		helper.setViewEditable(currentView, false);
		correctModel.isGuessed = true;
		correctView.model = correctModel;
		correctView.label.setVisible(true);
		correctView.repaint();
		showFireWorks();
	}

	public void showFireWorks() {
	}

}
