package jvmstatic;

import com.example.jvmstatic.JvmFieldClass;
import com.example.jvmstatic.JvmFieldObject;

public class JvmFieldExample {

    public static void main(String[] args) {
        // var id = JvmFieldClass.Companion.getId(); @JvmField 를 쓰지 않았을 경우 Companion 키워드로 property를 접근해야 한다.
        // var name = JvmFieldObject.INSTANCE.getName(); @JvmField 를 쓰지 않았을 경우 INSTANCE 키워드로 property를 접근해야 한다.

        var id = JvmFieldClass.id;
        var name = JvmFieldObject.name;

        System.out.println(id + "&& " + name);

        int code = JvmFieldClass.CODE; // 상수 접근
        String familyName = JvmFieldObject.FAMILY_NAME; // 상수 접근
    }
}
