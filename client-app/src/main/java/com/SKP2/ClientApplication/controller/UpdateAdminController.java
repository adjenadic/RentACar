package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.AdminDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateAdminController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblUpdateAdmin = new JLabel("Update Admin");
        lblUpdateAdmin.setBounds(40, 40, 250, 30);
        jDialog.add(lblUpdateAdmin);

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

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(40, 550, 250, 30);
        jDialog.add(btnUpdate);
        btnUpdate.addActionListener(event -> {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date birthDate = sdf.parse(tfDayOfBirth.getText());
                java.sql.Date birthDateToSqlDate = new java.sql.Date(birthDate.getTime());
                AdminDto adminDto = new AdminDto(Long.parseLong(tfID.getText()), tfUsername.getText(), tfPassword.getText(), tfEmail.getText(), tfPhone.getText(),
                        birthDateToSqlDate, tfFirstname.getText(), tfLastname.getText());
                AdminDto updatedAdminDto = MainFrame.getInstance().getUserService().updateAdmin(adminDto);
                JOptionPane.showMessageDialog(null, "Admin successfully updated.\nID: " + updatedAdminDto.getId() + "\nUsername: " + updatedAdminDto.getUsername() + "\nPassword: " + updatedAdminDto.getPassword()
                        + "\nEmail: " + updatedAdminDto.getEmail() + "\nDate of Birth: " + updatedAdminDto.getDayOfBirth() + "\nFirst name: " + updatedAdminDto.getFirstName() + "\nLast name: " + updatedAdminDto.getLastName(), "Operation successful", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException | ParseException ex) {
                JOptionPane.showMessageDialog(null, "Admin account not updated!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
