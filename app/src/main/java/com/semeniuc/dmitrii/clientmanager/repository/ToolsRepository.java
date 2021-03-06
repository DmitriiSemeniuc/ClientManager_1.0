package com.semeniuc.dmitrii.clientmanager.repository;

import android.util.Log;

import com.semeniuc.dmitrii.clientmanager.MyApplication;
import com.semeniuc.dmitrii.clientmanager.db.DatabaseHelper;
import com.semeniuc.dmitrii.clientmanager.db.DatabaseManager;
import com.semeniuc.dmitrii.clientmanager.model.Tools;
import com.semeniuc.dmitrii.clientmanager.utils.Constants;

import java.util.List;

public final class ToolsRepository implements Repository {

    public static final String LOG_TAG = ToolsRepository.class.getSimpleName();
    public static final boolean DEBUG = Constants.DEBUG;
    private static final ToolsRepository instance = new ToolsRepository();
    private static DatabaseHelper helper;

    static {
        DatabaseManager.init(MyApplication.getInstance().getApplicationContext());
        helper = DatabaseManager.getInstance().getHelper();
    }

    private ToolsRepository() {
    }

    public static ToolsRepository getInstance() {
        return instance;
    }

    @Override
    public int create(Object item) {
        int index = -1;
        Tools tools = (Tools) item;
        try {
            index = helper.getToolsDao().create(tools);
            if (DEBUG) Log.i(LOG_TAG, "created: " + index);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return index;
    }

    @Override
    public int update(Object item) {
        int index = -1;
        Tools tools = (Tools) item;
        try {
            index = helper.getToolsDao().update(tools);
            if (DEBUG) Log.i(LOG_TAG, "updated: " + index);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return index;
    }

    @Override
    public int delete(Object item) {
        int index = -1;
        Tools tools = (Tools) item;
        try {
            index = helper.getToolsDao().delete(tools);
            if (DEBUG) Log.i(LOG_TAG, "deleted: " + index);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return index;
    }

    @Override
    public Object findById(int id) {
        Tools tools = null;
        try {
            tools = helper.getToolsDao().queryForId(id);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return tools;
    }

    @Override
    public List<?> findAll() {
        List<Tools> items = null;
        try {
            items = helper.getToolsDao().queryForAll();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}

