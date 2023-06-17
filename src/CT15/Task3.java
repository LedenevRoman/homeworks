package CT15;

import java.util.HashMap;
import java.util.Map;

/**     * 3. Создать и заполнить две мапы.
        * Затем перебрать обе мапы и вывести на экран
        * средний возраст всех людей (из Map<String, Person>).
        */
public class Task3 {
    public static void main(String[] args) {
        Map<String, Person> stringPersonMap = new HashMap<>();

        stringPersonMap.put("1", new Person("Ivan", 25));
        stringPersonMap.put("2", new Person("Petr", 35));
        stringPersonMap.put("3", new Person("Sidr", 45));

        int sum = 0;

        for (Map.Entry<String, Person> entry : stringPersonMap.entrySet()) {
            sum += entry.getValue().getAge();
        }

        System.out.println(sum/stringPersonMap.size());
    }
}
