import java.util.*;

/**
 * ユーザから入力された文字を画像に書き込んだ後、画像を出力します。
 */

/**
 * 手続き型の場合はどうなるのか？
 * pinkとblueの変数を作る
 * imageGeneratorの各メソッドを実装（pinkでもblueでも処理できるようにする）
 * pinkの場合で処理
 * blueの場合で処理
 * →関数で分ける
 * →☆重複が多くなる
 * →☆templateImageとuserInputTextが変更しにくい
 * →greenを追加したい場合は
 *  →greenの変数を作る
 *  →各メソッドを呼び出す
 *  →☆greenとpinkとblueのつながりが分かりにくい（インスタンスだと分かりやすい）
 * ☆関数同士のつながりが分かりにくい（何が何を呼んでいるのか）
 * ☆関数や変数同士の責任の所在が分かりにくい
 */

public class HappyGoat {
    //ImageGenerator()
    //writeText()

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        //階層構造がHappyGoatから始まっているため、"src/main/java"を追記。new File("img name").getAbsoluteFile()によって確認
        String templateImageDirectoryPath = "src/main/img/";
        String templateImageFilenamePink= "pink.jpg";
        String templateImageFilenameBlue = "blue.jpg";

        //時々警告が出るけど、全角入力でも動く
        ArrayList<String> userInputTextArray = new ArrayList<>();
        String userInputText;

        //本文を入力。EOFで入力を中止。
        System.out.print("本文を入力してください。改行も入力できます。EOFで入力を中止します。\n");
        do {
            System.out.print("> ");
            userInputText = stdIn.nextLine();
            userInputTextArray.add(userInputText);
        } while(!userInputText.equals("EOF"));

        //変数を利用している範囲が狭いのでgeneratorという名前を採用
        ImageGenerator generatePinkLetter = new ImageGenerator(templateImageDirectoryPath + templateImageFilenamePink, userInputTextArray);
        ImageGenerator generateBlueLetter = new ImageGenerator(templateImageDirectoryPath + templateImageFilenameBlue, userInputTextArray);

        //手続き型だと同じことをしているのに繋がりが分かりにくい
        //TODO: 同じことを手続き型とオブジェクト指向で書いてみる
        generatePinkLetter.generate("src/main/out/", templateImageFilenamePink);
        generateBlueLetter.generate("src/main/out/",templateImageFilenameBlue);
    }
}

