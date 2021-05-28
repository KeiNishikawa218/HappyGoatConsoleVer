//ユーザが入力した文字に対応する画像を返す
//ユーザの入力は文字列で与えられる

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.*;

public class ReadAndWriteImage{
    private BufferedImage img = null; // 画像オブジェクト
    private int width = 0;  // 画面の幅
    private int height = 0; // 画面の高さ
    private String userInput = "";

    Graphics g;

    public ReadAndWriteImage(String imageName) {
        try {
            this.img = ImageIO.read(new File(imageName));
            this.width = img.getWidth();
            this.height = img.getHeight();
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("画像の読み込みに失敗しました");
        }
    }

    public void WriteImage(BufferedImage inputImg, String outputFilePath) {
        try {
            File outputFileName = new File(outputFilePath + "saved.png");
            ImageIO.write(inputImg, "png", outputFileName);
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("画像の書き込みに失敗しました");
        }
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public void addText() {
        Font font = new Font("ＭＳ 明朝", Font.PLAIN, 18);

        g = img.getGraphics();
        g.setFont(font);
        g.setColor(Color.GREEN);

        //入力が日本語だと警告出るけど一応動く
        g.drawString(this.userInput, 0, 20);
    }
}
