package DesignModel.BuilderModelDemo;



public class Demo {

    public static void main(String[] args){
        NormalHouseBuilder normalHouseBuilder = new NormalHouseBuilder();
        HighBuildingBuilder highBuildingBuilder  = new HighBuildingBuilder();
        Driector driector = new Driector(normalHouseBuilder);
        // 构建普通房子
        Product product = driector.construct();
        // 构建高楼
        Product product2 = new Driector(highBuildingBuilder).construct();
    }
}

class Driector{
    private Builder builder;
    Driector(Builder builder){
        this.builder = builder;
    }
    public Product construct(){
        builder.buildBasic();
        builder.buildTop();
        builder.buildWalls();
        return builder.getProduct();
    }
}

abstract class Builder{
    protected Product product = new Product();
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void buildTop();
    public Product getProduct(){
        return product;
    }
}

class NormalHouseBuilder extends Builder{

    @Override
    public void buildBasic() {
        product.setBasic("建造普通房子的地基");
    }

    @Override
    public void buildWalls() {
        product.setBasic("建造普通房子的墙壁");
    }

    @Override
    public void buildTop() {
        product.setBasic("建造普通房子的房顶");
    }
}

class HighBuildingBuilder extends Builder{
    @Override
    public void buildBasic() {
        product.setBasic("建造高楼的地基");
    }

    @Override
    public void buildWalls() {
        product.setBasic("建造高楼的墙壁");
    }

    @Override
    public void buildTop() {
        product.setBasic("建造高楼的房顶");
    }
}

class Product{
    private String basic;
    private String walls;
    private String top;

    public void setBasic(String basic) {
        this.basic = basic;
        System.out.println(basic);
    }

    public void setWalls(String walls) {
        this.walls = walls;
        System.out.println(walls);
    }

    public void setTop(String top) {
        this.top = top;
        System.out.println(top);
    }
}