package password_validator;

import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args){
        String username = "johndoe";
        String password = "ABC_1234";
        String newPassword = " ";
        newPassword = getNewPassword();

        boolean ok;
        do{
            ok = true;
            if(newPassword.length() < 8 ){
                System.out.println("Your password should have at least 8 characters");
                ok = false;
            }
            if(newPassword.equals(password)){
                System.out.println("Your password should not be the same as the old password");
                ok = false;
            }
            if(newPassword.contains(username)){
                System.out.println("Your password should not contain your username");
                ok = false;
            }
            int j = 0, k = 0;
            for(int i=0; i<newPassword.length(); i++)
            {
                if(Character.isUpperCase(newPassword.charAt(i)))
                    j++;
                if(!Character.isLetterOrDigit((newPassword.charAt(i))))
                    k++;
            }
            if(j==0) {
                System.out.println("Your password should contain at least one uppercase letter");
                ok = false;
            }
            if(k==0){
                System.out.println("Your password should contain at least one special character");
                ok = false;
            }
            if(ok == false){
                newPassword = getNewPassword();
            }
            else{
                System.out.println("Your new password has been saved successfully! Thank you");
            }
        }while(!ok);
    }

    public static String getNewPassword(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a new password:");
        String newPassword = scanner.next();
        return newPassword;
    }
}
