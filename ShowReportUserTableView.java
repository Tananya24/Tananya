package ku.cs.controllers.admin;

import javafx.beans.property.SimpleStringProperty;

public class ShowReportUserTableView {

    private SimpleStringProperty UserUsername;
    private SimpleStringProperty UserName;
    private SimpleStringProperty UserStore;
    private SimpleStringProperty UserRemark;
    private SimpleStringProperty UserTotalLogin;

    public ShowReportUserTableView(String userUsername, String userName, String userStore, String userRemark, String userTotalLogin) {
        UserUsername = new SimpleStringProperty(userUsername);
        UserName = new SimpleStringProperty(userName);
        UserStore = new SimpleStringProperty(userStore);
        UserRemark = new SimpleStringProperty(userRemark);
        UserTotalLogin = new SimpleStringProperty(userTotalLogin);
    }

    public String getUserUsername() {
        return UserUsername.get();
    }

    public void setUserUsername(String userUsername) {
        this.UserUsername=new SimpleStringProperty(userUsername);
    }

    public String getUserName() {
        return UserName.get();
    }

    public void setUserName(String userName) {
        this.UserName=new SimpleStringProperty(userName);
    }

    public String getUserStore() {
        return UserStore.get();
    }

    public void setUserStore(String userStore) {
        this.UserStore=new SimpleStringProperty(userStore);
    }

    public String getUserRemark() {
        return UserRemark.get();
    }

    public void setUserRemark(String userRemark) {
        this.UserRemark=new SimpleStringProperty(userRemark);
    }

    public String getUserTotalLogin() {
        return UserTotalLogin.get();
    }

    public void setUserTotalLogin(String userTotalLogin) {
        this.UserTotalLogin=new SimpleStringProperty(userTotalLogin);
    }
}
