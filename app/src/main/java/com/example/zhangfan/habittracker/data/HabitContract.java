package com.example.zhangfan.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by Harold on 2017/9/3.
 */

public class HabitContract {

    public static final class HabitEntry implements BaseColumns {

        public static final String TABLE_NAME = "habit";

        public static final String COLUMN_ACTION = "action";

        public static final String COLUMN_DESCRIPTION = "description";

        public static final String COLUMN_INTERVAL = "interval";

    }

}
