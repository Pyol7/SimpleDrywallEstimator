package com.jeffreyromero.simpledrywallestimator.Database;

import android.provider.BaseColumns;

public interface AppDatabaseTableSchema extends BaseColumns {

    //Ceilings Table -----------------------------------------
    String CREATE_CEILINGS_TABLE =
            "CREATE TABLE IF NOT EXISTS Ceilings (" +
                    "_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "CeilingName TEXT, " +
                    "CeilingArea TEXT" +
                    ")";

    String DROP_CEILINGS_TABLE =
            "DROP TABLE IF EXISTS Ceilings";

    //Boards Table -------------------------------------------
    String CREATE_BOARDS_TABLE =
            "CREATE TABLE IF NOT EXISTS Boards (" +
                    "_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "BoardDescription TEXT, " +
                    "BoardQuantity REAL, " +
                    "CeilingID INTEGER, " +
                    "FOREIGN KEY(CeilingID) REFERENCES Ceilings(_ID) " +
                    "ON DELETE CASCADE" +
                    ")";

    String DROP_BOARDS_TABLE =
            "DROP TABLE IF EXISTS Boards";

    //Furrings Table -------------------------------------------
    String CREATE_FURRINGS_TABLE =
            "CREATE TABLE IF NOT EXISTS Furrings (" +
                    "_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "FurringDescription TEXT, " +
                    "FurringQuantity REAL, " +
                    "CeilingID INTEGER, " +
                    "FOREIGN KEY(CeilingID) REFERENCES Ceilings(_ID) " +
                    "ON DELETE CASCADE" +
                    ")";

    String DROP_FURRINGS_TABLE =
            "DROP TABLE IF EXISTS Furrings";

    //CChannels Table -------------------------------------------
    String CREATE_CCHANNELS_TABLE =
            "CREATE TABLE IF NOT EXISTS CChannels (" +
                    "_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "CChannelDescription TEXT, " +
                    "CChannelQuantity REAL, " +
                    "CeilingID INTEGER, " +
                    "FOREIGN KEY(CeilingID) REFERENCES Ceilings(_ID) " +
                    "ON DELETE CASCADE" +
                    ")";

    String DROP_CCHANNELS_TABLE =
            "DROP TABLE IF EXISTS CChannels";
}
