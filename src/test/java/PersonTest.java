import Models.Person;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PersonTest {
    String namePerson1 = "Steven Cardona";
    String namePerson2 = "Miguel Alfonso";
    Person p1;
    Person p2;

    @BeforeClass
    public void initialized() {
        p1 = new Person(namePerson1, 18, "1025640734");
        p2 = new Person(namePerson2, 18, "1025640735");
    }

    @Test
    public void checkNamePerson1() {
        Assert.assertEquals(p1.getName(), namePerson1);
    }

    @Test
    public void checkNamePerson2() {
        Assert.assertEquals(p2.getName(), namePerson2);
    }
}
