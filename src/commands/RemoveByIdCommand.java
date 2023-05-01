package commands;

import data.Dragon;
import exceptions.DragonNotFoundException;
import exceptions.EmptyCollectionException;
import exceptions.IncorrectValueException;
import utilities.CollectionManager;
/**
 * Класс для команды "remove_by_id". удаляет элемент из коллекции по его id
 */
public class RemoveByIdCommand extends AbstractCommand{
    CollectionManager collectionManager;

    public RemoveByIdCommand(CollectionManager collectionManager){
        super("remove_by_id","удаляет элемент из коллекции по его id");
        this.collectionManager = collectionManager;
    }
    /**
     * Выполнение команды
     * @param argument аргумент
     * @return удаляет элемент из коллекции по его id
     */
    @Override
    public boolean execute(String argument) {
        try{
            if (argument.isEmpty()) throw new IncorrectValueException();
            if (collectionManager.collectionSize() == 0) throw new EmptyCollectionException();
            Long id = Long.parseLong(argument);
            Dragon dragonToRemove = collectionManager.getById(id);
            if (dragonToRemove == null) throw new DragonNotFoundException();
            collectionManager.removeFromCollection(dragonToRemove);
            System.out.println("Дракон удален из коллекции");
        }catch (IncorrectValueException e){
            System.err.println("Некорректное значение агрумента,введите аргумент,в данный момент он пуст");
        }catch (EmptyCollectionException e){
            System.err.println("В данный момент коллекция пуста");
        }catch (DragonNotFoundException e){
            System.err.println("Дракон с таким id не существует");
        }
        return false;
    }
}
