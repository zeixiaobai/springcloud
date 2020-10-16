package org.springcloud.template.usercenter.filter;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * TODO
 *
 * @author zjx
 * @date 2020/10/9 0009 16:01
 */
public class MyServletResponseWrapper extends HttpServletResponseWrapper {

    private ByteArrayOutputStream baos = new ByteArrayOutputStream();

    private PrintWriter pw;

    private MyServletOutputStream sos = new MyServletOutputStream();

    public MyServletResponseWrapper(HttpServletResponse response) {
        super(response);
        pw = new PrintWriter(baos);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return pw;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return sos;
    }

    public ByteArrayOutputStream getBaos() {
        return baos;
    }

    public class MyServletOutputStream extends ServletOutputStream {

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setWriteListener(WriteListener listener) {

        }

        @Override
        public void write(int b) throws IOException {
            baos.write(b);
        }
    }
}
