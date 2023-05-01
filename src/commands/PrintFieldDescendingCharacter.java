package commands;

import exceptions.EmptyArgumentException;
import exceptions.EmptyCollectionException;
import utilities.CollectionManager;

/**
 * команда "print_field_descending_character". Выводит значения поля character всех элементов в порядке убывания
 */

public class PrintFieldDescendingCharacter extends AbstractCommand{
    private CollectionManager collectionManager;


    public PrintFieldDescendingCharacter(CollectionManager collectionManager){
        super("print_field_descending_character","print_field_descending_character : вывести значения поля character всех элементов в порядке убывания");
        this.collectionManager = collectionManager;
    }

    /**
     * Выполнение команды
     * @param argument аргумент
     * @return Выводит значения поля character всех элементов в порядке убывания
     */
    @Override
    public boolean execute(String argument){
        try{
            if(collectionManager.collectionSize()==0) throw new EmptyCollectionException();
            if(!argument.isEmpty()) throw new EmptyArgumentException();
            collectionManager.sortCharacter();
            return true;
        }catch (EmptyArgumentException exception){
            System.out.println("Команда "+ getName() + " не имеет параметров");
            return false;
        }catch(EmptyCollectionException exception){
            System.out.println("Коллекция пуста");
            return false;
        }
    }
}
