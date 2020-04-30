package json_client;

import java.util.ArrayList;
import java.util.Collections;

// Класс для создания игрока (все, что нужно, - это вектор имеющихся у игрока чисел, поэтому игрок будет листом).
public class Gamer {

    private ArrayList<Integer> gamers = new ArrayList<>(8);
    private int port;

    Gamer() {
        int arr[] = new int[8];
        for(int i = 0; i < 8; i++) {
            arr[i] = (int)(Math.random() * 10 + 1);    // Элементу массива присваивается случайное число от 1 до 10 и записывается в лист с gamers.
            gamers.add(i, arr[i]);    // Помещаем элемент arr[i] на позицию i в листе gamers.
        }
        Collections.sort(gamers); // Сортируем элементы по возрастанию.
    }
}
