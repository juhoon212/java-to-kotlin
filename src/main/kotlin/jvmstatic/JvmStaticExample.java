package jvmstatic;

import com.example.jvmstatic.HelloClass;
import com.example.jvmstatic.HiObject;

public class JvmStaticExample {

    public static void main(String[] args) {
        // String hello = HelloClass.Companion.hello(); // 코틀린의 companion object 메서드 호출 Companion 키워드 사용 -> jvmstatic 어노테이션 안붙인 경우
        var hello = HelloClass.hello();
        // String hi = HiObject.INSTANCE.hi(); // 코틀린의 object 메서드 호출 INSTANCE 키워드 사용 -> jvmstatic 어노테이션 안붙인 경우
        var hi = HiObject.hi();
    }
}
