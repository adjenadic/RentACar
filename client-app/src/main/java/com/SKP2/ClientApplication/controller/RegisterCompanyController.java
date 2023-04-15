package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.CompanyCreateDto;
import com.SKP2.ClientApplication.dto.CompanyDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegisterCompanyController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblRegisterCompany = new JLabel("Register Company");
        lblRegisterCompany.setBounds(40, 40, 250, 30);
        jDialog.add(lblRegisterCompany);

        JLabel lblCompanyName = new JLabel("Company Name");
        lblCompanyName.setBounds(40, 70, 250, 30);
        jDialog.add(lblCompanyName);

        JTextField tfCompanyName = new JTextField();
        tfCompanyName.setBounds(40, 100, 250, 30);
        jDialog.add(tfCompanyName);

        JLabel lblDescription = new JLabel("Description");
        lblDescription.setBounds(40, 130, 250, 30);
        jDialog.add(lblDescription);

        JTextField tfDescription = new JTextField();
        tfDescription.setBounds(40, 160, 250, 30);
        jDialog.add(tfDescription);

        JLabel lblNumOfCars = new JLabel("Num of Cars");
        lblNumOfCars.setBounds(40, 190, 250, 30);
        jDialog.add(lblNumOfCars);

        JTextField tfNumOfCars = new JTextField();
        tfNumOfCars.setBounds(40, 220, 250, 30);
        jDialog.add(tfNumOfCars);

        JLabel lblCity = new JLabel("City");
        lblCity.setBounds(40, 250, 250, 30);
        jDialog.add(lblCity);

        JTextField tfCity = new JTextField();
        tfCity.setBounds(40, 280, 250, 30);
        jDialog.add(tfCity);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(40, 310, 250, 30);
        jDialog.add(btnRegister);
        btnRegister.addActionListener(event -> {
            try {
                CompanyCreateDto companyCreateDto = new CompanyCreateDto(tfCompanyName.getText(), tfDescription.getText(), Integer.parseInt(tfNumOfCars.getText()), tfCity.getText());
                CompanyDto updatedCompanyDto = MainFrame.getInstance().getRentalService().registerCompany(companyCreateDto);
                JOptionPane.showMessageDialog(null, "Company successfully registered.\nID: " + updatedCompanyDto.getId() + "\nCompany name: " + updatedCompanyDto.getName() + "\nDescription: " + updatedCompanyDto.getDescription()
                        + "\nNum of Cars: " + updatedCompanyDto.getNumOfCars() + "\nCity: " + updatedCompanyDto.getCity(), "Operation successful", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Company not registered!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
