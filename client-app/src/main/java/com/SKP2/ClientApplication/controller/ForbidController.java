package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ForbidController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(640, 240);

        JLabel lblBlock = new JLabel("Forbid a User Account");
        lblBlock.setBounds(40, 40, 250, 30);
        jDialog.add(lblBlock);

        JLabel lblUserID = new JLabel("User ID");
        lblUserID.setBounds(40, 70, 250, 30);
        jDialog.add(lblUserID);

        JTextField tfUserID = new JTextField();
        tfUserID.setBounds(40, 100, 250, 30);
        jDialog.add(tfUserID);

        JButton btnBlock = new JButton("Block");
        btnBlock.setBounds(40, 130, 250, 30);
        jDialog.add(btnBlock);
        btnBlock.addActionListener(event -> {
            try {
                if (MainFrame.getInstance().getUserService().forbid(Long.parseLong(tfUserID.getText()))) {
                    JOptionPane.showMessageDialog(null, "Client " + tfUserID.getText() + " successfully blocked.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Client " + tfUserID.getText() + " has not been blocked due to an error.", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "User has not been blocked!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}