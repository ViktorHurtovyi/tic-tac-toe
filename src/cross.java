import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class cross {
    static int count = 0;
    public static char[] desk = {'0', '1', '2', '3', '4', '5', '6', '7', '8'};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String answer = "yes";
        System.out.println("Впишите 1 для старта игры, 2 для истории прошлых игр, 3 для выхода");
        int menu = sc.nextInt();
        if (menu == 1) {
            while (answer.equals("yes")) {
                desk = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8'};
                game();
                System.out.println("Хотите сыграть еще раз?");
                answer = sc.nextLine();
                answer = sc.nextLine();
                System.out.println(answer);
            }
        } else if(menu == 2){
            history();
        }else {
            System.out.println("Конец игры");
        }
    }

    public static void Player1(){
        System.out.println("ход первого игрока");
    }
    public static void Player2(){
        System.out.println("ход второго игрока");
    }
    public static void showBoard(){
        System.out.println(desk[0]+" | "+desk[1]+" | "+desk[2]);
        System.out.println("-"+" | "+"-"+" | "+"-");
        System.out.println(desk[3]+" | "+desk[4]+" | "+desk[5]);
        System.out.println("-"+" | "+"-"+" | "+"-");
        System.out.println(desk[6]+" | "+desk[7]+" | "+desk[8]);
    }
    public static void game() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Имя 1 игрока");
        String Player1 = sc.nextLine();
        System.out.println("Имя 2 игрока");
        String Player2 = sc.nextLine();
        boolean check = false;
        FileWriter nFile = new FileWriter("game-log.txt", true);
        while(check = true){
            showBoard();
            Player1();
            boolean p1CHeck = false;
            while (p1CHeck == false) {
                int p1 = sc.nextInt();
                    if ((desk[p1] != 'X') && (desk[p1] != 'O') && (p1 < 9) && (p1 >= 0)) {
                        desk[p1] = 'X';
                        p1CHeck = true;
                        count++;
                    } else {p1CHeck = false;
                        System.out.println("неправильное значение");
                        showBoard();
                        Player1();}
            }
            showBoard();
                  if ((desk[0] == 'X' && desk[1] =='X' && desk[2] == 'X')||
                      (desk[3] == 'X' && desk[4] =='X' && desk[5] == 'X')
                    ||(desk[6] == 'X' && desk[7] =='X' && desk[8] == 'X')
                    ||(desk[0] == 'X' && desk[3] =='X' && desk[6] == 'X')
                    ||(desk[0] == 'X' && desk[4] =='X' && desk[8] == 'X')
                    ||(desk[2] == 'X' && desk[4] =='X' && desk[6] == 'X')
                    ||(desk[2] == 'X' && desk[5] =='X' && desk[8] == 'X')
                    ||(desk[1] == 'X' && desk[4] =='X' && desk[7] == 'X')){
                System.out.println("Победил игрок 1");
                      nFile.write("Победил игрок " + Player1 + "\r\n" +
                              desk[0]+" | "+desk[1]+" | "+desk[2]  + "\r\n" +
                              "-"+" | "+"-"+" | "+"-" + "\r\n" +
                              desk[3]+" | "+desk[4]+" | "+desk[5]  + "\r\n" +
                              "-"+" | "+"-"+" | "+"-" + "\r\n" +
                              desk[6]+" | "+desk[7]+" | "+desk[8]  + "\r\n" +
                              "-"+" | "+"-"+" | "+"-" + "\r\n");
                break;
            }
            if (count==9) {
                System.out.println("Ничья");nFile.write("Ничья"+"\r\n"+
                        desk[0]+" | "+desk[1]+" | "+desk[2]  + "\r\n" +
                        "-"+" | "+"-"+" | "+"-" + "\r\n" +
                        desk[3]+" | "+desk[4]+" | "+desk[5]  + "\r\n" +
                        "-"+" | "+"-"+" | "+"-" + "\r\n" +
                        desk[6]+" | "+desk[7]+" | "+desk[8]  + "\r\n" +
                        "-"+" | "+"-"+" | "+"-" + "\r\n");break;
            }
            Player2();
            boolean p2CHeck = false;
            while (p2CHeck == false) {
                int p2 = sc.nextInt();
                if ((desk[p2] != 'X') && (desk[p2] != 'O') && (p2 < 9) && (p2 >= 0)) {
                    desk[p2] = 'O';
                    count++;
                    p2CHeck = true;
                } else {p2CHeck = false;
                    System.out.println("неправильное значение");
                    showBoard();
                    Player2();}

            }
            if ((desk[0] == 'O' && desk[1] =='O' && desk[2] == 'O')||
                    (desk[3] == 'O' && desk[4] =='O' && desk[5] == 'O')
                    ||(desk[6] == 'O' && desk[7] =='O' && desk[8] == 'O')
                    ||(desk[0] == 'O' && desk[3] =='O' && desk[6] == 'O')
                    ||(desk[0] == 'O' && desk[4] =='O' && desk[8] == 'O')
                    ||(desk[2] == 'O' && desk[4] =='O' && desk[6] == 'O')
                    ||(desk[2] == 'O' && desk[5] =='O' && desk[8] == 'O')
                    ||(desk[1] == 'O' && desk[4] =='O' && desk[7] == 'O')){
                showBoard();
                System.out.println("Победил игрок 2");
                nFile.write("Победил игрок " + Player2+"\r\n"
                        +
                        desk[0]+" | "+desk[1]+" | "+desk[2]  + "\r\n" +
                        "-"+" | "+"-"+" | "+"-" + "\r\n" +
                        desk[3]+" | "+desk[4]+" | "+desk[5]  + "\r\n" +
                        "-"+" | "+"-"+" | "+"-" + "\r\n" +
                        desk[6]+" | "+desk[7]+" | "+desk[8]  + "\r\n" +
                        "-"+" | "+"-"+" | "+"-" + "\r\n");
                break;
            }

        }
           nFile.close();
    }
    public static void history() throws IOException {
        Files.lines(Paths.get("game-log.txt"), StandardCharsets.UTF_8).forEach(System.out::println);
    }
}
