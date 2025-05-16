package me.yurinero.RandomExploration.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;


public class DisplayPanel extends JPanel {
	private final JLabel resultLabel;

	public DisplayPanel() {
		setLayout(new BorderLayout());
		resultLabel = new JLabel("Click a button to generate output. Right Click to Copy.", SwingConstants.CENTER);
		resultLabel.setPreferredSize(new Dimension(300, 50));

		// Add right-click copy menu
		resultLabel.setComponentPopupMenu(createCopyMenu());
		add(resultLabel, BorderLayout.CENTER);
	}

	private JPopupMenu createCopyMenu() {
		JPopupMenu menu = new JPopupMenu();
		JMenuItem copyItem = new JMenuItem("Copy Value");
		copyItem.addActionListener(this::handleCopyAction);
		menu.add(copyItem);
		return menu;
	}

	private void handleCopyAction(ActionEvent e) {
		String fullText = resultLabel.getText();
		// Extract value after colon (e.g., "Result: 42" → "42")
		String value = fullText.contains(": ")
				? fullText.split(": ")[1].trim()
				: fullText;

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(new StringSelection(value), null);
	}

	public void setResult(String result) {
		resultLabel.setText(result);
	}
}