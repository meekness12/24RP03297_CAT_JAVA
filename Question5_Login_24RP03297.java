import java.awt.*;
import java.awt.event.*;

public class Question5_Login_24RP03297 extends Frame implements ActionListener {
    TextField txtUser, txtPass;
    Button btnLogin;

    private final String USERNAME = "admin";
    private final String PASSWORD = "12345";

    public Question5_Login_24RP03297() {
        setTitle("AWT Login Layout");
        setSize(500, 400);
        setLayout(new BorderLayout());
        setBackground(Color.white);

        // ===== HEADER (Dark Blue Bar) =====
        Panel headerPanel = new Panel(new BorderLayout());
        headerPanel.setBackground(new Color(0, 25, 90));
        Label lblHeader = new Label("SIMPLE JAVA AWT LAYOUT", Label.CENTER);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 18));
        lblHeader.setForeground(Color.white);
        headerPanel.add(lblHeader, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        // ===== MAIN SECTION =====
        Panel mainPanel = new Panel(new BorderLayout());
        mainPanel.setBackground(Color.white);

        // Left and right side color panels
        Panel leftSide = new Panel();
        leftSide.setBackground(new Color(170, 200, 220));
        Panel rightSide = new Panel();
        rightSide.setBackground(new Color(170, 200, 220));

        // ===== CENTER LOGIN CARD =====
        Panel loginCard = new Panel(new BorderLayout());
        loginCard.setBackground(new Color(230, 230, 225));
        loginCard.setPreferredSize(new Dimension(280, 200));
        loginCard.setFont(new Font("Arial", Font.PLAIN, 14));

        // Title above form
        Label lblLoginTitle = new Label("LOGIN PAGE", Label.CENTER);
        lblLoginTitle.setFont(new Font("Arial", Font.BOLD, 15));
        lblLoginTitle.setBackground(new Color(230, 230, 225));
        loginCard.add(lblLoginTitle, BorderLayout.NORTH);

        // Login form (table-style)
        Panel formPanel = new Panel(new GridLayout(3, 2, 8, 12));
        formPanel.setBackground(new Color(230, 230, 225));
        formPanel.setFont(new Font("Arial", Font.PLAIN, 14));

        Label lblUsername = new Label("Username", Label.RIGHT);
        txtUser = new TextField(15);

        Label lblPassword = new Label("Password", Label.RIGHT);
        txtPass = new TextField(15);
        txtPass.setEchoChar('*');

        formPanel.add(lblUsername);
        formPanel.add(txtUser);
        formPanel.add(lblPassword);
        formPanel.add(txtPass);

        // Empty space + Login button
        formPanel.add(new Label(""));
        btnLogin = new Button("LOGIN");
        btnLogin.setBackground(new Color(20, 40, 70));
        btnLogin.setForeground(Color.white);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
        btnLogin.addActionListener(this);
        formPanel.add(btnLogin);

        // Add border-style spacing
        Panel innerWrapper = new Panel(new FlowLayout(FlowLayout.CENTER, 10, 15));
        innerWrapper.setBackground(new Color(230, 230, 225));
        innerWrapper.add(formPanel);

        loginCard.add(innerWrapper, BorderLayout.CENTER);

        mainPanel.add(leftSide, BorderLayout.WEST);
        mainPanel.add(loginCard, BorderLayout.CENTER);
        mainPanel.add(rightSide, BorderLayout.EAST);
        add(mainPanel, BorderLayout.CENTER);

        // ===== FOOTER BAR (Black) =====
        Panel footer = new Panel();
        footer.setBackground(Color.black);
        footer.setPreferredSize(new Dimension(500, 30));
        add(footer, BorderLayout.SOUTH);

        // Window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            String user = txtUser.getText().trim();
            String pass = txtPass.getText().trim();

            if (user.equals(USERNAME) && pass.equals(PASSWORD)) {
                showDialog("Welcome " + user + "!");
            } else {
                showDialog("Incorrect credentials! Please try again.");
            }
        }
    }

    private void showDialog(String message) {
        Dialog dialog = new Dialog(this, "Message", true);
        dialog.setLayout(new FlowLayout());
        Label lblMsg = new Label(message);
        lblMsg.setFont(new Font("Arial", Font.PLAIN, 14));
        dialog.add(lblMsg);

        Button ok = new Button("OK");
        ok.addActionListener(e -> dialog.dispose());
        dialog.add(ok);

        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        new Question5_Login_24RP03297();
    }
}
