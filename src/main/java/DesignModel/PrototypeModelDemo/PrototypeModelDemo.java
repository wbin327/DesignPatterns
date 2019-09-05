package DesignModel.PrototypeModelDemo;

public class PrototypeModelDemo {
    public static void main(String[] args) throws CloneNotSupportedException{
        Sheep tom = new Sheep("tom", "white", 1);
        Sheep tomClone =(Sheep)tom.clone();
        System.out.println(tom);
        System.out.println(tomClone);
        System.out.println("tom == tomClone:" + (tom == tomClone? "true" : "false"));
    }
}

class Sheep implements Cloneable{
    private String name;
    private String color;
    private int age;

    public String toString(){
        return  name + "," + color + "," + age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Sheep(String name, String color, int age){
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
