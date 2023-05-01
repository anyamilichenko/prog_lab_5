package commands;


import exceptions.IncorrectValueException;
import utilities.CollectionManager;

import java.io.IOException;

/**
 * Класс для команды "exit". Проверяет аргумент и дальше ничего не делает
 */
public class ExitCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    public ExitCommand(CollectionManager collectionManager){
        super("exit","завершить программу (без сохранения в файл)")  ;
        this.collectionManager = collectionManager;
    }
    /**
     * Выполнение команды
     * @param argument аргумент
     * @return выходит из программы без сохранения в файл
     */

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new IncorrectValueException();
            collectionManager.exit();
        } catch (IncorrectValueException e) {
            System.err.println("Некорректное значение аргумента");
        }
        return true;
    }


//    @Override
//    public boolean execute(String argument){
//        try {
//            if (!argument.isEmpty())throw new IncorrectValueException();
//            return true;
//        }
//        catch (
//                IncorrectValueException e) {
//            System.err.println("У этой команды нет параметров! Необходимо ввести: exit");
//        }
//        return false;
//    }
}
