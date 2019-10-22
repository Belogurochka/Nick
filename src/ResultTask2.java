import java.util.Scanner;

//https://javarush.ru/groups/posts/1997-algoritmih-sortirovki-v-teorii-i-na-praktike
public class ResultTask2 {

	public static void main(String[] args) {
		selectionSort();
		insertionSort();
		quickSort();
		shellSort();
	}

	// Каждый проход выбирать самый минимальный элемент и смещать его в начало.
	// При этом каждый новый проход начинать сдвигаясь вправо, то есть первый проход — с первого элемента, второй проход — со второго
	private static void selectionSort() {
		System.out.println("=============== Сортировка прямым выбором ===============");
		int[] mass = getMass();
		for (int left = 0; left < mass.length; left++) {
			int minInd = left;
			for (int i = left; i < mass.length; i++) {
				if (mass[i] < mass[minInd]) {
					minInd = i;
				}
			}
			int tmp = mass[left];
			mass[left] = mass[minInd];
			mass[minInd] = tmp;
		}

		outputMass(mass);
	}

	//тоже самое,что и выбором, только одинаковые элементы не меняют свое местоположение
	private static void insertionSort() {
		System.out.println("=============== Сортировка вставками ===============");
		int[] mass = getMass();

		for (int left = 0; left < mass.length; left++) {
			int value = mass[left];
			int i = left - 1;
			for (; i >= 0; i--) {
				if (value < mass[i]) {
					mass[i + 1] = mass[i];
				} else {
					break;
				}
			}
			mass[i + 1] = value;
		}

		outputMass(mass);
	}

	private static void quickSort() {
		System.out.println("=============== Сортировка быстрая ===============");
		int[] mass = getMass();
		quickSort(mass, 0, mass.length - 1);
		outputMass(mass);
	}

	private static void quickSort(int[] source, int leftBorder, int rightBorder) {
		int leftMarker = leftBorder;
		int rightMarker = rightBorder;
		int pivot = source[(leftMarker + rightMarker) / 2];
		do {

			while (source[leftMarker] < pivot) {
				leftMarker++;
			}

			while (source[rightMarker] > pivot) {
				rightMarker--;
			}
			if (leftMarker <= rightMarker) {

				if (leftMarker < rightMarker) {
					int tmp = source[leftMarker];
					source[leftMarker] = source[rightMarker];
					source[rightMarker] = tmp;
				}

				leftMarker++;
				rightMarker--;
			}
		} while (leftMarker <= rightMarker);


		if (leftMarker < rightBorder) {
			quickSort(source, leftMarker, rightBorder);
		}
		if (leftBorder < rightMarker) {
			quickSort(source, leftBorder, rightMarker);
		}
	}

	//тот же пузырек,но с уменьшением вдвое каждую итерацию
	private static void shellSort() {
		System.out.println("=============== Сортировка Шелла ===============");
		int[] mass = getMass();
		int gap = mass.length / 2;
		while (gap >= 1) {
			for (int right = 0; right < mass.length; right++) {

				for (int c = right - gap; c >= 0; c -= gap) {
					if (mass[c] > mass[c + gap]) {
						int tmp = mass[c];
						mass[c] = mass[c + gap];
						mass[c + gap] = tmp;
					}
				}
			}
			gap = gap / 2;
		}
		outputMass(mass);
	}

	private static void outputMass(int[] mass) {
		System.out.println("Массив после сортировки");
		for (int i = 0; i < mass.length; i++) {
			System.out.print(mass[i] + " ");
		}
		System.out.println();
	}

	private static int[] getMass() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Введите размер массива");
		int massLength = scan.nextInt();

		int[] mass = new int[massLength];

		for (int i = 0; i < massLength; i++) {
			System.out.printf("Введите %d элемент массива \n", i + 1);
			mass[i] = scan.nextInt();
		}

		return mass;
	}


}
