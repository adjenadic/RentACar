package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ClientDto;
import com.SKP2.ClientApplication.util.JTableImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class AllClientsController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setSize(1024, 768);

        List<ClientDto> list;
        try {
            list = MainFrame.getInstance().getUserService().getAllClients();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        Object[][] data = new Object[50][50];
        int k = 0;
        for (ClientDto dto : list)
            data[k++] = new Object[]{dto.getId(), dto.getUsername(), dto.getPassword(), dto.getEmail(),
                    dto.getDayOfBirth(), dto.getFirstName(), dto.getLastName(), dto.getPassport()};
        String[] header = {"ID", "Username", "Password", "Email", "Date of Birth",
                "Firstname", "Lastname", "Passport"};

        JTableImpl table = new JTableImpl(header, data);
        table.setBounds(0, 0, 1024, 768);

        jDialog.add(new JScrollPane(table));
        jDialog.setVisible(true);
    }
}
