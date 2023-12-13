package bg.smg.view;

import bg.smg.model.User;
import bg.smg.services.UserService;
import bg.smg.services.UserServiceI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginScreen extends JFrame implements ActionListener {
    private JTextField usernameInput;
    private JTextField passwordInput;
    private UserServiceI userService;

    public LoginScreen() throws SQLException {
        userService = new UserService();
        setTitle("Login");
        setSize(300,200);
        setLayout(null);

        JLabel usernameLbl = new JLabel("Username:");
        usernameLbl.setBounds(20,20, 100, 20);
        add(usernameLbl);

        usernameInput = new JTextField();
        usernameInput.setBounds(140, 20, 100, 20);
        add(usernameInput);

        JLabel passwordLbl = new JLabel("Password:");
        passwordLbl.setBounds(20,60, 100, 20);
        add(passwordLbl);

        passwordInput = new JTextField();
        passwordInput.setBounds(140, 60, 100, 20);
        add(passwordInput);

        JButton loginBtn = new JButton("Login");
        loginBtn.addActionListener(this);
        loginBtn.setBounds(120, 100, 100, 20);
        add(loginBtn);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameInput.getText();
        String password = passwordInput.getText();
        try {
            User loggedUser = new User(username, password);
            if(userService.verifyUser(loggedUser)){
                setVisible(false);
                MainFrame mainFrame = new MainFrame(loggedUser);
            } else {
                JOptionPane.showMessageDialog(this, "Username or password is incorrect.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
