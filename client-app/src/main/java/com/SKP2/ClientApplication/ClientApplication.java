package com.SKP2.ClientApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class ClientApplication {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }
        MainFrame mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);
    }
}
