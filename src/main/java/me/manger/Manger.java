package me.manger;

import me.manger.db.LoadFile;
import me.manger.view.Login;

public class Manger {
    
    public static Login login;

    public static void main(String[] args) {

        LoadFile.loadDB();

        login = new Login();
        login.setLocationRelativeTo(null);
        login.setResizable(false);
        login.setVisible(true);

    }
    
}
