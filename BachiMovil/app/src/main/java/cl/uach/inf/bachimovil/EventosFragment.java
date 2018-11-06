package cl.uach.inf.bachimovil;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;



/**
 * A simple {@link Fragment} subclass.
 */
public class EventosFragment extends Fragment implements AsyncResponse{
    String response;
    String usr;
    TextView mostrarConsulta;
    Button btnConsultar;
    View view;

    public EventosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_eventos, container, false);

        mostrarConsulta = view.findViewById(R.id.resultadoConsulta);
        btnConsultar = view.findViewById(R.id.btnConsulta);


        return view;

    }

    @Override
    public void processFinish(JSONObject jsonObject) {
        try
        {
            response = jsonObject.getString("param1");
            usr = jsonObject.getString("usr");
            mostrarConsulta.setText("response: "+response+"\nuser: "+usr);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClick(View v) {
        if(v.getId() == R.id.btnConsulta) {

            DataRequest dataRequest = new DataRequest(getActivity());
            dataRequest.delegate = this;
            dataRequest.execute("http://146.83.216.206/info104/prueba.php?param1=hola&user=12");

        }

    }
}
