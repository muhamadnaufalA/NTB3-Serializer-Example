package com.learn.ntb3learn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NTB3Request {
    private boolean data_validity;
    private double roll;
    private double pitch;
    private double heading;
    private String checksum;
    private boolean auto_checksum;
    private int timesleep;
}
