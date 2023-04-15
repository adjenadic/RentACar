package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VerificationEmailController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblVerify = new JLabel("Verify Email");
        lblVerify.setBounds(40, 40, 250, 30);
        jDialog.add(lblVerify);

        JLabel lblVerification = new JLabel("Verification Text");
        lblVerification.setBounds(40, 70, 250, 30);
        jDialog.add(lblVerification);

        JTextField tfVerification = new JTextField();
        tfVerification.setBounds(40, 100, 250, 30);
        jDialog.add(tfVerification);

        JButton btnVerify = new JButton("Verify");
        btnVerify.setBounds(40, 130, 250, 30);
        jDialog.add(btnVerify);
        btnVerify.addActionListener(event -> {
            try {
                if (MainFrame.getInstance().getUserService().verificationEmail(tfVerification.getText())) {
                    JOptionPane.showMessageDialog(null, "Client " + tfVerification.getText() + " successfully verified.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Client " + tfVerification.getText() + " has not been verified due to an error.", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "User has not been verified!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}