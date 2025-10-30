import java.awt.*;
import java.awt.event.*;

public class Question1 extends Frame {

    public Question1() {
        // Frame title
        setTitle("My shapes");
        setSize(400, 300);
        setLayout(null);
        setBackground(Color.white);

        // Handle window close (clicking X button)
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0); // Close the app
            }
        });

        setVisible(true);
    }

    public void paint(Graphics g) {
        // Set drawing color
        g.setColor(new Color(165, 82, 0)); // Brown color

        // Draw face
        g.drawOval(150, 100, 100, 100); // Circle face

        // Draw eyes
        g.fillOval(175, 130, 15, 15);
        g.fillOval(210, 130, 15, 15);

        // Draw smile
        g.drawArc(175, 150, 50, 30, 180, 180);
    }

    public static void main(String[] args) {
        new Question1();
    }
}
