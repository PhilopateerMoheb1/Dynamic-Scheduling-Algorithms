package Simualtion;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class RealTimeSimualtionRectanglesDrawingExample extends JFrame {
    public static final int defX = 25;
    public static final int defY = 50;

    public RealTimeSimualtionRectanglesDrawingExample() {
        super("Rectangles Drawing Demo");

        getContentPane().setBackground(Color.WHITE);
        setSize(480, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    /*
     * ---------------------------------------- P1 | P2 | P1| P4 |
     * ----------------------------------------
     */
    void drawRectangles(Graphics g) {
        int width, x = defX, y = defY, clock = 0;
        PreemptiveSJFQ q = new PreemptiveSJFQ();
        Operation o1 = new Operation(1, 4, 5);
        Operation o2 = new Operation(2, 25, 7);
        Operation o3 = new Operation(3, 4, 7);
        Operation o4 = new Operation(4, 0, 10);
        q.enqueue(o1);
        q.enqueue(o2);
        q.enqueue(o3);
        q.enqueue(o4);
        InstantSimulation is = new InstantSimulation(q);
        is.graph = (Graphics2D) g;
        is.graph.setFont(new Font("TimesRoman", Font.BOLD, 12));
        is.graph.setColor(Color.BLACK);
        Operation o21 = null;
        while (!q.isEmpty() && o21 == null) {
            o21 = q.consumeTimeUnit();
            if (o21 == null) {
                width = defX;
                is.graph.drawRect(x, y, width, y);
                is.graph.drawString(clock + "", x, y + defY + 15);
                clock += 1;
                x += width;
            }
        }
        int previousID = o21.getID(), currTime = 0;

        do {
            Operation o21Temp = o21;
            o21 = q.consumeTimeUnit();
            if (o21 == null) {
                if (o21Temp.getID() == previousID && o21Temp != null) {
                    is.graph.drawRect(x, y, defX, y);
                    is.graph.drawString(clock + "", x, y + defY + 15);
                    clock++;
                    is.graph.drawString("P" + previousID, x + (1 / 2.f - 0.2f) * defX, 1.5f * y);
                    x += defX;
                    currTime++;
                }

                // else
                // printPreviousIfNullFlag = true ;
                width = defX;
                is.graph.drawRect(x, y, width, y);
                is.graph.drawString(clock + "", x, y + defY + 15);
                clock += 1;
                x += width;
                previousID = -1;
            } // defx width of rectangle and increment clock by 1
            else if (o21 != null && o21.getID() == previousID) {
                width = currTime * defX;
                is.graph.drawRect(x, y, defX, y);
                is.graph.drawString(clock + "", x, y + defY + 15);
                clock++;
                is.graph.drawString("P" + previousID, x + (1 / 2.f - 0.2f) * defX, 1.5f * y);
                x += defX;
                currTime++;
                previousID = o21.getID();
            } else if (o21 != null && o21.getID() != previousID && previousID != -1) {
                width = currTime * defX;
                is.graph.drawRect(x, y, defX, y);
                is.graph.drawString(clock + "", x, y + defY + 15);
                clock++;
                is.graph.drawString("P" + previousID, x + (1 / 2.f - 0.2f) * defX, 1.5f * y);
                x += defX;
                currTime = 1;
                previousID = o21.getID();
            }

        } while (!q.isEmpty());

        is.graph.drawString(clock + "", x, y + defY + 15);
        width = o21.getExecutionTime() * defX;
        is.graph.drawRect(x, y, width, y);
        is.graph.drawString(clock + "", x, y + defY + 15);
        clock += o21.getExecutionTime();
        x += width;
        is.graph.drawString("P" + o21.getID(), x - (currTime / 2.f) * defX, 1.5f * y);
        is.graph.drawString(clock + "", x, y + defY + 15);
    }
    // code to draw rectangles goes here...

    public void paint(Graphics g) {
        super.paint(g);
        drawRectangles(g);
    }

    public static void main(String[] args) throws Exception {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RealTimeSimualtionRectanglesDrawingExample().setVisible(true);
            }
        });
    }
}