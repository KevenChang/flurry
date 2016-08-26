
package my.custom.transformer;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;

import java.util.Arrays;


/**
 * 字节到字符串的转换
 * Spring XD中，kafka数据流是默认类型是字节流。当然这可以通过kafka配置做修改。
 */
@MessageEndpoint
public class Byte2StringTransformer {
    private ObjectMapper mapper = new ObjectMapper();

    @Transformer(inputChannel = "input", outputChannel = "output")
    public String transform(byte[] payload) {
        System.out.println(Arrays.toString(payload));
        return new String(payload);
    }
}
