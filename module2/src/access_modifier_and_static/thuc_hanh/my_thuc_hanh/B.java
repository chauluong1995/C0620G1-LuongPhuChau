package access_modifier_and_static.thuc_hanh.my_thuc_hanh;

import access_modifier_and_static.thuc_hanh.*;

//class B extends A{
//
//    public static void main(String args[]){
//
//        B obj = new B();
//
//        obj.msg();
//
//    }
//
//}
class B{

    public static void main(String args[]){

        A obj = new A();

        obj.msg();

    }

}
