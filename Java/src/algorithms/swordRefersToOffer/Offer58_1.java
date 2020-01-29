package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019/9/28.
 *
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Offer58_1 {

    public String ReverseSentence(String str) {

        if (str == null || str.equals("")) {
            return "";
        }
        if (str.trim().equals("")) {
            return str;
        }

        String[] s = str.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = s.length - 1; i >= 0; i--) {
            stringBuffer.append(s[i]);
            stringBuffer.append(" ");
        }
        return stringBuffer.substring(0, stringBuffer.length() - 1).toString();
    }

    public static void main(String[] args) {
        Offer58_1 f = new Offer58_1();
        System.out.println(f.ReverseSentence(""));
    }
}
