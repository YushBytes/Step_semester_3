package basics.assigment_problems;

public class ExamHallSeatDuplication {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No Duplicate Seats Found");
            return;
        }

        boolean foundAny = false;
        // Track printed duplicates using a boolean array or simple in-array checking without Collections
        boolean[] alreadyReported = new boolean[seatNumbers.length];

        for (int i = 0; i < seatNumbers.length; i++) {
            if (alreadyReported[i]) continue;

            boolean isDuplicate = false;
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    isDuplicate = true;
                    alreadyReported[j] = true;
                }
            }

            if (isDuplicate) {
                System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                foundAny = true;
            }
        }

        if (!foundAny) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        int[] hall1 = {101, 102, 103, 102, 105};
        System.out.println("Test Case 1 ({101, 102, 103, 102, 105}):");
        checkDuplicateSeats(hall1);

        int[] hall2 = {101, 102, 103, 104, 105};
        System.out.println("\nTest Case 2 ({101, 102, 103, 104, 105}):");
        checkDuplicateSeats(hall2);
    }
}
