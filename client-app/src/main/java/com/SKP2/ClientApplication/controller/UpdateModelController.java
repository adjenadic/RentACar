package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ModelDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateModelController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblUpdate = new JLabel("Update Model");
        lblUpdate.setBounds(40, 40, 250, 30);
        jDialog.add(lblUpdate);

        JLabel lblID = new JLabel("ID");
        lblID.setBounds(40, 70, 250, 30);
        jDialog.add(lblID);

        JTextField tfID = new JTextField();
        tfID.setBounds(40, 100, 250, 30);
        jDialog.add(tfID);

        JLabel lblModelName = new JLabel("Model Name");
        lblModelName.setBounds(40, 130, 250, 30);
        jDialog.add(lblModelName);

        JTextField tfModelName = new JTextField();
        tfModelName.setBounds(40, 160, 250, 30);
        jDialog.add(tfModelName);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(40, 190, 250, 30);
        jDialog.add(btnUpdate);
        btnUpdate.addActionListener(event -> {
            try {
                ModelDto modelDto = new ModelDto(Long.parseLong(tfID.getText()), tfModelName.getText());
                ModelDto updatedModelDto = MainFrame.getInstance().getRentalService().updateModel(modelDto);
                JOptionPane.showMessageDialog(null, "Model " + updatedModelDto.getId() + " successfully updated.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Model not updated!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
