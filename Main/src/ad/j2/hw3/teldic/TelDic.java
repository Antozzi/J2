package ad.j2.hw3.teldic;

import java.util.*;

public class TelDic {

    private final HashMap<String, List<String>> phonebook;

    public TelDic(){
        this.phonebook = new HashMap<>();
    }

    public void add(String surname, String number){
        if(phonebook.containsKey(surname)){
            List<String> numbers = phonebook.get(surname);
            if(!numbers.contains(number)){
                numbers.add(number);
                System.out.printf("Number %s added for %s%n", number, surname);
            } else {
                System.out.printf("Number %s exists for %s%n", number, surname);
            }
        } else {
            phonebook.put(surname, new ArrayList<>(Collections.singletonList(number)));
            System.out.printf("Number %s added for %s%n", number, surname);
        }
    }

    public List<String> get(String surname){
        if(phonebook.containsKey(surname)){
            return phonebook.get(surname);
        } else {
            System.out.printf("There is no record of %s in phonebook%n", surname);
            return new ArrayList<>();
        }
    }
}
