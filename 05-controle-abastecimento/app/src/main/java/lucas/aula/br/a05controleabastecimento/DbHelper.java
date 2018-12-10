package lucas.aula.br.a05controleabastecimento;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final int VERSAO_BD = 1;

    public DbHelper(Context context) {
        super(context, "meu_banco", null, DbHelper.VERSAO_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQLCriacaoTabelas = "CREATE TABLE abastecimento (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "KILOMETROS TEXT," +
                "LITROS TEXT," +
                "POSTO TEXT," +
                "DATA TEXT" +
                ");";
        sqLiteDatabase.execSQL(SQLCriacaoTabelas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE abastecimento");
        this.onCreate(sqLiteDatabase);
    }
}