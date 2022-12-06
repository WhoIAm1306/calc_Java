import java.util.Arrays;

class except {
    public static int diffNumSys(String str1, String str2) {
        String[] romanNum = {"нет", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] arabNum = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        int result = 1;
        boolean test1 = Arrays.asList(romanNum).contains(str1);
        boolean test2 = Arrays.asList(romanNum).contains(str2);
        if ((test1) && (!test2)) {
            System.out.println("*Exception* Используются одновременно " +
                    "разные системы счисления");
            result = 0;
        } else if ((!test1) && (test2)) {
            System.out.println("*Exception* Используются одновременно " +
                    "разные системы счисления");
            result = 0;
        }
        return result;
    }
}