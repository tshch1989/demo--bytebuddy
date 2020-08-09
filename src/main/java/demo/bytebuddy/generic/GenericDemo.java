package demo.bytebuddy.generic;

import demo.bytebuddy.util.FileUtil;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;

import java.io.IOException;
import java.lang.reflect.Type;

public class GenericDemo {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        TypeDescription.Generic parentGenericClass = TypeDescription.Generic.Builder
                .parameterizedType(Parent.class, String.class)
                .build();
        DynamicType.Unloaded<?> sub = new ByteBuddy()
                .subclass(parentGenericClass)
                .name("Sub")
                .make();
        FileUtil.saveClass(sub);
        DynamicType.Loaded<?> load = sub.load(GenericDemo.class.getClassLoader());
        Class<?> subClass = load.getLoaded();
        Parent<String> o = (Parent<String>) subClass.newInstance();
        o.setName("aaa");
        System.out.println(o.getName());
        Type genericSuperclass = o.getClass().getGenericSuperclass();
        System.out.println(genericSuperclass);
    }
}
