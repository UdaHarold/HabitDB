package com.example.zhangfan.habittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.zhangfan.habittracker.data.HabitContract.HabitEntry;


/**
 * Created by zhangfan on 2017/9/3.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "habit.db";

    private static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // create table
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_HABIT_TABLE =

                " CREATE TABLE " + HabitEntry.TABLE_NAME + " (" +

                        HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                        HabitEntry.COLUMN_ACTION + " TEXT NOT NULL, " +

                        HabitEntry.COLUMN_DESCRIPTION + " TEXT, " +

                        HabitEntry.COLUMN_INTERVAL + " INTEGER) ";

        sqLiteDatabase.execSQL(SQL_CREATE_HABIT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + HabitEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    // insert habit
    public long insertHabit() {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_ACTION, "running");
        values.put(HabitEntry.COLUMN_DESCRIPTION, "running everyday");
        values.put(HabitEntry.COLUMN_INTERVAL, 1);

        long rowID = db.insert(HabitEntry.TABLE_NAME, null, values);
        return rowID;
    }

    // query all habits, show all projections
    public Cursor queryAllHabits() {
        String selectQuery = "SELECT * FROM " + HabitEntry.TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(selectQuery, null);

    }

    public int updateHabitById() {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_ACTION, "reading");
        values.put(HabitEntry.COLUMN_DESCRIPTION, "running everyday");
        values.put(HabitEntry.COLUMN_INTERVAL, 2);

        String where = HabitEntry._ID + " = ? ";
        return db.update(HabitEntry.TABLE_NAME, values, where, new String[]{"1"});
    }

}
