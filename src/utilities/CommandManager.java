package utilities;


import commands.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для запуска команд
 */

public class CommandManager {

    final int maxCommandSize = 16;
    private final List<AbstractCommand> commands = new ArrayList<>(); //массив с командами
    public AbstractCommand addCommand;
    public AbstractCommand clearCommand;
    public AbstractCommand execute_script;
    public AbstractCommand exitCommand;
    public AbstractCommand helpCommand;
    public AbstractCommand infoCommand;
    public AbstractCommand remove_by_id;
    public AbstractCommand saveCommand;
    public AbstractCommand showCommand;
    public AbstractCommand updateIdCommand;
    public AbstractCommand remove_greater;
    public AbstractCommand count_greater_than_age;
    public AbstractCommand reorder;
    public AbstractCommand remove_last;
    public AbstractCommand remove_all_by_weight;
    public AbstractCommand print_field_descending_character;




    public CommandManager(AbstractCommand addCommand, AbstractCommand clearCommand, AbstractCommand execute_script, AbstractCommand exitCommand,
                          AbstractCommand helpCommand, AbstractCommand infoCommand, AbstractCommand remove_by_id,
                          AbstractCommand saveCommand, AbstractCommand showCommand, AbstractCommand updateIdCommand, AbstractCommand remove_greater, AbstractCommand count_greater_than_age, AbstractCommand reorder, AbstractCommand remove_last,
                          AbstractCommand remove_all_by_weight, AbstractCommand print_field_descending_character) {

        this.addCommand = addCommand;
        commands.add(addCommand);
        this.clearCommand = clearCommand;
        commands.add(clearCommand);
        this.execute_script = execute_script;
        commands.add(execute_script);
        this.exitCommand = exitCommand;
        commands.add(exitCommand);
        this.helpCommand = helpCommand;
        commands.add(helpCommand);
        this.infoCommand = infoCommand;
        commands.add(infoCommand);
        this.remove_by_id = remove_by_id;
        commands.add(remove_by_id);
        this.saveCommand = saveCommand;
        commands.add(saveCommand);
        this.showCommand = showCommand;
        commands.add(showCommand);
        this.updateIdCommand = updateIdCommand;
        commands.add(updateIdCommand);
        this.remove_greater = remove_greater;
        commands.add(remove_greater);
        this.count_greater_than_age = count_greater_than_age;
        commands.add(count_greater_than_age);
        this.reorder = reorder;
        commands.add(reorder);
        this.remove_last = remove_last;
        commands.add(remove_last);
        this.remove_all_by_weight = remove_all_by_weight;
        commands.add(remove_all_by_weight);
        this.print_field_descending_character = print_field_descending_character;
        commands.add(print_field_descending_character);
    }
//    public CommandManager(AbstractCommand addCommand, AbstractCommand clearCommand, AbstractCommand executeScriptCommand, AbstractCommand exitCommand,
//                          AbstractCommand helpCommand, AbstractCommand infoCommand, AbstractCommand removeByIdCommand,
//                          AbstractCommand saveCommand, AbstractCommand showCommand, AbstractCommand updateIdCommand, AbstractCommand removeGreaterCommand, AbstractCommand countGreaterThanAge, AbstractCommand reorder, AbstractCommand removeLast,
//                          AbstractCommand removeAllByWeight, AbstractCommand printFieldDescendingCharacter){
//
//        this.addCommand = addCommand;
//        commands.add(addCommand);
//        this.clearCommand = clearCommand;
//        commands.add(clearCommand);
//        this.executeScriptCommand = executeScriptCommand;
//        commands.add(executeScriptCommand);
//        this.exitCommand = exitCommand;
//        commands.add(exitCommand);
//        this.helpCommand = helpCommand;
//        commands.add(helpCommand);
//        this.infoCommand = infoCommand;
//        commands.add(infoCommand);
//        this.removeByIdCommand = removeByIdCommand;
//        commands.add(removeByIdCommand);
//        this.saveCommand = saveCommand;
//        commands.add(saveCommand);
//        this.showCommand = showCommand;
//        commands.add(showCommand);
//        this.updateIdCommand = updateIdCommand;
//        commands.add(updateIdCommand);
//        this.removeGreaterCommand = removeGreaterCommand;
//        commands.add(removeGreaterCommand);
//        this.countGreaterThanAge = countGreaterThanAge;
//        commands.add(countGreaterThanAge);
//        this.reorder = reorder;
//        commands.add(reorder);
//        this.removeLast = removeLast;
//        commands.add(removeLast);
//        this.removeAllByWeight = removeAllByWeight;
//        commands.add(removeAllByWeight);
//        this.printFieldDescendingCharacter = printFieldDescendingCharacter;
//        commands.add(printFieldDescendingCharacter);
//    }
    //использовать обобщение для расширения
//    public CommandManager(AddCommand addCommand, ClearCommand clearCommand,
//                          ExitCommand exitCommand,  HelpCommand helpCommand,
//                          InfoCommand infoCommand, RemoveByIdCommand removeByIdCommand,
//                          SaveCommand saveCommand, ShowCommand showCommand,
//                          UpdateCommand updateIdCommand, RemoveGreaterCommand removeGreaterCommand,
//                          CountGreaterThanAge countGreaterThanAge, Reorder reorder,
//                          RemoveLast removeLast,RemoveAllByWeight removeAllByWeight,
//                          PrintFieldDescendingCharacter printFieldDescendingCharacter){
//
//   }

