package com.lwk.springboot.fremarker.tag;

import freemarker.core.Environment;
import freemarker.template.*;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * Created by R9L4H0W on 2016/2/26.
 */
public class LwkTestTag implements TemplateDirectiveModel{


    @Override
    public void execute(Environment environment,
                        Map map,
                        TemplateModel[] templateModels,
                        TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {

                SimpleScalar param1=  (SimpleScalar) map.get("sss");
        environment.setVariable("lwk",ObjectWrapper.DEFAULT_WRAPPER.wrap("---23223"));
        templateDirectiveBody.render(new UpperCaseFilterWriter(environment.getOut(),param1.getAsString()));


    }

    private static class UpperCaseFilterWriter extends Writer {

        private final Writer out;
        private String hell;

        UpperCaseFilterWriter (Writer out,String hell) {
            this.out = out;
            this.hell=hell;
        }

        public void write(char[] cbuf, int off, int len)
                throws IOException {

            char[] transformedCbuf = new char[len];

            for (int i = 0; i < len; i++) {
                transformedCbuf[i] = Character.toUpperCase(cbuf[i + off]);
            }

            out.write(new String(transformedCbuf)+new String(hell));
        }

        public void flush() throws IOException {
            out.flush();
        }

        public void close() throws IOException {
            out.close();
        }
    }


}
