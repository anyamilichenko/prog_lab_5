package commands;


import exceptions.EmptyArgumentException;
import utilities.Console;

/**
 * Класс команды "execute_script"
 */
public class ExecuteScriptCommand extends AbstractCommand {
    private Console console;
    public ExecuteScriptCommand(){
        super("execute_script"," считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");

    }
    /**
     * Выполнение команды
     * @param argument аргумент
     * @return состояние выполнения команды
     */
    //Реализована Console.scriptMode
    @Override
    public boolean execute(String argument){
        try{
            if (argument.isEmpty()) throw new EmptyArgumentException();
            return true;
        }catch (
                EmptyArgumentException e) {
            System.err.println("У этой команды должен быть аргумент(имя файла для считывания скрипта)" );
        }
        return false;

    }
}
