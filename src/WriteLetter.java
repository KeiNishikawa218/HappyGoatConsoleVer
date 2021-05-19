import java.util.HashMap;
import java.util.Map;

public class WriteLetter {
    public static void main(String[] args) {
        //書き出しの言葉
        String[] header = new String[]{
                        "皆様お変わりなくお過ごしでしょうか",
                        "すっかりご無沙汰いたしまして、申し訳ありません。",
                        "天候不順のみぎり、お元気でご活躍のことと存じます。",
                        "平素は何かとお心にかけて下さいまして有難うございます。",
                        "いつもご高配をいただき、誠にありがとうございます。",
                    };

        //結びの言葉
        String[] footer = new String[] {
                "取り急ぎ近況お知らせ致します。",
                "切にご自愛を祈りあげます。",
                "時節柄、ご健康には一段とご留意のほどを。",
                "お返事を賜らば幸いに存じます。",
                "今後とも何卒よろしくお願いします。",
        };

        //文字の色
        HashMap<String, String> color = new HashMap<>();
        color.put("black", "\u001b[30m");
        color.put("green", "\u001b[32m");
        color.put("yellow", "\u001b[33m");
        color.put("blue", "\u001b[34m");
        color.put("white", "\u001b[37m");
        color.put("reset", "\u001b[0m");

        System.out.println(color.get("green")+"aaa"+color.get("reset"));
    }
}