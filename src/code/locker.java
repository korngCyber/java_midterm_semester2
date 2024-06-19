package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class locker extends JFrame {
    private JTextField password;
    private JButton btnEnter;
    private JLabel label;
    private String savedPassword = null;

    public locker() {
        // Set up the frame
        setTitle("Locker Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        password= new JTextField(15);
        password.setEditable(false);
        btnEnter = new JButton("Enter");
        label = new JLabel("Enter set password");
        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkPassword();
            }
        });
        JPanel allButton = new JPanel(new GridLayout(4, 3, 5, 5));
        for (int i = 1; i <= 9; i++) {
            addButton(allButton, String.valueOf(i));
        }
        addButton(allButton, "0");
        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(password);
        inputPanel.add(btnEnter);
        topPanel.add(label, BorderLayout.NORTH);
        topPanel.add(inputPanel, BorderLayout.SOUTH);
        add(topPanel, BorderLayout.NORTH);
        add(allButton, BorderLayout.CENTER);
    }
    private void addButton(JPanel panel, String text) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                password.setText(password.getText() + text);
            }
        });
        panel.add(button);
    }
    private void checkPassword() {
        String input = password.getText();
        if (savedPassword == null) {
            savedPassword = input;
            label.setText("Password Set");
        } else {

            if (savedPassword.equals(input)) {
                label.setText("Correct Password");
            } else {
                label.setText("Incorrect Password");
            }
        }


        password.setText("");
    }

    public static void main(String[] args) {
                            new locker().setVisible(true);
            }

    }

