package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ManagerDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateManagerController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblUpdateManager = new JLabel("Update Manager");
        lblUpdateManager.setBounds(40, 40, 250, 30);
        jDialog.add(lblUpdateManager);

        JLabel lblID = new JLabel("ID");
        lblID.setBounds(40, 70, 250, 30);
        jDialog.add(lblID);

        JTextField tfID = new JTextField();
        tfID.setBounds(40, 100, 250, 30);
        jDialog.add(tfID);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(40, 130, 250, 30);
        jDialog.add(lblUsername);

        JTextField tfUsername = new JTextField();
        tfUsername.setBounds(40, 160, 250, 30);
        jDialog.add(tfUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(40, 190, 250, 30);
        jDialog.add(lblPassword);

        JTextField tfPassword = new JTextField();
        tfPassword.setBounds(40, 220, 250, 30);
        jDialog.add(tfPassword);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(40, 250, 250, 30);
        jDialog.add(lblEmail);

        JTextField tfEmail = new JTextField();
        tfEmail.setBounds(40, 280, 250, 30);
        jDialog.add(tfEmail);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(40, 310, 250, 30);
        jDialog.add(lblPhone);

        JTextField tfPhone = new JTextField();
        tfPhone.setBounds(40, 340, 250, 30);
        jDialog.add(tfPhone);

        JLabel lblDayOfBirth = new JLabel("Date of Birth");
        lblDayOfBirth.setBounds(40, 370, 250, 30);
        jDialog.add(lblDayOfBirth);

        JTextField tfDayOfBirth = new JTextField();
        tfDayOfBirth.setBounds(40, 400, 250, 30);
        jDialog.add(tfDayOfBirth);

        JLabel lblFirstname = new JLabel("First name");
        lblFirstname.setBounds(40, 430, 250, 30);
        jDialog.add(lblFirstname);

        JTextField tfFirstname = new JTextField();
        tfFirstname.setBounds(40, 460, 250, 30);
        jDialog.add(tfFirstname);

        JLabel lblLastname = new JLabel("Last name");
        lblLastname.setBounds(40, 490, 250, 30);
        jDialog.add(lblLastname);

        JTextField tfLastname = new JTextField();
        tfLastname.setBounds(40, 520, 250, 30);
        jDialog.add(tfLastname);

        JLabel lblCompanyName = new JLabel("Company name");
        lblCompanyName.setBounds(40, 550, 250, 30);
        jDialog.add(lblCompanyName);

        JTextField tfCompanyName = new JTextField();
        tfCompanyName.setBounds(40, 580, 250, 30);
        jDialog.add(tfCompanyName);

        JLabel lblEmploymentDay = new JLabel("Employment date");
        lblEmploymentDay.setBounds(40, 610, 250, 30);
        jDialog.add(lblEmploymentDay);

        JTextField tfEmploymentDay = new JTextField();
        tfEmploymentDay.setBounds(40, 640, 250, 30);
        jDialog.add(tfEmploymentDay);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(40, 670, 250, 30);
        jDialog.add(btnUpdate);
        btnUpdate.addActionListener(event -> {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date birthDate = sdf.parse(tfDayOfBirth.getText());
                java.sql.Date birthDateToSqlDate = new java.sql.Date(birthDate.getTime());
                ManagerDto managerDto = new ManagerDto(Long.parseLong(tfID.getText()), tfUsername.getText(), tfPassword.getText(), tfEmail.getText(), tfPhone.getText(),
                        birthDateToSqlDate, tfFirstname.getText(), tfLastname.getText(), tfCompanyName.getText(), tfEmploymentDay.getText());
                ManagerDto updateManagerDto = MainFrame.getInstance().getUserService().updateManager(managerDto);
                JOptionPane.showMessageDialog(null, "Manager successfully updated.\nID: " + updateManagerDto.getId() + "\nUsername: " + updateManagerDto.getUsername() + "\nPassword: " + updateManagerDto.getPassword()
                        + "\nEmail: " + updateManagerDto.getEmail() + "\nDate of Birth: " + updateManagerDto.getDayOfBirth() + "\nFirst name: " + updateManagerDto.getFirstName() + "\nLast name: " + updateManagerDto.getLastName()
                        + "\nCompany name: " + updateManagerDto.getCompanyName() + "\nEmployment day: " + updateManagerDto.getEmploymentDay(), "Operation successful", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException | ParseException ex) {
                JOptionPane.showMessageDialog(null, "Manager account not updated!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
