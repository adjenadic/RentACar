package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ReviewCreateDto;
import com.SKP2.ClientApplication.dto.ReviewDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddReviewController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblAddReview = new JLabel("Add Review");
        lblAddReview.setBounds(40, 40, 250, 30);
        jDialog.add(lblAddReview);

        JLabel lblCompanyID = new JLabel("Company ID");
        lblCompanyID.setBounds(40, 70, 250, 30);
        jDialog.add(lblCompanyID);

        JTextField tfCompanyID = new JTextField();
        tfCompanyID.setBounds(40, 100, 250, 30);
        jDialog.add(tfCompanyID);

        JLabel lblRate = new JLabel("Rate");
        lblRate.setBounds(40, 130, 250, 30);
        jDialog.add(lblRate);

        JTextField tfRate = new JTextField();
        tfRate.setBounds(40, 160, 250, 30);
        jDialog.add(tfRate);

        JLabel lblDesc = new JLabel("Description");
        lblDesc.setBounds(40, 190, 250, 30);
        jDialog.add(lblDesc);

        JTextField tfDesc = new JTextField();
        tfDesc.setBounds(40, 220, 220, 30);
        jDialog.add(tfDesc);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(40, 250, 220, 30);
        jDialog.add(btnAdd);
        btnAdd.addActionListener(event -> {
            try {
                ReviewCreateDto reviewCreateDto = new ReviewCreateDto(Long.parseLong(tfCompanyID.getText()), Integer.parseInt(tfRate.getText()), tfDesc.getText());
                ReviewDto reviewDto = MainFrame.getInstance().getRentalService().add(reviewCreateDto);
                JOptionPane.showMessageDialog(null, "Review successfully added.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Review not added!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
