package me.yurinero.RandomExploration.gui;

import me.yurinero.RandomExploration.logic.BasicRandom;
import me.yurinero.RandomExploration.logic.PasswordGen;
import me.yurinero.RandomExploration.logic.SafeRandom;
import me.yurinero.RandomExploration.logic.UserTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
	private final DisplayPanel displayPanel;
	private final BasicRandom basicRandom;
	private final PasswordGen passwordGen;
	private final UserTime userTime;
	private final SafeRandom safeRandom;

	public ControlPanel(DisplayPanel displayPanel) {
		this.displayPanel = displayPanel;

		this.basicRandom = new BasicRandom();
		this.passwordGen = new PasswordGen();
		this.userTime = new UserTime();
		this.safeRandom = new SafeRandom();

		setupUI();
	}

	private void setupUI() {
		setLayout(new GridLayout(7, 1));
		setPreferredSize(new Dimension(250, 100));

		// The below is intentionally a bit dense. In a "normal" code base I would most likely split it across multiple lines for each function.
		JButton buttonUnboundRandom = createButton("Generate Unbound Random Number", () -> "Result: " + basicRandom.getUnboundedRandom());
		JButton buttonBoundRandom = createButton("Bound Random Number (0-100)", () -> "Result: " + basicRandom.getBoundedRandom());
		JButton buttonSafeRandom = createButton("Safe Random Number", () -> "Result: " + safeRandom.getSafeRandomLong());
		JButton buttonMultipliedRandom = createButton("Multiplied Random Number", () -> "Result: " + basicRandom.multipliedRandom());
		JButton buttonLocalDateTime = createButton("Local Date/Time", () -> "Your Date & Time: " + userTime.getFormattedUserDateTime());
		JButton buttonEpochTime = createButton("Epoch Time", () -> "Epoch Time: " + userTime.getEpochSecond());
		JButton buttonPassword = createButton("Generate Password", () -> "Password: " + passwordGen.generatePassword(16));
        // Ditto
		add(buttonUnboundRandom); add(buttonBoundRandom); add(buttonSafeRandom); add(buttonMultipliedRandom);
		add(buttonPassword); add(buttonLocalDateTime); add(buttonEpochTime);
	}

	private JButton createButton(String text, ResultSupplier action) {
		JButton button = new JButton(text);
		button.addActionListener(e ->
				displayPanel.setResult(action.getResult())
		);
		return button;
	}

	@FunctionalInterface
	private interface ResultSupplier {
		String getResult();
	}
}