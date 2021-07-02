package alura.agenda.database.converters;

import androidx.room.TypeConverter;

import alura.agenda.model.TipoTelefone;

public class ConversorTipoTelefone {

    @TypeConverter
    public String paraString(TipoTelefone tipo){
        return tipo.name();
    }

    @TypeConverter
    public TipoTelefone paraTipoTelefone(String valor){
        if(valor != null) return TipoTelefone.valueOf(valor);
        return TipoTelefone.FIXO;
    }
}
