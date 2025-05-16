package me.yurinero.RandomExploration.gui;

import javax.swing.*;
import java.awt.*;

/* This package contains some fairly disgusting boilerplate SWING GUI code.
* I fully admit I barely understand it, as I can't be bothered learning a legacy library right now, but it serves the purpose for an example program.
*/

public class MainFrame extends JFrame {

	public MainFrame() {
		super("Random Number Explorer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLayout(new BorderLayout());

		DisplayPanel displayPanel = new DisplayPanel();
		ControlPanel controlPanel = new ControlPanel(displayPanel);

		add(controlPanel, BorderLayout.WEST);
		add(displayPanel, BorderLayout.CENTER);
	}

	public void initialize() {
		setVisible(true);
	}
}