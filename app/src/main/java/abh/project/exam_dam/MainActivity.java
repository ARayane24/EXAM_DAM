package abh.project.exam_dam;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v->{
            PopupMenu popupMenu = new PopupMenu(this,v);
            popupMenu.inflate(R.menu.my_menu);
            popupMenu.getMenu().findItem(R.id.go).setOnMenuItemClickListener(this::onMenuItemClickListener);
            popupMenu.show();
        });


        Button Contextbutton = findViewById(R.id.Contextbutton);
        registerForContextMenu(Contextbutton);
    }
    private boolean onMenuItemClickListener(MenuItem menuItem) {
        menuItem.getItemId();
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
        return true;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.my_menu,menu);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        onMenuItemClickListener(item);
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onMenuItemClickListener(item);
        return true;
    }
}