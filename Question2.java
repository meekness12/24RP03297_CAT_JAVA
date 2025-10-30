import java.awt.*;
import java.awt.event.*;

public class Question2 extends Frame implements ActionListener {

    private CardLayout cardLayout = new CardLayout();
    private Panel mainContentPanel = new Panel(cardLayout);
    
    private MenuItem loginItem, studentItem;

    private static final String LOGIN_CARD = "LoginCard";
    private static final String STUDENT_CARD = "StudentCard";
    
    private static final String STUDENT_NAME = "Meekness Bonheur";
    private static final String REG_NUMBER = "24rp03297";

    public Question2() {
        setTitle("AWT MENU Practice");
        setSize(600, 400);
        setLayout(new BorderLayout());
        setBackground(new Color(230, 230, 230));

        setupMenuBar();

        Panel loginPanel = createLoginPage();
        Panel studentPanel = createStudentPage(STUDENT_NAME, REG_NUMBER);

        mainContentPanel.add(loginPanel, LOGIN_CARD);
        mainContentPanel.add(studentPanel, STUDENT_CARD);
        
        Panel headerPanel = createHeaderPanel();

        Panel contentContainer = new Panel(new BorderLayout());
        contentContainer.add(headerPanel, BorderLayout.NORTH);
        contentContainer.add(mainContentPanel, BorderLayout.CENTER);

        add(contentContainer, BorderLayout.CENTER);

        cardLayout.show(mainContentPanel, LOGIN_CARD);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    private void setupMenuBar() {
        MenuBar menuBar = new MenuBar();

        Menu pagesMenu = new Menu("Pages");
        
        // AWT Menu components do not support direct color changes or hover events.
        // The appearance is controlled by the operating system's theme.

        loginItem = new MenuItem("login");
        studentItem = new MenuItem("student");

        loginItem.addActionListener(this);
        studentItem.addActionListener(this);

        pagesMenu.add(loginItem);
        pagesMenu.add(studentItem);

        menuBar.add(pagesMenu);

        menuBar.add(new Menu("Edit"));
        menuBar.add(new Menu("Help"));

        setMenuBar(menuBar);
    }
    
    private Panel createHeaderPanel() {
        Panel headerPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(Color.decode("#1C3A54"));

        Label headerLabel = new Label("SIMPLE JAVA AWT LAYOUT");
        headerLabel.setForeground(Color.white);
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        
        headerPanel.add(headerLabel);
        
        return headerPanel;
    }

    private Panel createLoginPage() {
        Panel panel = new Panel(new GridBagLayout());
        panel.setBackground(Color.decode("#CCE0E5"));

        // --- Login Form Container using GridBagLayout for flexible design ---
        Panel loginBox = new Panel(new GridBagLayout());
        loginBox.setBackground(new Color(245, 245, 245));
        loginBox.setFont(new Font("SansSerif", Font.PLAIN, 14));
        loginBox.setPreferredSize(new Dimension(300, 200));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // 1. Title Label
        Label titleLabel = new Label("LOGIN PAGE", Label.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 5, 15, 5);
        loginBox.add(titleLabel, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridwidth = 1;

        // 2. Username Label
        Label userLabel = new Label("Username", Label.RIGHT);
        userLabel.setBackground(Color.decode("#D8D8D8")); 
        userLabel.setAlignment(Label.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 10;
        loginBox.add(userLabel, gbc);

        // 3. Username Field
        TextField usernameField = new TextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipadx = 0;
        loginBox.add(usernameField, gbc);

        // 4. Password Label
        Label passLabel = new Label("Password", Label.RIGHT);
        passLabel.setBackground(Color.decode("#D8D8D8"));
        passLabel.setAlignment(Label.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 10;
        loginBox.add(passLabel, gbc);

        // 5. Password Field
        TextField passwordField = new TextField(15);
        passwordField.setEchoChar('*');
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipadx = 0;
        loginBox.add(passwordField, gbc);

        // 6. Login Button
        Button loginButton = new Button("LOGIN");
        loginButton.setForeground(Color.white);
        loginButton.setBackground(Color.decode("#283B4F"));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(15, 5, 5, 5);
        loginBox.add(loginButton, gbc);
        
        // Add the structured login box to the main panel (it will be centered by GridBagLayout)
        GridBagConstraints centerGBC = new GridBagConstraints();
        centerGBC.insets = new Insets(20, 20, 20, 20);
        panel.add(loginBox, centerGBC);
        
        return panel;
    }

    private Panel createStudentPage(String name, String regNo) {
        Panel panel = new Panel(new GridBagLayout());
        panel.setBackground(Color.decode("#F0F8FF"));

        Label infoLabel = new Label(
            "Name: " + name + " | Registration No: " + regNo,
            Label.CENTER
        );
        infoLabel.setFont(new Font("Serif", Font.BOLD, 18));
        infoLabel.setForeground(Color.decode("#191970"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(infoLabel, gbc);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginItem) {
            System.out.println("Menu Clicked: Login - Switching to Login Page");
            cardLayout.show(mainContentPanel, LOGIN_CARD);
        } else if (e.getSource() == studentItem) {
            System.out.println("Menu Clicked: Student - Switching to Student Page");
            cardLayout.show(mainContentPanel, STUDENT_CARD);
        }
    }

    public static void main(String[] args) {
        new Question2();
    }
}
