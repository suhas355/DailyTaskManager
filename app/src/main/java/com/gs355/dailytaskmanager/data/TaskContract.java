package com.gs355.dailytaskmanager.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by suhas on 30-05-2015.
 */
public class TaskContract {
    // device.
    public static final String CONTENT_AUTHORITY = "com.example.android.sunshine.app";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

     public static final String PATH_TaskManager= "taskManager";

    public static final class TaskEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_TaskManager).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TaskManager;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TaskManager;

        public static final String TABLE_NAME = "taskdata";

        public static final String COLUMN_PRIORITY = "priority";

        public static final String COLUMN_TASK_DETAILS = "details";

        public static final String COLUMN_DATE_TIME = "datetime";


        public static Uri buildLocationUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

    }
}
