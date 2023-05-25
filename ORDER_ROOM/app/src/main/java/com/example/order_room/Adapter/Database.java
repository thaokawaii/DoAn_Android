package com.example.order_room.Adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "my_database.db";
        private static final int DATABASE_VERSION = 1;

        public Database(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // Thực hiện các lệnh SQL để tạo bảng
            String CREATE_TABLE_SQL = "CREATE TABLE Products (Id INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Price REAL)";
            db.execSQL(CREATE_TABLE_SQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Thực hiện các lệnh SQL để nâng cấp bảng
            String DROP_TABLE_SQL = "DROP TABLE IF EXISTS Products";
            db.execSQL(DROP_TABLE_SQL);

            onCreate(db);
        }
    }

