package cl.uach.inf.bachimovil;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CursosFragment extends Fragment {
    Intent myintent;
    Bundle bundle;

    String transDato;

    public CursosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        transDato = "Este string fue pasado desde el fragment anterior";

        return inflater.inflate(R.layout.fragment_cursos, container, false);
    }

    public void onClick(View v) {
        if(v.getId() == R.id.btn_curso1) {
            //para enviar  datos
            bundle = new Bundle();

            //Para la pantalla CursosActivity
            myintent = new Intent(getActivity(), CursosActivity.class );

            //dato a enviar
            myintent.putExtra("key1", transDato);

            //ir a pantalla CursosActivity
            startActivity(myintent);


        }
    }
}
