package blockchain.web.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class BlockData<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类型
     */
    private String type;
    /**
     * 唯一标识
     */
    private String id;

    private T data;
}
