package Simualtion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.naming.OperationNotSupportedException;

import org.hamcrest.Condition.Step;

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
    public BufferedImage render() {
        BufferedImage image = new BufferedImage(420, 150, BufferedImage.TYPE_INT_RGB);
        graph = (Graphics2D) image.getGraphics();
        return image;
    }

    @Override
    public OpQueue getQueue() {
        return queue;
    }

    // steps only 1 time unit which is not supported in Instant Simulation
    @Override
    public void step() {
        // declaring local variables x,y coordinate , clock to accumulate time
        int width, x = defX, y = defY, clock = 0;
        graph.setFont(new Font("TimesRoman", Font.BOLD, 12));
        graph.setColor(Color.BLACK);
        Operation o21 = null;
        if (!queue.isEmpty() && o21 == null) {
            o21 = queue.consumeTimeUnit();
            if (o21 == null) {
                width = defX;
                graph.drawRect(x, y, defX, y);
                graph.drawString(clock + "", x, y + defY + 15);
                clock += 1;
                x += width;
            }
        }
        int previousID = o21.getID(), currTime = 0;

        if (!queue.isEmpty()) {
            o21 = queue.consumeTimeUnit();
            if (o21 == null) {
                // as when it null and first acces it previuousID will not
                if (previousID != -1) {
                    graph.drawRect(x, y, defX, y);
                    graph.drawString(clock + "", x, y + defY + 15);
                    clock++;
                    graph.drawString("P" + previousID, x + (1 / 2.f - 0.2f) * defX, 1.5f * y);
                    x += defX;
                    currTime++;
                    // printPreviousIfNullFlag = false ;
                }
                // else
                // printPreviousIfNullFlag = true ;
                // width = defX;
                graph.drawRect(x, y, defX, y);
                graph.drawString(clock + "", x, y + defY + 15);
                clock += 1;
                // x += width;
                previousID = -1;
            } else if (o21 != null && o21.getID() == previousID) {
                // width = currTime * defX;
                graph.drawRect(x, y, defX, y);
                graph.drawString(clock + "", x, y + defY + 15);
                clock++;
                graph.drawString("P" + previousID, x + (1 / 2.f - 0.2f) * defX, 1.5f * y);
                x += defX;
                currTime++;
                previousID = o21.getID();
            } else if (o21 != null && o21.getID() != previousID && previousID != -1) {
                graph.drawRect(x, y, defX, y);
                graph.drawString(clock + "", x, y + defY + 15);
                clock++;
                graph.drawString("P" + previousID, x + (1 / 2.f - 0.2f) * defX, 1.5f * y);
                x += defX;
                currTime = 1;
                previousID = o21.getID();
            }
            // TimeUnit.SECONDS.sleep(1);
            // o21 = q.consumeTimeUnit();
        }

        graph.drawString(clock + "", x, y + defY + 15);
        width = o21.getExecutionTime() * defX;
        graph.drawRect(x, y, width, y);
        graph.drawString(clock + "", x, y + defY + 15);
        clock += o21.getExecutionTime();
        x += width;
        graph.drawString("P" + o21.getID(), x - (currTime / 2.f) * defX, 1.5f *
                y);
        graph.drawString(clock + "", x, y + defY + 15);

    }

}