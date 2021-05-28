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
    private BufferedImage img = null; // 画像オブジェクト
    private int width = 0;  // 画面の幅
    private int height = 0; // 画面の高さ
    private String userInputText = "";

    //TODO:変数名をimgかimageに統一
    //TODO:変数名gをgraphicsに変更
    Graphics g;

    public ImageGenerator(String imageFileName, String userInputText) {
        try {
            this.img = ImageIO.read(new File(imageFileName));
            this.userInputText = userInputText;

            this.width = img.getWidth();
            this.height = img.getHeight();
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("画像の読み込みに失敗しました");
        }
    }

    //TODO:addは追加するなので避けた方がいい（2回呼べばどんどん追加してくれると勘違いされるかも）
    public void addText() {
        Font font = new Font("ＭＳ 明朝", Font.PLAIN, 18);

        g = img.getGraphics();
        g.setFont(font);
        g.setColor(Color.GREEN);

        //警告出るけど、日本語の入力でも一応動く
        g.drawString(this.userInputText, 0, 20);
    }

    public void generate(String outputFilePath) {
        addText();

        try {
            File outputFileName = new File(outputFilePath + "saved.png");
            ImageIO.write(this.img, "png", outputFileName);
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("画像の書き込みに失敗しました");
        }
    }
}
