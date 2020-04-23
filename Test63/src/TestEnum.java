//枚举
enum Sex {
    MALE,
    FEMALE,
    OTHER,
}

public class TestEnum {
//    public static final int MALE = 1;
//    public static final int FEMALE = 2;
//    public static final int OTHER = 3;

    public static void main(String[] args) {
        Sex sex = Sex.MALE;
        if (sex == Sex.MALE) {
            System.out.println("这是枚举");
        }
    }
}
