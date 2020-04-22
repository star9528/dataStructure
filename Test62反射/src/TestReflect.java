//反射

import com.sun.scenario.effect.Merge;
import sun.awt.HeadlessToolkit;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

class Animal {
    public void eat(String food) {

    }
}

class Cat extends Animal{
    private String name;

    public Cat() {
        this.name = "小猫";
    }

    public Cat(String name) {
        this.name = name;
    }
    @Override
    public void eat(String food) {
        System.out.println(this.name + "正在吃" + food);
    }
}
class Bird extends Animal {
    private String name;

    public Bird() {
        this.name = "小鸟";
    }
    @Override
    public void eat(String food) {
        System.out.println(this.name + "正在吃" + food);
    }
}

public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException, NoSuchFieldException,
            NoSuchMethodException, InvocationTargetException {
//        //1.如何获取类对象
//        //1)通过字符串来获取到类，参数是类的全限定类名[最重要]
//        //  catClass 就是 Cat 类的图纸，里面描述了 Cat 类的内部结构
//        Class catClass = Class.forName("Cat");
//
//        //2)通过实例来获取
//        Cat cat = new Cat("小黑");
//        Class catClass2 = cat.getClass();
//        //得到的类对象在内存中只有一份，不管通过哪种方式获取到的类对象，
//        // 本质上是一个对象
//        System.out.println(catClass == catClass2);
//
//        //3)通过类来获取
//        Class catClass3 = Cat.class;
//        System.out.println(catClass == catClass3);

//        //2.通过类对象来创建实例
//        //  平时创建实例都是通过 new 方式
//        //  catClass 表示 Cat 类的对象.也就是 Cat 类的图纸
//        //  newInstance 创建对应的实例
//        Class catClass = Class.forName("Cat");
//        Cat cat = (Cat) catClass.newInstance();
//        cat.eat("鱼");


//        //下面这段代码，只看代码，是不知道要创建 Bird 还是 Cat 的实例。
//        // (开发时不知道要实例化那个类)
//        //在运行时，可以由使用的人来指定要实例那个
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入：");
//        String className = scanner.next();
//        System.out.println("您要创建的实例类型为：" + className);
//        Class animalClass = Class.forName(className);
//        Animal animal = (Animal) animalClass.newInstance();
//        animal.eat("鱼");


//
//    //1.当开发时不知道属性名的时候，可以再运行时来设计这个属性名
//    //2.对应字段为 private 的时候，同时有没有 getter setter 可以借助反射打破封装
//        //3.通过反射获取/修改属性(可以修改 private 的属性)
//        Class catClass = Class.forName("Cat");
//        // Cat 类中包含 name 属性，是 private 的。
//        // catClass 类对象是整体类的图纸。此处想关注一个图纸上的局部信息(name)
//        // 通过 getDeclaredField 能得到局部内容。通过 Field 对象来表示
//        Field field = catClass.getDeclaredField("name");
//        // 这个代码加上之后，才能访问 private 成员
//        field.setAccessible(true);
//
//        Cat cat = new Cat();
//        //拿着图纸中的局部信息，拆开 Cat 对象，看看里面有啥。
//        //除了获取以外，还可以根据名字来修改属性
//        field.set(cat,"大猫");
//        String name = (String) field.get(cat);// 这个相当于 cat.name
//        System.out.println(name);




//        //4.通过反射获取类中的方法
//        Class catClass = Class.forName("Cat");
//        //根据 catClass 这个图纸，找到 Cat 类中的 eat 方法。
//        //方法可以重载。就可以通过后续变长参数来指定，要获取那个版本的 eat。
//        //下面代码的意思是获取到只有一个参数且类型为 String 的 eat方法
//        Method method = catClass.getMethod("eat",String.class);
//        Cat cat = new Cat();
//        method.invoke(cat,"猫粮");


//        //5.获取构造方法，借助构造方法来实例化对象
//        Class catClass = Class.forName("Cat");
//        //获取到 Cat 类中，只有一个参数且类型为 String 的构造方法
//        Constructor constructor = catClass.getConstructor(String.class);
//        Cat cat = (Cat) constructor.newInstance("小黑");
//        cat.eat("鱼");
    }
}
