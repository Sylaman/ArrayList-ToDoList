import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String input = scanner.nextLine();
            if (input.equals("0")) {
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
                        todoList.add(index, task);
                    } else {
                        todoList.add(inputArray[1]);
                    }
                case "DELETE":
                    if (inputArray.length < 2) {
                        System.out.println("Не указан номер дела для удаления");
                        break;
                    } else if (!inputArray[1].matches("\\d+")) {
                        System.out.println("Некорректный ввод!");
                        break;
                    } else {
                        int index = Integer.parseInt(inputArray[1]);
                        todoList.delete(index);
                    }
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
                        todoList.edit(index, task);
                    }
                case "LIST":
                    ArrayList<String> todolist = todoList.getTodos();
                    for (int i = 0; i < todolist.size(); i++) {
                        System.out.println(i + " - " + todolist.get(i));
                    }
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
        System.out.println("EDIT X (для замена дела под номером X на новое");
        System.out.println("LIST (для вывода списка дел с их порядковыми номерами)");
        System.out.println("0 (для выхода из программы)");
    }
}
