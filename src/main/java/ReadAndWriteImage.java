//ユーザが入力した文字に対応する画像を返す
//ユーザの入力は文字列で与えられる

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

public class ReadAndWriteImage{
    private BufferedImage img = null; // 画像オブジェクト
    private int width = 0;  // 画面の幅
    private int height = 0; // 画面の高さ

    public ReadAndWriteImage(String imageName) {
        try {
            this.img = ImageIO.read(new File(imageName));
            this.width = img.getWidth();
            this.height = img.getHeight();
        } catch (Exception e) {
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

    public void addText() {
        Font font = new Font("Arial", Font.BOLD, 18);

        Graphics g = img.getGraphics();
        g.setFont(font);
        g.setColor(Color.GREEN);
        g.drawString("text", 0, 20);
    }
    //    @Override
//    public Dimension getPreferredSize() {
//        return new Dimension(width, height);
//    }

    // 画面描画
//    public void paintComponent(Graphics g) {
//        // 背景
//        g.setColor(Color.black);
//        g.fillRect(0, 0, width, height);
//        // 画像の表示
//        g.drawImage(this.img, 0, 0, null);
//    }


}
