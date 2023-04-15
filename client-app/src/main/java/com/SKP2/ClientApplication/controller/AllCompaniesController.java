package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.CompanyDto;
import com.SKP2.ClientApplication.util.JTableImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class AllCompaniesController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setSize(1024, 768);

        List<CompanyDto> list;
        try {
            list = MainFrame.getInstance().getRentalService().getAllCompanies();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        Object[][] data = new Object[50][50];
        int k = 0;
        for (CompanyDto dto : list)
            data[k++] = new Object[]{dto.getId(), dto.getName(), dto.getDescription(), dto.getNumOfCars(),
                    dto.getCity(), dto.getCarList().size()};
        String[] header = {"ID", "Company Name", "Description", "Num of Cars", "City", "Car List"};

        JTableImpl table = new JTableImpl(header, data);
        table.setBounds(0, 0, 1024, 600);

        jDialog.add(new JScrollPane(table));
        jDialog.setVisible(true);
    }
}
