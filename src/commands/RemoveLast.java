package commands;

import exceptions.EmptyArgumentException;
import utilities.CollectionManager;
/**
 * Класс для команды "remove_last". Удаляет последний аргумент из коллекции
 */
public class RemoveLast extends AbstractCommand{

    private CollectionManager collectionManager;

    public RemoveLast(CollectionManager collectionManager){
        super("remove_last", "remove_last : удалить последний элемент из коллекции");
        this.collectionManager = collectionManager;
    }

    /**
     * Выполнение команды
     * @param argument аргумент
     * @return Удаляет последний аргумент из коллекции
     */
    @Override
    public boolean execute(String argument){
        try {
            if (!argument.equals("")) throw new EmptyArgumentException();
            collectionManager.getCollection().removeLast();
            //collectionManager.removeFromCollection(collectionManager.getCollection().get(collectionManager.collectionSize()));
            System.out.println("Последний элемент успешно удалён");
        }catch (EmptyArgumentException e){
            System.err.println("Аргумент пуст");
        }
        return false;
    }

}
