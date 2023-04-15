package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ModelDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ModelByIdController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblGet = new JLabel("Get Model By ID");
        lblGet.setBounds(40, 40, 250, 30);
        jDialog.add(lblGet);

        JLabel lblModelID = new JLabel("Model ID");
        lblModelID.setBounds(40, 70, 250, 30);
        jDialog.add(lblModelID);

        JTextField tfModelID = new JTextField();
        tfModelID.setBounds(40, 100, 250, 30);
        jDialog.add(tfModelID);

        JButton btnGet = new JButton("Get");
        btnGet.setBounds(40, 130, 250, 30);
        jDialog.add(btnGet);
        btnGet.addActionListener(event -> {
            try {
                ModelDto modelDto = MainFrame.getInstance().getRentalService().getModelById(Long.parseLong(tfModelID.getText()));
                JOptionPane.showMessageDialog(null, "ID: " + modelDto.getId() + "\nName: " + modelDto.getName(), "Model " + tfModelID.getText(), JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "An error has occurred!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
