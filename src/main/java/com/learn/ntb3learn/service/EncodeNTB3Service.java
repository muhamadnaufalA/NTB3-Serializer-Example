package com.learn.ntb3learn.service;

import org.springframework.stereotype.Service;
import com.learn.ntb3learn.utils.Serializer;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import com.learn.ntb3learn.dto.NTB3Request;
import com.learn.ntb3learn.dto.NTB3Response;
import java.util.Date;

@Service
public class EncodeNTB3Service {

    //Method untuk konversi hex ke binary
    public String convertHexToBinary(String hex) {
        // Memanggil class Hex2Biner untuk melakukan konversi
        return Serializer.hex2biner(hex);
    }
  
    //Method untuk menghitung bit definition
    public double [] calculateBitDefinition(Empty empty) {
        return Serializer.calculateBitDefinition();
    }

    //Method untuk encode data NTB3
    public NTB3Response encodeNTB3(NTB3Request ntb3Request) {
        NTB3Response ntb3Response = new NTB3Response();
        // Melakukan proses encoding
        ntb3Response.setTimestamp(new Date());
        ntb3Response.setData(Serializer.encodeNTB3toBiner(ntb3Request));
        ntb3Response.setSending(true); //contoh yang start
        ntb3Response.setAutoChecksum(ntb3Request.isAuto_checksum());
        return ntb3Response;
    }
}

