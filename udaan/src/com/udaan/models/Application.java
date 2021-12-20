package com.udaan.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    Map<String, User> userMap;
    Map<String, Deal> dealMap;
    Map<String, List<String>> userClaimedList;
    List<String> transactionHistory;

    public Application() {
        this.userMap = new HashMap<>();
        this.dealMap = new HashMap<>();
        this.userClaimedList = new HashMap<>();
        this.transactionHistory = new ArrayList<>();
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Map<String, Deal> getDealMap() {
        return dealMap;
    }

    public void setDealMap(Map<String, Deal> dealMap) {
        this.dealMap = dealMap;
    }

    public Map<String, List<String>> getUserClaimedList() {
        return userClaimedList;
    }

    public void setUserClaimedList(Map<String, List<String>> userClaimedList) {
        this.userClaimedList = userClaimedList;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }
}
