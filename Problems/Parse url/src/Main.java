import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sample = scanner.nextLine();
        String[] parts1 = sample.split("\\?");
        String check = parts1[1];
        String[] parts2 = check.split("\\&");
        String[][] result = new String[5][2];
        for(int i = 0; i < parts2.length; i++) {
            if(parts2[i] == "pass" || parts2[i] == "port" || parts2[i] == "cookie"|| parts2[i] == "host" || parts2[i] == "password") {
                result[i][0] = parts2[i];
            }
            for(int j =i; j < i+1; j++) {
                if(parts2[j] != "pass" || parts2[j] != "port" || parts2[j] != "cookie"|| parts2[j] != "host" || parts2[j] != "password" || parts2[j] == " ") {
                    result[i][1] = parts2[i];
                } else if (parts2[j] == " ") {
                    result[i][1] = "not found";
                }
            }
        }
        for(int i = 0; i < parts2.length; i++) {
            for (int j = 0; j < 1; j++) {
                System.out.println(result[i][0] + " : " + result[i][1]);
            }
        }
    }
}
