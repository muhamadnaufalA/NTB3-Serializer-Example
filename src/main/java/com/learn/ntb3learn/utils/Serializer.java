package com.learn.ntb3learn.utils;

import com.learn.ntb3learn.dto.NTB3Request;

public class Serializer {

    private static final int FC = 360;
    private static final String IDENTIFIER = "11101111";
    private static final String VERSION_ID = "00001000";
    private static final String MESSAGE_DATA_LENGTH = "00000000 00010010";

    // Method untuk mengubah hexadecimal menjadi biner
    public static String hex2biner(String hex) {
        // Mengubah input hexadecimal menjadi nilai integer
        int decimalValue = Integer.parseInt(hex, 16);
        
        // Mengubah nilai integer menjadi biner
        return Integer.toBinaryString(decimalValue);
    }

    // Method untuk menghitung bit definition
    public static double [] calculateBitDefinition() {
        //inisialisasi variable 
        int pangkat;
        double [] bitDefinition = new double[16];

        for (int i = 0; i < 16; i++) {
            pangkat = i+1;
            if (i == 0){
                bitDefinition[i] = (double) (-FC/(Math.pow(2, pangkat))); 
            }else{
                bitDefinition[i] = (double) (FC/(Math.pow(2, pangkat)));
            }  
        }
        return bitDefinition;
    }

    //Method untuk mengubah data validity menjadi biner
    public static String DataValidity (boolean dataValidity){
        if(dataValidity){
            return "10000000 ";
        }else{
            return "00000000 ";
        }
    }

    // Method untuk mengubah data ship reference menjadi biner
    public static String shipReferenceData(double degreeInput){
        //inisialisasi variable
        String binaryOutput = "";
        double [] bitDefinition = calculateBitDefinition();

        for(int i = 0; i < bitDefinition.length; i++){
            if(degreeInput >= 0 && i == 0){
                binaryOutput += "0";
                continue;
            } 
            if(degreeInput >= bitDefinition[i]){
                binaryOutput += "1";
                degreeInput -= bitDefinition[i];
            }else{
                binaryOutput += "0";
            }
            if(i == 7){
                binaryOutput += " ";
            }
        }

        return binaryOutput;
    }

    // Method untuk encode data NTB3 ke biner
    public static String encodeNTB3toBiner(NTB3Request ntb3Request) {
        
        String binaryOutput = String.format("%s %s %s ", 
                IDENTIFIER, 
                VERSION_ID, 
                MESSAGE_DATA_LENGTH);
        
        binaryOutput += DataValidity(ntb3Request.isData_validity());
        binaryOutput += shipReferenceData(ntb3Request.getRoll()) + " ";
        binaryOutput += shipReferenceData(ntb3Request.getPitch()) + " ";
        binaryOutput += shipReferenceData(ntb3Request.getHeading());
        return binaryOutput;
    }
}
