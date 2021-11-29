package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
    Si tu copie ce fichier, tu devra surement créer un nouveau projet et seulement copier le contenu des classes.
    Tu pourra ensuite entrer tous les packages nécessaires au développement avec le raccourci "Alt + entrée" pour les intégrer 1 par 1
*/

public class Manager extends SQLiteOpenHelper {

    private static final String name = "Shop.db";
    private static final int version = 1;

    public Manager(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL = "CREATE TABLE T_Electronics (id_product integer PRIMARY KEY autoincrement, name_product TEXT not null, price_product FLOAT not null, stock_product integer not null)";
        sqLiteDatabase.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //this.delete_Table();
        String SQL = "CREATE TABLE T_Jardin (id_product integer PRIMARY KEY autoincrement, name_product TEXT not null, price_product FLOAT not null, stock_product integer not null)";
        sqLiteDatabase.execSQL(SQL);
    }

    public void insert_Data(){
        String SQL = "INSERT INTO T_Electronics ( name_product, price_product, stock_product) " +
                "VALUES ('Arduino UNO', 19.99, 7) ";
        this.getWritableDatabase().execSQL(SQL);
    }

    public String read_Data(){
        String SQL = "SELECT * FROM T_Electronics WHERE name_product = 'Arduino UNO'";
        Cursor cursor = this.getReadableDatabase().rawQuery(SQL, null);
        cursor.moveToFirst();

        if(cursor != null && cursor.getCount() > 0){
            String str = cursor.getString(1); // nom du produit
            String str2 = Float.toString(cursor.getFloat(2)); // le prix du produit
            String str3 = Integer.toString(cursor.getInt(3)); // stock du produit

            return "Le produit : " + str + " est au prix de : " + str2 + " et il en reste " + str3 + " en stock";
        }
        else {
            return "Il n'y a rien dans ce rayon";
        }
    }

    public void update_Data(){
        //  Il me reste 3 Arduino UNO et leur prix a augmenté il est donc de 25€
        String SQL = "UPDATE T_Electronics SET price_product = 25, stock_product = 3 WHERE name_product = 'Arduino UNO'";
        this.getWritableDatabase().execSQL(SQL);
    }

    public void delete_Data(){
        // je veux supprimer toutes les données de ma table T_Electronics
        String SQL = "DELETE FROM T_Electronics";
        this.getWritableDatabase().execSQL(SQL);
    }

    // Je vends du matériel de jardinnage
    public void delete_Table(){
        String SQL = "DROP TABLE T_Electronics";
        this.getWritableDatabase().execSQL(SQL);
    }
}
