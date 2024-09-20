import java.util.Random;
import java.util.Scanner;

public class Main {

    // Константы для кратности
    private static final int KRAT = 21;

    public static void main(String[] args) {
        // Инициализируем ввод данных
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[1000];
        // Заполняем массив
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            numbers[i] = random.nextInt(1, 10001);

            // Переменные для хранения минимальных значений, кратных 3, 7 и 21
            int div3 = Integer.MAX_VALUE;
            int div7 = Integer.MAX_VALUE;
            int div21 = Integer.MAX_VALUE;

            // Переменная для хранения минимального результата
            int result = Integer.MAX_VALUE;

            // Однопроходный алгоритм по массиву
            for (int number : numbers) {
                if (number % 21 == 0) {
                    // Если число кратно 21, обновляем минимум для кратного 21
                    div21 = Math.min(div21, number);
                } else if (number % 3 == 0) {
                    // Если число кратно 3, проверяем возможность произведения с минимальным кратным 7
                    if (div7 < Integer.MAX_VALUE) {
                        result = Math.min(result, number * div7);
                    }
                    div3 = Math.min(div3, number);
                } else if (number % 7 == 0) {
                    // Если число кратно 7, проверяем возможность произведения с минимальным кратным 3
                    if (div3 < Integer.MAX_VALUE) {
                        result = Math.min(result, number * div3);
                    }
                    div7 = Math.min(div7, number);
                }
            }

            if (div21 < Integer.MAX_VALUE) {
                result = Math.min(result, div21 * div21);
            }

            // Вывод результата
            if (i == 999) {
                if (result == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println("Минимальное произведение двух различных чисел, кратное 21: " + result);
                }
                scanner.close();
            }
        }
    }
}
