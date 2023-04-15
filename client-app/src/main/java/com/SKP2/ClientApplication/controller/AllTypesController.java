package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.TypeDto;
import com.SKP2.ClientApplication.util.JTableImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class AllTypesController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setSize(1024, 768);

        List<TypeDto> list;
        try {
            list = MainFrame.getInstance().getRentalService().getAllTypes();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        Object[][] data = new Object[50][50];
        int k = 0;
        for (TypeDto dto : list)
            data[k++] = new Object[]{dto.getId(), dto.getName()};
        String[] header = {"ID", "Name"};

        JTableImpl table = new JTableImpl(header, data);
        table.setBounds(0, 0, 1024, 768);

        jDialog.add(new JScrollPane(table));
        jDialog.setVisible(true);
    }
}
