package utilities;

import data.Dragon;

import java.time.LocalDateTime;


import java.io.IOException;

import java.util.*;


/**
 * Управляет коллекцией
 */
//работа с коллекцией: создание нового id, добавление элемента, удаление и тд

public class CollectionManager {

    private LinkedList<Dragon> linkedlist = new LinkedList<>();
    private FileManager fileManager;

    private  LocalDateTime lastInitTime;
    private Creator creator;
    private Scanner scanner = new Scanner(System.in);
    private LinkedList<Dragon> dragons;
    private List<Dragon> sortDragonByCharacter = new ArrayList<>();

    public CollectionManager(FileManager fileManager, Creator creator){
        this.fileManager = fileManager;
        this.creator = creator;
    }
    public LinkedList<Dragon> getCollection() {
        return linkedlist;
    }

    public void setCollection(LinkedList<Dragon> dragons) {
        this.dragons = dragons;
    }

    /**
     * Записывает коллекцию в файл
     */

    public void saveToFile(){
        fileManager.writeCollection(linkedlist);
    }



    /**
     * Читает коллекцию из файла
     */
    ///private final LocalDateTime lastInitTime = LocalDateTime;
    public void loadCollection(){
        linkedlist = fileManager.readCollection();
        lastInitTime = LocalDateTime.now();


    }


    /**
     * Представляет все элементы коллекции в виде строки
     * @return строковое представление коллекции
     */


    public String getStringElements() {
        String strElem = "";
        if (linkedlist.isEmpty()) return "Коллекция пуста!";
        Iterator<Dragon> iter = linkedlist.iterator();
        while (iter.hasNext()) {
            Dragon d = iter.next();
            strElem += d.toString() + "\n";
        }
        return strElem;
    }


    /**
     * Чистит коллекцию
     */

    public void clear(){
        linkedlist.clear();
    }


    /**
     * Определяет класс коллекции
     * @return имя класса коллекции
     */

    public String collectionType(){
        return linkedlist.getClass().getName();
    }


    /**
     * Определяет размер коллекции
     * @return размер коллекции
     */

    public int collectionSize(){
        return linkedlist.size();
    }

    /**
     *  Определяет дату и время последней инициализации объекта
     * @return размер коллекции
     */

    public LocalDateTime getLastInitTime(){
        return lastInitTime;
    }


    /**
     * Генерирует ID
     * @return ID
     */

//    public Long newId(){
//        if (linkedlist.isEmpty()) return 1;
//        int lastId = 0;
//        for (Iterator<Dragon> iter = linkedlist.iterator(); iter.hasNext();){
//            Dragon d = iter.next();
//            lastId = (int) Math.max(lastId, d.getID());
//        }
//        return lastId + 1;
//    }

    public Long newId() {
        if (linkedlist.isEmpty()) {
            return 1L;
        }
        Long lastId = Long.MIN_VALUE;
        for (Iterator<Dragon> iter = linkedlist.iterator(); iter.hasNext();) {
            Dragon d = iter.next();
            lastId = Math.max(lastId, d.getID());
        }
        return lastId + 1;
    }


    /**
     * Добавляет новый элемент в коллекцию
     */

    public void insertNew(Dragon dragon){
        linkedlist.add(dragon);
    }


    /**
     * Проверяет, есть ли в коллекции элемент с таким ID
     * @param id id
     * @throws NullPointerException если нет эл-та с таким ID
     */
    public boolean checkId(Long id) {
        Iterator<Dragon> iterator = linkedlist.iterator();
        while (iterator.hasNext()) {
            Dragon d = iterator.next();
            if (d.getID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Находит ключ элемента по его ID
     * @param id id
     * @return ключ
     */

    public Integer getKeyById(Long id){
        for (int i = 0; i < linkedlist.size(); i++) {
            Dragon dragon = linkedlist.get(i);
            if (dragon.getID().equals(id))
                return i;
        }
        return null;
    }

    /**
     * Заменяет элемент по ключу
     *
     * @param dragon значение
     */
    public void update(Integer key, Dragon dragon){
        linkedlist.remove(key);
        linkedlist.set(Math.toIntExact(key),dragon);
    }

    /**
     * Removes greater.
     */
    public void removeGreater(Dragon dragonToCompare) {
        linkedlist.removeIf(dragon -> dragon.compareTo(dragonToCompare) > 0);
    }


    public Dragon getByValue(Dragon dragon){
        for (Dragon dragonn : linkedlist){
            if (dragonn.equals(dragon)) return dragonn;
        }
        return null;
    }

    /**
     * @return Элемент по его id
     */
    public Dragon getById(Long id) {
        for (Dragon element : linkedlist) {
            if (element.getID() == id) return element;
        }
        return null;
    }
    /**
     * Удаляет элемент из коллекции
     * @param element который удалили
     */
    public void removeFromCollection(Dragon element) {
        linkedlist.remove(element);
    }

    public void exit() {
        System.out.print("Здесь есть несохраненные изменения. Хотите ли вы сохранить их? (да/нет): ");
        String response = scanner.nextLine().trim().toLowerCase();
        switch (response) {
            case "да":
                saveToFile();
                break;
            case "нет":
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
        System.out.println("Программа завершена");

    }

    public void sortCharacter(){
        sortDragonByCharacter.addAll(linkedlist);
        Collections.sort(sortDragonByCharacter);
        Collections.reverseOrder();
        for(Dragon dragon1:sortDragonByCharacter){
            System.out.println(dragon1.getCharacter());

        }
        sortDragonByCharacter.clear();
    }









}
