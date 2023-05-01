package utilities;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import data.Dragon;
import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.google.gson.reflect.TypeToken;




/**
 * Класс загрузки/чтения коллекции из файла
 */

public class FileManager {
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();

    private  String envVariable;
    private CollectionManager collectionManager;
    File file;


    public FileManager(String fileName) {
        this.envVariable = fileName;
        try{this.file = new File(System.getenv(envVariable));

        }catch (NullPointerException e){
            System.out.println("\u001B[37m"+"\u001B[31m"+"Вам необходимо задать переменную окружения!!!"+"\u001B[31m"+"\u001B[37m");
        }
    }

    /**
     * Запись коллекции в файл
     * @param collection -коллекция, которую нужно записать
     */

    public void writeCollection(LinkedList collection){
        if (System.getenv().get(envVariable) != null){
            if (!file.canWrite()){
                System.out.println("\u001B[37m"+"\u001B[31m"+"Недостаточно прав для записи в файл. Добавьте права на запись "+"\u001B[31m"+"\u001B[37m" );
                System.out.println("Тест 6");
                try(PrintWriter out = new PrintWriter(new FileOutputStream(("/home/studs/s367397/lab5/MY_DRAGON")))){
                    out.write(gson.toJson(collection));
                    System.out.println("Не переживайте. Мы записали вашу коллекцию в новый файл: "+"/home/studs/s367397/lab5/MY_DRAGON");
                }catch (Exception e){
                    System.out.println("Ошибка, но не переживайте. Мы записали вашу коллекцию в новый файл: "+"/home/studs/s367397/lab5/MY_DRAGON");
                }
            }else{
                try (PrintWriter pw = new PrintWriter(new FileOutputStream(System.getenv().get(envVariable)))){
                    pw.write((gson.toJson(collection)));
                    System.out.println(("Коллекция успешно сохранена в файл!"));

//закрытие файла    НО файл и так будет закрыт, так как мы используем конструкцию try
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("Ошибка при сохранении коллекции в файл: " + e.getMessage());
                }
            }
        } else System.out.println("Системная переменная с файлом не найдена!");

    }

    /**
     *Чтение коллекции из файла
     * @return коллекция, которая была считана из файла
     */

    public LinkedList<Dragon> readCollection() {
        //LinkedList<Dragon> dragons = new LinkedList<Dragon>();
        if (System.getenv().get(envVariable) != null){
            if (file.exists() & !file.canRead()){
                System.out.println("\u001B[37m"+"\u001B[31m"+"Недостаточно прав для чтения данных из файла. Добавьте права на чтение и запустите программу вновь"+"\u001B[31m"+"\u001B[37m");
                System.exit(0);
            }
            try (FileReader fileScanner = new FileReader(file)){
                Type collectionType = new TypeToken<LinkedList<Dragon>>() {}.getType();
                LinkedList<Dragon> collection = gson.fromJson(fileScanner, collectionType);
                LinkedList<Dragon> validCollection = collection.stream()
                        .filter(Dragon::validate)
                        .collect(Collectors.toCollection(LinkedList::new));

//                Type collectionType = new TypeToken<LinkedList<Dragon>>() {}.getType();
//                LinkedList<Dragon> collection = gson.fromJson(fileScanner, collectionType);
                System.out.println("\u001B[37m"+"\u001B[33m"+"Коллекция успешно прочитана!"+"\u001B[33m"+"\u001B[37m");
                if (validCollection==null) return new LinkedList<>();
                return validCollection;
            } catch (FileNotFoundException e) {
                System.err.println("Файл с таким именем не найден :(");
            } catch (IOException | IllegalStateException e) {
                System.err.println("Ошибка ввода-вывода");
            }catch (JsonSyntaxException e){
                System.err.println("Формат файла не удовлетворяет условию");
            } catch (NoSuchElementException exception) {
                System.err.println("Загрузочный файл пуст!");
            }

        }else System.out.println("\u001B[37m"+"\u001B[31m"+"Системная переменная с загрузочным файлом не найдена!"+"\u001B[31m"+"\u001B[37m");
        return new LinkedList<>();
    }

    @Override
    public String toString(){
        String string = "FileManager (класс для работы с загрузочным файлом)";
        return string;
    }
}
