package com.jeffreyromero.simpledrywallestimator.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class AppDatabaseHelper extends SQLiteOpenHelper implements AppDatabaseTableSchema {
    private final String LOG_TAG = "AppDatabaseHelper";

    private static final String DB_NAME = "CEILINGS";
    private static final int DB_VERSION = 1;
    private static AppDatabaseHelper dbInstance;

    private AppDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static synchronized AppDatabaseHelper getInstance(Context context) {
        if (dbInstance == null) {
            dbInstance = new AppDatabaseHelper(context.getApplicationContext());
        }
        return dbInstance;
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_CEILINGS_TABLE);
            db.execSQL(CREATE_BOARDS_TABLE);
            db.execSQL(CREATE_FURRINGS_TABLE);
            db.execSQL(CREATE_CCHANNELS_TABLE);
            Log.d(LOG_TAG, "Tables created successfully");
        } catch (SQLException e) {
            Log.d(LOG_TAG, "Error creating tables " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            try {
                db.execSQL(DROP_CEILINGS_TABLE);
                db.execSQL(DROP_BOARDS_TABLE);
                db.execSQL(DROP_FURRINGS_TABLE);
                db.execSQL(DROP_CCHANNELS_TABLE);
                onCreate(db);
                Log.d(LOG_TAG, "Tables upgraded successfully");
            } catch (SQLException e) {
                Log.d(LOG_TAG, "Error upgrading tables " + e.getMessage());
            }
        }
    }

//    public void store(Ceiling ceiling) {
//        //Put the database in write mode
//        SQLiteDatabase db = getWritableDatabase();
//
//        // Insert data into ceiling table
//        ContentValues CeilingsValues = new ContentValues();
//        CeilingsValues.put("CeilingName", ceiling.getCeilingName());
//        CeilingsValues.put("CeilingArea", ceiling.getCeilingArea());
//        long newCeilingRowId = 0;
//        newCeilingRowId = db.insert("Ceilings", null, CeilingsValues);
//
//        //Insert data into Boards table
//        ContentValues BoardsValues = new ContentValues();
//        BoardsValues.put("CeilingID", newCeilingRowId);
//        BoardsValues.put("BoardDescription", ceiling.getBoardDescription());
//        BoardsValues.put("BoardQuantity", ceiling.getBoards());
//        db.insert("Boards", null, BoardsValues);
//
//        //Insert data into Furrings table
//        ContentValues FurringsValues = new ContentValues();
//        FurringsValues.put("CeilingID", newCeilingRowId);
//        FurringsValues.put("FurringDescription", ceiling.getFurringChannelDescription());
//        FurringsValues.put("FurringQuantity", ceiling.getFurringChannels());
//        db.insert("Furrings", null, FurringsValues);
//
//        //Insert data into CChannels table
//        ContentValues CChannelsValues = new ContentValues();
//        CChannelsValues.put("CeilingID", newCeilingRowId);
//        CChannelsValues.put("CChannelDescription", ceiling.getCChannelDescription());
//        CChannelsValues.put("CChannelQuantity", ceiling.getCChannels());
//        db.insert("CChannels", null, CChannelsValues);
//    }
//
//    public ArrayList<Ceiling> getAllCeilings() {
//        ArrayList<Ceiling> list = new ArrayList<>();
//        SQLiteDatabase db = this.getReadableDatabase();
//        String query =
//                "SELECT " +
//                        "CeilingName, CeilingArea," +
//                        "BoardDescription, BoardQuantity," +
//                        "FurringDescription, FurringQuantity," +
//                        "CChannelDescription, CChannelQuantity " +
//                        "FROM Ceilings " +
//                        "INNER JOIN Boards ON Boards.CeilingID = Ceilings._ID " +
//                        "INNER JOIN Furrings ON Furrings.CeilingID = Ceilings._ID " +
//                        "INNER JOIN CChannels ON CChannels.CeilingID = Ceilings._ID";
//
//        Cursor cursor = db.rawQuery(query, null);
//
//        while (cursor.moveToNext()) {
//            String CeilingName = cursor.getString(cursor.getColumnIndexOrThrow("CeilingName"));
//            String CeilingArea = cursor.getString(cursor.getColumnIndexOrThrow("CeilingArea"));
//            String BoardDescription = cursor.getString(cursor.getColumnIndexOrThrow("BoardDescription"));
//            String BoardQuantity = cursor.getString(cursor.getColumnIndexOrThrow("BoardQuantity"));
//            String FurringDescription = cursor.getString(cursor.getColumnIndexOrThrow("FurringDescription"));
//            String FurringQuantity = cursor.getString(cursor.getColumnIndexOrThrow("FurringQuantity"));
//            String CChannelDescription = cursor.getString(cursor.getColumnIndexOrThrow("CChannelDescription"));
//            String CChannelQuantity = cursor.getString(cursor.getColumnIndexOrThrow("CChannelQuantity"));
//
//            Ceiling ceiling = new Ceiling(new CeilingMaterialListBuilder());
//            ceiling.setCeilingName(CeilingName);
//            ceiling.setCeilingArea(CeilingArea);
//            ceiling.setBoardDescription(BoardDescription);
//            ceiling.setBoards(BoardQuantity);
//            ceiling.setFurringChannelDescription(FurringDescription);
//            ceiling.setFurringChannels(FurringQuantity);
//            ceiling.setCChannelDescription(CChannelDescription);
//            ceiling.setCChannels(CChannelQuantity);
//            list.add(ceiling);
//        }
//        cursor.close();
//        return list;
//    }
//
//    public void delete(int id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        db.delete("ceiling", "_ID = ?", new String[]{String.valueOf(id)});
//
//        db.close();
//    }
}