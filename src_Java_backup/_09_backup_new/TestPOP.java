package _09_backup_new;

public class TestPOP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] index = new int [] { 7, 4, 8, 3, 9, 1, 6, 0, 5, 2 };
		sort(index);
		//print(index);
	}

	private static void print(int[] index) {
		for (int x = 0; x < index.length; x++) {
			System.out.print(index[x] + "��");
		}
		System.out.println();
	}

	static void sort(int[] array) {
		int length = array.length;
		for (int x = 0; x < length; x++) {
			for (int y = 0; y < length - 1; y++) {
				if (array[y] > array[y + 1]) {
					int temp = array[y];
					array[y] = array[y + 1];
					array[y + 1] = temp;
				}
			}
			print(array);
		}
	}

}
