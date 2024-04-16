import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String input = scanner.nextLine();
            if (input.equals("EXIT")) {
                System.out.println("Работа программы завершена.");
                break;
            }
            String[] inputArray = input.split(" ", 2);
            String command = inputArray[0];

            switch (command) {
                case "ADD":
                    if (inputArray[1].matches("\\d.*")) {
                        int index = Integer.parseInt(inputArray[1].replaceAll("\\D+", ""));
                        String task = inputArray[1].replaceAll("\\d+", "").trim();
                        todoList.add(index - 1, task);
                    } else {
                        todoList.add(inputArray[1]);
                    }
                    break;
                case "DELETE":
                    if (inputArray.length < 2) {
                        System.out.println("Не указан номер дела для удаления");
                        break;
                    } else if (!inputArray[1].matches("\\d+")) {
                        System.out.println("Некорректный ввод!");
                        break;
                    } else {
                        int index = Integer.parseInt(inputArray[1]);
                        todoList.delete(index - 1);
                    }
                    break;
                case "EDIT":
                    if (inputArray.length < 2) {
                        System.out.println("Не указан номер редактируемого дела");
                        break;
                    } else if (!inputArray[1].matches("\\d.*")) {
                        System.out.println("Не указан номер редактируемого дела");
                        break;
                    } else {
                        int index = Integer.parseInt(inputArray[1].replaceAll("\\D+", ""));
                        String task = inputArray[1].replaceAll("\\d+", "").trim();
                        todoList.edit(index - 1, task);
                    }
                    break;
                case "LIST":
                    ArrayList<String> todolist = todoList.getTodos();
                    for (int i = 0; i < todolist.size(); i++) {
                        System.out.println((i + 1) + " - " + todolist.get(i));
                    }
                    break;
                default:
                    System.out.println("Введена некорректная команда!");
                    break;
            }
        }
    }

    static void printMenu() {
        System.out.println("Введите одну из доступных команд");
        System.out.println("ADD дело (для добавления дела в конец списка) "
                + "или ADD X дело (где X - номер в списке для добавления дела)");
        System.out.println("DELETE X (для удаления дела под номером X");
        System.out.println("EDIT X дело (для замена дела под номером X на новое");
        System.out.println("LIST (для вывода списка дел с их порядковыми номерами)");
        System.out.println("EXIT (для выхода из программы)");
    }
}
