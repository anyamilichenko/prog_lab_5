package commands;

import data.Dragon;
import exceptions.EmptyArgumentException;
import utilities.CollectionManager;
import utilities.Creator;

import java.time.LocalDateTime;
import java.util.Map;

public class UpdateCommand extends AbstractCommand {
    Creator creator;
    CollectionManager collectionManager;

    public UpdateCommand(CollectionManager collectionManager, Creator creator) {
        super("update", "обновить значение элемента коллекции, id которого равен заданному");
        this.creator = creator;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполнение команды
     *
     * @param argument аргумент
     * @return состояние выполнения команды
     */
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new EmptyArgumentException();
            Long id = Long.parseLong(argument);
            collectionManager.checkId(id);
            Integer key = collectionManager.getKeyById(id);
            collectionManager.update(key, new Dragon(id, creator.newName(), creator.newCoordinates(), LocalDateTime.now(), creator.newAge(), creator.newWingspan(), creator.newWeight(), creator.newDragonCharacter(), creator.newCave()));
            return true;
        } catch (EmptyArgumentException e) {
            System.err.println("У этой команды должен быть аргумент(ключ для удаления элементов)");
        } catch (NumberFormatException e) {
            System.err.println("Формат введенного аргумента неверен . Он должен быть целым.");
        } catch (NullPointerException e) {
            System.err.println("Элемента с таким id не существует");
        }
        return false;
    }


}
