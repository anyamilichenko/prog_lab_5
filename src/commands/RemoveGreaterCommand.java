package commands;

import data.Dragon;
import exceptions.DragonNotFoundException;
import exceptions.EmptyCollectionException;
import exceptions.IncorrectValueException;
import utilities.CollectionManager;
import utilities.Creator;
/**
 * Класс для команды "remove_greater". Удаляет из коллекции все элементы, превышающие заданный
 */
public class RemoveGreaterCommand extends AbstractCommand {

    CollectionManager collectionManager;

    Creator creator;

    public RemoveGreaterCommand(CollectionManager collectionManager, Creator creator){
        super("remove_greater", "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный");
        this.collectionManager = collectionManager;
        this.creator = creator;
    }

    /**
     * Выполнение команды
     * @param argument аргумент
     * @return Удаляет из коллекции все элементы, превышающие заданный
     */
    @Override
    public boolean execute(String argument){
        try {
            if (!argument.isEmpty()) throw new IncorrectValueException();
            if (collectionManager.collectionSize() == 0) throw new EmptyCollectionException();
            var dragon = new Dragon(
                    collectionManager.newId(),
                    creator.newName(),
                    creator.newCoordinates(),
                    collectionManager.getLastInitTime(),
                    creator.newAge(),
                    creator.newWingspan(),
                    creator.newWeight(),
                    creator.newDragonCharacter(),
                    creator.newCave()
            );
            Dragon dragonColl = collectionManager.getByValue(dragon);
            if (dragonColl == null) throw  new DragonNotFoundException();
            collectionManager.removeGreater(dragonColl);
            System.out.println("Драконов больше нет");
            return true;
        }catch (IncorrectValueException e){
            System.err.println("Некорректно передан аргумент");
        }catch (EmptyCollectionException e){
            System.err.println("Коллекция пуста");
        }catch (DragonNotFoundException e){
            System.err.println("Тут нет такого дракона, как этот");
        } return false;
    }

}
