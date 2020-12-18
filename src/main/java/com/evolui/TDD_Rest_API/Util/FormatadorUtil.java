package com.evolui.TDD_Rest_API.Util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public final class FormatadorUtil {

    public static double formatarParaDoubleDaStringComVirgula(double ferias) {
        DecimalFormat df = new DecimalFormat("##.00");
        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
        Number number = null;

        try {
            number = format.parse(df.format(ferias));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return number.doubleValue();
    }
}
