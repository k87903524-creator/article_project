import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println(" == 프로그램 시작 ==");
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.print("명령어) ");
      String cmd = sc.nextLine().trim();

      if (cmd.equals("exit")) {
        break;
      } else if (cmd.length() == 0) {
        System.out.println("명령어를 입력해주세요");
        continue;
      }
    }
    System.out.println(" == 프로그램 종료 ==");
    sc.close();
  }
}