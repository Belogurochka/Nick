import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Task18 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Введите путь к файлу, который необходимо прочитать");
		String filePath = scan.nextLine();

		if (filePath == null || filePath.length() == 0) {
			System.out.println("Путь к файлу пустой");
			return;
		}

		File file = new File(filePath);

		int linesCount = readFile(file);
		rewriteFile(filePath, file, linesCount);
	}

	private static int readFile(File file) {
		int linesCount = 0;
		try (FileReader fileReader = new FileReader(file);
			 BufferedReader bufferedFileReader = new BufferedReader(fileReader)) {

			String fileLine;

			while ((fileLine = bufferedFileReader.readLine()) != null) {
				System.out.println(fileLine);
				linesCount++;
			}

		} catch (FileNotFoundException e) {
			System.out.println("Файл не найден");
		} catch (IOException e) {
			System.out.println("Ошибка чтения файла");
		}
		return linesCount;
	}

	private static void rewriteFile(String filePath, File file, int linesCount) {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		try (FileWriter fileWriter = new FileWriter(file);
			 BufferedReader bufferedInputReader = new BufferedReader(inputStreamReader);
			 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

			System.out.printf("Количество строк в файле %s =  %d \n", filePath, linesCount);
			System.out.printf("Начните ввод данных, ввод не прекратится пока количество введенных строк не будет равно %d \n", linesCount);

			String inputLine;
			while (linesCount > 0) {
				inputLine = bufferedInputReader.readLine();
				bufferedWriter.write(inputLine);
				linesCount--;
			}

		} catch (FileNotFoundException e) {
			System.out.println("Файл не найден");
		} catch (IOException e) {
			System.out.println("Ошибка чтения файла");
		}
	}
}
