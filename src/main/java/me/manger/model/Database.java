package me.manger.model;

import me.manger.model.ledger.Ledger;
import me.manger.model.user.Admin;
import me.manger.model.user.Owner;
import me.manger.model.user.President;

import java.util.ArrayList;

public class Database {

    private static Company company;
    private static Building building;
    private static Admin admin;
    private static President president;
    private static ArrayList<Owner> owners;
    private static Ledger ledger;

    private Database() {}

    public static Company getCompany() {
        return company;
    }

    public static Building getBuilding() {
        return building;
    }

    public static Admin getAdmin() {
        return admin;
    }

    public static President getPresident() {
        return president;
    }

    public static ArrayList<Owner> getOwners() {
        return owners;
    }

    public static Ledger getLedger() {
        return ledger;
    }

    public static void setCompany(Company company) {
        Database.company = company;
    }

    public static void setBuilding(Building building) {
        Database.building = building;
    }

    public static void setAdmin(Admin admin) {
        Database.admin = admin;
    }

    public static void setPresident(President president) {
        Database.president = president;
    }

    public static void setOwners(ArrayList<Owner> owners) {
        Database.owners = owners;
    }

    public static void setLedger(Ledger ledger) {
        Database.ledger = ledger;
    }

}
