package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ManagerDto;
import com.SKP2.ClientApplication.util.JTableImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class AllManagersController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setSize(1024, 768);

        List<ManagerDto> list;
        try {
            list = MainFrame.getInstance().getUserService().getAllManagers();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        Object[][] data = new Object[50][50];
        int k = 0;
        for (ManagerDto dto : list)
            data[k++] = new Object[]{dto.getId(), dto.getUsername(), dto.getPassword(), dto.getEmail(),
                    dto.getDayOfBirth(), dto.getFirstName(), dto.getLastName(), dto.getCompanyName(), dto.getEmploymentDay()};
        String[] header = {"ID", "Username", "Password", "Email", "Date of Birth",
                "Firstname", "Lastname", "Company Name", "Employment Day"};

        JTableImpl table = new JTableImpl(header, data);
        table.setBounds(0, 0, 1024, 768);

        jDialog.add(new JScrollPane(table));
        jDialog.setVisible(true);
    }
}
