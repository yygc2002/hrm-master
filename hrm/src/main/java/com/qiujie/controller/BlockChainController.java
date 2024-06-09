package com.qiujie.controller;

import blockchain.web.model.Block;
import com.qiujie.dto.Response;
import com.qiujie.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blockchain")
public class BlockChainController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/findAll")
    ResponseDTO findAllBlockChain(){
        List<Block> blockList = mongoTemplate.findAll(Block.class);
        if(!blockList.isEmpty()){
            return Response.success(blockList);
        }
        return Response.error();
    }

}
