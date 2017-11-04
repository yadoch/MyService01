package tw.com.abc.myservice01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit=(EditText)findViewById(R.id.edit);




    }

    public void test1(View view){
        int n =Integer.parseInt(edit.getText().toString());
        Intent intent = new Intent(this,MyService.class);
        intent.putExtra("n",n);
        startService(intent);

    }
}
