package funix.prm.prm1391x_tourguide_cultrfx02223funixeduvn;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity
         implements CatalogFragment.OnFragmentInteractionListener,
                    LocationListFragment.OnFragmentInteractionListener{
    private FragmentManager mFragmentManager;
    private ActionBar mActionBar; // action bar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();


        // hiển thị danh mục cho người dùng chọn để xem chi tiết
        if(savedInstanceState == null){

            CatalogFragment catalogFragment = CatalogFragment.newIntance();

            FragmentTransaction fragmentManager = mFragmentManager.beginTransaction();
            fragmentManager.add(R.id.framentPlace, catalogFragment).commit();
        }

        // cấu hình action bar
        mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(true);
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setHomeAsUpIndicator(R.drawable.ic_back);
        mActionBar.show();
    }

    // hiển thị danh sách các địa điểm
    @Override
    public void onViewLocationList(int resourceId, int mFlagImgId) {
        LocationListFragment locationListFragment = LocationListFragment.newIntance(resourceId, mFlagImgId);
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framentPlace, locationListFragment).commit();
        fragmentTransaction.addToBackStack("xx");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch ((item.getItemId())){
            case  android.R.id.home:
                onBackPressed();
                break;
                default: break;
        }
        return super.onOptionsItemSelected(item);
    }

    // ẩn back-icon của action bar
    @Override
    public void onDisplayCatalog() {
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
        mActionBar.setDisplayHomeAsUpEnabled(false);
        mActionBar.show();
    }

    // hiện back-icon của action bar
    @Override
    public void onDisplayLocationList(int resourceId) {
        Resources resuorce = getResources();
        String actionBarTitle = "";
        switch (resourceId){
            case R.array.hn_atms:
                actionBarTitle = resuorce.getString(R.string.atm);
                break;
            case R.array.hn_hospitals:
                actionBarTitle = resuorce.getString(R.string.hospital);
                break;
            case R.array.hn_hotels:
                actionBarTitle = resuorce.getString(R.string.hotel);
                break;
            case R.array.hn_metro:
                actionBarTitle = resuorce.getString(R.string.metro);
                break;
        }
        mActionBar.setTitle(actionBarTitle);
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.show();
    }
}
