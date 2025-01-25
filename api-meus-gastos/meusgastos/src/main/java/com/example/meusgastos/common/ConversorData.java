package com.example.meusgastos.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversorData {
    
    public static String converterDateParaDataEHora(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        return sdf.format(data);
    }
}
