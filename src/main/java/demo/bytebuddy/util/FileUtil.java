package demo.bytebuddy.util;

import net.bytebuddy.dynamic.DynamicType;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    public static final String GEN_OUT = "gen-out";

    public static void saveClass(DynamicType.Unloaded<?> type) throws IOException {
        type.saveIn(new File(GEN_OUT));
    }
}
