package com.example.mperezsilva.cambioaplis;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Button bhola=(Button)findViewById(R.id.bhola);
        bhola.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MyActivity.this,MyActivity2.class);
                Bundle reci=new Bundle();
                reci.putString("nombre","damian");
                intento.putExtras(reci);
                startActivityForResult(intento, 1);
            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        String res = data.getExtras().getString("respuesta");
        Context context = getApplicationContext();
        CharSequence text = res;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
