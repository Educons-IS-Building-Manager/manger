package me.manger.db;

import me.manger.model.Company;
import me.manger.model.Database;
import me.manger.model.Notification;
import me.manger.model.Apartment;
import me.manger.model.Building;
import me.manger.model.ledger.Entry;
import me.manger.model.ledger.Ledger;
import me.manger.model.user.Admin;
import me.manger.model.user.Owner;
import me.manger.model.user.President;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LoadFile {

    public static void loadDB() {
        Database.setLedger(loadLedger());
        Database.setCompany(loadCompany());
        Database.setAdmin(loadAdmin());
        Database.setPresident(loadPresident());
        Database.setOwners(loadOwners());
        Database.setBuilding(loadBuilding());
        loadApartments();
    }

    public static void loadApartments() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FileNames.APARTMENTS));
            String line;
            while((line = reader.readLine()) != null) {
                String[] line1 = line.split("\\|");
                String tempLine = reader.readLine();
                String[] line2 = {};
                if(tempLine != null) {
                    line2 = tempLine.split("\\|");
                }
                Apartment apartment = new Apartment(
                        Integer.parseInt(line1[0]),
                        Double.parseDouble(line1[1]),
                        Double.parseDouble(line1[2]));
                Database.getBuilding().getApartments().add(apartment);
                for(String temp : line2) {
                    for(Owner owner : Database.getOwners()) {
                        if(temp.equals(owner.getUsername())) {
                            apartment.getOwners().add(owner);
                            owner.getApartments().add(apartment);
                        }
                    }
                }
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Building loadBuilding() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(FileNames.BUILDING));
            if(lines.isEmpty()) {
                throw new RuntimeException("Empty building file");
            }
            return new Building(lines.get(0), Double.parseDouble(lines.get(1)));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Owner> loadOwners() {
        try {
            ArrayList<Owner> owners = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(FileNames.OWNERS));
            String line = reader.readLine();
            while(line != null) {
                String firstName = line;
                String lastName = reader.readLine();
                String email = reader.readLine();
                String phone = reader.readLine();
                String username = reader.readLine();
                String password = reader.readLine();
                ArrayList<Notification> notifications = new ArrayList<>();
                while(!Objects.equals(line = reader.readLine(), "#")) {
                    String[] notif = line.split("\\|");
                    notifications.add(new Notification(Long.parseLong(notif[0]), notif[1]));
                }
                owners.add(new Owner(firstName, lastName, email, phone, username, password,
                        notifications, new ArrayList<>()));
                line = reader.readLine();
            }
            reader.close();
            return owners;
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static President loadPresident() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(FileNames.PRESIDENT));
            if(lines.isEmpty()) {
                throw new RuntimeException("Empty president file");
            }
            ArrayList<Notification> notifications = new ArrayList<>();
            for(int i = 6; i < lines.size(); i++) {
                String[] data = lines.get(i).split("\\|");
                notifications.add(new Notification(Long.parseLong(data[0]), data[1]));
            }
            return new President(lines.get(0), lines.get(1), lines.get(2), lines.get(3), lines.get(4), lines.get(5), notifications);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Admin loadAdmin() {
        try {
            String line = Files.readString(Paths.get(FileNames.ADMIN));
            if(line.isEmpty()) {
                throw new RuntimeException("Empty admin file");
            }
            String[] data = line.split("\n");
            return new Admin(data[0], data[1]);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Company loadCompany() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(FileNames.COMPANY));
            if(lines.isEmpty()) {
                throw new RuntimeException("Empty company file");
            }
            return new Company(lines.get(0), lines.get(1), lines.get(2), Double.parseDouble(lines.get(3)));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Ledger loadLedger() {
        ArrayList<Entry> entries = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(FileNames.LEDGER));
            if(lines.isEmpty()) {
                return new Ledger();
            }
            for(String line : lines) {
                String[] data = line.split(("\\|"));
                entries.add(new Entry(Long.parseLong(data[0]), data[1]));
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return new Ledger(entries);
    }

}
