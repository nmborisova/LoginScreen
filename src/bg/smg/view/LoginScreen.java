package bg.smg.view;

import bg.smg.model.User;
import bg.smg.services.UserService;
import bg.smg.services.UserServiceI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginScreen extends JFrame implements ActionListener {
    private JTextField usernameInput;
    private JPasswordField passwordInput;
    private UserServiceI userService;

    public LoginScreen() throws SQLException {
        userService = new UserService();
        setTitle("Login");
        setSize(500,400);
        setLayout(null);

        JLabel usernameLbl = new JLabel("Username:");
        usernameLbl.setBounds(20,50, 100, 20);
        add(usernameLbl);

        usernameInput = new JTextField();
        usernameInput.setBounds(140, 50, 100, 20);
        add(usernameInput);

        JLabel passwordLbl = new JLabel("Password:");
        passwordLbl.setBounds(20,100, 100, 20);
        add(passwordLbl);

        passwordInput = new JPasswordField();
        passwordInput.setBounds(140, 100, 100, 20);
        add(passwordInput);

        JButton loginBtn = new JButton("Login");
        loginBtn.addActionListener(this);
        loginBtn.setBounds(120, 160, 100, 20);
        add(loginBtn);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameInput.getText();
        String password = passwordInput.getPassword().toString();
        try {
            if(userService.verifyUser(new User(username,password))){
                System.out.println("logged in");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
