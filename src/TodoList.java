import java.util.ArrayList;

public class TodoList {

    ArrayList<String> arrayList = new ArrayList<>();

    public void add(String todo) {
        arrayList.add(todo);
        System.out.println("Добавлено дело \"" + todo + "\"");
    }

    public void add(int index, String todo) {
        if (index < arrayList.size()) {
            arrayList.add(index,todo);
        } else {
            arrayList.add(todo);
        }
        System.out.println("Добавлено дело \"" + todo + "\"");
    }

    public void edit(int index, String todo) {
        if (index < arrayList.size()) {
            System.out.println("Дело \"".concat(arrayList.get(index)).concat("\" заменено на \""
                    + todo.concat("\"")));
            arrayList.set(index, todo);
        } else {
            System.out.println("Дело с таким номером не существует");
        }
    }

    public void delete(int index) {
        if (index < arrayList.size()) {
            System.out.println("Дело \"" + arrayList.get(index) + "\"".concat(" удалено"));
            arrayList.remove(index);
        } else {
            System.out.println("Дело с таким номером не существует");
        }
    }

    public ArrayList<String> getTodos() {
        if (arrayList.isEmpty()) {
            System.out.println("Список дел пуст");
        }
        return arrayList;
    }
}