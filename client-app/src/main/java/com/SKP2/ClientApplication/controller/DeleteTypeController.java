package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DeleteTypeController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblDeleteID = new JLabel("Delete ID:");
        lblDeleteID.setBounds(40, 40, 250, 30);
        jDialog.add(lblDeleteID);

        JLabel lblID = new JLabel("Type ID");
        lblID.setBounds(40, 70, 250, 30);
        jDialog.add(lblID);

        JTextField tfID = new JTextField();
        tfID.setBounds(40, 100, 250, 30);
        jDialog.add(tfID);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(40, 130, 250, 30);
        jDialog.add(btnDelete);
        btnDelete.addActionListener(event -> {
            try {
                if (MainFrame.getInstance().getRentalService().deleteType(Long.parseLong(tfID.getText()))) {
                    JOptionPane.showMessageDialog(null, "Type " + tfID.getText() + " successfully deleted.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Type " + tfID.getText() + " has not been deleted due to an error.", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "An error has occurred!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
