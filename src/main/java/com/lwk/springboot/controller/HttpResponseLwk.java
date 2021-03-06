package com.lwk.springboot.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;

/**
 * http://blog.csdn.net/shuwei003/article/details/7986158
 *  todo 自定义response数据拦截
 */
public class HttpResponseLwk extends HttpServletResponseWrapper {

    private PrintWriter tmpWriter;
    private StringWriter output;

    public HttpResponseLwk(HttpServletResponse response) {
        super(response);
        output = new StringWriter();
        tmpWriter = new PrintWriter(output);
    }

    public void finalize() throws Throwable {
        super.finalize();
        output.close();
        tmpWriter.close();
    }

    public String getContent() {
        tmpWriter.flush();   //刷新该流的缓冲，详看java.io.Writer.flush()
        String s = output.toString();
        //此处可根据需要进行对输出流以及Writer的重置操作
        //比如tmpWriter.getByteArrayOutputStream().reset()
        return s;
    }

    //覆盖getWriter()方法，使用我们自己定义的Writer
    public PrintWriter getWriter() throws IOException {
        return tmpWriter;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return super.getOutputStream();
    }

    public void close() throws IOException {
        tmpWriter.close();
    }
}
