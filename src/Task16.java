import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task16 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Введите путь к файлу, который необходимо прочитать");
		String filePath = scan.nextLine();

		if (filePath == null || filePath.length() == 0) {
			System.out.println("Путь к файлу пустой");
			return;
		}

		File file = new File(filePath);

		try (FileReader fileReader = new FileReader(file);
			 BufferedReader bufferedReader = new BufferedReader(fileReader)) {

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Файл не найден");
		} catch (IOException e) {
			System.out.println("Ошибка чтения файла");
		}
	}
}
