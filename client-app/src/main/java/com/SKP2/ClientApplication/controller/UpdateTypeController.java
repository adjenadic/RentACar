package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.TypeDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateTypeController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblUpdate = new JLabel("Update Type");
        lblUpdate.setBounds(40, 40, 250, 30);
        jDialog.add(lblUpdate);

        JLabel lblID = new JLabel("ID");
        lblID.setBounds(40, 70, 250, 30);
        jDialog.add(lblID);

        JTextField tfID = new JTextField();
        tfID.setBounds(40, 100, 250, 30);
        jDialog.add(tfID);

        JLabel lblTypeName = new JLabel("Type Name");
        lblTypeName.setBounds(40, 130, 250, 30);
        jDialog.add(lblTypeName);

        JTextField tfTypeName = new JTextField();
        tfTypeName.setBounds(40, 160, 250, 30);
        jDialog.add(tfTypeName);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(40, 190, 250, 30);
        jDialog.add(btnUpdate);
        btnUpdate.addActionListener(event -> {
            try {
                TypeDto typeDto = new TypeDto(Long.parseLong(tfID.getText()), tfTypeName.getText());
                TypeDto updatedTypeDto = MainFrame.getInstance().getRentalService().updateType(typeDto);
                JOptionPane.showMessageDialog(null, "Type " + updatedTypeDto.getId() + " successfully updated.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Type not updated!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
