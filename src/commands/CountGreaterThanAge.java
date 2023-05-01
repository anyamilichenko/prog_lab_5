package commands;

import exceptions.IncorrectValueException;
import utilities.CollectionManager;
import utilities.Console;

import java.util.Objects;

/**
 * команда "CountGreaterThanAge". Выводит количество элементов, значение поля age которых больше заданного
 */

public class CountGreaterThanAge extends AbstractCommand{
    private CollectionManager collectionManager;


    public CountGreaterThanAge( CollectionManager collectionManager){
        super("count_greater_than_age", "count_greater_than_age age : вывести количество элементов, значение поля age которых меньше заданного");

        this.collectionManager = collectionManager;
    }

    /**
     * Исполнить команду
     *
     * @param argument аргументы команды
     * @return
     * @throws IncorrectValueException неверные аргументы команды
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isBlank()) throw new IncorrectValueException();
            long age = Long.parseLong(argument.trim());
            System.out.println("Количество элементов, с меньшим значением поля expelled_students: ");
            System.out.println(collectionManager.getCollection().stream()
                    .filter(Objects::nonNull)
                    .filter(s -> Long.compare(s.getAge(), age) <= -1)
                    .map(Objects::toString)
                    .count());

        } catch (NumberFormatException exception) {
            System.err.println("expelled_students должно быть числом типа long");
        }catch (IncorrectValueException e){
            System.err.println("");
        }
        return false;
    }



}
