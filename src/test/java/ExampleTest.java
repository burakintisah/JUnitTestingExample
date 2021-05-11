import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExampleTest {

    @Test
    //@Disabled("Not implemented yet!")
    @DisplayName("Should demonstrate a simple assertion.")
    void shouldShowSimpleAssertion() {
        Assertions.assertEquals(1,1);
    }

    @Test
    void shouldCheckAllItemsInTheList() {
        List<Integer> numbers = List.of(2,3,5,7);
        Assertions.assertAll(
                () -> assertEquals((Integer)2, numbers.get(0)),
                () -> assertEquals((Integer)3, numbers.get(1)),
                () -> assertEquals((Integer)5, numbers.get(2)),
                () -> assertEquals((Integer)7, numbers.get(3))
        );
    }
    @Test
    void shouldCreateUserWithDemograficInfo() {
        Object [] userInfo = { "Ali", "Veli", "Ankara", 17, "Cough", 36.5};
        User user = new User (userInfo);
    }
    @Test
    void shouldNotCreateUserWithInfo() {
        Object [] userInfo1 = { "Ali", "Veli", "Ankara", Integer.MAX_VALUE, "Cough", "36.5"};
        Object [] userInfo2 = { "Ali", "Veli", "Ankara", 12 , "Cough", "36.5"};

        Assertions.assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new User(userInfo1)),
                () -> assertThrows(ClassCastException.class, () -> new User(userInfo2) )
        );
    }

    @Test
    void checkShowAlertFunction() {
        Object [] userInfo1 = { "Ali", "Veli", "Ankara", 18, "Cough", 36.5};
        Object [] userInfo2 = { "Ali", "Veli", "Ankara", 18, "Cough", 40.0};

        User user1 = new User (userInfo1);
        User user2 = new User (userInfo2);

        Assertions.assertAll(
                () -> assertEquals(false, user1.checkAlert()),
                () -> assertEquals(true, user2.checkAlert())
        );
    }
    @Before
    // this method is called before EACH test method execution
    public void before() {
        System.out.println("This is before method.");
    }

    @After
    // this method is called after EACH test method execution
    public void after() {
        System.out.println("This is after method.");
    }

    @BeforeClass
    // this method is called ONLY ONCE before test class execution
    public static void beforeClass() {
        System.out.println("This is beforeClass method.");
    }

    @AfterClass
    // this method is called ONLY ONCE after test class execution
    public static void afterClass() throws Exception {
        System.out.println("This is afterClass method.");
    }
}
