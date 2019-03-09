package com.me.celcius_to_farenheit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ActivityConverter extends Activity {

    private TextView resultView;
    private EditText text;
    private Boolean isCelsius = true;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_converter);

        initControls();
    }

    private void initControls() {
        final Button submit = findViewById(R.id.converter_activity_submit);
        final RadioGroup radioGroup = findViewById(R.id.converter_radiogroup);
        text = findViewById(R.id.converter_activity_text_edit);
        resultView = findViewById(R.id.converter_activity_results);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                isCelsius = group.getCheckedRadioButtonId() == R.id.converter_set_celsius;
                //if ()
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                renderResult();
            }
        });
    }

    private void renderResult() {
        String textValue = text.getText().toString();

        if (textValue == "" || textValue.isEmpty()) {
            // No value, nothing to calculate
            resultView.setText("");
            return;
        }

        Double value = Double.valueOf(textValue);
        String result = "";

        if (isCelsius) {
           // result = String.valueOf(value )
        } else {

        }
        resultView.setText(result);
    }
}
