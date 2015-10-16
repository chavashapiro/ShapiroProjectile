package shapiro.projectile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private ImageView projectileImage;
    private TextView textAngle;
    private EditText editAngle;
    private TextView textVelocity;
    private EditText editVelocity;
    private TextView textTime;
    private EditText editTime;
    private Button calculate;
    private TextView answer;

    /**@Override
    protected void onResume() {
        super.onResume();
    }**/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        projectileImage = (ImageView) findViewById(R.id.projectile_image);
        Picasso.with(this).load("http://www.splung.com/kinematics/images/projectiles/motorbike-parabola.jpg").into(projectileImage);

        textAngle = (TextView) findViewById(R.id.text_angle);
        textVelocity = (TextView) findViewById(R.id.text_velocity);
        textTime = (TextView) findViewById(R.id.text_time);
        answer = (TextView) findViewById(R.id.result);
        editAngle = (EditText) findViewById(R.id.edit_angle);
        editVelocity = (EditText) findViewById(R.id.edit_velocity);
        editTime = (EditText) findViewById(R.id.edit_time);
        calculate = (Button) findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProjectileAnswer();
            }
        });
    }

    private void showProjectileAnswer() {
        Intent intent = new Intent(this, AnswerActivity.class);
        double angle, velocity, time, x, y;
        angle = Double.parseDouble(editAngle.getText().toString());
        velocity = Double.parseDouble(editVelocity.getText().toString());
        time = Double.parseDouble(editTime.getText().toString());
        intent.putExtra("ANGLE", angle);
        intent.putExtra("VELOCITY", velocity);
        intent.putExtra("TIME", time);
        startActivity(intent);
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
