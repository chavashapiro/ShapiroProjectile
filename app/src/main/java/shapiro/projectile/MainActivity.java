package shapiro.projectile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text1;
    private EditText edit1;
    private TextView text2;
    private EditText edit2;
    private TextView text3;
    private EditText edit3;
    private Button button1;
    private TextView text4;

    /**@Override
    protected void onResume() {
        super.onResume();
    }**/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        edit3 = (EditText) findViewById(R.id.edit3);
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                double angle, velocity, time, x, y;
                angle = Math.toRadians(Double.parseDouble(edit1.getText().toString()));
                velocity = Double.parseDouble(edit2.getText().toString());
                time = Double.parseDouble(edit3.getText().toString());
                x = Math.sin(angle) * velocity * time;
                y = Math.cos(angle) * velocity * time - (.5 * 9.8 * time * time);
                text4.setText("x=" + x + ",y=" + y);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
