public class StringConcatenate {
    public static void main(String[] args) {
        int n = 10000;
        long startTime, endTime;

        // Using String
        String str = "";
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            str += "hi";
        }
        endTime = System.nanoTime();
        System.out.println("String Concatenation Time: " + (endTime - startTime) + " ms");

        // Using StringBuilder
        StringBuilder sb = new StringBuilder();
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            sb.append("hi");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) + " ms");

        // Using StringBuffer
        StringBuffer sbf = new StringBuffer();
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            sbf.append("hi");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime - startTime) + " ms");
    }
}
/*String Concatenation Time: 47799800 ms
StringBuilder Time: 1371500 ms
StringBuffer Time: 1103300 ms
 */