import java.util.HashSet;
import java.util.Set;
//给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
// S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
public class Solution {
    public int numJewelsInStones(String J, String S) {
        //1.先遍历 J 把所有的宝石类型加入到一个 Set 中
        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }
        //2.遍历 S  拿到每个元素取 set 中查找，如果能找到就说明是宝石
        int ret = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                ret++;
            }
        }
        return ret;
    }
}
