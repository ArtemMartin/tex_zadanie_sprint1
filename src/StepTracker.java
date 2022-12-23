import java.util.Scanner;

class StepTracker {
    Scanner scanner;
    MonthData[] monthToData;
    Converter converter = new Converter();
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner sc) {
        scanner = sc;
        monthToData = new MonthData[12];
        for (int i = 0; i < 12; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        if (month < 0) {
            System.out.println("Не корректный ввод");
            return;
        } else if (month > 11) {
            System.out.println("Не корректный ввод");
            return;
        }
        // ввод и проверка номера месяца

        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();
        if (day < 1) {
            System.out.println("Не корректный ввод");
            return;
        } else if (day > 30) {
            System.out.println("Не корректный ввод");
            return;
        }
        // ввод и проверка дня

        System.out.println("Введите количество шагов");
        int step = scanner.nextInt();
        if (step < 0) {
            System.out.println("Не корректный ввод");
            return;
        }
        // ввод и проверка количества шагов

        // сохранение данных
        MonthData monthData = monthToData[month];
        monthData.days[day - 1] = step;

    }

    void changeStepGoal(Scanner scan) {
        System.out.println("Ввести новую цель ");
        int step = scan.nextInt();
        if (step <= 0) {
            System.out.println("Не корректный ввод");
        } else {
            goalByStepsPerDay = step;
        }
    }

    void printStatistic() {
        System.out.println("Введите число месяца");
        int month = scanner.nextInt();
        if (month < 0) {
            System.out.println("не корректный ввод");
            return;
        } else if (month > 11) {
            System.out.println("не корректный ввод");
            return;
        }
        // ввод и проверка номера месяца
        MonthData monthData = monthToData[month];// получение соответствующего месяца
        long sumSteps = monthData.sumStepsFromMonth(); // получение суммы шагов за месяц
        monthData.printDaysAndStepsFromMonth();// вывод общей статистики
        System.out.println("Вывод суммы шагов за месяц " + monthData.sumStepsFromMonth());
        System.out.println("Вывод максимального пройденного количества шагов за месяц " + monthData.maxSteps());
        System.out.println("Вывод пройденной за месяц дистанции в км " + converter.convertToKm((int) sumSteps));
        System.out.println("Вывод количества сожжённых килокалорий за месяц " + converter.convertStepsToKilocalories((int) sumSteps));
        System.out.println("Вывод лучшей серии " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println(); //дополнительный перенос строки
    }
}