    /**
     * Добавляет новый элемент в коллекцию
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */

    public boolean add(String argument){
        return addCommand.execute(argument);
    }

    /**
     * Запускает команду очистки коллекции
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */

    public boolean clear(String argument){
        return clearCommand.execute(argument);
    }

    /**
     * Запускает команду выполнения скрипта
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean executeScript(String argument){
        return execute_script.execute(argument);
    }

    /**
     * Запускает команду выхода из программы
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */

    public boolean exit(String argument){
        return exitCommand.execute(argument);
    }


    /**
     * Выводит все доступные команды с описанием
     * @param argument это аргумент
     * @return Состояние работы команды
     */

    public boolean help (String argument){
        if (helpCommand.execute(argument)) {
            for (AbstractCommand command : commands) {
                System.out.println("\u001B[37m"+"\u001B[33m"+command.getName()+"\u001B[33m"+"\u001B[37m" + ": " + command.getDescription());
            }
            return true;
        } else return false;
    }


    /**
     * Запускает команду информации о коллекции
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */

    public boolean info(String argument){
        return infoCommand.execute(argument);
    }

    /**
     * Удаляет из коллекции все элементы, значение поля weight которого эквивалентно заданному
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public  boolean removeByIdCommand(String argument){
        return remove_by_id.execute(argument);
    }


    /**
     * Запускает команду сохранения коллекции в файл
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */

    public boolean save(String argument){
        return saveCommand.execute(argument);
    }


    /**
     * Запускает команду показа всех элементов коллекции
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */

    public boolean show(String argument){
        return showCommand.execute(argument);
    }

    /**
     * Запускает команду замены элемента по ключу
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean update(String argument){
        return updateIdCommand.execute(argument);
    }
    /**
     * Удаляет из коллекции все элементы, превышающие заданный
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean removeGreaterCommand(String argument){
        return remove_greater.execute(argument);
    }

    /**
     * Выводит количество элементов, значение поля age которых больше заданного
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean countGreaterThanAge(String argument){
        return count_greater_than_age.execute(argument);
    }

    /**
     * Сортирует коллекцию в порядке, обратном нынешнему
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean reorder(String argument){
        return reorder.execute(argument);
    }

    /**
     * Удаляет последний аргумент из коллекции
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean removeLast(String argument){
        return  remove_last.execute(argument);
    }

    /**
     * Удаляет из коллекции все элементы, значение поля weight которого эквивалентно заданному
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public  boolean removeAllByWeight(String argument){
        return remove_all_by_weight.execute(argument);
    }

    /**
     * Выводит значения поля character всех элементов в порядке убывания
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean printFieldDescendingCharacter(String argument){
        return print_field_descending_character.execute(argument);
    }


}


//прочитать про паттерн команды и инвокер