package com.operrappium.serenity.cucumber.features.utils;

public class TestDataSetup {
    public static String getCredits() {
        return credits;
    }

    public static void setCredits(String credits) {
        TestDataSetup.credits = credits;
    }

    private static String credits;
    private static String studioName;
    private static int classLen;
    public static int getClassLen() {
        return classLen;
    }

    public static void setClassLen(int classLen) {
        TestDataSetup.classLen = classLen;
    }

    public static String getStudioName() {
        return studioName;
    }

    public static void setStudioName(String studioName) {
        TestDataSetup.studioName = studioName;
    }


    private static String doNotSkipStep = "Y";
    public static String getDoNotSkipStep() {
        return doNotSkipStep;
    }

    public static void setDoNotSkipStep(String doNotSkipStep) {
        TestDataSetup.doNotSkipStep = doNotSkipStep;
    }

    private static String pickUp_dropOff_add;
    public static String getPickUp_dropOff_add() {
        return pickUp_dropOff_add;
    }

    public static void setPickUp_dropOff_add(String pickUp_dropOff_add) {
        TestDataSetup.pickUp_dropOff_add = pickUp_dropOff_add;
    }

    private static String scheduled_trip_Id;
    public static String getScheduled_trip_Id() {
        return scheduled_trip_Id;
    }

    public static void setScheduled_trip_Id(String scheduled_trip_Id) {
        TestDataSetup.scheduled_trip_Id = scheduled_trip_Id;
    }


}
