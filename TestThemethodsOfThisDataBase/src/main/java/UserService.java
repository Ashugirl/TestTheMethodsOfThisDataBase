
import java.nio.charset.StandardCharsets;

public class UserService {


    private UserRepository userRepository;

    public UserService() {

    }


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //To test this method, create a mock user with
    public User login(String userName, String passWord) {

        User user = userRepository.findOneById(userName);
        String hashedPassWord = scramblePassword(passWord);//needs to be hashes first
        if (hashedPassWord.equals(user.getPassWordHashed())) {
            return user;
        }

        return null;
    }


    public User createUserWithHasher(String userName, String passWord) {

        String hashedPassWord = scramblePassword(passWord);
        userRepository.createOne(new User(userName, hashedPassWord));
        return userRepository.findOneById(userName);
    }

    public String scramblePassword(String password) {

        String scrambledPassword = "";
        for (int pos = 0; pos < password.length(); pos++) {
            char currentLetter = password.charAt(pos);
            char newLetter = ++currentLetter;
            scrambledPassword = scrambledPassword.concat(Character.toString(newLetter));

        }

        return scrambledPassword;
    }
}