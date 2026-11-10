package Arrays;

public class ArraySearch {

	public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int search = 30;
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == search) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.println("Index position = " + index);
        } else {
            System.out.println("Number not found");
        }

	}

}
