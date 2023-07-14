package summary_0707;

public class Classwork {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Task task1 = new Task("Buy beer");
        Task task2 = new Task("Buy vodka");
        Task task3 = new Task("Buy pills");
        Task task4 = new Task("Buy Whiskey");

        taskManager.addTask(1, task3);
        taskManager.addTask(2, task1);
        taskManager.addTask(3, task2);
        taskManager.addTask(3, task4);

        System.out.println(taskManager.getMostPriorityTask());
        System.out.println(taskManager.getMostPriorityTask());
        System.out.println(taskManager.getMap());
    }
    /**
     * 0. Даны два отсортированных массива размера n и m. Нужно создать новый массив n+m из элементов первых двух
     * так же в отсортированном порядке.
     */

     /**
     * 1. Спроектируйте класс для управления задачами. В нем должен быть метод по добавлению задачи с приоритетом
     * и получения самой приоритетной задачи (с её удалением)
      * * Примечание:
     * а) Приоритет - целое число. Чем оно больше тем приоритет выше.
     * б) Задача представляет собой класс Task с одним полем "String name". Приоритет не является составной частью задачи
     * и передаётся отдельно
     */

    /** 2. Нужно написать модуль программы по составлению отчета по продажам за выбранные даты.
            * Check представляет собой: артикул, количество и стоимость.
     * ReportResult должен отображать: самый продаваемый артикул и общую стоимость всех продаж по каждому артикулу.
     * Желаемый интерфейс:
            * <p>
     * interface ReportGenerator {
     *     ReportResult generateReport(ZonedDateTime from, ZoneDateTime to);
     * }
     * <p>
     * Примечание:
            * а) при этом выгрузкой информации по продажам занимается другая команда, которая пока ещё не передала вам
     * информацию как в вашем модуле получать сами заказы. Обойдите это ограничение.
     * б) ZonedDateTime можно создать с помощью:
            * LocalDate.parse("2023-06-01").atStartOfDay(ZoneId.of("Europe/Berlin"));
     * c) В классе Продажа дата не нужна!
     */

}
