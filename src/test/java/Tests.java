import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Tests {

    @Test
    public void nullaryConstructorTest() {
        PhoneBook phoneBook = new PhoneBook();

        Assert.assertTrue(phoneBook.getMap() instanceof HashMap);
    }

    @Test
    public void addAllTest() {
        PhoneBook phoneBook = new PhoneBook();
        String name = "Joe";
        String[] phoneNumbers = {
                "302-555-4444",
                "302-555-3333",
                "302-555-2222",
                "302-555-1111",
        };

        phoneBook.addAll(name, phoneNumbers);
        List<String> actualPhoneNumbers = phoneBook.lookup(name);
        Assert.assertEquals(Arrays.asList(phoneNumbers), actualPhoneNumbers);
    }

    @Test
    public void removeTest() {
        PhoneBook phoneBook = new PhoneBook();
        String name = "John";
        String phoneNumber = "302-555-4545";
        phoneBook.add(name, phoneNumber);
        Assert.assertTrue(phoneBook.hasEntry(phoneNumber));

        phoneBook.remove(name);

        Assert.assertFalse(phoneBook.hasEntry(name));
    }

    @Test
    public void reverseLookUpTest() {
        PhoneBook phoneBook = new PhoneBook();
        String expectedName = "John";
        String phoneNumber = "302-555-4545";
        phoneBook.add(expectedName, phoneNumber);
        Assert.assertTrue(phoneBook.hasEntry(phoneNumber));

        String actualName = phoneBook.reverseLookup(phoneNumber);

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getAllContactNamesTest() {
        PhoneBook phoneBook = new PhoneBook();
        String[] names = new String[]{"John", "Joe", "Jim", "Jay"};
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            phoneBook.add(name, "");
        }

        List<String> actualNames = phoneBook.getAllContactNames();

        Assert.assertEquals(Arrays.asList(names), actualNames);
    }

}
