import java.util.ArrayList;
import java.util.List;

public class Yanghui {
    public List<List<Integer>> generate(int numRows){
        //杨辉三角的特点：
        //1.第一行固定是一个一
        //2.第二行固定是两个一
        //3.第i行，首尾元素固定是一
        //4.第i行有i个元素
        //5.对于第i行来说第j列的值是i - 1行j - 1列值加上i - 1行j列的值
        //  例如：第2行第2列的值是2,。就是第1行第1列 + 第1第2列的值
        if(numRows <= 0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        //1.第一行固定是一个一
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if(numRows == 1){
            return result;
        }
        //2.第二行固定是两个一
        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if(numRows == 2){
            return result;
        }

        //3.第i行
        //  第i行有i个元素
        //  对于第i行来说第j列的值是i - 1行j - 1列值加上i - 1行j列的值
        //  第i行的元素首尾元素都是1
        for(int row = 3;row <= numRows;row++){
            //如果要想知道第row行的情况，就得先知道row - 1行的情况
            //row - 1 -1   第一个减一是为了得到row - 1行
            //             第二个减一 是为了得到row - 1的下标
            List<Integer> prevLine = result.get(row - 1 -1);
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);
            //第row行应该有row列，下面这个循环相当于循环了row- 2次
            //因为第一列和最后一列都固定是一，不参与循环
            //如果row为5的话，第5行应该有5列。下面的循环应该就要执行三次
            //针对差一问题，最好的办法就是带入具体的数字去验证是否合理
            for(int col = 2;col < row;col++){
                int curNum = prevLine.get(col - 1 - 1) + prevLine.get(col - 1);
                curLine.add(curNum);
            }
            //处理最后一个一
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }
}
