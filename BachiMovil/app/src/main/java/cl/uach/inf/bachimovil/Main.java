package cl.uach.inf.bachimovil;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import android.view.View;
import android.widget.FrameLayout;


public class Main extends AppCompatActivity{

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private EventosFragment eventosFragment;
    private CursosFragment cursosFragment;
    private ForoFragment foroFragment;
    private PlanFragment planFragment;
    private MaterialFragment materialFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainNav = findViewById(R.id.btm_nav);
        mMainFrame = findViewById(R.id.main_nav);

        eventosFragment = new EventosFragment();
        cursosFragment = new CursosFragment();
        foroFragment = new ForoFragment();
        planFragment = new PlanFragment();
        materialFragment = new MaterialFragment();

        setFragment(eventosFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.id_Eventos:
                        setFragment(eventosFragment);
                        return true;
                    case R.id.id_Cursos:
                        setFragment(cursosFragment);
                        return  true;
                    case R.id.id_Foro:
                        setFragment(foroFragment);
                        return  true;
                    case R.id.id_Planificacion:
                        setFragment(planFragment);
                        return  true;
                    case R.id.id_Material:
                        setFragment(materialFragment);
                        return  true;
                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_nav, fragment);
        fragmentTransaction.commit();
    }

    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClick(View v){
        eventosFragment.onClick(v);
        cursosFragment.onClick(v);
    }

}
