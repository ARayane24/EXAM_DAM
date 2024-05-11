package abh.project.exam_dam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import kotlin.jvm.internal.Intrinsics;

public class MainActivity2 extends AppCompatActivity {

    Button go , cancel;
    RadioButton tel;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        go = findViewById(R.id.go);
        cancel = findViewById(R.id.cancel_button);
        tel = findViewById(R.id.tel);
        editText = findViewById(R.id.num);

        cancel.setOnClickListener(v->finish());
        go.setOnClickListener(v->{
            Intent i = null;

            if (tel.isChecked())
                i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+editText.getText().toString()));
            else{
                i = new Intent(v.getContext(),MainActivity3.class);
                i.putExtra("num",editText.getText().toString());
            }

            startActivity(i);
        });
    }
}