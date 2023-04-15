package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.CarDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CarByIdController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblGet = new JLabel("Get Car By ID");
        lblGet.setBounds(40, 40, 250, 30);
        jDialog.add(lblGet);

        JLabel lblCarID = new JLabel("Car ID");
        lblCarID.setBounds(40, 70, 250, 30);
        jDialog.add(lblCarID);

        JTextField tfCarID = new JTextField();
        tfCarID.setBounds(40, 100, 250, 30);
        jDialog.add(tfCarID);

        JButton btnGet = new JButton("Get");
        btnGet.setBounds(40, 130, 250, 30);
        jDialog.add(btnGet);
        btnGet.addActionListener(event -> {
            try {
                CarDto carDto = MainFrame.getInstance().getRentalService().getCarById(Long.parseLong(tfCarID.getText()));
                JOptionPane.showMessageDialog(null, "ID: " + carDto.getId() + "\nModel Name: " + carDto.getModelName() + "\nType Name: " + carDto.getTypeName()
                        + "\nCompany Name: " + carDto.getCompanyName() + "\nRental Day Price: " + carDto.getRentalDayPrice(), "Car " + tfCarID.getText(), JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "An error has occurred!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
