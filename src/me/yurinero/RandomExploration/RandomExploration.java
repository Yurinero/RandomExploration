package me.yurinero.RandomExploration;

import me.yurinero.RandomExploration.gui.MainFrame;
import javax.swing.*;


public class RandomExploration {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			MainFrame mainFrame = new MainFrame();
			mainFrame.initialize();


		});
	}
}




