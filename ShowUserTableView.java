package ku.cs.controllers.admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.ImageView;

public class ShowUserTableView {
    private ImageView Userphoto;
    private SimpleStringProperty UserUsername;
    private SimpleStringProperty UserName;
    private SimpleStringProperty UserStore;
    private SimpleStringProperty UserDate;
    private SimpleStringProperty UserTime;

    public ShowUserTableView(ImageView empPhoto, String userUsername, String userName, String userStore, String userDate, String userTime) {
        this.Userphoto = empPhoto;
        UserUsername = new SimpleStringProperty(userUsername);
        UserName = new SimpleStringProperty(userName);
        UserStore = new SimpleStringProperty(userStore);
        UserDate = new SimpleStringProperty(userDate);
        UserTime = new SimpleStringProperty(userTime);
    }

    public ImageView getImage() {
        return Userphoto;
    }

    public void setImage(ImageView photo) {
        this.Userphoto = photo;
    }

    public String getUserUsername() {
        return UserUsername.get();
    }

    public void setUserUsername(String userUsername) {
        UserUsername  = new SimpleStringProperty(userUsername);
    }

    public String getUserName() {
        return UserName.get();
    }

    public void setUserName(String userName) {
        UserName = new SimpleStringProperty(userName);
    }

    public String getUserStore() {
        return UserStore.get();
    }

    public void setUserStore(String userStore) {
        UserStore  = new SimpleStringProperty(userStore);
    }

    public String getUserDate() {
        return UserDate.get();
    }

    public void setUserDate(String userDate) {
        UserDate = new SimpleStringProperty(userDate);
    }

    public String getUserTime() {
        return UserTime.get();
    }

    public void setUserTime(String userTime) {
        UserTime = new SimpleStringProperty(userTime);
    }
//    public ShowUserTableView(String userImage, String userUsername, String userName, String userStore, String userDate, String userTime) {
//        UserImage = new SimpleStringProperty(userImage);
//        UserUsername =  new SimpleStringProperty(userUsername);
//        UserName =  new SimpleStringProperty(userName);
//        UserStore =  new SimpleStringProperty(userStore);
//        UserDate =  new SimpleStringProperty(userDate);
//        UserTime =  new SimpleStringProperty(userTime);
//    }
//
//    public String getUserImage() {
//        return UserImage.get();
//    }
//
//    public void setUserImage(String userImage) {
//        UserImage =  new SimpleStringProperty(userImage);
//    }
//
//    public String getUserUsername() {
//        return UserUsername.get();
//    }
//
//    public void setUserUsername(String userUsername) {
//        UserUsername =  new SimpleStringProperty(userUsername);
//    }
//
//    public String getUserName() {
//        return UserName.get();
//    }
//
//    public void setUserName(String userName) {
//        UserName =  new SimpleStringProperty(userName);
//    }
//
//    public String getUserStore() {
//        return UserStore.get();
//    }
//
//    public void setUserStore(String userStore) {
//        UserStore =  new SimpleStringProperty(userStore);
//    }
//
//    public String getUserDate() {
//        return UserDate.get();
//    }
//
//    public void setUserDate(String userDate) {
//        UserDate =  new SimpleStringProperty(userDate);
//    }
//
//    public String getUserTime() {
//        return UserTime.get();
//    }
//
//    public void setUserTime(String userTime) {
//        UserTime =  new SimpleStringProperty(userTime);
//    }
}
