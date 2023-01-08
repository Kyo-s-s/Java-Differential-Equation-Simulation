import java.awt.*;
import javax.swing.*;

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
