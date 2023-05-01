package commands;


import data.Dragon;
import exceptions.EmptyArgumentException;
import utilities.CollectionManager;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Класс команды "reorder". Сортирует коллекцию в порядке, обратном нынешнему
 */
public class Reorder extends AbstractCommand{
    private CollectionManager collectionManager;

    public Reorder(CollectionManager collectionManager){
        super("reorder", "Сортирует коллекцию в порядке, обратном нынешнему");
        this.collectionManager = collectionManager;
    }


    /**
     * Выполнение команды
     * @param argument аргумент
     * @return коллекцию в обратном порядке
     */

    @Override
    public boolean execute(String argument){
        try{
            if (!argument.equals("")) throw new EmptyArgumentException();
            LinkedList<Dragon> dragons = collectionManager.getCollection();
            Collections.reverse(dragons);
            collectionManager.setCollection(dragons);
            System.out.println("Коллекция успешно перевернута");
        }catch (EmptyArgumentException e){

        }return false;
    }
}
