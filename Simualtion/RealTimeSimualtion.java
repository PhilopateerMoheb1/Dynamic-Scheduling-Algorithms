package processmanager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 @author : Philopateer Moheb
 * performs instant simulation on a Graphics2D graph 
 */

public class RealTimeSimualtion extends JPanel implements Simulation {
    private OpQueue queue;
    private Graphics2D graph;
    private BufferedImage image; // Buffered image as consturctor
    private int previousID;
    // private RealTimeRectanglesDrawing r;
    ArrayList<Rectangle> rectangles = new ArrayList<>();
    ArrayList<TextCoordinates> texStrings = new ArrayList<>();// to make string with coordinates
    private Operation o21;
    private int currX;
    private int currY;
    public static final int defX = 25;
    public static final int defY = 50;
    private int currTime;
    public int clock;

    // constructor
    public RealTimeSimualtion(OpQueue queue) {
        image = new BufferedImage(5000, 150, BufferedImage.TYPE_INT_RGB);
        graph = image.createGraphics();
        graph.fillRect(0, 0, (4000 + 100) * defX, 5000);
        // r = new RealTimeRectanglesDrawing();
        // graph = image.createGraphics();
        rectangles = new ArrayList<>();
        texStrings = new ArrayList<>();
        currX = defX;
        currY = defY;
        this.queue = queue;
    }

    public synchronized BufferedImage render() {
        // if (image == null) {
        // image = new BufferedImage(420, 150, BufferedImage.TYPE_INT_RGB);
        // graph = (Graphics2D) image.createGraphics();
        // r = new RealTimeRectanglesDrawing();
        // }
        // r.drawRectangles(graph);
        // r = new RealTimeRectanglesDrawing();
        // repaint();
        return image;
    }

    @Override
    public OpQueue getQueue() {
        return queue;
    }

    // steps only 1 time unit which is not supported in Instant Simulation
    @Override
    public synchronized void step() {
        o21 = queue.consumeTimeUnit();
        graph = image.createGraphics();
        graph.setFont(new Font("TimesRoman", Font.BOLD, 12));
        // graph.fillRect(0, 0, (4000 + 100) * defX, 5000);
        graph.setColor(Color.black);
        if (o21 == null) {
            // width = defX;
            Rectangle rectangle = new Rectangle(currX + 20, currY + 20, defX, defY);
            rectangles.add(rectangle);
            TextCoordinates tCoordinates = new TextCoordinates(clock + "", new Point(currX + 20, currY + defY + 40));
            texStrings.add(tCoordinates);
            clock++;
            currX += defX;
        } else if (o21 != null) {
            Rectangle rectangle = new Rectangle(currX + 20, currY + 20, defX, defY);
            rectangles.add(rectangle);
            TextCoordinates tCoordinates = new TextCoordinates(clock + "", new Point(currX + 20, currY + defY + 40));
            texStrings.add(tCoordinates);
            clock++;
            TextCoordinates tCoordinates1 = new TextCoordinates("P" + o21.getID(),
                    new Point((int) rectangle.getCenterX() - 5, (int) rectangle.getCenterY()));
            texStrings.add(tCoordinates1);
            currX += defX;
        }
        for (int i = 0; i < rectangles.size(); i++) {
            graph.draw(rectangles.get(i));
        }
        for (int i = 0; i < texStrings.size(); i++) {
            graph.drawString(texStrings.get(i).getText(), (int) texStrings.get(i).getCoordinates().getX(),
                    (int) texStrings.get(i).getCoordinates().getY());

        }
        repaint();
    }

    @Override
    synchronized public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    // public class RealTimeRectanglesDrawing extends JPanel {

    // // Graphics g;

    // // private RealTimeRectanglesDrawing() {
    // // super();
    // // getContentPane().setBackground(Color.black);
    // // setSize(480, 200);
    // // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // // setLocationRelativeTo(null);

    // // }

    // /*
    // * ---------------------------------------- P1 | P2 | P1| P4 |
    // * ----------------------------------------
    // */
    // private synchronized void drawRectangles(Graphics g, Operation o21, int
    // clock) {
    // // int width, x = defX, y = defY;
    // graph = (Graphics2D) g;
    // graph.setFont(new Font("TimesRoman", Font.BOLD, 12));
    // graph.setColor(Color.black);
    // if (o21 == null) {
    // // width = defX;
    // graph.drawRect(currX, currY, defX, currY);
    // graph.drawString(clock + "", currX, currY + defY + 15);
    // clock += 1;
    // currX += defX;
    // } else if (o21 != null) {
    // graph.drawRect(currX, currY, defX, currY);
    // graph.drawString(clock + "", currX, currY + defY + 15);
    // clock++;
    // graph.drawString("P" + o21.getID(), currX + (1 / 2.f - 0.2f) * defX, 1.5f *
    // currY);
    // graph.drawString(clock + "", currX, currY + defY + 15);
    // currX += defX;
    // }
    // // TimeUnit.SECONDS.sleep(1);
    // // o21 = q.consumeTimeUnit();

    // // graph.drawString(clock + "", x, y + defY + 15);
    // // width = o21.getExecutionTime() * defX;
    // // graph.drawRect(x, y, width, y);
    // // graph.drawString(clock + "", x, y + defY + 15);
    // // clock += o21.getExecutionTime();
    // // x += width;
    // // graph.drawString("P" + o21.getID(), x - (currTime / 2.f) * defX, 1.5f *
    // // y);
    // // graph.drawString(clock + "", x, y + defY + 15);
    // }
    // // code to draw rectangles goes here...

    // public synchronized void paint(Graphics g) {
    // super.paint(g);
    // drawRectangles(g, o21, clock);
    // }

    // }

    public static void main(String[] args) {
        FCFSQ q = new FCFSQ();
        Operation o1 = new Operation(1, 4, 5);
        Operation o2 = new Operation(2, 25, 7);
        Operation o3 = new Operation(3, 4, 7);
        Operation o4 = new Operation(4, 0, 10);
        q.enqueue(o1);
        q.enqueue(o2);
        q.enqueue(o3);
        q.enqueue(o4);
        RealTimeSimualtion simulation = new RealTimeSimualtion(q);

        JFrame frame = new JFrame("Real Time Simulation");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton stepButton = new JButton("Step");
        stepButton.addActionListener(e -> {
            simulation.step();
            simulation.render();
            frame.repaint();
        });

        JPanel panel = new JPanel();
        panel.add(stepButton);
        frame.add(panel);
        frame.setVisible(true);
    }
}