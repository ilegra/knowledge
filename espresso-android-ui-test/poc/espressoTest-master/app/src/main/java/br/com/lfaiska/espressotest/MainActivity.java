package br.com.lfaiska.espressotest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.inputField);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.switchActivity:
                String text = editText.getText().toString();
                if (!text.isEmpty()) {
                    Intent intent = new Intent(this, SecondActivity.class);
                    intent.putExtra("input", editText.getText().toString());
                    startActivity(intent);
                    break;
                } else {
                    editText.setError("Por favor digite um texto válido.");
                }

        }
    }
}
