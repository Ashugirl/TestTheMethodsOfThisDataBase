import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String userName;
    private String passWordHashed;

    public User() {
    }

    public User(String userName, String passWordHashed) {
        this.userName = userName;
        this.passWordHashed = passWordHashed;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWordHashed() {
        return passWordHashed;
    }

    public void setPassWordHashed(String passWordHashed) {
        this.passWordHashed = passWordHashed;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWordHashed='" + passWordHashed + '\'' +
                '}';
    }
}
