package ku.cs.controllers.purchaser;

public class SavePurchaseUserName {

    // SimpleStringProperty ใช้ในการรวมกลุ่มของค่า string

    private String username;
    private String name;
    private String password;
    private String confirmPassword;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    // constructor
    public SavePurchaseUserName (String name, String username, String password, String confirmPassword){
        this.name = name;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }






}
