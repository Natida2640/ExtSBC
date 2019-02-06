package ni.mind.th.ac.sutheast.extsbc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.contentMainFragment, new QRFragment()).commit();

        }
    }

}
