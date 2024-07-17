package OnlineShopingApplication;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PasswordUtility {

    public static String encrpte(String password) {
        String en="";
        //ABCD 
        for(int i=0;i<password.length();i++) {
            char ch = password.charAt(i);
            if(ch=='z') {
                ch='a';
            }
            else if(ch=='Z') {
                ch='A';
            }
            else if(ch=='9') {
                ch='0';
            }
            else {
                ch++;
            }
            en=en+ch;
        }

        return en;
         
    }

    public static String timeGenerate() {
         LocalDateTime localDateTime = LocalDateTime.now();
         DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

         return localDateTime.format(dateTimeFormatter);

    }

    

}
