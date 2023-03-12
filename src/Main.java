import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//Напишите приложение, которое на входе получает через консоль текст, а в ответ выдает статистику:
//
//1. Количество слов в тексте.
//2. Топ-10 самых часто упоминаемых слов, упорядоченных по количеству упоминаний в
//обратном порядке. В случае одинакового количества упоминаний слова должны быть отсортированы по алфавиту.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст");
        String text = scanner.nextLine();
        String[] words = text.split(" ");
        List<String> word = Arrays.asList(text.split(" "));
        System.out.println("Слов в тексте" + word.size());
        word.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(100)
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));



    }
}