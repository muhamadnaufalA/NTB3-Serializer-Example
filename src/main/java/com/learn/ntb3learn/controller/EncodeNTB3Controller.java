package com.learn.ntb3learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.learn.ntb3learn.service.EncodeNTB3Service;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import com.learn.ntb3learn.dto.*;

@RestController
public class EncodeNTB3Controller {

    @Autowired
    private EncodeNTB3Service encodeNTB3Service;

    @PostMapping("/convert")
    public String convertHexToBinary(@RequestBody HexRequest hexRequest) {
        // Memanggil service untuk melakukan konversi
        return encodeNTB3Service.convertHexToBinary(hexRequest.getHex());
    }

    @PostMapping("/encode")
    public NTB3Response encodeNTB3(@RequestBody NTB3Request ntb3Request) {
        NTB3Response ntb3Response = encodeNTB3Service.encodeNTB3(ntb3Request);
        return ntb3Response;
    }

    @PostMapping("/bitDefinition")
    public double [] postMethodName(@RequestBody(required = false) Empty empty) {
        double [] output = encodeNTB3Service.calculateBitDefinition(empty);
        return output;
    }
    
    
    
}

