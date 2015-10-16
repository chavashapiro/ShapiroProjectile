package shapiro.projectile;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    private TextView answer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        answer = (TextView) findViewById(R.id.answer);
        double angle, velocity, time, x, y;

        Intent intent = getIntent();
        angle = intent.getDoubleExtra("ANGLE", 0.0);
        velocity = intent.getDoubleExtra("VELOCITY", 0.0);
        time = intent.getDoubleExtra("TIME", 0.0);
        Projectile proj = new Projectile(angle, velocity, time);
        x = proj.getX();
        y = proj.getY();
        answer.setText("x=" + x + ",z=" + y);
    }

}
