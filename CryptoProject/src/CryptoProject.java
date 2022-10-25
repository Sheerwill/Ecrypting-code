public class CryptoProject {
    public static void main(String[] args){
        System.out.println(encryptString("Who will win the election?", 5, 3));
    }
    public static String normalizeText(String str){
        str = str.replaceAll("\\s", "");
        str = str.replaceAll("\\p{Punct}", "");
        str = str.toUpperCase();
        return str;
    }
    public static String obify(String str){
        String result = "";
        for(int i = 0; i < str.length(); i++){
            char x = str.charAt(i);
            if(x == 'A' || x == 'E' || x == 'I' || x == 'O' || x == 'U' || x == 'Y'){
                result += "OB" + x;
            }else{
                result += x;
            }
        }
        return result;
    }
    public static String caesarify(String str, int shiftValue){
        String result = "";
        for(int i = 0; i < str.length(); i++){
            int newCharUnicode = (int)(str.charAt(i)) + shiftValue;
            if (newCharUnicode > (int)'Z'){
                newCharUnicode = (((int)'A') - 1) + (newCharUnicode % (int)'Z');
                char newChar = (char)newCharUnicode;
                result += newChar;
            }else{
                char newChar = (char)newCharUnicode;
                result += newChar;
            }

        }
        return result;
    }
    public static String groupify(String str, int lettersNumber){
        String result = "";
        int count = 0;
        int x = str.length() % lettersNumber; /*numbers left afterdividing*/
        for (int i = 0; i < str.length(); i++){
            if (i > 0 && (i + 1) % lettersNumber == 0){
                result += str.substring(count, i + 1) + " ";
                count += lettersNumber;
            }else if ((i + 1) == str.length() && x != 0){
                result += str.substring(count);

                for(int j = 1; j <= (((str.length()/lettersNumber) + 1) * lettersNumber) - str.length(); j++){
                    result += "x";
                }
            }
        }
        return result;
    }
    public static String encryptString(String str, int shiftValue, int lettersNumber){
        String normalized = normalizeText(str);
        String obified = obify(normalized);
        String caesarified = caesarify(obified, shiftValue);
        String groupified = groupify(caesarified, lettersNumber);

        return groupified;
    }
}
