package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JTextArea;
import javax.swing.border.AbstractBorder;

/**
 * retirado e adaptado de: http://www.guj.com.br/posts/list/123003.java#665398 <br>
 */
class NumberedBorder extends AbstractBorder {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5089118025935944759L;

	private static int lineHeight;
	private final int characterHeight = 8;
	private final int characterWidth = 7;
	private final Color myColor;

	NumberedBorder() {
		myColor = new Color(164, 164, 164);
	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		JTextArea textArea = (JTextArea) c;
		Font font = textArea.getFont();
		FontMetrics metrics = g.getFontMetrics(font);
		lineHeight = metrics.getHeight();

		Color oldColor = g.getColor();
		g.setColor(myColor);

		double r = (double) height / (double) lineHeight;
		int rows = (int) (r + 0.5);
		String str = String.valueOf(rows);
		int lineLeft = calculateLeft(height) + 10;

		int px = 0;
		int py = 0;
		int lenght = 0;

		int visibleLines = textArea.getHeight() / lineHeight;
		for (int i = 0; i < visibleLines; i++) {

			str = String.valueOf(i + 1);
			lenght = str.length();

			py = lineHeight * i + 14;
			px = lineLeft - (characterWidth * lenght) - 2;

			g.drawString(str, px, py);
		}

		g.drawLine(lineLeft, 0, lineLeft, height);

		g.setColor(oldColor);
	}

	@Override
	public Insets getBorderInsets(Component c) {
		int left = calculateLeft(c.getHeight()) + 13;
		return new Insets(1, left, 1, 1);
	}

	private int calculateLeft(int height) {
		double r = (double) height / (double) lineHeight;
		int rows = (int) (r + 0.5);
		String str = String.valueOf(rows);
		int lenght = str.length();
		return characterHeight * lenght;
	}
}


/* como usar com um JTextArea:
JTextArea  = new JTextArea();
txt.setBorder(new NumberedBorder());
*/