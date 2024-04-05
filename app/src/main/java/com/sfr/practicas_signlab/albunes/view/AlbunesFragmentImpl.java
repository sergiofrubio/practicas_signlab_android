package com.sfr.practicas_signlab.albunes.view;
import com.sfr.practicas_signlab.albunes.adapter.AlbunesAdapter;
import com.sfr.practicas_signlab.api.Models.User;
import com.sfr.practicas_signlab.di.appComponent.DaggerAppComponent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SearchView;

import com.sfr.practicas_signlab.api.Models.Album;
import com.sfr.practicas_signlab.databinding.FragmentAlbunesBinding;
import com.sfr.practicas_signlab.di.appComponent.AppComponent;
import com.sfr.practicas_signlab.di.appModule.AppModule;
import com.sfr.practicas_signlab.di.appModule.ConnectionModule;
import com.sfr.practicas_signlab.di.appModule.SharedPreferencesModule;
import com.sfr.practicas_signlab.albunes.presenter.AlbunesPresenter;
import com.sfr.practicas_signlab.usuarios.presenter.UsuariosPresenter;
import com.sfr.practicas_signlab.usuarios.view.UsuariosFragment;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlbunesFragmentImpl#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlbunesFragmentImpl extends Fragment implements AlbunesFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AlbunesFragmentImpl() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UsuariosFragment.
     */
    // TODO: Rename and change types and number of parameters


    private RecyclerView recyclerView;
    private AlbunesAdapter adapter;
    private FragmentAlbunesBinding binding;
    @Inject
    AlbunesPresenter albunespresenter;
    @Inject
    UsuariosPresenter usuariospresenter;

    public static AlbunesFragmentImpl newInstance(String param1, String param2) {
        AlbunesFragmentImpl fragment = new AlbunesFragmentImpl();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Utilizamos el objeto de ViewBinding para inflar el diseño
        binding = FragmentAlbunesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        initInjection();
        recyclerView = binding.recyclerView; // Accedemos a las vistas a través del objeto de ViewBinding
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));


        showLoading();
        albunespresenter.onAlbumsFetched();
        //usuariospresenter.onUsersFetched();
        //setupSpinner(usuarios);

        adapter = new AlbunesAdapter();
        recyclerView.setAdapter(adapter);

        binding.txtBuscar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // No necesitas hacer nada aquí, ya que estamos filtrando en tiempo real
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Cuando el texto cambia en el SearchView, aplicar el filtro
                adapter.getFilter().filter(newText);
                return true;
            }
        });

        return view;
    }

    private void initInjection() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, requireContext()))
                .connectionModule(new ConnectionModule())
                .sharedPreferencesModule(new SharedPreferencesModule(requireContext()))
                .build();
        appComponent.inject(this);
    }


    @Override
    public void showAlbums(ArrayList<Album> albums) {
        hideLoading();
        // Pasar los datos al adaptador
        adapter.setAlbums(albums);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void showUser(ArrayList<User> users) {
        // Crear un ArrayList de nombres de usuarios
        ArrayList<String> nombresUsuarios = new ArrayList<>();
        for (User usuario : users) {
            nombresUsuarios.add(usuario.getName());
        }

        // Crear un adaptador para el Spinner
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, nombresUsuarios);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Configurar el adaptador para el Spinner
        binding.spinner.setAdapter(spinnerAdapter);

    }


    private void showLoading() {
        // Mostrar el TextView y el ProgressBar
        binding.LinearLayoutLoading.setVisibility(View.VISIBLE);
        binding.LinearLayoutAlbum.setVisibility(View.GONE);
        // binding.textViewLoading.setVisibility(View.VISIBLE);
        // binding.progressBar.setVisibility(View.VISIBLE);
    }

    private void hideLoading() {
        // Ocultar el TextView y el ProgressBar
        binding.LinearLayoutLoading.setVisibility(View.GONE);
        binding.LinearLayoutAlbum.setVisibility(View.VISIBLE);
        // binding.textViewLoading.setVisibility(View.GONE);
        // binding.progressBar.setVisibility(View.GONE);
    }

}