package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.CompanyDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateCompanyController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblUpdateCompany = new JLabel("Update Company");
        lblUpdateCompany.setBounds(40, 40, 250, 30);
        jDialog.add(lblUpdateCompany);

        JLabel lblID = new JLabel("ID");
        lblID.setBounds(40, 70, 250, 30);
        jDialog.add(lblID);

        JTextField tfID = new JTextField();
        tfID.setBounds(40, 100, 250, 30);
        jDialog.add(tfID);

        JLabel lblCompanyName = new JLabel("Company Name");
        lblCompanyName.setBounds(40, 130, 250, 30);
        jDialog.add(lblCompanyName);

        JTextField tfCompanyName = new JTextField();
        tfCompanyName.setBounds(40, 160, 250, 30);
        jDialog.add(tfCompanyName);

        JLabel lblDescription = new JLabel("Description");
        lblDescription.setBounds(40, 190, 250, 30);
        jDialog.add(lblDescription);

        JTextField tfDescription = new JTextField();
        tfDescription.setBounds(40, 220, 250, 30);
        jDialog.add(tfDescription);

        JLabel lblNumOfCars = new JLabel("Num of Cars");
        lblNumOfCars.setBounds(40, 250, 250, 30);
        jDialog.add(lblNumOfCars);

        JTextField tfNumOfCars = new JTextField();
        tfNumOfCars.setBounds(40, 280, 250, 30);
        jDialog.add(tfNumOfCars);

        JLabel lblCity = new JLabel("City");
        lblCity.setBounds(40, 310, 250, 30);
        jDialog.add(lblCity);

        JTextField tfCity = new JTextField();
        tfCity.setBounds(40, 340, 250, 30);
        jDialog.add(tfCity);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(40, 370, 250, 30);
        jDialog.add(btnUpdate);
        btnUpdate.addActionListener(event -> {
            try {
                CompanyDto cDto = MainFrame.getInstance().getRentalService().getCompanyById(Long.parseLong(tfID.getText()));
                CompanyDto companyDto = new CompanyDto(Long.parseLong(tfID.getText()), tfCompanyName.getText(), tfDescription.getText(), Integer.parseInt(tfNumOfCars.getText()), tfCity.getText(),
                        cDto.getCarList());
                CompanyDto updatedCompanyDto = MainFrame.getInstance().getRentalService().updateCompany(companyDto);
                JOptionPane.showMessageDialog(null, "Company " + updatedCompanyDto.getId() + " successfully updated.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Company not updated!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
