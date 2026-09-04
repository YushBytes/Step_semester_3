package basics.assigment_problems;

public class TypingSpeedAccuracy {

    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input strings");
            return;
        }

        int totalChars = original.length();
        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = '\0';
        char typedChar = '\0';

        int compareLen = Math.min(original.length(), typed.length());

        for (int i = 0; i < compareLen; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; // 1-indexed position
                origChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        double accuracy = (totalChars > 0) ? ((double) matched / totalChars) * 100.0 : 0.0;

        StringBuilder sb = new StringBuilder();
        sb.append("Matched: ").append(matched).append("/").append(totalChars);
        sb.append(" | Accuracy: ").append(String.format("%.2f%%", accuracy));

        if (firstMismatchPos != -1) {
            sb.append(" | First Mismatch at position ").append(firstMismatchPos)
              .append(" ('").append(origChar).append("' vs '").append(typedChar).append("')");
        } else if (original.length() != typed.length()) {
            sb.append(" | Length mismatch");
        } else {
            sb.append(" | No Mismatches");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1:");
        checkTypingAccuracy("hello world", "hello worlt");

        System.out.println("\nTest Case 2:");
        checkTypingAccuracy("coding", "coding");
    }
}
