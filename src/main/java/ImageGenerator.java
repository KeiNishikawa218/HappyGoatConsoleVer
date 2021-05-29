//ユーザが入力した文字に対応する画像を返す
//ユーザの入力は文字列で与えられる

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.*;

/**
 * 画像の読み込み・文字の付け足し・書き込みを行うクラスです。
 * 文字を埋め込んだ画像を生成するクラスです。
 */
public class ImageGenerator {
    private BufferedImage image = null; // 画像オブジェクト
    private String userInputText = "";

    Graphics graphics;

    public ImageGenerator(String imageFileName, String userInputText) {
        try {
            this.image = ImageIO.read(new File(imageFileName));
            this.userInputText = userInputText;
        } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("画像の読み込みに失敗しました");
        }
    }

    public void writeText() {
        Font font = new Font("ＭＳ 明朝", Font.PLAIN, 18);

        graphics = image.getGraphics();
        graphics.setFont(font);
        graphics.setColor(Color.GREEN);

        //警告出るけど、日本語の入力でも一応動く
        graphics.drawString(this.userInputText, 0, 20);
    }

    public void generate(String outputFilePath) {
        //imageがnullの場合テキストを書き込めないため、nullか確認。
        if (this.image == null) {
            System.out.println("指定した画像名は無効です。\nプログラムを終了します。");
            System.exit(1);
        }

        writeText();

        try {
            File outputFileName = new File(outputFilePath + "saved.png");
            ImageIO.write(this.image, "png", outputFileName);
        } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("画像の書き込みに失敗しました");
        }
    }
}