package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.EmailDto;
import com.SKP2.ClientApplication.dto.FilterEmailDto;
import com.SKP2.ClientApplication.util.JTableImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FilterEmailsController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblFilter = new JLabel("Filter Parameters");
        lblFilter.setBounds(40, 40, 250, 30);
        jDialog.add(lblFilter);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(40, 70, 250, 30);
        jDialog.add(lblEmail);

        JTextField tfEmail = new JTextField();
        tfEmail.setBounds(40, 100, 250, 30);
        jDialog.add(tfEmail);

        JLabel lblSubject = new JLabel("Subject");
        lblSubject.setBounds(40, 130, 250, 30);
        jDialog.add(lblSubject);

        JTextField tfSubject = new JTextField();
        tfSubject.setBounds(40, 160, 250, 30);
        jDialog.add(tfSubject);

        JLabel lblStartDate = new JLabel("Start date");
        lblStartDate.setBounds(40, 190, 250, 30);
        jDialog.add(lblStartDate);

        JTextField tfStartDate = new JTextField();
        tfStartDate.setBounds(40, 220, 250, 30);
        jDialog.add(tfStartDate);

        JLabel lblEndDate = new JLabel("End date");
        lblEndDate.setBounds(40, 250, 250, 30);
        jDialog.add(lblEndDate);

        JTextField tfEndDate = new JTextField();
        tfEndDate.setBounds(40, 280, 250, 30);
        jDialog.add(tfEndDate);

        JButton btnFilter = new JButton("Filter");
        btnFilter.setBounds(40, 310, 250, 30);
        jDialog.add(btnFilter);
        btnFilter.addActionListener(e1 -> {
            List<EmailDto> list;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate = sdf.parse(tfStartDate.getText());
                java.sql.Date startDateToSqlDate = new java.sql.Date(startDate.getTime());
                Date endDate = sdf.parse(tfEndDate.getText());
                java.sql.Date endDateToSqlDate = new java.sql.Date(endDate.getTime());
                FilterEmailDto filterEmailDto = new FilterEmailDto(tfEmail.getText(), tfSubject.getText(), startDateToSqlDate, endDateToSqlDate);
                list = MainFrame.getInstance().getNotificationService().getFilterEmails(filterEmailDto);
            } catch (IOException | ParseException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
            JDialog internalJDialog = new JDialog();
            internalJDialog.setSize(1024, 768);

            Object[][] data = new Object[50][50];
            int k = 0;
            for (EmailDto dto : list)
                data[k++] = new Object[]{dto.getSubject(), dto.getContext(), dto.getEmailFrom(), dto.getEmailTo(),
                        dto.getDate()};
            String[] header = {"Subject", "Context", "Email from", "Email to", "Date"};

            JTableImpl table = new JTableImpl(header, data);
            table.setBounds(0, 340, 1024, 768);

            internalJDialog.add(new JScrollPane(table));
            internalJDialog.setVisible(true);
        });

        jDialog.setVisible(true);
    }
}
