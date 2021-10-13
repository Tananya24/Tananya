package ku.cs.controllers.admin;

import java.util.ArrayList;

public class Account {
    private String username;
    private String password;

    ArrayList<Account> accounts;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account() {
        accounts = new ArrayList<>();
    }

    public Account getAdmin(String username) {
        for (Account admin : accounts) {
            if (admin.getUsername().equals(username)) {
                return admin;
            }
        }
        return null;
    }

    public boolean checkAdminLogin(String username, String password) {
        for (Account admin : accounts) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return true;
            }

        }
        return false;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void add(Account newAdmin) {
        accounts.add(newAdmin);
    }


}
