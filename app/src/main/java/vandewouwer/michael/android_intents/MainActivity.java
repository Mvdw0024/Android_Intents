package vandewouwer.michael.android_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etname;
    private EditText etPhone;
    private EditText etHomePage;
    private EditText etAdress;

    public void navToSec(View v) {
        Intent navIntent = new Intent(this, DetailActivity.class);
        navIntent.putExtra("key_name", etname.getText().toString());
        navIntent.putExtra("key_phone", etPhone.getText().toString());
        navIntent.putExtra("key_homepage", etHomePage.getText().toString());
        navIntent.putExtra("key_adress", etAdress.getText().toString());
        startActivity(navIntent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        etHomePage = findViewById(R.id.et_homepage);
        etAdress = findViewById(R.id.et_adress);


    }
}
