package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.CompanyDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CompanyByIdController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblGet = new JLabel("Get Company By ID");
        lblGet.setBounds(40, 40, 250, 30);
        jDialog.add(lblGet);

        JLabel lblCompanyID = new JLabel("Company ID");
        lblCompanyID.setBounds(40, 70, 250, 30);
        jDialog.add(lblCompanyID);

        JTextField tfCompanyID = new JTextField();
        tfCompanyID.setBounds(40, 100, 250, 30);
        jDialog.add(tfCompanyID);

        JButton btnGet = new JButton("Get");
        btnGet.setBounds(40, 130, 250, 30);
        jDialog.add(btnGet);
        btnGet.addActionListener(event -> {
            try {
                CompanyDto companyDto = MainFrame.getInstance().getRentalService().getCompanyById(Long.parseLong(tfCompanyID.getText()));
                JOptionPane.showMessageDialog(null, "ID: " + companyDto.getId() + "\nCompany name: " + companyDto.getName() + "\nDescription: " + companyDto.getDescription()
                        + "\nNum of Cars: " + companyDto.getNumOfCars() + "\nCity: " + companyDto.getCity() + "\nCar List: " + companyDto.getCarList().size(), "Company " + tfCompanyID.getText(), JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "An error has occurred!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
