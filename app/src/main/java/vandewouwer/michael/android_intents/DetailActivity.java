package vandewouwer.michael.android_intents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView tvName;
    private Button callBtn;

    private View.OnClickListener callListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startCall();
        }
    };

    private void startCall() {
        Bundle recData = getIntent().getExtras();
        String phone = recData.getString("key_phone", "+32475100000");
        Uri callUri = Uri.parse("tel:" + phone);
        Intent callIntent = new Intent(Intent.ACTION_CALL, callUri);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                askPermission();
                return;
            }
        }
        startActivity(callIntent);
    }

    private void askPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvName = findViewById(R.id.tv_name);
        callBtn = findViewById(R.id.btn_call);
        Bundle recData = getIntent().getExtras();
        String name = recData.getString("key_name", "blanco");
        tvName.setText(name);
        callBtn.setOnClickListener(callListener);


    }

    public void openSite(View v) {
        Bundle recData = getIntent().getExtras();
        String homepage = recData.getString("key_homepage", "www.google.com");
        Uri webUri = Uri.parse("http://" + homepage);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webUri);
        startActivity(webIntent);
    }

    public void openLocation(View v) {
        Bundle recData = getIntent().getExtras();
        String intadress = recData.getString("key_adress", "Nijverheidskaai 170,1070 Anderlecht");
        String adress = "geo:0,0?q="+Uri.encode(intadress);
        Uri webUri = Uri.parse(adress);
        Intent adressIntent = new Intent(Intent.ACTION_VIEW, webUri);
        startActivity(adressIntent);
    }


}

