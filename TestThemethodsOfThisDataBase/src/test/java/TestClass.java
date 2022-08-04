import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestClass {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService = new UserService();

    @Test
   public void testPasswordHasher(){
       String hashedpassWord = userService.scramblePassword("test");
        Assert.assertEquals("uftu", hashedpassWord);
   }

   @Test
   public void testLogin(){
        String hashedPassword = userService.scramblePassword("test");
        when(userRepository.findOneById("test")).thenReturn(new User("test", hashedPassword));


        User user = userService.login("test", "test");
        Assert.assertEquals("test", user.getUserName());
        Assert.assertEquals("uftu", user.getPassWordHashed());

   }
@Test
    public void testBadLogin(){
        String hashedPassword = userService.scramblePassword("test");
        when(userRepository.findOneById("test")).thenReturn(new User("test", hashedPassword));
        User user = userService.login("test", "badPassword");
        Assert.assertNull(user);


    }

    @Test
    public void testUserCreator(){
        String hashedPassword = userService.scramblePassword("test");
        userRepository.createOne(new User("test", "test"));
        // to use to test void method in mockito instead of when
        verify(userRepository,times(1)).createOne(any(User.class));
        when(userRepository.findOneById("test")).thenReturn(new User("test", hashedPassword));

        User user = userService.createUserWithHasher("test", "test");
        Assert.assertEquals("test", user.getUserName());
        Assert.assertEquals("uftu", user.getPassWordHashed());

    }



}
