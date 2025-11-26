package extensions;

import com.example.extensions.MyExtensionsKt;

public class MyExtensions {

    public static void main(String[] args) {
        //"ABCD".first();
        //"ABCD".addFirst('Z');

        final char first = MyExtensionsKt.first("ABCD");
        final String addFirst = MyExtensionsKt.addFirst("ABCD", 'Z');

        System.out.println(first);
        System.out.println(addFirst);
    }
}
