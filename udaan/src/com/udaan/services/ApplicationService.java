package com.udaan.services;

import com.udaan.models.Application;
import com.udaan.models.Deal;
import com.udaan.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationService {
    Application application;
    public static final Long time = 3600000L;

    public ApplicationService() {
        this.application = new Application();
    }

    public void createUser(String userName) {
        if (application.getUserMap().containsKey(userName)) {
            System.out.println("User with the userName " + userName + " already exist");
        } else {
            User user = new User(userName);
            application.getUserMap().put(userName, user);
            String transactionDetails = "User created with userName " + userName + " userId " + user.getUserId();
            application.getTransactionHistory().add(transactionDetails);
            System.out.println(transactionDetails);
        }
    }
    public void addDeal(String name, int noOfItem, double price, int hr) {
        Long expireTime = (time * hr) + System.currentTimeMillis();
        Deal deal =  new Deal(name, noOfItem, price, expireTime);
        application.getDealMap().put(deal.getDealId(), deal);
        String transactionDetails = "Deal created with dealName " + name + " and dealId " + deal.getDealId();
        application.getTransactionHistory().add(transactionDetails);
        System.out.println(transactionDetails);
    }

    public void updateDeal(String dealId, int noOfItem, double price, int hr) {
        if (application.getDealMap().containsKey(dealId)) {
            Deal deal = application.getDealMap().get(dealId);
            deal.setNoOfItems(deal.getNoOfItems() + noOfItem);
            deal.setDealPrice(price);
            Long expireTime = time * hr * System.currentTimeMillis();
            deal.setExpireDate(expireTime);
            application.getDealMap().put(dealId, deal);
            String transactionDetails = "Deal updated with id " + dealId;
            application.getTransactionHistory().add(transactionDetails);
            System.out.println(transactionDetails);
        } else {
            System.out.println("Deal Id not exist");
        }
    }
    public void endDeal(String dealId) {
        if (application.getDealMap().containsKey(dealId)) {
            application.getDealMap().remove(dealId);
            String transactionDetails = "Deal ended with Id " + dealId;
            application.getTransactionHistory().add(transactionDetails);
            System.out.println(transactionDetails);
        } else {
            System.out.println("Deal Id not exist");
        }
    }

    public void claimDeal(String userName, String dealId) {
        if (application.getDealMap().containsKey(dealId)) {
            if (!application.getUserMap().containsKey(userName)) {
                application.getUserMap().put(userName, new User(userName));
            }
            Long currentTime = System.currentTimeMillis();
            //4*60*60*1000
            Deal  deal = application.getDealMap().get(dealId);
            List<String> dealClaimedByUser = application.getUserClaimedList().getOrDefault(userName, new ArrayList<>());
            for (String id : dealClaimedByUser) {
                Deal currentDeal = application.getDealMap().get(id);
                if (currentDeal.getDealId().equalsIgnoreCase(dealId)) {
                    System.out.println("User already claimed this deal");
                    return;
                }
            }

            if (deal.getNoOfItems() > 0 && deal.getExpireDate() > currentTime) {
                deal.setNoOfItems(deal.getNoOfItems() - 1);
                dealClaimedByUser.add(dealId);
                application.getUserClaimedList().put(userName, dealClaimedByUser);
                application.getTransactionHistory().add(userName + " claimed deal " + dealId);
                System.out.println("User " + userName + " claimed deal " + dealId);
            } else {
                System.out.println("User can't claim this deal");
            }
        } else {
            System.out.println("Deal is not exist with dealId " + dealId);
        }
    }

    public void printTransactionDetails() {
        for (String transaction : application.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }
}
