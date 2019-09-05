package DesignModel.AdapterModelDemo;


/**
 * 接口适配器模式
 */
public class InterfaceAdapter {
    public static void main(String[] args){
        new AbstractAdapter(){
            @Override
            public void function4() {
                super.function4();
            }
        };
    }
}

interface Interface1{
    void function1();
    void function2();
    void function3();
    void function4();
}

abstract class AbstractAdapter implements Interface1{
    @Override
    public void function1() {

    }

    @Override
    public void function2() {

    }

    @Override
    public void function3() {

    }

    @Override
    public void function4() {

    }
}
