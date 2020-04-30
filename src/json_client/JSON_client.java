package json_client;

import com.google.gson.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import static json_client.Gamer.*;
import static json_client.Network.*;

public class JSON_client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Gamer gamer1 = new Gamer();    // Создаем 1 игрока в клиенте, так как в одном клиенте 1 игрок.

        // Сканируем число, которое ввел пользователь.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер порта 3222 или 2015:");
        int port = scanner.nextInt();

        // Создаем сокет с введенным пользователем портом.
        Socket socket;
        socket = new Socket("localhost", port);

        InputStream sin = socket.getInputStream();
        OutputStream sout = socket.getOutputStream();

        DataInputStream in = new DataInputStream(sin);
        DataOutputStream out = new DataOutputStream(sout);

        // Формируем строку JSON из данных игрока, которые передаются в качестве аргумента.
        String line = createJSON(gamer1);

        System.out.println("Отправка строки серверу...");
        System.out.println();
        out.writeUTF(line); // Отсылаем введенную строку текста серверу (записываем в поток строку в кодировке UTF-8).
        out.flush();        // Очистка буферов вывода. Байты записываются в место назначения. Поток прекращает передачу данных и данные сбрасываются в поток.

        line = in.readUTF();    // Считываем из потока строку в кодировке UTF-8 и записываем ее в переменную line.
        System.out.println("Ответ от сервера: " + line);
        System.out.println();
    }
}
