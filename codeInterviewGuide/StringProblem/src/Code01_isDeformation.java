public class Code01_isDeformation {
    public static void main(String[] args) {
        String str1 = "acdes14";
        String str2 = "ed14sac";
        System.out.println(isDeformation(str1, str2));

        System.out.println('A' - '\0');
    }

    public static boolean isDeformation(String str1,String str2){
        if (str2.length() != str1.length())
            return false;
//        char []map = new char[256];
//        for (int i = 0; i < str1.length(); i++) {
//            map[str1.charAt(i)]++;
//        }
//        for (int i = 0; i < str2.length(); i++) {
//            map[str2.charAt(i)]--;
//        }
//        for (char c : map) {
//            if (c != 0) {
//                return false;
//            }
//        }
//        return true;
        int []map = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            map[str1.charAt(i)]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            if (map[str2.charAt(i)]-- == 0){
                return false;
            }
        }
        return true;
    }
}
