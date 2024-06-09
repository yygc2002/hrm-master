package blockchain.web.model;

import com.qiujie.entity.Staff;
import com.qiujie.enums.TranscationTypeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 业务数据模型
 *
 * @author huangguotong
 *
 */
@Data
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 唯一标识
     */
    private String id;
    /**
     * 业务数据
     */
    private String businessInfo;

    /**
     * 类型
     */
    private TranscationTypeEnum type;

    String data;
}