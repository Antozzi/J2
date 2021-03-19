package ad.j2.hw3.teldic;

/**
 * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 * В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии. Следует учесть,
 * что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
 * Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес),
 * делать взаимодействие с пользователем через консоль и т.д.). Консоль желательно не использовать (в том числе Scanner), тестировать просто из метода main() прописывая add() и get().
 */

public class Main {
    public static void main(String[] args){
        System.out.println("Create phonebook");
        TelDic phonebook = new TelDic();
        System.out.println("Make records in phonebook");
        phonebook.add("Bobby", "223344");
        phonebook.add("Johnny", "22334411");
        phonebook.add("Willy", "22334499");
        phonebook.add("Sally", "22334488");
        phonebook.add("Bobby", "22334422");

        System.out.println("Get numbers of:");
        System.out.println("Bobby");
        System.out.println(phonebook.get("Bobby"));
        System.out.println("Johnny");
        System.out.println(phonebook.get("Johnny"));
        System.out.println("Willy");
        System.out.println(phonebook.get("Willy"));

        System.out.println("No such record:");
        System.out.println("Baddie");
        System.out.println(phonebook.get("Baddie"));

        System.out.println("Make a record over existing record");
        phonebook.add("Bobby", "223344");
        System.out.println("Bobby");
        System.out.println(phonebook.get("Bobby"));
    }
}
