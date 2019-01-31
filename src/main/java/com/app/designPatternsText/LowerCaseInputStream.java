package com.app.designPatternsText;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: ben
 * @Date: 2018/12/29 17:19
 */
public class LowerCaseInputStream extends FilterInputStream {

    public LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return c == -1 ? c:Character.toLowerCase(c);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {

        int result = super.read(b, off, len);

        for (int i = off;i<off + len;i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }


        return result;
    }
}
