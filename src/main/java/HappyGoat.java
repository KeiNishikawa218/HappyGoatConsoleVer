import java.util.*;

public class HappyGoat {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        //階層構造がHappyGoatから始まっているため、"src/main/java"を追記。new File("img name").getAbsoluteFile()によって確認
        String filename = "src/main/img/pink.jpg";

        //警告が出るけど、全角入力でも動く
        ArrayList<String> userInputTextArray = new ArrayList<String>();
        String userInputText = "";

        //本文を入力。EOFで入力を中止。
        System.out.print("本文を入力してください。改行も入力できます。EOFで入力を中止します。\n");
        do {
            System.out.print("> ");
            userInputText = stdIn.nextLine();
            userInputTextArray.add(userInputText);

        } while(!userInputText.equals("EOF"));

        //変数を利用している範囲が狭いのでgeneratorという名前を採用
        ImageGenerator generator = new ImageGenerator(filename, userInputTextArray);
        generator.generate("src/main/out/");
    }
}