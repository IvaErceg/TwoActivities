package com.example.android.twoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String MESSAGE_STRING = "message";
    public static final int TEXT_REQUEST = 1;

    private EditText mEditText;
    private TextView mHeader;
    private TextView mReplyMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.et_message);
        mHeader = (TextView) findViewById(R.id.text_header_reply);
        mReplyMessage = (TextView) findViewById(R.id.text_message_reply);
    }

    public void launchSecondActivity(View view) {
        Intent i = new Intent(this, SecondActivity.class);
        String message = mEditText.getText().toString();
        i.putExtra(MESSAGE_STRING, message);
        startActivityForResult(i, TEXT_REQUEST);
        mEditText.setText("");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST && resultCode == RESULT_OK) {
            mHeader.setVisibility(View.VISIBLE);
            String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
            mReplyMessage.setText(reply);
            mReplyMessage.setVisibility(View.VISIBLE);
        }
    }
}
