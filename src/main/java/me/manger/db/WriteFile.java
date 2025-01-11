package me.manger.db;

import me.manger.model.Company;
import me.manger.model.Database;
import me.manger.model.Notification;
import me.manger.model.building.Apartment;
import me.manger.model.building.Building;
import me.manger.model.ledger.Entry;
import me.manger.model.ledger.Ledger;
import me.manger.model.user.Admin;
import me.manger.model.user.Owner;
import me.manger.model.user.President;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class WriteFile {

    public static void saveDB() {
        saveLedger(Database.getLedger());
        saveCompany(Database.getCompany());
        saveAdmin(Database.getAdmin());
        savePresident(Database.getPresident());
        saveOwners(Database.getOwners());
        saveBuilding(Database.getBuilding());
        saveApartments(Database.getBuilding().getApartments());
    }

    public static void saveApartments(ArrayList<Apartment> apartments) {
        try {
            Files.write(Paths.get(FileNames.APARTMENTS), "".getBytes());
            for(Apartment apartment : apartments) {
                String content = apartment.getNumber() + "|"
                        + apartment.getArea() + "|"
                        + apartment.getBalance() + '\n';
                for(Owner owner : apartment.getOwners()) {
                    content += owner.getUsername() + "|";
                }
                if(content.charAt(content.length() - 1) == '|') {
                    content = content.substring(0, content.length() - 1);
                }
                content += '\n';
                Files.write(Paths.get(FileNames.APARTMENTS), content.getBytes(), StandardOpenOption.APPEND);
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveBuilding(Building building) {
        try {
            String content = building.getAddress() + '\n' + building.getTotalMoney();
            Files.write(Paths.get(FileNames.BUILDING), content.getBytes());
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveOwners(ArrayList<Owner> owners) {
        try {
            Files.write(Paths.get(FileNames.OWNERS), "".getBytes());
            BufferedWriter writer = new BufferedWriter(new FileWriter(FileNames.OWNERS, true));
            for(Owner owner : owners) {
                writer.write(owner.getFirstName() + "\n");
                writer.write(owner.getLastName() + "\n");
                writer.write(owner.getEmail() + "\n");
                writer.write(owner.getPhone() + "\n");
                writer.write(owner.getUsername() + "\n");
                writer.write(owner.getPassword() + "\n");
                for(Notification notif : owner.getNotifications()) {
                    writer.write(notif.getDate().getTime() + "|" + notif.getMessage() + "\n");
                }
                writer.write("#\n");
            }
            writer.close();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void savePresident(President president) {
        try {
            String content = president.getFirstName() + '\n'
                    + president.getLastName() + '\n'
                    + president.getEmail() + '\n'
                    + president.getPhone() + '\n'
                    + president.getUsername() + '\n'
                    + president.getPassword() + '\n';
            for(Notification notification : president.getNotifications()) {
                content += notification.getDate().getTime() + "|" + notification.getMessage() + '\n';
            }
            Files.write(Paths.get(FileNames.PRESIDENT), content.getBytes());
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveAdmin(Admin admin) {
        try {
            String content = admin.getUsername() + "\n" + admin.getPassword();
            Files.write(Paths.get(FileNames.ADMIN), content.getBytes());
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveCompany(Company company) {
        try {
            String content = company.getName() + '\n'
                    + company.getEmail() + '\n'
                    + company.getPhoneNumber() + '\n'
                    + company.getPrice();
            Files.write(Paths.get(FileNames.COMPANY), content.getBytes());
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveLedger(Ledger ledger) {
        try {
            String content = "";
            for(Entry entry : ledger.getEntries()) {
                content += entry.getDate().getTime() + "|" + entry.getMessage() + '\n';
            }
            Files.write(Paths.get(FileNames.LEDGER), content.getBytes());
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

}
