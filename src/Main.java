import commands.*;
import utilities.*;

import java.util.Scanner;

/**
 * Главный класс, в котором создаются все экземпляры и запускается программа
 * @author Milichenko Anna
 */

public class Main {


    public static void main(String[] args){
        FileManager fileManager;
        CollectionManager collectionManager;
        final String myenv = "DRAGON_FILE";
        Scanner scanner = new Scanner(System.in);
        Creator creator = new Creator(scanner);
        fileManager = new FileManager(myenv);
        collectionManager = new CollectionManager(fileManager, creator);
        collectionManager.loadCollection();
        CommandManager commandManager = new CommandManager(new AddCommand(collectionManager, creator),  new ClearCommand(collectionManager),
                new ExecuteScriptCommand(),
                new ExitCommand(collectionManager),
                new HelpCommand(),
                new InfoCommand(collectionManager),
                new RemoveByIdCommand(collectionManager),
                new SaveCommand(collectionManager),
                new ShowCommand(collectionManager),
                new UpdateCommand(collectionManager, creator),
                new RemoveGreaterCommand(collectionManager, creator),
                new CountGreaterThanAge(collectionManager),
                new Reorder(collectionManager),
                new RemoveLast(collectionManager),
                new RemoveAllByWeight(collectionManager),
                new PrintFieldDescendingCharacter(collectionManager));


//        CommandManager commandManager = new CommandManager(new AddCommand(collectionManager, creator), new HelpCommand(),
//                new InfoCommand(collectionManager),
//                new ExitCommand(collectionManager),
//                new ShowCommand(collectionManager),
//                new ClearCommand(collectionManager),
//                new SaveCommand(collectionManager),
//                new ShowCommand(collectionManager),
//                new UpdateCommand(collectionManager, creator),
//                new RemoveGreaterCommand(collectionManager, creator),
//                new RemoveByIdCommand(collectionManager),
//                new CountGreaterThanAge(collectionManager),
//                new Reorder(collectionManager),
//                new RemoveLast(collectionManager),
//                new RemoveAllByWeight(collectionManager),
//                new PrintFieldDescendingCharacter(collectionManager));
        Console console = new Console(scanner, commandManager, creator);
        console.workMode();
    }

}
