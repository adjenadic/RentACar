package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ReviewDto;
import com.SKP2.ClientApplication.dto.ReviewFilterDto;
import com.SKP2.ClientApplication.util.JTableImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class FilterReviewController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblFilter = new JLabel("Filter Parameters");
        lblFilter.setBounds(40, 40, 250, 30);
        jDialog.add(lblFilter);

        JLabel lblCity = new JLabel("City");
        lblCity.setBounds(40, 70, 250, 30);
        jDialog.add(lblCity);

        JTextField tfCity = new JTextField();
        tfCity.setBounds(40, 100, 250, 30);
        jDialog.add(tfCity);

        JLabel lblCompanyID = new JLabel("Company ID");
        lblCompanyID.setBounds(40, 130, 250, 30);
        jDialog.add(lblCompanyID);

        JTextField tfCompanyID = new JTextField();
        tfCompanyID.setBounds(40, 160, 250, 30);
        jDialog.add(tfCompanyID);

        JButton btnFilter = new JButton("Filter");
        btnFilter.setBounds(40, 190, 250, 30);
        jDialog.add(btnFilter);

        btnFilter.addActionListener(e1 -> {
            List<ReviewDto> list;
            try {
                ReviewFilterDto reviewFilterDto = new ReviewFilterDto(tfCity.getText(), Long.parseLong(tfCompanyID.getText()));
                list = MainFrame.getInstance().getRentalService().filterReview(reviewFilterDto);
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
            JDialog internalJDialog = new JDialog();
            internalJDialog.setSize(1024, 768);

            Object[][] data = new Object[50][50];
            int k = 0;
            for (ReviewDto dto : list)
                data[k++] = new Object[]{dto.getId(), dto.getCompanyId(), dto.getRate(), dto.getDesc()};
            String[] header = {"ID", "Company ID", "Rate", "Description"};

            JTableImpl table = new JTableImpl(header, data);
            table.setBounds(0, 220, 1024, 768);

            internalJDialog.add(new JScrollPane(table));
            internalJDialog.setVisible(true);
        });

        jDialog.setVisible(true);
    }
}
