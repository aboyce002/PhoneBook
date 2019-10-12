import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> map;

    public PhoneBook(Map<String, List<String>> map) {
        this.map = map;
    }

    public PhoneBook(){
        this(new HashMap<String, List<String>>());
    }

    public void add(String name, String phoneNumber) {
        List<String> nums = new ArrayList<String>();
        nums.add(phoneNumber);
        map.put(name, nums);
    }

    public void addAll(String name, String... phoneNumbers) {
        map.put(name, Arrays.asList(phoneNumbers));
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
        List<String> nums;
        String result = "";
        for ( String key : map.keySet() ) {
            nums = map.get(key);
            for ( String k : nums) {
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
