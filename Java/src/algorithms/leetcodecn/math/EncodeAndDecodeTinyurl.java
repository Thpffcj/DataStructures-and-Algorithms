package algorithms.leetcodecn.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by thpffcj on 2020/1/6.
 *
 * TinyURL是一种URL简化服务，比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的
 * URL http://tinyurl.com/4e9iAk.
 *
 * 要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。你的加密和解密算法如何设计和运作是没有限制的，你只需要保证一个URL
 * 可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。
 */
public class EncodeAndDecodeTinyurl {

    /**
     * 为了加密 URL，我们使用计数器 (i) ，每遇到一个新的 URL 都加一。我们将 URL 与它的次数 i 放在哈希表 HashMap 中，这样我们
     * 在稍后的解密中可以轻易地获得原本的 URL。
     */
//    Map<Integer, String> map = new HashMap<>();
//    int i = 0;
//
//    // Encodes a URL to a shortened URL.
//    public String encode(String longUrl) {
//        map.put(i, longUrl);
//        return "http://tinyurl.com/" + i++;
//    }
//
//    // Decodes a shortened URL to its original URL.
//    public String decode(String shortUrl) {
//        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
//    }

    /**
     * 这种方法中，我们将当前 URL 第几个出现作为关键字进行加密，将这个出现次序看做 62 进制，并将每一位映射到一个长度为 62 位的表中对
     * 应的字母作为哈希值。此方法中，我们使用一系列整数和字母表来加密，而不是仅仅使用数字进行加密。
      */
//    String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
//    HashMap<String, String> map = new HashMap<>();
//    int count = 1;
//
//    public String getString() {
//        int c = count;
//        StringBuilder sb = new StringBuilder();
//        while (c > 0) {
//            c--;
//            sb.append(chars.charAt(c % 62));
//            c /= 62;
//        }
//        return sb.toString();
//    }
//
//    public String encode(String longUrl) {
//        String key = getString();
//        map.put(key, longUrl);
//        count++;
//        return "http://tinyurl.com/" + key;
//    }
//
//    public String decode(String shortUrl) {
//        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
//    }

    /**
     * 这种方法中，我们使用一种内建函数 \text{hashCode()}hashCode() 来为每一个 URL 产生加密结果。同样的，映射结果保存在 HashMap
     * 中以供解码。
      */
//    Map<Integer, String> map = new HashMap<>();
//
//    public String encode(String longUrl) {
//        map.put(longUrl.hashCode(), longUrl);
//        return "http://tinyurl.com/" + longUrl.hashCode();
//    }
//
//    public String decode(String shortUrl) {
//        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
//    }

    /**
     * 这个方法中，我们使用随机整数来加密。为了防止产生的结果与之前某个 \text{longURL}longURL 产生的结果相同，我们生成一个新的随机
     * 数作为加密结果。这个数据存在哈希表 HashMap 中，以便解码。。
     */
//    Map<Integer, String> map = new HashMap<>();
//    Random r = new Random();
//    int key = r.nextInt(Integer.MAX_VALUE);
//
//    public String encode(String longUrl) {
//        while (map.containsKey(key)) {
//            key = r.nextInt(Integer.MAX_VALUE);
//        }
//        map.put(key, longUrl);
//        return "http://tinyurl.com/" + key;
//    }
//
//    public String decode(String shortUrl) {
//        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
//    }

    /**
     * 在这种方法中，我们像方法 2 一样再次使用数字和字母表集合来为 URL 生成加密结果。这种方法中，加密后的长度固定是 6 位。如果产生出
     * 来的加密结果与之前产生的结果一样，就换一个新的加密结果。
     */
    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    HashMap<String, String> map = new HashMap<>();
    Random rand = new Random();
    String key = getRand();

    public String getRand() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(alphabet.charAt(rand.nextInt(62)));
        }
        return sb.toString();
    }

    public String encode(String longUrl) {
        while (map.containsKey(key)) {
            key = getRand();
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
}

