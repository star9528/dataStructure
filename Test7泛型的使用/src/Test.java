 class A<T> {
    T value;

    A(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}

public class Test<E> {
    public static void main(String[] args) {
        A<String> a = new A<>("100");
        System.out.println(a.get());
    }
}
