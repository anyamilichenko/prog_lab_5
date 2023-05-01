package utilities;


import data.Coordinates;
import data.DragonCave;
import data.DragonCharacter;
import exceptions.IncorrectValueException;

import java.util.Scanner;

/**
 * Спрашивает пользователя значения для нового экземпдяра Dragon
 */

//ПРИДУМАТЬ ШУТКИ

public class Creator {
    private boolean t = true;
    private Scanner scanner;

    public Creator(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Установка сканера для нового ввода пользователя
     *
     * @param scanner сканнер
     */

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * @return Scanner, который используется для пользовательсеого ввода
     */

    public Scanner getScanner() {
        return this.scanner;
    }

    /**
     * Узнает координаты дракона
     *
     * @return Координаты дракона
     */

    public Coordinates newCoordinates() {
        double x = 5.5;
        double y = 6.6;
        t = true;
        System.out.println("Введите координаты местоположения");
        while (t) {
            try {
                System.out.println("y:");
                x = Double.parseDouble(scanner.nextLine().trim());
                if (y <= -513.0) throw new IncorrectValueException();
                t = false;
            } catch (NumberFormatException e) {
                System.err.println("Координата может быть только числом");
            } catch (IncorrectValueException e) {
                System.err.println("Координата y должна быть больше -513");
            }
        }
        t = true;
        while (t) {
            try {
                System.out.println("x:");
                y = Double.parseDouble(scanner.nextLine().trim());
                t = false;
            } catch (NumberFormatException e) {
                System.err.println("Координата может быть только числом");
            }
        }
        return new Coordinates(x, y);
    }


    /**
     * Узнает характер дракона
     *
     * @return характер дракона
     */
    public DragonCharacter newDragonCharacter() {
        String character = "";
        for (DragonCharacter d : DragonCharacter.values()) {
            character += "\n" + d.name();
        }
        DragonCharacter returnn = DragonCharacter.EVIL;
        t = true;
        while (t) {
            try {
                System.out.println("Введите характер дракона");
                System.out.println("Выберете из следующих вариантов: " + character);
                returnn = DragonCharacter.valueOf(scanner.nextLine().trim().toUpperCase());
                t = false;
            } catch (IllegalArgumentException e) {
                System.err.println("Значение должно быть выбрано из заданного списка");
                System.out.println();
            }
        }
        return returnn;
    }

    /**
     * Узнает имя дракона
     *
     * @return Имя дракона
     */
    public String newName() {
        t = true;
        String name = "";
        while (t) {
            try {
                System.out.println("Введите имя дракона");
                name = scanner.nextLine().trim();
                if (name.equals("")) throw new IncorrectValueException();
                t = false;
            } catch (IncorrectValueException e) {
                System.err.println("Имя не может быть пустой строкой");

            }
        }
        return name;
    }

    /**
     * Узнает возраст дракона
     *
     * @return возраст дракона
     */
    public long newAge() {
        t = true;
        long age = 5;
        while (t) {
            try {
                System.out.println("Введите возраст дракона");
                age = Long.parseLong(scanner.nextLine().trim());
                if (age <= 0) throw new IncorrectValueException();
                t = false;
            } catch (NumberFormatException e) {
                System.err.println("Возраст - это целое число");
            } catch (IncorrectValueException e) {
                System.err.println("Возраст должен быть больше нуля. Меньший возраст доступен лишь существам, которые выигрывают всеросс в утробе матери.");
            }
        }
        return age;
    }

    /**
     * Узнает вес дракона
     *
     * @return вес дракона
     */
    public Double newWeight() {
        t = true;
        Double weight = 5.0;
        while (t) {
            try {
                System.out.println("Введите вес дракона");
                weight = Double.parseDouble(scanner.nextLine().trim());
                if (weight <= 0) throw new IncorrectValueException();
                t = false;

            } catch (NumberFormatException e) {
                System.err.println("Вес может быть только  числом");
                System.out.println();
            } catch (IncorrectValueException e) {
                System.err.println("Вес может быть только положительным числом. ");
            }
        }
        return weight;
    }

    /**
     * Узнает вес дракона
     *
     * @return вес дракона-
     */
    public Integer newWingspan() {
        t = true;
        Integer wingspan = 10;
        while (t) {
            try {
                System.out.println("Введите силу размаха крыльев дракона");
                wingspan = Integer.parseInt(scanner.nextLine().trim());
                if (wingspan <= 0) throw new IncorrectValueException();
                t = false;

            } catch (NumberFormatException e) {
                System.err.println("Сила размаха крыльев дракона может быть только  числом");
            } catch (IncorrectValueException e) {
                System.err.println("Сила размаха крыльев дракона может быть только положительным числом.");
            }
        }
        return wingspan;
    }

    /**
     * Узнает пещеру, в которой находятся сокровища
     *
     * @return Пещера
     */
    public DragonCave newCave() {
        Double depth = depthOfCave();
        float numberOfTreasures = treasuresInCave();
        return new DragonCave(depth, numberOfTreasures);
    }

    /**
     * Узнает количество сокровищ в пещере
     *
     * @return количество сокровищ
     */
    private float treasuresInCave() {
        t = true;
        float treasurs = 4.0f;
        while (t) {
            try {
                System.out.println("Введите количество сокровищ в пещере");
                treasurs = Float.valueOf(scanner.nextLine().trim());
                if (treasurs <= 0) throw new IncorrectValueException();
                t = false;
            } catch (NumberFormatException e) {
                System.err.println("Формат введенного значения неверен");
            } catch (IncorrectValueException e) {
                System.err.println("Значение должно быть больше 0");
            }
        }
        return treasurs;
    }


    public Double depthOfCave() {
        t = true;
        Double depth = 34.5;
        while (t) {
            try {
                System.out.println("Введите глубину пещеры дракона:");
                depth = Double.valueOf(scanner.nextLine().trim());
                if (depth.compareTo(0.0) <= 0) throw new IncorrectValueException();
                t = false;
            } catch (NumberFormatException e) {
                System.err.println("Формат введенного значения неверен");
            } catch (IncorrectValueException e) {
                System.err.println("Глубина пещеры должна быть больше нуля");

            }
        }
        return depth;
    }
}