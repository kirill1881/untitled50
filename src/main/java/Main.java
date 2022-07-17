import java.util.*;


public class Main {
    public static void main(String[] args) {
        String str;
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();

        String[] strings = str.split("\\.");
        if (strings.length!=4){
            System.out.println("Not correct");
        }
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length(); j++) {
                if (strings[i].charAt(j)<48&&
                        strings[i].charAt(j)>57){
                    System.out.println("Not correct");
                    System.exit(1);
                }
            }
        }
        for (int i = 0; i < strings.length; i++) {
            if (Integer.parseInt(strings[i])<0||
                    Integer.parseInt(strings[i])>255){
                System.out.println("Not correct");
                System.exit(1);
            }
        }
        System.out.println("correct ip");
    }
}

