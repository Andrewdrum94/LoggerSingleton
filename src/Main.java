import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.print("Введите размер списка: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        System.out.print("Введите верхнюю границу для значений: ");
        int upperBound = scanner.nextInt();
        logger.log("Создаём и наполняем список");
        List<Integer> source = generateList(size, upperBound);
        System.out.print("Вот случайный список: ");
        printList(source);
        logger.log("Просим пользователя вести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        int threshold = scanner.nextInt();
        logger.log("Запускаем фильтрацию");
        List<Integer> filteredList = new Filter(threshold).filterOut(source);
        logger.log("Выводим результат на экран");
        System.out.print("Отфильтрованный список: ");
        printList(filteredList);
        logger.log("Завершаем программу");
    }

    private static List<Integer> generateList(int size, int upperBound) {
        List<Integer> source = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            source.add(random.nextInt(upperBound));
        }
        return source;
    }

    private static void printList(List<Integer> source) {
        for (Integer integer : source) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
