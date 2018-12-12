package lucas.aula.br.a05controleabastecimento;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ListaPostosDAO{
    private static ArrayList<Abastecimento> CACHE = new ArrayList<Abastecimento>();
    public static final String nomeArquivo = "abastecimentos1.txt";

    public static boolean salvar(Context context, Abastecimento objeto){
        DbHelper meuBd = new DbHelper(context);
        SQLiteDatabase db = meuBd.getWritableDatabase();
        ContentValues chaveValor = new ContentValues();

        chaveValor.put("kilometros", objeto.getKilometros());
        chaveValor.put("litros", objeto.getLitros());
        chaveValor.put("data", objeto.getData());
        chaveValor.put("posto", objeto.getPosto());
        long id = db.insert("abastecimento", null, chaveValor);
        objeto.setId(id);

        CACHE.add(objeto);
        return true;
    }

//    public static boolean salvarEdicao(Context context, Abastecimento objeto){
//        DbHelper meuBd = new DbHelper(context);
//        SQLiteDatabase db = meuBd.getWritableDatabase();
//        ContentValues chaveValor = new ContentValues();
//        chaveValor.put("kilometros", objeto.getKilometros());
//        chaveValor.put("litros", objeto.getLitros());
//        chaveValor.put("data", objeto.getData());
//        chaveValor.put("posto", objeto.getPosto());
//        String[] whereId = { String.valueOf( objeto.getId() ) };
//        db.update("abastecimento", chaveValor, "id = ?", whereId);
//        db.close();
//        getLista(context);
//        return true;
//    }

//    public static boolean salvar(Context c, Abastecimento objeto){
//        if(objeto.getId() == -1){
//            //eh um abastecimento novo.... então salvaNovo
//            Toast.makeText(c, "Abastecimento salvo", Toast.LENGTH_SHORT).show();
//            return salvarNovo(c, objeto);
//        }else{
//            //eh um abastecimento velho, então edita...
//            Toast.makeText(c, "Abastecimento editado", Toast.LENGTH_SHORT).show();
//            return salvarEdicao(c, objeto);
//        }
//    }

//    public static boolean excluir(Context context, Abastecimento objeto){
//        DbHelper meuBd = new DbHelper(context);
//        SQLiteDatabase db = meuBd.getWritableDatabase();
//        String[] whereId = { String.valueOf(objeto.getId()) };
//        db.delete("abastecimento", "id = ?", whereId);
//        getLista(context);
//        return true;
//    }

    public static ArrayList<Abastecimento> getLista(Context context) {
        CACHE = new ArrayList<>();

        DbHelper meuBd = new DbHelper(context);
        SQLiteDatabase db = meuBd.getReadableDatabase();

        String SQLBuscarAbastecimentos = "SELECT kilometros, litros, data, posto, id FROM abastecimento";
        Cursor ponteiro = db.rawQuery(SQLBuscarAbastecimentos, null);

        while(ponteiro.moveToNext()){
            Abastecimento daVez = new Abastecimento();
            daVez.setKilometros(ponteiro.getDouble(0));
            daVez.setLitros(ponteiro.getDouble(1));
            daVez.setData(ponteiro.getString(2));
            daVez.setPosto(ponteiro.getString(3));
            daVez.setId(ponteiro.getLong(4));
            CACHE.add(daVez);
        }
        return CACHE;
    }
}