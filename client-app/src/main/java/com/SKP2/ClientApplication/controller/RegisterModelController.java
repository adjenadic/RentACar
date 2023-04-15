package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ModelCreateDto;
import com.SKP2.ClientApplication.dto.ModelDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegisterModelController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblRegisterModel = new JLabel("Register Model");
        lblRegisterModel.setBounds(40, 40, 250, 30);
        jDialog.add(lblRegisterModel);

        JLabel lblModelName = new JLabel("Model Name");
        lblModelName.setBounds(40, 70, 250, 30);
        jDialog.add(lblModelName);

        JTextField tfModelName = new JTextField();
        tfModelName.setBounds(40, 100, 250, 30);
        jDialog.add(tfModelName);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(40, 130, 250, 30);
        jDialog.add(btnRegister);
        btnRegister.addActionListener(event -> {
            try {
                ModelCreateDto modelCreateDto = new ModelCreateDto(tfModelName.getText());
                ModelDto modelDto = MainFrame.getInstance().getRentalService().registerModel(modelCreateDto);
                JOptionPane.showMessageDialog(null, "Model successfully registered.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Model not registered!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
