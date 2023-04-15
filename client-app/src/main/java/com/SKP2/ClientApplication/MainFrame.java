package com.SKP2.ClientApplication;

import com.SKP2.ClientApplication.dto.UserDto;
import com.SKP2.ClientApplication.rest.NotificationService;
import com.SKP2.ClientApplication.rest.RentalService;
import com.SKP2.ClientApplication.rest.UserService;
import com.SKP2.ClientApplication.token.TokenDecoder;
import com.SKP2.ClientApplication.view.AdminPanel;
import com.SKP2.ClientApplication.view.ClientPanel;
import com.SKP2.ClientApplication.view.LoginPanel;
import com.SKP2.ClientApplication.view.ManagerPanel;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class MainFrame extends JFrame {
    private static MainFrame instance = null;
    private String token;
    private UserDto activeUser;
    private TokenDecoder tokenDecoder;

    private UserService userService;
    private RentalService rentalService;
    private NotificationService notificationService;

    private JPanel currentPanel = null;
    private JPanel registerManagerPanel;
    private JPanel registerClientPanel;
    private JPanel loginPanel;
    private JPanel adminPanel;
    private JPanel managerPanel;
    private JPanel clientPanel;

    public MainFrame() {
        setTitle("SK_Project2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);
        setResizable(false);

        tokenDecoder = new TokenDecoder();
        userService = new UserService();
        rentalService = new RentalService();
        notificationService = new NotificationService();

        loginPanel = new LoginPanel();
        adminPanel = new AdminPanel();
        managerPanel = new ManagerPanel();
        clientPanel = new ClientPanel();

        showLoginPanel();
    }

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }

    public void showLoginPanel() {
        currentPanel = loginPanel;
        this.getContentPane().setVisible(false);
        this.getContentPane().removeAll();
        this.getContentPane().add(currentPanel);
        this.getContentPane().setVisible(true);
    }

    public void showAdminPanel() {
        currentPanel = adminPanel;
        this.getContentPane().setVisible(false);
        this.getContentPane().removeAll();
        this.getContentPane().add(currentPanel);
        this.getContentPane().setVisible(true);
    }

    public void showManagerPanel() {
        currentPanel = managerPanel;
        this.getContentPane().setVisible(false);
        this.getContentPane().removeAll();
        this.getContentPane().add(currentPanel);
        this.getContentPane().setVisible(true);
    }

    public void showClientPanel() {
        currentPanel = clientPanel;
        this.getContentPane().setVisible(false);
        this.getContentPane().removeAll();
        this.getContentPane().add(currentPanel);
        this.getContentPane().setVisible(true);
    }
}