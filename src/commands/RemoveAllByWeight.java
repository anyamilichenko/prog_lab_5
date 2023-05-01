package commands;

import data.Dragon;
import utilities.CollectionManager;
import java.util.LinkedList;


/**
 * Класс для команды "remove_all_by_weight". Удаляет из коллекции все элементы, значение поля weight которого эквивалентно заданному
 */
public class RemoveAllByWeight extends AbstractCommand{
    private CollectionManager collectionManager;

    public RemoveAllByWeight(CollectionManager collectionManager){
        super("remove_all_by_weight","remove_all_by_weight weight : удалить из коллекции все элементы, значение поля weight которого эквивалентно заданному");
        this.collectionManager = collectionManager;
    }

    /**
     * Выполнение команды
     * @param argument аргумент
     * @return Удаляет из коллекции все элементы, значение поля weight которого эквивалентно заданному
     */

    @Override
    public boolean execute(String argument){
           LinkedList<Dragon> dragons = collectionManager.getCollection();
           if (argument.equals("null")) dragons.removeIf(labWork -> labWork.getWeight() == null);
           else dragons.removeIf(dragonn -> dragonn.getWeight() != null &&
                   dragonn.getWeight().toString().equals(argument.toUpperCase()));
           System.out.println("Элементы коллекции успешно удалены!");
        return false;
    }
}
