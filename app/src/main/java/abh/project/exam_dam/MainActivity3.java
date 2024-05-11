package abh.project.exam_dam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    Button go , cancel;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        String num = getIntent().getStringExtra("num");

        go = findViewById(R.id.go);
        cancel = findViewById(R.id.cancel_button);
        editText = findViewById(R.id.sms);

        cancel.setOnClickListener(v->getOnBackPressedDispatcher().onBackPressed());
        go.setOnClickListener(v->{
            Intent i = new Intent(Intent.ACTION_SEND, Uri.parse("sms:"+num));
            i.putExtra("sms_body",editText.getText().toString());
            startActivity(i);
        });

    }
}