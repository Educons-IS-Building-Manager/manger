package me.manger.model.ledger;

import java.util.ArrayList;

public class Ledger {

    private ArrayList<Entry> entries;

    public Ledger(ArrayList<Entry> entries) {
        this.entries = entries;
    }

    public ArrayList<Entry> getEntries() {
        return entries;
    }

}
