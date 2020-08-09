package demo.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;

import java.io.File;
import java.io.IOException;

public class CreateClassDemo {
    public static void main(String[] args) throws IOException {
        DynamicType.Unloaded<Object> type = new ByteBuddy()
                .subclass(Object.class)
                .name("CreateClassDemoOut")
                .make();
        type.saveIn(new File("gen-out"));
    }
}
