package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ClientCreateDto;
import com.SKP2.ClientApplication.dto.ClientDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterClientController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(40, 40, 250, 30);
        jDialog.add(lblUsername);

        JTextField tfUsername = new JTextField();
        tfUsername.setBounds(40, 70, 250, 30);
        jDialog.add(tfUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(40, 100, 250, 30);
        jDialog.add(lblPassword);

        JTextField tfPassword = new JTextField();
        tfPassword.setBounds(40, 130, 250, 30);
        jDialog.add(tfPassword);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(40, 160, 250, 30);
        jDialog.add(lblEmail);

        JTextField tfEmail = new JTextField();
        tfEmail.setBounds(40, 190, 250, 30);
        jDialog.add(tfEmail);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(40, 220, 250, 30);
        jDialog.add(lblPhone);

        JTextField tfPhone = new JTextField();
        tfPhone.setBounds(40, 250, 250, 30);
        jDialog.add(tfPhone);

        JLabel lblDayOfBirth = new JLabel("Day of Birth:");
        lblDayOfBirth.setBounds(40, 280, 250, 30);
        jDialog.add(lblDayOfBirth);

        JTextField tfDayOfBirth = new JTextField();
        tfDayOfBirth.setBounds(40, 310, 250, 30);
        jDialog.add(tfDayOfBirth);

        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setBounds(40, 340, 250, 30);
        jDialog.add(lblFirstName);

        JTextField tfFirstName = new JTextField();
        tfFirstName.setBounds(40, 370, 250, 30);
        jDialog.add(tfFirstName);

        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setBounds(40, 400, 250, 30);
        jDialog.add(lblLastName);

        JTextField tfLastName = new JTextField();
        tfLastName.setBounds(40, 430, 250, 30);
        jDialog.add(tfLastName);

        JLabel lblPassport = new JLabel("Passport:");
        lblPassport.setBounds(40, 460, 250, 30);
        jDialog.add(lblPassport);

        JTextField tfPassport = new JTextField();
        tfPassport.setBounds(40, 490, 250, 30);
        jDialog.add(tfPassport);

        JButton btnRegisterClient = new JButton("Register Client");
        btnRegisterClient.setBounds(40, 520, 250, 30);
        jDialog.add(btnRegisterClient);
        btnRegisterClient.addActionListener(event -> {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date birthDate = sdf.parse(tfDayOfBirth.getText());
                java.sql.Date birthDateToSqlDate = new java.sql.Date(birthDate.getTime());
                ClientCreateDto clientCreateDto = new ClientCreateDto(tfUsername.getText(), tfPassword.getText(), tfEmail.getText(),
                        tfPhone.getText(), birthDateToSqlDate, tfFirstName.getText(), tfLastName.getText(), tfPassport.getText());
                ClientDto clientDto = MainFrame.getInstance().getUserService().registerClient(clientCreateDto);
                JOptionPane.showMessageDialog(null, "Client successfully created!\nID: " + clientDto.getId() + "\nUsername: " + clientDto.getUsername() + "\nPassword: " + clientDto.getPassword()
                        + "\nEmail: " + clientDto.getEmail() + "\nDate of Birth: " + clientDto.getDayOfBirth() + "\nFirst name: " + clientDto.getFirstName() + "\nLast name: " + clientDto.getLastName()
                        + "\nPassport: " + clientDto.getPassport(), "Operation successful", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException | ParseException ex) {
                throw new RuntimeException(ex);
//                JOptionPane.showMessageDialog(null, "Client account not created!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
