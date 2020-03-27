import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//这是一张扑克牌
class Card{
    private String rank;  //点数
    private String suit;  //花色

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
//        return "Card{" +
//                "rank='" + rank + '\'' +
//                ", suit='" + suit + '\'' +
//                '}';
        return "[" + this.rank + this.suit + "]";
    }
}

public class Poker {
    public static void main(String[] args) {
        //1.创建一副牌
        List<Card> poker = buyPoker();
        //2.洗牌,最简单的办法，可以直接使用Collections.shuffle方法
        //  把List中的元素随机打乱顺序
        //  shuffle也可以自己实现：从后往前遍历List，取出当前元素，
        //  在生成一个随机位置，把当前元素和随机位置的元素交换
        Collections.shuffle(poker);
        //3.发牌。假设有三个玩家，每人发五张牌

        List<List<Card>> players = new ArrayList<>();
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        //给三个玩家发牌，每人发五张
        //i 表示牌的编号，j 表示玩家的编号
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                List<Card> player = players.get(j);
                //remove 表示删除 List 中指定下标的元素，并且把删除元素返回
                //remove 的作用是牌库中的牌减少一张,这个程序是在删除的同时插入
                player.add(poker.remove(0));
            }
        }
        //查看玩家手牌
        for (int i = 0; i < 3; i++) {
            System.out.println("玩家" + i + ":" + players.get(i));
        }
    }
    //下面这段程序是为了创建一副牌
    private static List<Card> buyPoker() {
        //一张牌的模型
        List<Card> poker = new ArrayList<>();
        //牌的所有花色
        String[] suits = {"♥","♠","♣","♦"};

        for (int i = 0;i < 4;i++){
            //这个循环来处理四种花色
            for(int j = 2;j < 10;j++){
                //这个循环表示每种花色有十三张牌
                //add为List接口中的方法，可以直接调用
                //"" + j  和  String.valueOf(j) 整数转换为字符串
                //下面这个就是一张牌的点数和花色
                poker.add(new Card("" + j,suits[i]));
            }
            poker.add(new Card("J",suits[i]));
            poker.add(new Card("Q",suits[i]));
            poker.add(new Card("K",suits[i]));
            poker.add(new Card("A",suits[i]));
        }
        return poker;
    }
}
