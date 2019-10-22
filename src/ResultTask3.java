import java.text.DecimalFormat;
import java.util.Scanner;

public class ResultTask3 {

	private static DecimalFormat df = new DecimalFormat("0.00");

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Введите текущий курс валют");
		double cource = scan.nextDouble();
		System.out.println("Введите количество рублей");
		double rubles = scan.nextDouble();


		System.out.printf("Конвертированная валюта = %f \n", Math.round(cource * rubles * 100.0) / 100.0);
		System.out.println("Конвертированная валюта = " + df.format(cource * rubles));
	}
}
