package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ReservationCreateDto;
import com.SKP2.ClientApplication.dto.ReservationDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddReservationController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblAdd = new JLabel("Add Reservation");
        lblAdd.setBounds(40, 40, 250, 30);
        jDialog.add(lblAdd);

        JLabel lblCarID = new JLabel("Car ID");
        lblCarID.setBounds(40, 70, 250, 30);
        jDialog.add(lblCarID);

        JTextField tfCarID = new JTextField();
        tfCarID.setBounds(40, 100, 250, 30);
        jDialog.add(tfCarID);

        JLabel lblStartDate = new JLabel("Start date");
        lblStartDate.setBounds(40, 130, 250, 30);
        jDialog.add(lblStartDate);

        JTextField tfStartDate = new JTextField();
        tfStartDate.setBounds(40, 160, 250, 30);
        jDialog.add(tfStartDate);

        JLabel lblEndDate = new JLabel("End date");
        lblEndDate.setBounds(40, 190, 250, 30);
        jDialog.add(lblEndDate);

        JTextField tfEndDate = new JTextField();
        tfEndDate.setBounds(40, 220, 250, 30);
        jDialog.add(tfEndDate);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(40, 250, 250, 30);
        jDialog.add(btnAdd);
        btnAdd.addActionListener(event -> {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate = sdf.parse(tfStartDate.getText());
                java.sql.Date startDateToSqlDate = new java.sql.Date(startDate.getTime());
                Date endDate = sdf.parse(tfEndDate.getText());
                java.sql.Date endDateToSqlDate = new java.sql.Date(endDate.getTime());
                ReservationCreateDto reservationCreateDto = new ReservationCreateDto(Long.parseLong(tfCarID.getText()), startDateToSqlDate, endDateToSqlDate);
                ReservationDto reservationDto = MainFrame.getInstance().getRentalService().addReservation(reservationCreateDto);
                JOptionPane.showMessageDialog(null, "Reservation successfully added.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException | ParseException ex) {
                JOptionPane.showMessageDialog(null, "Reservation not registered!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
