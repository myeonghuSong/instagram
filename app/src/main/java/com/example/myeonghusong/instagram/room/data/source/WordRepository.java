package com.example.myeonghusong.instagram.room.data.source;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.myeonghusong.instagram.room.data.Word;
import com.example.myeonghusong.instagram.room.data.source.local.WordDao;
import com.example.myeonghusong.instagram.room.data.source.local.WordRoomDatabase;

import java.util.List;

/**
 * Created by myeonghusong on 2018. 11. 11..
 */

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application)
    {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);

        mWordDao = db.wordDao();

        mAllWords = mWordDao.getAllWords();

    }

    public LiveData<List<Word>> getAllWords()
    {
        return mAllWords;
    }

    public void insert(Word word)
    {
        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void>
    {
        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao)
        {
            mAsyncTaskDao=dao;
        }

        @Override
        protected Void doInBackground(final Word... words)
        {
            mAsyncTaskDao.insert(words[0]);
            return null;
        }
    }
}
