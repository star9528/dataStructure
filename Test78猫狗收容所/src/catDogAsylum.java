import java.util.ArrayList;

public class catDogAsylum {
    public ArrayList<Integer> asylum(int[][] ope) {
        ArrayList<Integer> input = new ArrayList<Integer>();
        ArrayList<Integer> output = new ArrayList<Integer>();
        int rows = ope.length;
        for (int i = 0; i < rows; i++) {
            switch (ope[i][0]) {
                //有动物进入
                case 1:
                    input.add(ope[i][1]);
                    break;
                //有人领养
                case 2:
                    //第一种领养方式
                    if (ope[i][1] == 0) {
                        for (int j = 0; j < input.size(); j++) {
                            if (input.get(j) != 0) {
                                output.add(input.get(j));
                                input.set(j, 0);
                                break;
                            }
                        }
                    }
                    //指定收养狗
                    else if (ope[i][1] == 1) {
                        for (int j = 0; j < input.size(); j++) {
                            if (input.get(j) > 0) {
                                output.add(input.get(j));
                                input.set(j, 0);
                                break;
                            }
                        }
                    }
                    //指定收养猫
                    else if (ope[i][1] == -1) {
                        for (int j = 0; j < input.size(); j++) {
                            if (input.get(j) < 0) {
                                output.add(input.get(j));
                                input.set(j, 0);
                                break;
                            }
                        }
                    }
                    break;
            }
        }
        return output;
    }
}
