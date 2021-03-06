package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.module.IDeleteModel;
import com.danielspeixoto.musician.model.pojo.ToDo;
import com.danielspeixoto.musician.presenter.module.IDeletePresenter;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 03/12/16.
 */
public class DeleteToDoModel implements IDeleteModel<ToDo> {

    private final DatabaseHandler mDBHandler;
    private IDeletePresenter mDeletePresenter;

    public DeleteToDoModel(IDeletePresenter mDeletePresenter, Context mContext) {
        this.mDeletePresenter = mDeletePresenter;
        this.mDBHandler = new DatabaseHandler(mContext);
    }

    @Override
    public void delete(long id) {
        SQLiteDatabase db = mDBHandler.getWritableDatabase();
        db.delete(ToDo.TABLE,
                ToDo._ID + " = ?",
                new String[]{Long.toString(id)}
        );
        mDeletePresenter.onDeleted();
    }
}