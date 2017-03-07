package ru.ikota.domark;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    PreferenceHelper preferenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PreferenceHelper.getInstance().init(getApplicationContext());
        preferenceHelper = PreferenceHelper.getInstance();

        fragmentManager = getFragmentManager();
        runSplash();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem spashItem = menu.findItem(R.id.action_splash);
        spashItem.setChecked(preferenceHelper.getBoolean(PreferenceHelper.KEY_SPALSH));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_splash){
            item.setChecked(!item.isChecked());
            preferenceHelper.putBulean(PreferenceHelper.KEY_SPALSH, item.isChecked());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void runSplash(){
        if (!preferenceHelper.getBoolean(PreferenceHelper.KEY_SPALSH)) {
            SplashFragment splashFragment = new SplashFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, splashFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
