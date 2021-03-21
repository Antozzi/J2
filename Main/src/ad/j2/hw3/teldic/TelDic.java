package ad.j2.hw3.teldic;

import java.util.*;

public class TelDic {

    private final Map<String, Set<String>> phonebook;

    public TelDic(){
        this.phonebook = new HashMap<>();
    }

    public void add(String surname, String number){
        Set<String> numbers = phonebook.getOrDefault(surname, new HashSet<>());
        numbers.add(number);
        phonebook.putIfAbsent(surname,numbers);
//        if(phonebook.containsKey(surname)){
//            Set<String> numbers = phonebook.get(surname);
//            if(!numbers.contains(number)){
//                numbers.add(number);
//                System.out.printf("Number %s added for %s%n", number, surname);
//            } else {
//                System.out.printf("Number %s exists for %s%n", number, surname);
//            }
//        } else {
//            phonebook.put(surname, new HashSet<>(Collections.singletonList(number)));
//            System.out.printf("Number %s added for %s%n", number, surname);
//        }
    }

    public Set<String> get(String surname){
        return phonebook.getOrDefault(surname, Collections.emptySet());
//        if(phonebook.containsKey(surname)){
//            return phonebook.get(surname);
//        } else {
//            System.out.printf("There is no record of %s in phonebook%n", surname);
//            return new HashSet<>();
//        }
    }
}
