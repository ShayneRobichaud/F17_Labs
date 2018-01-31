package com.example.diamond.androidlabs;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatWindow extends Activity {

    ListView lv;
    EditText editText;
    Button button2;
    ArrayList<String> al;
    ChatAdapter messageAdapter;
    //ChatDatabaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //helper = new ChatDatabaseHelper(this);
        //helper.setDB(helper.getReadableDatabase());
        //String sql = "SELECT * FROM " + ChatDatabaseHelper.DATABASE_NAME;
        //Cursor cursor = helper.db.rawQuery(sql, null);
        setContentView(R.layout.activity_chat_window);
        messageAdapter = new ChatAdapter(this);
        lv = findViewById(R.id.lv);
        editText = findViewById(R.id.editText);
        button2 = findViewById(R.id.button2);
        al = new ArrayList<>();
        String message;
        //if(cursor.moveToFirst()) {
         //   for(int i = 0; i < cursor.getCount(); i++){
           //     message = cursor.getString(i);
             //   al.add(message);
         //   }
        //}
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                al.add(editText.getText().toString());
                //ContentValues val = new ContentValues();
                //val.put("KEY_ID", editText.getText().toString());
                //helper.db.insert("messages", null, val);
                messageAdapter.notifyDataSetChanged();
                editText.setText("");
            }
        });
        lv.setAdapter(messageAdapter);

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        //helper.db.close();
    }
    private class ChatAdapter extends ArrayAdapter<String>{
        public ChatAdapter(Context cntx){
            super(cntx, 0);
        }
        public int getCount(){
            return al.size();
        }
        public String getItem(int position){
            return al.get(position);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();
            View result = null;
            if(position % 2 == 0){
                result = inflater.inflate(R.layout.chat_row_incoming, null);
            } else {
                result = inflater.inflate(R.layout.chat_row_outgoing,null);
            }
            TextView message = result.findViewById(R.id.message_text);
            message.setText(getItem(position));
            return result;
        }


    }
}
