import com.example.KotlinThrow;

import java.io.IOException;

public class JavaThrow {

    public void throwIoException() throws IOException {
        throw new IOException("Checked exception IO Exception occurred");
    }

    public static void main(String[] args) {
        var kotlinThrow = new KotlinThrow();
        kotlinThrow.throwIoException(); // 코틀린 것도 강제로 throw 하거나 try-catch를 강제하지 않음
        // 강제하고 싶다면 @Throws 어노테이션을 사용해야 함

        // in java
        var javaThrow = new JavaThrow();
        try {
            javaThrow.throwIoException();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
