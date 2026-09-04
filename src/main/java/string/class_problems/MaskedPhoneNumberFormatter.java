package string.class_problems;

public class MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {
        if (phone == null) {
            return "Invalid phone number";
        }

        String trimmed = phone.trim();
        if (trimmed.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < trimmed.length(); i++) {
            if (!Character.isDigit(trimmed.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append("-");
        sb.append(trimmed.substring(6));

        return sb.toString();
    }

    public static void main(String[] args) {
        String p1 = "9876543210";
        System.out.println("Input: \"" + p1 + "\" -> Output: " + maskPhoneNumber(p1));

        String p2 = "98765";
        System.out.println("Input: \"" + p2 + "\" -> Output: " + maskPhoneNumber(p2));
    }
}
