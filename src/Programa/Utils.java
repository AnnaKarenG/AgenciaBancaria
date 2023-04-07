package Programa;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    static NumberFormat formattingNumber = new DecimalFormat("R$ #,##0.00");
    static SimpleDateFormat formattingDate = new SimpleDateFormat("dd/MM/yyyy");

    public static String dateToString(Date date) {
        return Utils.formattingDate.format(date);
    }

    public static String doubleToString(Double value) {
        return Utils.formattingNumber.format(value);
    }

}