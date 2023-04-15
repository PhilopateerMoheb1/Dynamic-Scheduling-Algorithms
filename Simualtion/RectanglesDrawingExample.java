package Simualtion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class RectanglesDrawingExample extends JFrame {
    public static final int defX = 25;
    public static final int defY = 50;

    public RectanglesDrawingExample() {
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
        FCFSQ q = new FCFSQ();
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
            if (o21 == null) {
                if (previousID != -1) {
                    width = currTime * defX;
                    is.graph.drawRect(x, y, width, y);
                    is.graph.drawString(clock + "", x, y + defY + 15);
                    clock += currTime;
                    x += width;
                    is.graph.drawString("P" + previousID, x - (currTime / 2.f) * defX, 1.5f * y);
                    // printPreviousIfNullFlag = false ;
                }
                // else
                // printPreviousIfNullFlag = true ;
                width = defX;
                is.graph.drawRect(x, y, width, y);
                is.graph.drawString(clock + "", x, y + defY + 15);
                clock += 1;
                x += width;
                previousID = -1;
            } else if (o21 != null && o21.getID() == previousID)
                currTime++;
            else if (o21 != null && o21.getID() != previousID && previousID != -1) {
                width = currTime * defX;
                is.graph.drawRect(x, y, width, y);
                is.graph.drawString(clock + "", x, y + defY + 15);
                clock += currTime;
                x += width;
                is.graph.drawString("P" + previousID, x - (currTime / 2.f) * defX, 1.5f * y);
                currTime = 1;
                previousID = o21.getID();
            }
            o21 = q.consumeTimeUnit();
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
                new RectanglesDrawingExample().setVisible(true);
            }
        });
    }
}