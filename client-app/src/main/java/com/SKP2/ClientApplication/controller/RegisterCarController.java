package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.CarCreateDto;
import com.SKP2.ClientApplication.dto.CarDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegisterCarController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblRegisterCar = new JLabel("Register Car");
        lblRegisterCar.setBounds(40, 40, 250, 30);
        jDialog.add(lblRegisterCar);

        JLabel lblModelID = new JLabel("Model ID");
        lblModelID.setBounds(40, 70, 250, 30);
        jDialog.add(lblModelID);

        JTextField tfModelID = new JTextField();
        tfModelID.setBounds(40, 100, 250, 30);
        jDialog.add(tfModelID);

        JLabel lblTypeID = new JLabel("Type ID");
        lblTypeID.setBounds(40, 130, 250, 30);
        jDialog.add(lblTypeID);

        JTextField tfTypeID = new JTextField();
        tfTypeID.setBounds(40, 160, 250, 30);
        jDialog.add(tfTypeID);

        JLabel lblCompanyID = new JLabel("Company ID");
        lblCompanyID.setBounds(40, 190, 250, 30);
        jDialog.add(lblCompanyID);

        JTextField tfCompanyID = new JTextField();
        tfCompanyID.setBounds(40, 220, 250, 30);
        jDialog.add(tfCompanyID);

        JLabel lblRentalDayPrice = new JLabel("Rental Day Price");
        lblRentalDayPrice.setBounds(40, 250, 250, 30);
        jDialog.add(lblRentalDayPrice);

        JTextField tfRentalDayPrice = new JTextField();
        tfRentalDayPrice.setBounds(40, 280, 250, 30);
        jDialog.add(tfRentalDayPrice);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(40, 310, 250, 30);
        jDialog.add(btnRegister);
        btnRegister.addActionListener(event -> {
            try {
                CarCreateDto carDto = new CarCreateDto(Long.parseLong(tfModelID.getText()), Long.parseLong(tfTypeID.getText()), Long.parseLong(tfCompanyID.getText()), Integer.parseInt(tfRentalDayPrice.getText()));
                CarDto updatedCarDto = MainFrame.getInstance().getRentalService().registerCar(carDto);
                JOptionPane.showMessageDialog(null, "Car successfully registered.\nID: " + updatedCarDto.getId() + "\nModel name: " + updatedCarDto.getModelName() + "\nType name: " + updatedCarDto.getTypeName()
                        + "\nCompany name: " + updatedCarDto.getCompanyName() + "\nRental day price: " + updatedCarDto.getRentalDayPrice(), "Operation successful", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Car not registered!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
