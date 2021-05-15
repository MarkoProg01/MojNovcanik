package com.example.mojnovcanik;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SQLHelper extends SQLiteOpenHelper {
    Context context;
    private static final String DATABASE_NAME = "NovcanikBazav1.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "Novcanik";
    public static final String COLUMN_IZNOS = "iznos";
    private static final String COLUMN_OPIS = "opis";
    private static final String COLUMN_DATUM = "datum";

    public SQLHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+ TABLE_NAME +
                " ( " +
                COLUMN_IZNOS + " TEXT, "+
                COLUMN_OPIS + " TEXT, "+
                COLUMN_DATUM + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    void dodajUListu(String iznos,String opis,String datum){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_IZNOS,iznos);
        cv.put(COLUMN_OPIS,opis);
        cv.put(COLUMN_DATUM,datum);

        long result = db.insert(TABLE_NAME,null,cv);

        if(result == -1){
            Toast.makeText(context, "Greška!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Uspešno!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(String query){
       // String query = "SELECT * FROM "+TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;

        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

    void obrisiSvePodatkeIzBaze(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NAME);

    }


}
