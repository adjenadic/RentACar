package com.SKP2.ClientApplication.view;

import com.SKP2.ClientApplication.controller.*;

import javax.swing.*;

public class AdminPanel extends JPanel {
    public AdminPanel() {
        setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 1024, 30);
        add(menuBar);

        // User Service
        JMenu userService = new JMenu("User Service");
        menuBar.add(userService);

        JMenuItem allClients = new JMenuItem("All Clients");
        userService.add(allClients);
        allClients.addActionListener(new AllClientsController());

        JMenuItem byClientId = new JMenuItem("Get By Client ID");
        userService.add(byClientId);
        byClientId.addActionListener(new ClientByIdController());

        JMenuItem registerClient = new JMenuItem("Register Client");
        userService.add(registerClient);
        registerClient.addActionListener(new RegisterClientController());

        JMenuItem updateClient = new JMenuItem("Update Client");
        userService.add(updateClient);
        updateClient.addActionListener(new UpdateClientController());

        JMenuItem deleteClient = new JMenuItem("Delete Client");
        userService.add(deleteClient);
        deleteClient.addActionListener(new DeleteClientController());

        userService.addSeparator();

        JMenuItem allManagers = new JMenuItem("All Managers");
        userService.add(allManagers);
        allManagers.addActionListener(new AllManagersController());

        JMenuItem byManagerId = new JMenuItem("Get By Manager ID");
        userService.add(byManagerId);
        byManagerId.addActionListener(new ManagerByIdController());

        JMenuItem registerManager = new JMenuItem("Register Manager");
        userService.add(registerManager);
        registerManager.addActionListener(new RegisterManagerController());

        JMenuItem deleteManager = new JMenuItem("Delete Manager");
        userService.add(deleteManager);
        deleteManager.addActionListener(new DeleteManagerController());

        JMenuItem updateManager = new JMenuItem("Update Manager");
        userService.add(updateManager);
        updateManager.addActionListener(new UpdateManagerController());

        userService.addSeparator();

        JMenuItem byAdminId = new JMenuItem("Get By Admin ID");
        userService.add(byAdminId);
        byAdminId.addActionListener(new AdminByIdController());

        JMenuItem updateAdmin = new JMenuItem("Update Admin");
        userService.add(updateAdmin);
        updateAdmin.addActionListener(new UpdateAdminController());

        userService.addSeparator();

        JMenuItem accountBlocking = new JMenuItem("Account Blocking");
        userService.add(accountBlocking);
        accountBlocking.addActionListener(new ForbidController());

        userService.addSeparator();

        JMenuItem addRank = new JMenuItem("Add Rank");
        userService.add(addRank);
        addRank.addActionListener(new AddRankController());

        userService.addSeparator();

        JMenuItem discount = new JMenuItem("Get Discount By ID");
        userService.add(discount);
        discount.addActionListener(new DiscountController());

        // Rental Service
        JMenu rentalService = new JMenu("Rental Service");
        menuBar.add(rentalService);

        JMenuItem filter = new JMenuItem("Filter");
        rentalService.add(filter);
        filter.addActionListener(new FilterController());

        JMenuItem sortASC = new JMenuItem("Sort Cars ASC");
        rentalService.add(sortASC);
        sortASC.addActionListener(new SortASCController());

        JMenuItem sortDESC = new JMenuItem("Sort Cars DESC");
        rentalService.add(sortDESC);
        sortDESC.addActionListener(new SortDESCController());

        rentalService.addSeparator();

        JMenuItem sortCompaniesByRate = new JMenuItem("Sort Companies By Rate");
        rentalService.add(sortCompaniesByRate);
        sortCompaniesByRate.addActionListener(new SortCompaniesByRateController());

        rentalService.addSeparator();

        JMenuItem findAllReviews = new JMenuItem("Find All Reviews");
        rentalService.add(findAllReviews);
        findAllReviews.addActionListener(new FindAllController());

        JMenuItem byReviewID = new JMenuItem("Find By Review ID");
        rentalService.add(byReviewID);
        byReviewID.addActionListener(new FindByIdController());

        JMenuItem filterReview = new JMenuItem("Filter Review");
        rentalService.add(filterReview);
        filterReview.addActionListener(new FilterReviewController());

        JMenuItem addReview = new JMenuItem("Add Review");
        rentalService.add(addReview);
        addReview.addActionListener(new AddReviewController());

        JMenuItem deleteReview = new JMenuItem("Delete Review");
        rentalService.add(deleteReview);
        deleteReview.addActionListener(new DeleteReviewController());

        JMenuItem updateReview = new JMenuItem("Update Review");
        rentalService.add(updateReview);
        updateReview.addActionListener(new UpdateReviewController());

        // Notification Service
        JMenu notificationService = new JMenu("Notification Service");
        menuBar.add(notificationService);

        JMenuItem allEmails = new JMenuItem("All Emails");
        notificationService.add(allEmails);
        allEmails.addActionListener(new AllEmailsController());

        JMenuItem filterEmails = new JMenuItem("Filter Emails");
        notificationService.add(filterEmails);
        filterEmails.addActionListener(new FilterEmailsController());

        notificationService.addSeparator();

        JMenuItem allNotifTypes = new JMenuItem("All Notification Types");
        notificationService.add(allNotifTypes);
        allNotifTypes.addActionListener(new AllNotificationTypesController());

        JMenuItem notifTypeByID = new JMenuItem("Notification Type By ID");
        notificationService.add(notifTypeByID);
        notifTypeByID.addActionListener(new NotifTypeByIdController());

        JMenuItem registerNotif = new JMenuItem("Register Notification Type");
        notificationService.add(registerNotif);
        registerNotif.addActionListener(new RegisterNotifTypeController());

        JMenuItem deleteNotif = new JMenuItem("Delete Notification Type");
        notificationService.add(deleteNotif);
        deleteNotif.addActionListener(new DeleteNotifTypeController());

        JMenuItem updateNotif = new JMenuItem("Update Notification Type");
        notificationService.add(updateNotif);
        updateNotif.addActionListener(new UpdateNotifTypeController());
    }
}
