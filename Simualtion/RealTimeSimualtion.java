package Simualtion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.naming.OperationNotSupportedException;

/*
 * @author : Philopateer Moheb
 * performs instant simulation on a Graphics2D graph 
 */

public class RealTimeSimualtion implements Simulation {
    private OpQueue queue;
    private Graphics2D graph;
    public static final int defX = 25; // default width (1 second = 25pixels )
    public static final int defY = 50; // default length

    // constructor
    public RealTimeSimualtion(OpQueue queue) {
        this.queue = queue;
    }

    @Override
    public Graphics2D render() {
        // setting font and color
        graph.setFont(new Font("TimesRoman", Font.BOLD, 12));
        graph.setColor(Color.BLACK);
        // declaring local variables x,y coordinate , clock to accumulate time
        int width, x = defX, y = defY, clock = 0;
        Operation o21 = null; // operation instance set to null
        // handle null cases in the beginning (idle processor)
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
        int previousID = o21.getID(), currTime = 0;
        // handles rest of processes
        do {
            // handles null cases in the middle
            if (o21 == null) {
                // render previous process
                if (previousID != -1) {
                    width = currTime * defX;
                    graph.drawRect(x, y, width, y);
                    graph.drawString(clock + "", x, y + defY + 15);
                    clock += currTime;
                    x += width;
                    graph.drawString("P" + previousID, x - (currTime / 2.f) * defX, 1.5f * y);

                }
                // render current null
                width = defX;
                graph.drawRect(x, y, width, y);
                graph.drawString(clock + "", x, y + defY + 15);
                clock += 1;
                x += width;
                previousID = -1;
            }
            // process is not yet finished so accumulate time
            else if (o21 != null && o21.getID() == previousID)
                currTime++;
            // a process which is not NULL has finished so it is now rendered
            else if (o21 != null && o21.getID() != previousID && previousID != -1) {
                width = currTime * defX;
                graph.drawRect(x, y, width, y);
                graph.drawString(clock + "", x, y + defY + 15);
                clock += currTime;
                x += width;
                graph.drawString("P" + previousID, x - (currTime / 2.f) * defX, 1.5f * y);
                currTime = 1;
                previousID = o21.getID();
            }
            // consume another time unit
            o21 = queue.consumeTimeUnit();
        } while (!queue.isEmpty());
        // renders last process
        graph.drawString(clock + "", x, y + defY + 15);
        width = o21.getTimeLeft() * defX;
        graph.drawRect(x, y, width, y);
        graph.drawString(clock + "", x, y + defY + 15);
        clock += o21.getTimeLeft();
        x += width;
        graph.drawString("P" + o21.getID(), x - (currTime / 2.f) * defX, 1.5f * y);
        // renders last clock of process
        graph.drawString(clock + "", x, y + defY + 15);
        return graph;
    }

    @Override
    public OpQueue getQueue() {
        return queue;
    }

    // steps only 1 time unit which is not supported in Instant Simulation
    @Override
    public void step() throws OperationNotSupportedException {

    }

}