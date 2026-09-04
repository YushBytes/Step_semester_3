package string.assigment_problems;

public class AtmPinValidator {

    public static void checkPinLength(String pin) {
        if (pin == null || pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1 (\"482\"):");
        checkPinLength("482");

        System.out.println("\nTest Case 2 (\"4820\"):");
        checkPinLength("4820");
    }
}
