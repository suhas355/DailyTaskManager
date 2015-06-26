package com.gs355.dailytaskmanager.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.gs355.dailytaskmanager.data.TaskContract.TaskEntry;

/**
 * Created by suhas on 30-05-2015.
 */
public class TaskDbHelper  extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "taskmanager.db";


    public TaskDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

           final String SQL_CREATE_TASK_TABLE = "CREATE TABLE " + TaskEntry.TABLE_NAME + " (" +
                   TaskEntry._ID +  " INTEGER PRIMARY KEY ," +

                   TaskEntry.COLUMN_PRIORITY +  " INTEGER PRIMARY KEY ," +

                   TaskEntry.COLUMN_TASK_DETAILS +  " TEXT UNIQUE NOT NULL, " +

                   TaskEntry.COLUMN_DATE_TIME +  " INTEGER NOT NULL, " +

                   ") ON CONFLICT REPLACE);";

        sqLiteDatabase.execSQL(SQL_CREATE_TASK_TABLE);

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TaskEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
        }

}
