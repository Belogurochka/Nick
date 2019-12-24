import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CollectionTask {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Введите путь к файлу, который необходимо прочитать");
		String filePath = scan.nextLine();

		if (filePath == null || filePath.length() == 0) {
			System.out.println("Путь к файлу пустой");
			return;
		}

		File file = new File(filePath);
		List<String> words = new ArrayList<>();

		try (FileReader fileReader = new FileReader(file);
			 BufferedReader bufferedReader = new BufferedReader(fileReader)) {

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				List<String> strWords = Arrays.asList(line.split(" "));
				words.addAll(strWords);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Файл не найден");
		} catch (IOException e) {
			System.out.println("Ошибка чтения файла");
		}

		int cnt = 0;
		int maxLengthCnt = 0;
		String maxLengthWord = null;
		String prevWord = null;

		if (!words.isEmpty()) {
			Collections.sort(words);
			for (String word : words) {
				if (prevWord == null) {
					prevWord = word;
					cnt = 1;
				} else if (word.equals(prevWord)) {
					cnt++;
				} else {
					System.out.println(String.format("Слово \"%1s\" встречается %2d раз и имеет длинну %3d символов", prevWord, cnt, prevWord.length()));
					cnt = 1;
					prevWord = word;
				}

				if (maxLengthWord == null || maxLengthWord.length() < word.length()) {
					maxLengthWord = word;
					maxLengthCnt = 1;
				} else if (maxLengthWord.equals(word)) {
					maxLengthCnt++;
				}
			}
			System.out.println(String.format("Самое длинное слово \"%1s\" встречается %2d раз и имеет длинну %3d символов", maxLengthWord, maxLengthCnt, maxLengthWord.length()));
		}
	}
}
