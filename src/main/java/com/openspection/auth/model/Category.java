package com.openspection.auth.model;

public enum Category {

SECRET_SHOPPING("Secret Shopping"),
SECRET_RESTAURANTS("Secret Restaurants"),
LANDMARKS("Landmarks"),
SPOUSES("Spouses"),
CELEBRITIES("Celebrities"),
CONCERTS("Concerts"),
LIVE_SPORTS("Live Sports"),
CONFERENCES("Conferences"),
NEW_VEHICLES("New Vehicles"),
AUTO_PARTS("Auto parts"),
CODE_REVIEWS("Code Reviews"),
WEBSITE_INVESTIGATIONS("Website Investigations"),
HACKING("Hacking"),
WATER("Water"),
SOIL("Soil"),
AIR_QUALITY("Air Quality"),
ACCOUNT_INVESTIGATION("Account Investigation"),
PUBLIC_FILINGS("Public Filings"),
CREDIT_CHECKS("Credit Checks"),
HOME_INVESTIGATIONS("Home Investigtions"),
TITLE_INVESTIGATIONS("Title Investigtions"),
DRONE_FLYOVERS("Drone Flyovers");

private String displayname;

    Category(String displayname) {
        this.displayname = displayname;
    }

    public String getDisplayname() {
        return displayname;
    }
}
