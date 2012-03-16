// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// as published by the Free Software Foundation; either version 2
// of the License, or (at your option) any later version.

// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.

// Copyright (c) 2012, Christoph Schmidt-Hieber

package csh.cryptonite;

import java.util.HashMap;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.exception.DropboxServerException;

import android.app.Application;
import android.util.Log;

public class CryptoniteApp extends Application {

    private DropboxAPI<AndroidAuthSession> mApi;
    private HashMap<String, Entry> dbHashMap;
    
    public CryptoniteApp() {
        super();
        mApi = null;
        dbHashMap = new HashMap<String, Entry>();
    }
    
    public DropboxAPI<AndroidAuthSession> getDBApi() {
        return mApi;
    }
    
    public void setDBApi(DropboxAPI<AndroidAuthSession> api) {
        mApi = api;
    }
    
    public Entry getDBEntry(String dbPath) throws DropboxException {
        if (mApi == null) {
            /* This shouldn't happen really */
            throw new DropboxException("mApi == null: " + getString(R.string.dropbox_null));
        }
        if (dbPath == null) {
            throw new DropboxException("dbPath == null: " + getString(R.string.dropbox_null));
        }
        
        String hash = null;
        
        if (dbHashMap.containsKey(dbPath)) {
            Log.d(Cryptonite.TAG, "Found hash for " + dbPath);
            hash = dbHashMap.get(dbPath).hash;
        }
        try {
            Entry dbEntry = mApi.metadata(dbPath, 0, hash, true, null);
            if (hash == null) {
                dbHashMap.put(dbPath, dbEntry);
            }
            return dbEntry;
        } catch (DropboxServerException e) {
            if (e.error == DropboxServerException._304_NOT_MODIFIED) {
                return dbHashMap.get(dbPath);
            } else {
                throw e;
            }
        }
    }
    
    public void clearDBHashMap() {
        dbHashMap.clear();
    }
    
    public boolean dbFileExists(String dbPath) throws DropboxException {
        Entry dbEntry;
        try {
            /* We need a new metadata call here without hash
             * to make sure we get 404 if the file
             * doesn't exist rather than 304 if we've
             * asked before
             */
            dbEntry = mApi.metadata(dbPath, 0, null, true, null);
            if (dbEntry.isDeleted) {
                return false;
            }
        } catch (DropboxServerException e) {
            if (e.error == DropboxServerException._404_NOT_FOUND) {
                return false;
            }
        } catch (DropboxException e) {
            throw e;
        }
        return true;
    }

}
