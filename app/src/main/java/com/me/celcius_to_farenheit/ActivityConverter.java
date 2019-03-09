package com.me.celcius_to_farenheit;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ActivityConverter extends Activity {

    private TextView resultView;
    private EditText text;
    private Boolean convertToFahrenheit = true;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_converter);

        initControls();
    }

    private void initControls() {
        final RadioGroup radioGroup = findViewById(R.id.converter_radiogroup);
        text = findViewById(R.id.converter_activity_text_edit);
        resultView = findViewById(R.id.converter_activity_results);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                convertToFahrenheit = group.getCheckedRadioButtonId() == R.id.converter_to_fahrenheit;
                renderResult();
            }
        });

        text.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                renderResult();
                return false;
            }
        });
    }

    private void renderResult() {
        String textValue = text.getText().toString();
        Double value;

        if (textValue == "" || textValue.isEmpty()) {
            resultView.setText("");
            return;
        }

        try {
            value = Double.valueOf(textValue);
        } catch (Exception e) {
            resultView.setText(getResources().getString(R.string.conversion_error));
            return;
        }

        String result;

        if (convertToFahrenheit) {
            result = String.format("%s Celsius equals to %.2f Fahrenheit",textValue, value * 9 / 5 + 32);
        } else {
            result = String.format("%s Fahrenheit equals to %.2f Celsius", textValue, (value - 32) * 5 / 9);
        }
        resultView.setText(result);
    }
}
