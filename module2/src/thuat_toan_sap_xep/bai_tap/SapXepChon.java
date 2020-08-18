package thuat_toan_sap_xep.bai_tap;

public class SapXepChon {
    static int[] list = {1995, 5, 27, 15, 1996, 10, 8};

    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            // Gán phần từ đầu là min, vị trí hiện tại là min index :
            int currentMin = list[i];
            int currentMinIndex = i;

            // Duyệt từ phần tử đầu đến cuối mảng tìm ra phần tử nhỏ nhất và vị trí của phần tử đó :
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            // Nếu vị trí của phần tử nhỏ nhất khác vị trí bắt đầu thì đổi chỗ :
            if (currentMinIndex != i) {
                // Gán phần tử nhỏ nhất vừa tìm được bằng phần tử đầu :
                list[currentMinIndex] = list[i];
                // Gán  phần tử đầu bằng phần tử nhỏ nhất vừa tìm được :
                list[i] = currentMin;
            }
        }
    }

    public static void main(String[] args) {
        selectionSort(list);
        for (int element : list) {
            System.out.print(element + " ");
        }
    }
}
