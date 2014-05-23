package com.example.apes;


import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB {
	
	public static final String KEY_MONEY = "money";
	public static final String KEY_ID ="id";
	private static final String DATABASE_NAME = "apesDB";
	private static final String TABLE_APES = "apesTable";
	private static final int DATABASE_VERSION = 1;
	
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	
	private static class DbHelper extends SQLiteOpenHelper
	{

		public DbHelper(Context context)
		{
			super(context,DATABASE_NAME, null, DATABASE_VERSION);
			
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + TABLE_APES + " (" +
					KEY_ID + " INTEGER, " +
					KEY_MONEY + " INTEGER);"
				
					);
			db.execSQL("insert into " + TABLE_APES + "("+KEY_ID +", "+KEY_MONEY+") values(1,0)"); 
			db.execSQL("insert into " + TABLE_APES + "("+KEY_ID +", "+KEY_MONEY+") values(2,0)"); 
			db.execSQL("insert into " + TABLE_APES + "("+KEY_ID +", "+KEY_MONEY+") values(3,0)"); 
			db.execSQL("insert into " + TABLE_APES + "("+KEY_ID +", "+KEY_MONEY+") values(4,0)"); 
			
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_APES);
			
			onCreate(db);
			
		}
		
	}
	
	public DB (Context c)
	{
		ourContext = c;
	}
	public DB open() throws SQLException
	{
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	
	public void close()
	{
		ourHelper.close();
	}
	
	public void insertValues(int arun, int enayat, int pranav, int saurav)
	{
		String sql="";
		sql = "UPDATE " + TABLE_APES + " SET " + KEY_MONEY + " = " + arun + " WHERE " + KEY_ID+ "=1;";
		ourDatabase.execSQL(sql);
		sql = "UPDATE " + TABLE_APES + " SET " + KEY_MONEY + " = " + enayat + " WHERE " + KEY_ID+ "=2;";
		ourDatabase.execSQL(sql);
		sql = "UPDATE " + TABLE_APES + " SET " + KEY_MONEY + " = " + pranav + " WHERE " + KEY_ID+ "=3;";
		ourDatabase.execSQL(sql);
		sql = "UPDATE " + TABLE_APES + " SET " + KEY_MONEY + " = " + saurav + " WHERE " + KEY_ID+ "=4;";
		ourDatabase.execSQL(sql);
		
	}
	
	public int getValue(int id)
	{
		String[] columns = new String[]{KEY_ID, KEY_MONEY};
		Cursor c = ourDatabase.query(TABLE_APES, columns, KEY_ID + "="+Integer.toString(id), null, null, null, null);
		
		int iMoney = c.getColumnIndex(KEY_MONEY);
		int retVal=0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
		{	
			
			retVal = c.getInt(iMoney);
		}
		
		return retVal;
		
		
		
	}

}
