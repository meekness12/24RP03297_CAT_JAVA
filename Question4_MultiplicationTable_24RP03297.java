import java.awt.*;
import java.awt.event.*;

public class Question4_MultiplicationTable_24RP03297 extends Frame implements ActionListener {

    Label lblTitle;
    TextField txtNumber;
    Button btnDisplay;
    TextArea txtOutput;
    Panel mainPanel, inputPanel, outputPanel, headerPanel;

    public Question4_MultiplicationTable_24RP03297() {
        // Frame setup
        setTitle("AWT Practice");
        setSize(400, 400);
        setLayout(new BorderLayout());
        setBackground(Color.white);

        // ===== MAIN PANEL =====
        mainPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        mainPanel.setBackground(Color.white);

        // ===== INPUT PANEL =====
        inputPanel = new Panel(new FlowLayout());
        inputPanel.setBackground(new Color(20, 10, 20)); // orange background
        txtNumber = new TextField(10);
        txtNumber.setFont(new Font("Consolas", Font.BOLD, 16));
        txtNumber.setBackground(new Color(255, 18, 90));
        txtNumber.setForeground(Color.BLACK);
        inputPanel.add(txtNumber);

        // ===== BUTTON =====
        btnDisplay = new Button("DISPLAY");
        btnDisplay.setBackground(new Color(40, 90, 120)); // dark blue
        btnDisplay.setForeground(Color.WHITE);
        btnDisplay.setFont(new Font("Arial", Font.BOLD, 14));
        btnDisplay.setPreferredSize(new Dimension(100, 35));
        btnDisplay.addActionListener(this);
        mainPanel.add(inputPanel);
        mainPanel.add(btnDisplay);

        // ===== OUTPUT PANEL =====
        outputPanel = new Panel(new FlowLayout());
        outputPanel.setBackground(new Color(230, 120, 20)); // orange background
        txtOutput = new TextArea(10, 20);
        txtOutput.setFont(new Font("Consolas", Font.PLAIN, 14));
        txtOutput.setBackground(new Color(230, 120, 20));
        txtOutput.setForeground(Color.BLACK);
        txtOutput.setEditable(false);
        outputPanel.add(txtOutput);

        // Add to frame
        mainPanel.add(outputPanel);
        add(mainPanel, BorderLayout.CENTER);

        // Window close handling
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDisplay) {
            try {
                int n = Integer.parseInt(txtNumber.getText());
                StringBuilder table = new StringBuilder();
                for (int i = 1; i <= 10; i++) {
                    table.append(n + " * " + i + " = " + (n * i) + "\n");
                }
                txtOutput.setText(table.toString());
            } catch (NumberFormatException ex) {
                txtOutput.setText("Please enter a valid number!");
            }
        }
    }

    public static void main(String[] args) {
        new Question4_MultiplicationTable_24RP03297();
    }
}
