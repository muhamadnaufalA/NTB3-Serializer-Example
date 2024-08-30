package com.learn.ntb3learn.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NTB3Response {
    private Date timestamp;
    private String data;
    private boolean isSending;
    private boolean autoChecksum;
}
