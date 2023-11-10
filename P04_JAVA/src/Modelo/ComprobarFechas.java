package Modelo;

import java.util.Calendar;
import static java.util.Calendar.*;
import java.util.GregorianCalendar;

public interface ComprobarFechas {
    
    GregorianCalendar hoy = new GregorianCalendar();
    
    static final int DIA_DEL_MES = hoy.get(DAY_OF_MONTH);
    static final int MES = hoy.get(MONTH) +1;
    static final int AÑO = hoy.get(YEAR);
    
    public boolean CumplirMes();
    public boolean CumplirAño();
}
