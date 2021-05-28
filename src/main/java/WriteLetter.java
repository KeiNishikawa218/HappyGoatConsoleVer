import java.util.*;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs; // imread, imwrite, etc
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Core;
import org.opencv.highgui.HighGui;
import org.opencv.core.Point;
import org.opencv.core.Scalar;

public class WriteLetter {
    public static void main(String[] args) {
        //文字と画像合成機能以外
        //サービスを通じて人々を幸せに→気持ちを伝える
        //気持ちを伝え合うために何ができれば良いのか　←　音声・画像・Gif (apngという形式もある)
        //文章の自動生成（テンプレート機能）
        //Springのフレームワーク
        //SVG　←　文字のところだけいじれる？
        //メソッド名で機能を表現
        //画像生成クラス　→　文字と画像を与えると合成
        //XXX: 愚直な実装だけど動いてる。直したい
        //FIXME:　実装はしたけど直してくれ〜。期待通りに動かないところがある
        //TODO: やること！
        Scanner stdIn = new Scanner(System.in);

//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        String picFileSrc = "../img/pink.jpg";

        Mat matSrc = new Mat();

        matSrc = Imgcodecs.imread(picFileSrc);                          // 入力画像の読み込み

        String text = "Happy Goat!!";
        Point position = new Point(180, 180);
        Scalar color = new Scalar(0, 0, 255);
        int font = Imgproc.FONT_HERSHEY_SIMPLEX;
        int scale = 1;
        int thickness = 3;
        //Adding text to the image
        Imgproc.putText(matSrc, text, position, font, scale, color, thickness);
        //Displaying the resultant Image
        HighGui.imshow("Contours operation", matSrc);
        HighGui.waitKey();

        System.exit(0);

        //TODO:ユーザからの入力は後ほど対応
        //どの季節か
        int season = 2;

        //本文
        String inputBody = "";
        ArrayList<String> body = new ArrayList<String>();

        //書き出しの言葉
        String[] header = new String[] {
                "うららかな春の日差しが心地よい季節となりました。",
                "草木の緑も一段と濃くなってきましたが、お変わりなくお過ごしでしょうか。",
                "朝晩はだいぶ涼しく感じられるようになりましたが、いかがお過ごしでしょうか。",
                "日ごとに寒さが増し、冬支度にお忙しくされていることと存じます。",
                "いつもご高配をいただき、誠にありがとうございます。",
        };

        //結びの言葉
        String[] footer = new String[] {
                "花冷えに風邪など召されませぬようご自愛下さい。",
                "時節柄、ご自愛専一にご精励ください。",
                "秋気肌に染む時節、風邪など召されませぬようご自愛ください。",
                "寒さひとしお厳しき折、何卒ご自愛専一にてお願い申し上げます。",
                "今後とも何卒よろしくお願いします。",
        };

        //文字の色
//        HashMap<String, String> color = new HashMap<>();
//        color.put("black", "\u001b[30m");
//        color.put("green", "\u001b[32m");
//        color.put("yellow", "\u001b[33m");
//        color.put("blue", "\u001b[34m");
//        color.put("white", "\u001b[37m");
//        color.put("reset", "\u001b[0m");


        System.out.println("文章作成を支援します。\n季節を選んでください。");
        System.out.print("1→春　2→夏　3→秋　4→冬 5→その他\n>");

        //nextIntの場合改行が残るためnextLineを使用
        try {
            season = Integer.parseInt(stdIn.nextLine());
        } catch (NumberFormatException e) {
            season = 5;
            System.out.println("季節が存在しないため。その他を選択します。");
            System.out.println("5→その他を選択しました。\n");
            //プログラムを終わらせるという選択肢もある
            //もう一回聞くのもあり
//            e.printStackTrace();
        }

        //TODO:季節の訂正ができるといいね

        //本文を入力。EOFで入力を中止。
        System.out.print("本文を入力してください。改行も入力できます。EOFで入力を中止します。\n");
        do {
            inputBody = stdIn.nextLine();
            body.add(inputBody);

        } while(!inputBody.equals("EOF"));

        //メッセージを出力。
        System.out.println(header[season-1] + "\n");

        //ListをStringに変換すれば１行でかけるのでは
        for(int i = 0; i < body.size()-1; i++){
            System.out.println(body.get(i));
        }

        System.out.println("\n" + footer[season-1]);

        //良いコメント　→　なぜその処理なのか。何をは見ればわかる場合も


    }
}