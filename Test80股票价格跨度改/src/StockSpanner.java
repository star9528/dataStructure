
import java.util.Stack;

public class StockSpanner {
        Stack<Integer> prices,weights;//价格,价格跨度

        public StockSpanner() {
            prices = new Stack<>();
            weights = new Stack<>();
        }

        public int next(int price) {
            //当栈为 null 时,price 依然满足 price = price,
            // 因此价格跨度最少为一
            int w = 1;
            //prices.peek() <= price 只有当这个条件满足时,才会进入循环
            //也就是说进入循环则 prices.peek() <= price 一定满足
            while (!prices.isEmpty() && prices.peek() <= price) {
                //把满足条件的 price 出栈,再去判断栈中下一个元素
                prices.pop();
                // w 就是表示价格跨度
                w += weights.pop();
            }
            prices.push(price);
            weights.push(w);
            return w;
        }

    public static void main(String[] args) {
        StockSpanner S = new StockSpanner();
        S.next(100);
        S.next(80);
        S.next(60);
        S.next(70);
        S.next(60);
        S.next(75);

        System.out.println(S.next(85));
    }
}
