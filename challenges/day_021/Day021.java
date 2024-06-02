import java.util.regex.Pattern;

public class Day021 {

    public static void main(String[] args) {
        Day021 d21 = new Day021();
        String email = "edvaldo200gmail.com";
        System.out.println(d21.validadorEmail(email));
    }

  
 private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
    );


    public boolean validadorEmail(String email) {
      return email.length() >= 7 && EMAIL_PATTERN.matcher(email).matches();
  }



}

