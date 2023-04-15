package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.RankCreateDto;
import com.SKP2.ClientApplication.dto.RankDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddRankController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblRankName = new JLabel("Rank Name:");
        lblRankName.setBounds(40, 40, 250, 30);
        jDialog.add(lblRankName);

        JTextField tfRankName = new JTextField();
        tfRankName.setBounds(40, 70, 250, 30);
        jDialog.add(tfRankName);

        JLabel lblMinTotalNumberOfRentCar = new JLabel("Minimum Total Number Of Rent Car:");
        lblMinTotalNumberOfRentCar.setBounds(40, 100, 250, 30);
        jDialog.add(lblMinTotalNumberOfRentCar);

        JTextField tfMinTotalNumberOfRentCar = new JTextField();
        tfMinTotalNumberOfRentCar.setBounds(40, 130, 250, 30);
        jDialog.add(tfMinTotalNumberOfRentCar);

        JLabel lblMaxTotalNumberOfRentCar = new JLabel("Maximum Total Number Of Rent Car:");
        lblMaxTotalNumberOfRentCar.setBounds(40, 160, 250, 30);
        jDialog.add(lblMaxTotalNumberOfRentCar);

        JTextField tfMaxTotalNumberOfRentCar = new JTextField();
        tfMaxTotalNumberOfRentCar.setBounds(40, 190, 250, 30);
        jDialog.add(tfMaxTotalNumberOfRentCar);

        JLabel lblDiscount = new JLabel("Discount:");
        lblDiscount.setBounds(40, 220, 250, 30);
        jDialog.add(lblDiscount);

        JTextField tfDiscount = new JTextField();
        tfDiscount.setBounds(40, 250, 250, 30);
        jDialog.add(tfDiscount);

        JButton btnAdd = new JButton("Add Rank");
        btnAdd.setBounds(40, 280, 250, 30);
        jDialog.add(btnAdd);
        btnAdd.addActionListener(event -> {
            try {
                RankDto rankDto = MainFrame.getInstance().getUserService().addRank(new RankCreateDto(tfRankName.getText(), Integer.parseInt(tfMinTotalNumberOfRentCar.getText()), Integer.parseInt(tfMaxTotalNumberOfRentCar.getText()), Integer.parseInt(tfDiscount.getText())));
                JOptionPane.showMessageDialog(null, "Rank successfully created.\nID: " + rankDto.getId() + "\nRank Name: " + rankDto.getName() + "\nMin Cars: " + rankDto.getMinTotalNumberOfRentCar()
                        + "\nMax Cars: " + rankDto.getMaxTotalNumberOfRentCar() + "\nDiscount: " + rankDto.getDiscount(), "Operation successful", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "An error has occurred!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
