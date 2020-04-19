import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class BrokenKeyBoard {
    public static void main(String[] args) {
        //3.题目中的主要任务是判定预期输出的哪些字符串在实际输出的字符串中没有存在
        //  先搞定一个 Set 把实际输出的每个字符都存进去。就可以遍历预期输出字符串，
        //  看看哪个字符串在这个 Set 中不存在
        //[注意事项]预期字符串：7_This_is_a_test    实际字符串：_hs_s_a_es
        //可以看到 预期字符串 中你有三次出现 T 这个键，都是在实际字符串中不存在的。
        // 但是最后给的实例结构中 T 就只出现一次。
        // 最后还得对坏掉的键进行去重（同样可以使用 Set 来去重）
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //1.循环输入两个字符串。第一个是预期输出内容。第二个是实际输出内容。
            String expected = scanner.next();
            String actual = scanner.next();
            //2.把读入的两个字符串全部都转成大写
            expected = expected.toUpperCase();
            actual = actual.toUpperCase();
            //3，创建一个 Set 保存实际那些字符串输出
            Set<Character> actualSet = new HashSet<>();
            for (int i = 0; i < actual.length(); i++) {
                //注意，Set 中的元素不能重复。
                // 如果 add 的时候就发现在这个元素已经存在，add 就失败了
                //没有任何负面影响（不会因为失败就抛出异常，也不影响原来 Set 中的内容）
                actualSet.add(actual.charAt(i));
            }
            //4.遍历预期输出的字符串，看看哪个字符没有被实际输出
            Set<Character> brokenKeySet = new HashSet<>();
            for (int i = 0; i < expected.length(); i++) {
                char c = expected.charAt(i);
                if (actualSet.contains(c)){
                    //当前字符已经被输出了，就是一个好键。
                    continue;
                }
                //当前这个键没有被实际输出，就是坏了的键
                //输出格式非常重要，
                //还要考虑当前坏键的去重问题
                if (brokenKeySet.contains(c)) {
                    //用于去重，防止同一个坏件多次被打印
                    continue;
                }
                System.out.print(c);
                brokenKeySet.add(c);
            }
        }
    }
}
