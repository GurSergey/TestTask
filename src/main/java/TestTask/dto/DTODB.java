package TestTask.dto;

import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.Reader;

public abstract class DTODB {
    public Reader getReader() throws IOException {
        return Resources
                .getResourceAsReader("mybatis-config.xml");
    }
}
