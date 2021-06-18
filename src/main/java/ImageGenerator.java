//ユーザが入力した文字に対応する画像を返す
//ユーザの入力は文字列で与えられる

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.*;

/**
 * 画像の読み込み・文字の付け足し・書き込みを行うクラスです。
 * 文字を埋め込んだ画像を生成するクラスです。
 */

//変数名命名←クラスの型を意識する
//変数名に型を付けるのか

public class ImageGenerator {
    private BufferedImage image = null; // 画像オブジェクト
    private  int imageWidth = 0;
    private  int imageHeight = 0;

    private ArrayList<String> userInputTextArray;   //messageLines

    Graphics graphics;

    public ImageGenerator(String imageFileName, ArrayList<String> userInputTextArray) {
        this.userInputTextArray = userInputTextArray;

        try {
            this.image = ImageIO.read(new File(imageFileName));
            this.imageWidth = image.getWidth();
            this.imageHeight = image.getHeight();

            this.userInputTextArray = userInputTextArray;
        } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("画像の読み込みに失敗しました");
        }
    }

    private void writeText() {
        Font font = new Font("ＭＳ 明朝", Font.PLAIN, 18);

        graphics = image.getGraphics();
        graphics.setFont(font);
        graphics.setColor(Color.BLACK);

        int i = 0; int j = 25;

        //ときどき警告出るけど、日本語の入力でも一応動く
        //size()-1することでEOFを出力しないようにする
        while (i < userInputTextArray.size()-1) {
            graphics.drawString(this.userInputTextArray.get(i), 15, i+j);

            i += 1; j += 30;
        }
    }

    private void drawLines() {
        graphics = image.getGraphics();
        graphics.setColor(Color.BLACK);

        for(int i = 30; i < imageHeight; i += 30) {
            graphics.drawLine(15, i, imageWidth - 15, i);
        }
    }

    public void generate(String outputDirectoryPath, String outputFilename) {
                //imageがnullの場合テキストを書き込めないため、nullか確認。
                if (this.image == null) {
                    System.out.println("指定した画像名は無効です。\nプログラムを終了します。");
                    System.exit(1);
                }

                drawLines();
                writeText();

                try {
                    File outputFilePath = new File(outputDirectoryPath + outputFilename);
                    ImageIO.write(this.image, "png", outputFilePath);
        } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("画像の書き込みに失敗しました");
        }
    }
}