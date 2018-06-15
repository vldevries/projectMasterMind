package Mastermind;

import static org.junit.Assert.*;

import java.awt.Color;

public class Test {

	@org.junit.Test
	public void ControllerTest() {
		Controller controller = new Controller();
		GuessModel correctModel = new GuessModel(1, 2, 3, 4, true);
		controller.correctModel = correctModel;

		GuessModel model = new GuessModel(1, 2, 3, 4, false);

		controller.CheckModel(model);

		assertEquals(4, model.bulls);
		assertEquals(0, model.crows);
	}

	@org.junit.Test
	public void ControllerTestWrongUserInput() {
		Controller controller = new Controller();
		GuessModel correctModel = new GuessModel(1, 2, 3, 4, true);
		controller.correctModel = correctModel;

		GuessModel model = new GuessModel(1, 2, 3, 2, false);

		controller.CheckModel(model);

		assertEquals(3, model.bulls);
		assertEquals(0, model.crows);
	}

	@org.junit.Test
	public void HelperTest1() {
		Helper helper = new Helper();

		Color helperColor = helper.getCorrectColor(1);

		assertEquals(Color.red.hashCode(), helperColor.hashCode());
	}

	@org.junit.Test
	public void HelperTest2() {
		Helper helper = new Helper();

		Color helperColor = helper.getCorrectColor(2);

		assertEquals(Color.blue.hashCode(), helperColor.hashCode());
	}

	@org.junit.Test
	public void HelperTest3() {
		Helper helper = new Helper();

		Color helperColor = helper.getCorrectColor(3);

		assertEquals(Color.green.hashCode(), helperColor.hashCode());
	}

	@org.junit.Test
	public void HelperTest4() {
		Helper helper = new Helper();

		Color helperColor = helper.getCorrectColor(4);

		assertEquals(Color.yellow.hashCode(), helperColor.hashCode());
	}

	@org.junit.Test
	public void HelperTest5() {
		Helper helper = new Helper();

		Color helperColor = helper.getCorrectColor(0);

		assertEquals(Color.gray.hashCode(), helperColor.hashCode());
	}

}
