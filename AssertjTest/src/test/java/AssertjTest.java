import DTO.Address;
import DTO.Person;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;


public class AssertjTest {

    @Test
    public void testAsserj() {
        Address expectedAddress = new Address("New York", "10001");
        Person expectedPerson = new Person("Alice", 30, expectedAddress);

        // Create the actual Person object with a different age
        Address actualAddress = new Address("New York", "10001");
        Person actualPerson = new Person("Alice", 35, actualAddress);

        // Use AssertJ to compare the objects while ignoring the "age" field
        Assertions.assertThat(actualPerson)
                .usingRecursiveComparison()
                .ignoringFields("age")  // Ignore the "age" field during comparison
                .isEqualTo(expectedPerson);
    }
}
