import java.util.Scanner;

public class ResultTask1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Введите число в бинарном формате");
		String binaryString = scan.nextLine();

		if (binaryString == null || binaryString.length() == 0) {
			System.out.println("Введена пустая строка");
			return;
		}

		double result = 0;
		char[] binaryChars = binaryString.toCharArray();
		int powCount = 0;

		for (int i = binaryChars.length - 1; i >= 0; i--) {
			if (binaryChars[i] != '0' && binaryChars[i] != '1') {
				System.out.println("Ошибка формата числа");
				return;
			}
			result = result + Character.getNumericValue(binaryChars[i]) * Math.pow(2, powCount);
			powCount++;
		}
		System.out.printf("Число в десятичном формате = %d \n", (long) result);
	}
}
