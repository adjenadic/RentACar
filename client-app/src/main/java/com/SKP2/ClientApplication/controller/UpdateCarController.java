package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.CarDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class UpdateCarController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblUpdateCar = new JLabel("Update Car");
        lblUpdateCar.setBounds(40, 40, 250, 30);
        jDialog.add(lblUpdateCar);

        JLabel lblID = new JLabel("ID");
        lblID.setBounds(40, 70, 250, 30);
        jDialog.add(lblID);

        JTextField tfID = new JTextField();
        tfID.setBounds(40, 100, 250, 30);
        jDialog.add(tfID);

        JLabel lblModelName = new JLabel("Model name");
        lblModelName.setBounds(40, 130, 250, 30);
        jDialog.add(lblModelName);

        JTextField tfModelName = new JTextField();
        tfModelName.setBounds(40, 160, 250, 30);
        jDialog.add(tfModelName);

        JLabel lblTypeName = new JLabel("Type name");
        lblTypeName.setBounds(40, 190, 250, 30);
        jDialog.add(lblTypeName);

        JTextField tfTypeName = new JTextField();
        tfTypeName.setBounds(40, 220, 250, 30);
        jDialog.add(tfTypeName);

        JLabel lblCompanyName = new JLabel("Company name");
        lblCompanyName.setBounds(40, 250, 250, 30);
        jDialog.add(lblCompanyName);

        JTextField tfCompanyName = new JTextField();
        tfCompanyName.setBounds(40, 280, 250, 30);
        jDialog.add(tfCompanyName);

        JLabel lblRentalDayPrice = new JLabel("Rental Day Price");
        lblRentalDayPrice.setBounds(40, 310, 250, 30);
        jDialog.add(lblRentalDayPrice);

        JTextField tfRentalDayPrice = new JTextField();
        tfRentalDayPrice.setBounds(40, 340, 250, 30);
        jDialog.add(tfRentalDayPrice);

//        JLabel lblStartDate = new JLabel("Start date");
//        lblStartDate.setBounds(40, 370, 250, 30);
//        jDialog.add(lblStartDate);
//
//        JTextField tfStartDate = new JTextField();
//        tfStartDate.setBounds(40, 400, 250, 30);
//        jDialog.add(tfStartDate);
//
//        JLabel lblEndDate = new JLabel("End date");
//        lblEndDate.setBounds(40, 430, 250, 30);
//        jDialog.add(lblEndDate);
//
//        JTextField tfEndDate = new JTextField();
//        tfEndDate.setBounds(40, 460, 250, 30);
//        jDialog.add(tfEndDate);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(40, 490, 250, 30);
        jDialog.add(btnUpdate);
        btnUpdate.addActionListener(event -> {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                Date startDate = sdf.parse(tfStartDate.getText());
//                java.sql.Date startDateToSqlDate = new java.sql.Date(startDate.getTime());
//                Date endDate = sdf.parse(tfEndDate.getText());
//                java.sql.Date endDateToSqlDate = new java.sql.Date(startDate.getTime());
                CarDto carDto = new CarDto(Long.parseLong(tfID.getText()), tfModelName.getText(), tfTypeName.getText(), tfCompanyName.getText(), Integer.parseInt(tfRentalDayPrice.getText()));
                CarDto updatedCarDto = MainFrame.getInstance().getRentalService().updateCar(carDto);
                JOptionPane.showMessageDialog(null, "Car successfully updated.\nID: " + updatedCarDto.getId() + "\nModel name: " + updatedCarDto.getModelName() + "\nType name: " + updatedCarDto.getTypeName()
                        + "\nCompany name: " + updatedCarDto.getCompanyName() + "\nRental day price: " + updatedCarDto.getRentalDayPrice(), "Operation successful", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Car not updated!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
