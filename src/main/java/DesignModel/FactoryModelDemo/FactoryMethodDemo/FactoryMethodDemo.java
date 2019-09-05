package DesignModel.FactoryModelDemo.FactoryMethodDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactoryMethodDemo {
    public static void main(String[] args){
        PizzaStore store = new PizzaStore();
        store.submitOrder();
    }
}

abstract class Pizza{
    protected String name;
    public void prepare(){
        System.out.println(name + ":材料准备中");
    }
    public void bake(){
        System.out.println(name + ":烘烤中");
    }
    public void cut(){
        System.out.println(name + ":分割中");
    }
    public void packUp(){
        System.out.println(name + ":打包中");
    }

}

class BeiJinCheesePizza extends Pizza {
    BeiJinCheesePizza(){
         super.name = "北京芝士披萨";
     }
}

class BeiJinBananaPizza extends Pizza {
    BeiJinBananaPizza(){
        super.name = "北京香蕉披萨";
    }
}

class LondonCheesePizza extends Pizza {
    LondonCheesePizza(){
        super.name = "伦敦芝士披萨";
    }
}

class LondonBananaPizza extends Pizza {
    LondonBananaPizza(){
        super.name = "伦敦香蕉披萨";
    }
}

abstract class PizzaFactory{
    public abstract Pizza createPizza(String type);
    public static PizzaFactory getFactory(String region){
        if(region.toLowerCase().equals("beijin"))
            return new BeiJinPizzaFactory();
        else if(region.toLowerCase().equals("london"))
            return new LondonPizzaFactory();
        else return null;
    }
}

class BeiJinPizzaFactory extends PizzaFactory{

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type.toLowerCase().equals("cheese"))
            pizza = new BeiJinCheesePizza();
        else if(type.toLowerCase().equals("banana"))
            pizza = new BeiJinBananaPizza();
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.packUp();
        return pizza;
    }
}

class LondonPizzaFactory extends PizzaFactory{

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type.toLowerCase().equals("cheese"))
            pizza = new LondonCheesePizza();
        else if(type.toLowerCase().equals("banana"))
            pizza = new LondonBananaPizza();
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.packUp();
        return pizza;
    }
}

class PizzaStore {
    PizzaFactory pizzaFactory;

    public void submitOrder(){
        while (true){
            String region = getRegion();
            String type = getType();
            this.pizzaFactory = PizzaFactory.getFactory(region);
            pizzaFactory.createPizza(type);
        }
    }
    private String getRegion(){
        String str = null;
        try {
            BufferedReader strIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入地区：");
            str = strIn.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    private String getType(){
        String str = null;
        try {
            BufferedReader strIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入需要的pizza种类：");
            str = strIn.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}