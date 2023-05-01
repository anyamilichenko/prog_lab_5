package commands;

import data.Dragon;
import exceptions.IncorrectValueException;
import utilities.CollectionManager;
import utilities.Creator;

/**
 * команда "add". Добавляет новый элемент в коллекцию
 */

public class AddCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    private Creator creator;
    
    public AddCommand(CollectionManager collectionManager, Creator creator){
        super("add","Добавляет новый элемент в коллекцию");
        this.collectionManager = collectionManager;
        this.creator = creator;
    }


    @Override
    public boolean execute(String argument){
        try{
            if (!argument.isEmpty()) throw new IncorrectValueException();
            collectionManager.insertNew(new Dragon(
                    collectionManager.newId(),
                    creator.newName(),
                    creator.newCoordinates(),
                    collectionManager.getLastInitTime(),
                    creator.newAge(),
                    creator.newWingspan(),
                    creator.newWeight(),
                    creator.newDragonCharacter(),
                    creator.newCave()
            ));
            System.out.println("Добавление дракона прошло успешно");
            return true;
        }catch (IncorrectValueException e){
            System.err.println("Неправильно передан параметр для добавления");
        }
        return false;
    }
}

