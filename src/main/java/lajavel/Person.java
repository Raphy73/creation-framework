package lajavel;

public class Person
{
    public String firstName;
    public String lastName;

    public Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstnameAndLastname()
    {
        return firstName + " " + lastName;
    }
}
