package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.EmailDto;
import com.SKP2.ClientApplication.util.JTableImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class AllEmailsController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setSize(1024, 768);

        List<EmailDto> list;
        try {
            list = MainFrame.getInstance().getNotificationService().getAllEmails();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        Object[][] data = new Object[50][50];
        int k = 0;
        for (EmailDto dto : list)
            data[k++] = new Object[]{dto.getSubject(), dto.getContext(), dto.getEmailFrom(), dto.getEmailTo(),
                    dto.getDate()};
        String[] header = {"Subject", "Context", "Email from", "Email to", "Date"};

        JTableImpl table = new JTableImpl(header, data);
        table.setBounds(0, 0, 1024, 768);

        jDialog.add(new JScrollPane(table));
        jDialog.setVisible(true);
    }
}
