import java.io.PrintStream;

public class vigenerechpher
{
  public vigenerechpher() {}
  
  public static void main(String[] args) throws java.io.IOException
  {
    java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
    

    String result = "";
    System.out.print("Enter Plain Text:");
    String input = br.readLine();
    System.out.print("Enter key:");
    String key = br.readLine();
    char[] keyarr = new char[input.length()];
    char[] inputarr = new char[input.length()];
    

    boolean flag = false;
    while (!input.equals("#")) {
      for (int i = 0; i < input.length(); i++) {
        char inp = input.charAt(i);
        inputarr[i] = inp;
      }
      int j = 0;
      for (int i = 0; i < input.length(); i++) {
        char c = key.charAt(j);
        if ((inputarr[i] < ' ') || (inputarr[i] > '9')) {
          keyarr[i] = c;
          j++;
          if (j == key.length()) {
            j = 0;
          }
        }
      }
      
      if ((key.matches(".*[!@#$%^&*].*")) || (key.matches(".*\\d.*")) || (!key.matches("\\S+"))) {
        flag = true;
      }
      if (!flag) {
        for (int i = 0; i < input.length(); i++) {
          if ((inputarr[i] >= 'A') && (inputarr[i] <= 'Z')) {
            if ((keyarr[i] >= 'A') && (keyarr[i] <= 'Z')) {
              char ch1 = (char)(inputarr[i] + (keyarr[i] - 'A'));
              if (ch1 > 'Z') {
                ch1 = (char)(ch1 - '\032');
                result = result + Character.toString(ch1);
              } else if (ch1 < 'A') {
                ch1 = (char)(ch1 + '\032');
                result = result + Character.toString(ch1);
              } else {
                result = result + Character.toString(ch1);
              }
            } else if ((keyarr[i] >= 'a') && (keyarr[i] <= 'z')) {
              char ch1 = (char)(inputarr[i] + (keyarr[i] - 'a'));
              if (ch1 > 'Z') {
                ch1 = (char)(ch1 - '\032');
                result = result + Character.toString(ch1);
              } else if (ch1 < 'A') {
                ch1 = (char)(ch1 + '\032');
                result = result + Character.toString(ch1);
              } else {
                result = result + Character.toString(ch1);
              }
            }
          } else if ((inputarr[i] >= 'a') && (inputarr[i] <= 'z')) {
            if ((keyarr[i] >= 'a') && (keyarr[i] <= 'z')) {
              char ch1 = (char)(inputarr[i] + (keyarr[i] - 'a'));
              if (ch1 > 'z') {
                ch1 = (char)(ch1 - '\032');
                result = result + Character.toString(ch1);
              } else if (ch1 < 'a') {
                ch1 = (char)(ch1 + '\032');
                result = result + Character.toString(ch1);
              } else {
                result = result + Character.toString(ch1);
              }
            } else {
              char ch1 = (char)(inputarr[i] + (keyarr[i] - 'A'));
              if (ch1 > 'z') {
                ch1 = (char)(ch1 - '\032');
                result = result + Character.toString(ch1);
              } else if (ch1 < 'a') {
                ch1 = (char)(ch1 + '\032');
                result = result + Character.toString(ch1);
              } else {
                result = result + Character.toString(ch1);
              }
            }
          }
          else if ((inputarr[i] >= ' ') && (inputarr[i] <= '9')) {
            result = result + Character.toString(inputarr[i]);
          }
        }
        System.out.print(result);
      }
      else {
        System.out.print("Enter key between [A-Zz-a]");
      }
      result = "";
      System.out.println();
      System.out.print("Enter Plain Text:");
      input = br.readLine();
      System.out.print("Enter key:");
      key = br.readLine();
    }
  }
}