package Mastermind;

public class GuessModel {
	public int Guess1 = 0;
	public int Guess2 = 0;
	public int Guess3 = 0;
	public int Guess4 = 0;
	public int bulls; // aantal goed geraden pinnetjes
	public int crows; // aantal juiste pinnetjes maar niet op de goed plek
	public boolean isCorrect = false;
	public boolean isGuessed = false;

	public GuessModel() {

	}

	public GuessModel(int guess1, int guess2, int guess3, int guess4, boolean isCorrect) {
		this.Guess1 = guess1;
		this.Guess2 = guess2;
		this.Guess3 = guess3;
		this.Guess4 = guess4;
		this.isCorrect = isCorrect;
	}

	public void setGuess1(int guess) {
		this.Guess1 = guess;
	}

	public void setGuess2(int guess) {
		this.Guess2 = guess;
	}

	public void setGuess3(int guess) {
		this.Guess3 = guess;
	}

	public void setGuess4(int guess) {
		this.Guess4 = guess;
	}

	public void checkCorrectAmount(GuessModel model) {
		System.out.println("Checking model");
		if (model.Guess1 == Guess1) {
			bulls++;
		}
		if (model.Guess2 == Guess2) {
			bulls++;
		}
		if (model.Guess3 == Guess3) {
			bulls++;
		}
		if (model.Guess4 == Guess4) {
			bulls++;
		}

		if (model.Guess1 == Guess2 || model.Guess1 == Guess3 || model.Guess1 == Guess4) {
			crows++;
		}

		if (model.Guess2 == Guess1 || model.Guess1 == Guess3 || model.Guess1 == Guess4) {
			crows++;
		}

		if (model.Guess3 == Guess1 || model.Guess1 == Guess2 || model.Guess1 == Guess4) {
			crows++;
		}

		if (model.Guess4 == Guess1 || model.Guess1 == Guess2 || model.Guess1 == Guess3) {
			crows++;
		}
	}

}
