package sg.edu.rp.c346.id20046797.demosimplesave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

//        String msg = "No Greeting! (onResume)";
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String msgSP = prefs.getString("greetings", "Nothing was found.");
        Toast.makeText(this, msgSP, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Init the SharedPreference to Save Data
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        // Enter Edit Mode.
        SharedPreferences.Editor prefEdit = prefs.edit();

        // Putting data inside the SharedPreference called prefEdit
        prefEdit.putString("greetings", "Hello!");
        prefEdit.commit();

    }
}