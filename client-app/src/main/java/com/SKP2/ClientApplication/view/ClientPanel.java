package com.SKP2.ClientApplication.view;

import com.SKP2.ClientApplication.controller.*;

import javax.swing.*;

public class ClientPanel extends JPanel {
    public ClientPanel() {
        setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 1024, 30);
        add(menuBar);

        // User Service
        JMenu userService = new JMenu("User Service");
        menuBar.add(userService);

        JMenuItem deleteClient = new JMenuItem("Delete Client");
        userService.add(deleteClient);
        deleteClient.addActionListener(new DeleteClientController());

        JMenuItem updateClient = new JMenuItem("Update Client");
        userService.add(updateClient);
        updateClient.addActionListener(new UpdateClientController());

        userService.addSeparator();

        JMenuItem verifyEmail = new JMenuItem("Verify Email");
        userService.add(verifyEmail);
        verifyEmail.addActionListener(new VerificationEmailController());

        userService.addSeparator();

        JMenuItem discount = new JMenuItem("Get Discount By ID");
        userService.add(discount);
        discount.addActionListener(new DiscountController());

        // Rental Service
        JMenu rentalService = new JMenu("Rental Service");
        menuBar.add(rentalService);

        JMenuItem sortASC = new JMenuItem("Sort Cars ASC");
        rentalService.add(sortASC);
        sortASC.addActionListener(new SortASCController());

        JMenuItem sortDESC = new JMenuItem("Sort Cars DESC");
        rentalService.add(sortDESC);
        sortDESC.addActionListener(new SortDESCController());

        JMenuItem filter = new JMenuItem("Filter");
        rentalService.add(filter);
        filter.addActionListener(new FilterController());

        rentalService.addSeparator();

        JMenuItem sortCompaniesByRate = new JMenuItem("Sort Companies By Rate");
        rentalService.add(sortCompaniesByRate);
        sortCompaniesByRate.addActionListener(new SortCompaniesByRateController());

        rentalService.addSeparator();

        JMenuItem addReservation = new JMenuItem("Add Reservation");
        rentalService.add(addReservation);
        addReservation.addActionListener(new AddReservationController());

        JMenuItem cancelReservation = new JMenuItem("Cancel Reservation");
        rentalService.add(cancelReservation);
        cancelReservation.addActionListener(new CancelReservationController());

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
    }
}
