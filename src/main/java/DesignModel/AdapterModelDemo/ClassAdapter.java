package DesignModel.AdapterModelDemo;

/**
 * 类适配器模式
 */
public class ClassAdapter {
    public static void main(String[] args){
        Phone phone = new Phone();
        phone.charge(new Adapter().output());
    }
}

interface Voltage5{
    int output();
}
class Adapter implements Voltage5{
    Voltage220 voltage220 = new Voltage220();

    @Override
    public int output() {
        int input = voltage220.output();
        int output = input/44;
        return output;
    }
}
class Voltage220{
    public int output(){
        return 220;
    }
}
class Phone{
    public void charge(int input){
        System.out.println("手机充电中，当前电压为：" + input);
    }
}
