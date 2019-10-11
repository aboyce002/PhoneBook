import java.util.*;

public class PhoneBook {
    Map<String, List<String>> map = new HashMap<String, List<String>>();

    public PhoneBook(Map<String, List<String>> map) {
        this.map = map;
    }

    public PhoneBook() {
        this(null);
    }

    public void add(String name, String phoneNumber) {
        List<String> nums = new ArrayList<String>();
        nums.add(phoneNumber);
        map.put(name, nums);
    }

    public void addAll(String name, String... phoneNumbers) {
        List<String> nums = new ArrayList<String>();
        for ( String key : phoneNumbers) {
            nums.add(key);
            map.put(name, nums);
        }
    }

    public void remove(String name) {
        map.remove(name);
    }

    public Boolean hasEntry(String name) {
        return map.containsKey(name);
    }

    public List<String> lookup(String name) {
        return map.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        List<String> names;
        String result = "";
        for ( String key : map.keySet() ) {
            names = map.get(key);
            for ( String k : names) {
                if(k.equals(phoneNumber))
                    return key;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        return new ArrayList<String>(map.keySet());
    }

    public Map<String, List<String>> getMap() {
        return map;
    }
}
