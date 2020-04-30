package json_client;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Network {

    // Метод формирует строку в формате JSON из полученного в качестве аргумента листа.
    static String createJSON(Gamer gamer) {
        Gson g = new Gson();
        String jsonString = g.toJson(gamer);    // Метод toJson() приводит строку к типу JSON.

        System.out.println("\nСтрока в формате JSon, которая будет отправлена серверу:");
        System.out.println(jsonString);
        System.out.println();
        return jsonString;
    }
}
