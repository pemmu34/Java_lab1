import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.InputMismatchException;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println(" ");
            System.out.println("Выберите задание(1-5):");
            int count = sc.nextInt();
            switch (count) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    task5();
                    break;
                default:
                    System.out.println("Такого задания нет, попробуй ещё раз!");
            }
        }
    }

    public static void task1() {
        System.out.println("---------------------Задание_1---------------------------"); // готово
        double price = 20.40;
        System.out.println("Таблица стоимости товаров:");
        System.out.println("-------------------------------------------------");
        System.out.printf("| %-12s | %-11s |\n", "Количество", "Стоимость");
        System.out.println("-------------------------------------------------");
        for (int i = 2; i <= 20; i++) {
            String formattedString = String.format("| %-12d | %-11.2f рублей|\n", i, price * i);
            System.out.print(formattedString);
        }
        System.out.println("-------------------------------------------------");
    }

    public static void task2() {
        System.out.println("---------------------Задание_2---------------------------");
        System.out.println("Введите число А: ");
        int A = sc.nextInt();
        System.out.println("Введите число B: ");
        int B = sc.nextInt();

        int min = Math.min(A, B);
        int max = Math.max(A, B);

        System.out.print("Все нечетные числа в заданном диапозоне: ");
        printOddNumbers(min, max);
        System.out.println();
    }

    public static void printOddNumbers(int current, int max) {
        // Базовый случай рекурсии
        if (current > max) return;

        // Печатаем текущее число, если оно нечетное
        if (current % 2 != 0) {
            System.out.print(current + (current < max ? ", " : ""));
        }

        // Рекурсивный вызов для следующего числа
        printOddNumbers(current + 1, max);
    }

    public static void task3() {
        System.out.println("---------------------Задание_3---------------------------"); // готово
        int COUNTER = 0;
        final long MAX_VALUE = 9999999999L; // Установим максимальное значение для N
        long N = 0;
        int K = 0;

        try {
            // Запрос числа N
            System.out.println("Введите натуральное число N: ");
            N = sc.nextLong(); // Используем long для больших чисел

            // Проверка на слишком большое число
            if (N < 0 || N > MAX_VALUE) {
                System.out.println("Ошибка: Введено слишком большое или отрицательное число.");
                return;
            }

            // Запрос цифры K
            System.out.println("Введите цифру K: ");
            K = sc.nextInt();

            // Проверка диапазона для K
            if (K < 0 || K > 9) {
                System.out.println("Цифра должна входить в диапозон от 0 до 9!");
                return;
            }

            // Подсчет вхождений цифры K в числе N
            while (N != 0) {
                if (N % 10 == K) {
                    COUNTER++;
                }
                N /= 10;
            }

            System.out.printf("Цифра %d встречается %d раз(а).\n", K, COUNTER);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Введено некорректное значение.");
        } finally {
            sc.nextLine(); // Очищаем буфер ввода
        }
    }

    public static void task4() {
        System.out.println("---------------------Задание_4---------------------------"); // готово
        int counter = 0;
        int number; // Объявляем переменную вне цикла

        System.out.println("Введите целые числа(чтобы закончить введите 0): ");

        do {
            number = sc.nextInt(); // Читаем число

            if (number != 0) { // Проверяем, не равно ли число 0
                if (number % 3 == 0) {
                    counter++;
                }
                System.out.println(number);
            }
        } while (number != 0); // Условие продолжения цикла

        System.out.println("Количество чисел, которые делятся на 3: " + counter);
    }

    public static void task5() {
        System.out.println("---------------------Задание_5---------------------------");
        List<Integer> numbers = new ArrayList<>();
        int num;

        System.out.println("Введите целые числа (чтобы закончить введите 0): ");

        do {
            num = sc.nextInt(); // Читаем число
            if (num != 0 && num % 2 == 0 && !numbers.contains(num)) { // Проверяем, что число четное и уникальное
                numbers.add(num);
            }
        } while (num != 0); // Условие продолжения цикла

        // Находим максимальное четное число
        if (numbers.isEmpty()) {
            System.out.println("Вы не ввели ни одного чётного числа. Пожалуйста, введите хотя бы одно чётное число.");
        } else {
            int max = Integer.MIN_VALUE;
            for (int number : numbers) {
                if (number > max) {
                    max = number;
                }
            }
            System.out.println("Максимальное чётное число: " + max);
        }
    }
}
