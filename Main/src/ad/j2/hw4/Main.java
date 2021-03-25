package ad.j2.hw4;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;


/**
 * 1. Создать коллекцию типа List. Наполнить ее значениями и вывести значения в консоль при помощи ее метода forEach.
 * createList()
 * 2. Создать утилитарный метод forItem. Метод принимает два параметра: Коллекция Set<String>
 * и консьюмер типа Consumer<String>. Внутри метода проитерироваться по коллекции
 * и для каждого элемента выполнить метод консьюмера accept, который выводит значение элемента в консоль.
 * forItemAccept();
 * 3. Создать утилитарный метод doubleUp. Метод принимает два параметра:
 * значение типа int и консьюмер типа Supplier<Integer>. Внутри метода выполнить метод саплаера get,
 * который возвращает множитель и затем переданное значение на него умножается.
 * Функция возвращает результат произведения.
 * multiply();
 * 4. Создать метод findAllChars. Метод принимает два параметра: String target и char toFind.
 * Первый параметр является входной строкой, а второй - символ, который необходимо найти в входящей строке.
 * Учесть что искомый символ может повторяется (напр.: 'ccch').
 * Необходимо найти все повторения и вернуть в виде конкатенированной строки обвернутый в Optional.
 * Если ни одного совпадения не найдено, тогда необходимо вернуть пустой Optional.
 * Пример выполнения: Optional<String> opt = findAllChars("ccch", 'c'); opt.get(); // вернет "ссс".
 * findChars();
 * 5. Создать окно для клиентской части чата: большое текстовое поле для отображения переписки в центре окна.
 * Однострочное текстовое поле для ввода сообщений и кнопка для отсылки сообщений на нижней панели.
 * Сообщение должно отсылаться либо по нажатию кнопки на форме, либо по нажатию кнопки Enter.
 * При «отсылке» сообщение перекидывается из нижнего поля в центральное. (ОПЦИОНАЛЬНО)
 */

public class Main {

    public static void main(String[] args) {
        //1
        createList();
        //2
        forItemAccept();
        //3
        multiply(24, 3);
        //4
        findChars("ccch", 'c');
        //5
        MyChatSwing myChat = new MyChatSwing("Swing chat");
    }

    public static void createList() {
        List<String> strings = List.of("1", "12", "123", "1234");
        strings.forEach(System.out::println);
    }

    public static void forItemAccept() {
        Set<String> setStrings = Set.of("1", "12", "123");
        forItem(setStrings, System.out::println);
    }

    public static void multiply(int x, int m) {
        System.out.println(doubleUp(x, getMultiplier(m)));
    }

    static Supplier<Integer> getMultiplier(int m) {
        return () -> m;
    }

    public static void findChars(String where, char what) {
        Optional<String> opt = findAllChars(where, what);
        opt.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("no entries")
        );
    }

    public static void forItem(Set<String> setStrings, Consumer<String> consumer) {
        setStrings.forEach(consumer);
    }

    public static int doubleUp(int integer, Supplier<Integer> supplier) {
        return integer * supplier.get();
    }

    public static Optional<String> findAllChars(String target, char toFind) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == toFind) result.append(toFind);
        }
        if (result.length() == 0)
            return Optional.empty();
        else
            return Optional.of(result.toString());
    }
}
