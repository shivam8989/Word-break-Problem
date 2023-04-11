package Trie;
import java.util.*;
public class Word_Break_Problem {
    static class Node {
        Node childern[] = new Node[26];
        boolean endofwords = false;

        Node() {
            for (int i = 0; i < childern.length; i++) {
                childern[i] = null;
            }

        }
    }

    public static Node root = new Node();

    public static void Insert(String words) {
        Node curr = root;
        for (int level = 0; level < words.length(); level++) {
            int idx = words.charAt(level) - 'a';
            if (curr.childern[idx] == null) {
                curr.childern[idx] = new Node();
            }
            curr = curr.childern[idx];

        }
        curr.endofwords = true;
    }
    public static boolean Search(String key){
        Node curr = root;
        for(int i = 0; i<key.length(); i++){
            int idx = key.charAt(i)-'a';
            if(curr.childern[idx]==null){
                return false;
            }
            curr = curr.childern[idx];
        }
        return curr.endofwords==true;
    }
public static boolean wordBreak(String key){
        if(key.length()==0){
            return true;
        }
        for(int i = 1; i<=key.length(); i++) {
            // substring
            if (Search(key.substring(0, i)) && wordBreak(
                    key.substring(i))) {
                return true;
            }
        }
        return false;

}

    public static void main(String[] args) {
String arr [] = {"i","like","sam","samsung","mobile","ice"};
for(int i = 0; i< arr.length; i++){
    Insert(arr[i]);
}
String key = "ilikesamsunga";
        System.out.println(wordBreak(key));
    }
}
