package BankApplication;

public class PasswordUtility {

    public static String Encrpte(String password)
    {
        String en="";

        for(int i=0;i<password.length();i++)
        {
            char ch = password.charAt(i);
            if(ch=='z')
            {
                ch='a';
            }
            else if(ch=='Z')
            {
                ch='A';
            }
            else if(ch=='9')
            {
                ch='0';
            }
            else
            ch++;

            en+=ch;
        }

        return en;
    }

    
}
