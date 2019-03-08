package com.me.celcius_to_farenheit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        initControls();
    }

    private void initControls() {
        final EditText text = findViewById(R.id.main_activity_text_edit);
        final Button submit = findViewById(R.id.main_activity_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getResources().getString(R.string.main_activity_unsecure_password).equals(text.getText().toString())) {

                } else {
                    text.setError(getResources().getString(R.string.main_activity_password_invalid));
                }
            }
        });
    }
}
