package com.example.testpproject.room;

import android.database.Cursor;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.testpproject.MyApplication;

@Database(entities = {Student.class, User.class}, version = 2, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    public abstract StudentDao studentDao();

    private static class Holder {

        private static final AppDataBase appDataBase = Room.databaseBuilder(MyApplication.getInstance(), AppDataBase.class, "hanqi.db")
                .addMigrations(migration)
                .build();

    }

    public static AppDataBase getInstance() {

        return Holder.appDataBase;
    }

    public void closeDb() {

        Log.e("=====", getInstance().isOpen() + "");

        if (getInstance().isOpen()) {

            getInstance().close();
        }
    }


    private static Migration migration = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

            Log.e("====", "执行升级");
            if (!checkColumnExists(database, "Student", "weight")) {
                Log.e("===", "执行sql语句");
                database.execSQL("create table User (id Integer primary key autoincrement NOT NULL DEFAULT 0,name text,age Integer NOT NULL DEFAULT 0)");

                database.execSQL("alter table Student add column weight Float NOT NULL DEFAULT 66");

            }
        }
    };


    private static boolean checkColumnExists(SupportSQLiteDatabase db, String tableName, String columnName) {
        boolean result = false;
        Cursor cursor = null;
        try {
            cursor = db.query("select * from sqlite_master where name = ? and sql like ?"
                    , new String[]{tableName, "%" + columnName + "%"});
            result = null != cursor && cursor.moveToFirst();
        } catch (Exception e) {
        } finally {
            if (null != cursor && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return result;
    }

}
