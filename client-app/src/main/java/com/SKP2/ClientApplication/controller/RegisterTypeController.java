package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.TypeCreateDto;
import com.SKP2.ClientApplication.dto.TypeDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegisterTypeController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblRegisterType = new JLabel("Register Type");
        lblRegisterType.setBounds(40, 40, 250, 30);
        jDialog.add(lblRegisterType);

        JLabel lblTypeName = new JLabel("Type Name");
        lblTypeName.setBounds(40, 70, 250, 30);
        jDialog.add(lblTypeName);

        JTextField tfTypeName = new JTextField();
        tfTypeName.setBounds(40, 100, 250, 30);
        jDialog.add(tfTypeName);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(40, 130, 250, 30);
        jDialog.add(btnRegister);
        btnRegister.addActionListener(event -> {
            try {
                TypeCreateDto typeCreateDto = new TypeCreateDto(tfTypeName.getText());
                TypeDto typeDto = MainFrame.getInstance().getRentalService().registerType(typeCreateDto);
                JOptionPane.showMessageDialog(null, "Type successfully registered.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Type not registered!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
