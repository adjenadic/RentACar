package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ReviewDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateReviewController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblUpdateCar = new JLabel("Update Review");
        lblUpdateCar.setBounds(40, 40, 250, 30);
        jDialog.add(lblUpdateCar);

        JLabel lblID = new JLabel("ID");
        lblID.setBounds(40, 70, 250, 30);
        jDialog.add(lblID);

        JTextField tfID = new JTextField();
        tfID.setBounds(40, 100, 250, 30);
        jDialog.add(tfID);

        JLabel lblCompanyID = new JLabel("Company ID");
        lblCompanyID.setBounds(40, 130, 250, 30);
        jDialog.add(lblCompanyID);

        JTextField tfCompanyID = new JTextField();
        tfCompanyID.setBounds(40, 160, 250, 30);
        jDialog.add(tfCompanyID);

        JLabel lblRate = new JLabel("Rate");
        lblRate.setBounds(40, 190, 250, 30);
        jDialog.add(lblRate);

        JTextField tfRate = new JTextField();
        tfRate.setBounds(40, 220, 250, 30);
        jDialog.add(tfRate);

        JLabel lblDesc = new JLabel("Description");
        lblDesc.setBounds(40, 250, 250, 30);
        jDialog.add(lblDesc);

        JTextField tfDesc = new JTextField();
        tfDesc.setBounds(40, 280, 250, 30);
        jDialog.add(tfDesc);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(40, 310, 250, 30);
        jDialog.add(btnUpdate);
        btnUpdate.addActionListener(event -> {
            try {
                ReviewDto reviewDto = new ReviewDto(Long.parseLong(tfID.getText()), Long.parseLong(tfCompanyID.getText()), Integer.parseInt(tfRate.getText()), tfDesc.getText());
                ReviewDto updatedReviewDto = MainFrame.getInstance().getRentalService().update(reviewDto);
                JOptionPane.showMessageDialog(null, "Review " + updatedReviewDto.getId() + " successfully updated.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Review not updated!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
