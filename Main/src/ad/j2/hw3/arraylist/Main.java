package ad.j2.hw3.arraylist;

/**
 * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать сколько раз встречается каждое слово.
 */

import java.util.*;

public class Main {
    public static void main(String[] args){
        List<String> words = Arrays.asList("What", "is", "love", "baby", "do", "not", "heart", "me", "do", "not","heart", "me", "no", "more");
        Set<String> unique = new HashSet<>(words);
        System.out.println("Initial ArrayList");
        System.out.println(words.toString());
        System.out.println("Unique words");
        System.out.println(unique.toString());
        System.out.println("Frequency of repeating words");
        for (String key : unique) {
            System.out.println(key + ": " + Collections.frequency(words, key));
        }
    }
}
