import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        while (true) {
            printMenu();
            int i = scanner.nextInt();
            if (i == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (i == 2) {
                stepTracker.changeStepGoal(scanner);
            } else if (i == 3) {
                stepTracker.printStatistic();
            } else if (i == 0) {
                System.out.println("Выход");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды не существует:");
            }
        }
    }

    static void printMenu() {
        System.out.println("МЕНЮ:");
        System.out.println("1 - Ввести количество шагов за определённый день: ");
        System.out.println("2 - Изменить цель по количеству шагов в день: ");
        System.out.println("3 - Напечатать статистику за определённый месяц: ");
        System.out.println("0 - Выйти из приложения: ");
    }
}