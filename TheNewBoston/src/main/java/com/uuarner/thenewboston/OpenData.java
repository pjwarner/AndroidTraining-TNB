package com.uuarner.thenewboston;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by pwarner on 10/13/13.
 */
public class OpenData extends Activity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    TextView question, test;
    Button returnData;
    RadioGroup selectionList;
    String gotBread, sendData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        init();

        Bundle gotBasket = getIntent().getExtras();
        gotBread = gotBasket.getString("key");
        question.setText(gotBread);
    }

    private void init() {
        question = (TextView)findViewById(R.id.tvQuestion);
        test = (TextView)findViewById(R.id.tvText);
        returnData = (Button)findViewById(R.id.bReturn);
        returnData.setOnClickListener(this);
        selectionList = (RadioGroup)findViewById(R.id.rgAnswers);
        selectionList.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent person = new Intent();
        Bundle backpack = new Bundle();
        backpack.putString("answer", sendData);
        person.putExtras(backpack);
        setResult(RESULT_OK, person);
        finish();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch(checkedId){
            case R.id.rCrazy:
                sendData = "Probably Right!";
                break;
            case R.id.rSexy:
                sendData = "Definitely Right!";
                break;

            case R.id.rBoth:
                sendData = "Spot On!";
                break;
        }

        test.setText(sendData);
    }
}
