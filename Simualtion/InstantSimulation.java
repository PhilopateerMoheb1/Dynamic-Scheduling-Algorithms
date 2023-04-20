package Simualtion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Iterator;

import javax.naming.OperationNotSupportedException;
import javax.swing.JFrame;

/*
 * @author : Mina Mounir
 * performs instant simulation on a Graphics2D graph 
 */
public class InstantSimulation implements Simulation {

	private OpQueue queue;
	private Graphics2D graph;

	public InstantSimulation(OpQueue queue) {
		this.queue = queue;
	}

	@Override
	public BufferedImage render() {

		BufferedImage image = new BufferedImage(420, 150, BufferedImage.TYPE_INT_RGB);
		graph = (Graphics2D) image.getGraphics();
		RectanglesDrawing r = new RectanglesDrawing();
		r.drawRectangles(graph);

		return image;
	}

	@Override
	public OpQueue getQueue() {
		return queue;
	}

	@Override
	public void step() throws OperationNotSupportedException {
		throw new OperationNotSupportedException("not supported in instant simulation");

	}

	private class RectanglesDrawing extends JFrame {

		private static final int defX = 25;
		private static final int defY = 50;

		private RectanglesDrawing() {
			super("Rectangles Drawing Demo");

			getContentPane().setBackground(Color.WHITE);
			setSize(480, 200);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);

		}

		private void drawRectangles(Graphics g) {
			int width, x = defX, y = defY, clock = 0;
			graph = (Graphics2D) g;
			graph.setColor(Color.WHITE);
			graph.fillRect(0, 0, 500, 500);
			graph.setFont(new Font("TimesRoman", Font.BOLD, 12));
			graph.setColor(Color.BLACK);
			Operation o21 = null;
			while (!queue.isEmpty() && o21 == null) {
				o21 = queue.consumeTimeUnit();
				if (o21 == null) {
					width = defX;
					graph.drawRect(x, y, width, y);
					graph.drawString(clock + "", x, y + defY + 15);
					clock += 1;
					x += width;
				}

			}
			int previousID = o21.getID(), currTime = 1;

			while (!queue.isEmpty()) {
				o21 = queue.consumeTimeUnit();
				if (o21 == null) {
					if (previousID != -1) {
						width = currTime * defX;
						graph.drawRect(x, y, width, y);
						graph.drawString(clock + "", x, y + defY + 15);
						clock += currTime;
						x += width;
						graph.drawString("P" + previousID, x - (currTime / 2.f) * defX, 1.5f * y);

					}

					width = defX;
					graph.drawRect(x, y, width, y);
					graph.drawString(clock + "", x, y + defY + 15);
					clock += 1;
					x += width;
					previousID = -1;
				} else if (o21 != null && o21.getID() == previousID) {
					currTime++;
				} else if (o21 != null && o21.getID() != previousID && previousID != -1) {
					width = currTime * defX;
					graph.drawRect(x, y, width, y);
					graph.drawString(clock + "", x, y + defY + 15);
					clock += currTime;
					x += width;
					graph.drawString("P" + previousID, x - (currTime / 2.f) * defX, 1.5f * y);
					currTime = 1;
					previousID = o21.getID();
				}

			}

			graph.drawString(clock + "", x, y + defY + 15);
			width = o21.getExecutionTime() * defX;
			graph.drawRect(x, y, width, y);
			graph.drawString(clock + "", x, y + defY + 15);
			clock += o21.getExecutionTime();
			x += width;
			graph.drawString("P" + o21.getID(), x - (currTime / 2.f) * defX, 1.5f * y);
			graph.drawString(clock + "", x, y + defY + 15);
		}

		public void paint(Graphics g) {
			super.paint(g);
			drawRectangles(g);
		}

	}
}
