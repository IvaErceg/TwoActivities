package com.example.android.twoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";
    private TextView mTextView;
    private EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mTextView = (TextView) findViewById(R.id.tw_message);
        mEditText = (EditText) findViewById(R.id.et_message_second);

        Intent i = getIntent();
        if(i.hasExtra(MainActivity.MESSAGE_STRING)){
            mTextView.setText(i.getStringExtra(MainActivity.MESSAGE_STRING));
        }
    }

    public void returnReply(View view) {
        Intent i = new Intent(this, MainActivity.class);
        String replyMessage = mEditText.getText().toString();
        i.putExtra(EXTRA_REPLY, replyMessage);
        setResult(RESULT_OK, i);
        finish();
    }
}
