package bg.smg.view;

import bg.smg.model.User;

import javax.swing.*;

public class MainFrame extends JFrame {
    MainFrame(User user){
        setTitle("Main");
        setLayout(null);
        setSize(400,600);

        JLabel nameLbl = new JLabel(user.getUsername());
        nameLbl.setBounds(20,20,100,20);
        add(nameLbl);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
}
