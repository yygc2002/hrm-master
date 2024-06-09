package blockchain.web.controller;

import javax.annotation.Resource;

import blockchain.web.model.Transaction;
import blockchain.web.service.BlockService;
import blockchain.web.service.PowService;
import blockchain.web.util.BlockCache;
import com.qiujie.entity.Staff;
import com.qiujie.enums.TranscationTypeEnum;
import com.qiujie.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
public class BlockController {

    @Resource
    BlockService blockService;

    @Resource
    PowService powService;

    @Autowired
    BlockCache blockCache;

    @Resource
    StaffMapper staffMapper;

    /**
     * 查看当前节点区块链数据
     * @return
     */
    @GetMapping("/scan")
    @ResponseBody
    public String scanBlock() {
        return JSON.toJSONString(blockCache.getBlockChain());
    }

    /**
     * 查看当前节点区块链数据
     * @return
     */
    @GetMapping("/data")
    @ResponseBody
    public String scanData() {
        return JSON.toJSONString(blockCache.getPackedTransactions());
    }

    /**
     * 创建创世区块
     * @return
     */
    @GetMapping("/create")
    @ResponseBody
    public String createFirstBlock() {
        blockService.createGenesisBlock();
        return JSON.toJSONString(blockCache.getBlockChain());
    }

    /**
     * 工作量证明PoW
     * 挖矿生成新的区块
     */
    @GetMapping("/mine")
    @ResponseBody
    public String createNewBlock() {
        powService.mine();
        return JSON.toJSONString(blockCache.getBlockChain());
    }

    @GetMapping("/mine1")
    @ResponseBody
    public String createNewBlockTest() {
        Staff staff = staffMapper.selectById(1);
        Transaction transaction = new Transaction();
        transaction.setData(JSON.toJSONString(staff));
        transaction.setId("1");
        transaction.setType(TranscationTypeEnum.ADD);
        transaction.setBusinessInfo("测试");
        powService.invokeBlockService(transaction);

        return JSON.toJSONString(blockCache.getBlockChain());
    }
}