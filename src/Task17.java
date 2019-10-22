import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Task17 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Введите путь к файлу, в который будет производиться запись");
		String filePath = scan.nextLine();

		if (filePath == null || filePath.length() == 0) {
			System.out.println("Путь к файлу пустой");
			return;
		}

		File file = new File(filePath);
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);

		System.out.println("Начните ввод данных, прекращение ввода - команда stop");

		try (FileWriter fileWriter = new FileWriter(file);
			 BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

			String line;
			while (!(line = bufferedReader.readLine()).equals("stop")) {
				bufferedWriter.write (line);
				bufferedWriter.newLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Файл не найден");
		} catch (IOException e) {
			System.out.println("Ошибка записи файла");
		}
	}
}
