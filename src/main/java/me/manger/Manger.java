package me.manger;

import me.manger.db.LoadFile;
import me.manger.db.WriteFile;
import me.manger.view.Login;

public class Manger {

	public static void main(String[] args) {

            LoadFile.loadDB();
            
            Login login = new Login();
            login.setVisible(true);
            login.setLocationRelativeTo(null);
            login.setResizable(false);
            
            WriteFile.saveDB();

	}
}
