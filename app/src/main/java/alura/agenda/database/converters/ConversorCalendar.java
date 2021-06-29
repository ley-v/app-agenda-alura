package alura.agenda.database.converters;

import androidx.room.TypeConverter;

import java.util.Calendar;

public class ConversorCalendar {

    @TypeConverter
    public Long paraLong(Calendar valor) {
        if (valor != null) return valor.getTimeInMillis();
        return null;
    }

    @TypeConverter
    public Calendar paraCalendar(Long valor) {
        Calendar momento = Calendar.getInstance();
        if (valor != null) momento.setTimeInMillis(valor);
        return momento;
    }
}
