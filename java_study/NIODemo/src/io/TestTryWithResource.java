package io;

import java.io.Closeable;
import java.io.IOException;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2019/3/8
 */
public class TestTryWithResource  implements Closeable {
    @Override
    public void close() throws IOException {
        throw new RuntimeException("Close exception");
    }
}
