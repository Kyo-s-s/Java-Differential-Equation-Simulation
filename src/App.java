import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Image;

public class App extends JFrame {
    public static void main(String[] args) throws Exception {
        new App();
    }

    public App() {
        setSize(500, 500);
        setTitle("Differential Equations Simulator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Panel panel = new Panel();
        Container container = getContentPane();
        container.add(panel);
        setVisible(true);
    }
}
