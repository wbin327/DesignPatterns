package DesignModel.FactoryModelDemo.SimpleFactoryDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleFactoryDemo {
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

class CheesePizza extends Pizza{
     CheesePizza(){
         super.name = "芝士披萨";
     }
}

class BananaPizza extends Pizza{
    BananaPizza(){
        super.name = "香蕉披萨";
    }
}

class PizzaFactory{
    public Pizza createPizza(String type){
        Pizza pizza = null;
        if(type.toLowerCase().equals("banana"))
            pizza =  new BananaPizza();
        else if(type.toLowerCase().equals("cheese"))
            pizza =  new CheesePizza();
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.packUp();
        return pizza;
    }
}

class PizzaStore {
    PizzaFactory pizzaFactory;
    PizzaStore(){
        this.pizzaFactory = new PizzaFactory();
    }
    public void submitOrder(){
        while (true){
            String type = getType();
            this.pizzaFactory.createPizza(type);
        }
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