import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Panel extends JPanel implements ActionListener, MouseListener {

    final int WIDTH = 500;
    final int HEIGHT = 500;
    double prevv[][] = new double[WIDTH][HEIGHT];
    double prev[][] = new double[WIDTH][HEIGHT];
    double curr[][] = new double[WIDTH][HEIGHT];
    double v = 0.5;
    double dt = 0.1;
    double dx = 0.1;
    double dy = 0.1;
    Timer timer;

    public Panel() {
        addMouseListener(this);

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                prevv[i][j] = 0;
                prev[i][j] = 0;
                curr[i][j] = 0;
            }
        }

        timer = new Timer(10, this);
        timer.start();
    }

    public void mousePressed(MouseEvent e) {

    }

    Color calcColor(double x) {
        final double min = -1.5;
        final double max = 1.5;
        if (x < min) {
            return Color.BLACK;
        } else if (x > max) {
            return Color.WHITE;
        } else {
            int r = (int) (255 * (x - min) / (max - min));
            return new Color(r, r, r);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                g.setColor(calcColor(curr[i][j]));
                g.fillRect(i, j, 1, 1);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                prevv[x][y] = prev[x][y];
                prev[x][y] = curr[x][y];
            }
        }

        for (int x = 1; x < WIDTH - 1; x++) {
            for (int y = 1; y < HEIGHT - 1; y++) {
                curr[x][y] = v * v * dt * dt
                        * ((prev[x + 1][y] - 2 * prev[x][y] + prev[x - 1][y]) / (dx * dx)
                                + (prev[x][y + 1] - 2 * prev[x][y] + prev[x][y - 1]) / (dy * dy))
                        + 2 * prev[x][y] - prevv[x][y];
            }
        }

        repaint();
    }

    double f(double x, double y) {
        return Math.exp(-(x * x + y * y) / 0.1);
    }

    public void mouseClicked(MouseEvent e) {
        for (int i = -100; i <= 100; i++) {
            for (int j = -100; j <= 100; j++) {
                if (e.getX() + i >= 0 && e.getX() + i < WIDTH && e.getY() + j >= 0 && e.getY() + j < HEIGHT) {
                    curr[e.getX() + i][e.getY() + j] += f(i * dx, j * dy);
                }
            }
        }
        actionPerformed(null);
    }

    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
