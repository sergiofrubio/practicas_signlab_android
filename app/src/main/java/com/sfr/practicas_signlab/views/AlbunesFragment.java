package com.sfr.practicas_signlab.views;
import com.sfr.practicas_signlab.di.appComponent.DaggerAppComponent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sfr.practicas_signlab.api.Models.Album;
import com.sfr.practicas_signlab.databinding.FragmentAlbunesBinding;
import com.sfr.practicas_signlab.di.appComponent.AppComponent;
import com.sfr.practicas_signlab.di.appModule.AppModule;
import com.sfr.practicas_signlab.di.appModule.ConnectionModule;
import com.sfr.practicas_signlab.di.appModule.SharedPreferencesModule;
import com.sfr.practicas_signlab.presenters.AlbunesPresenterInt;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UsuariosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlbunesFragment extends Fragment implements AlbunesFragmentInt{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AlbunesFragment() {
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
    // private AlbunesAdapter adapter;
    private FragmentAlbunesBinding binding;

    AlbunesPresenterInt albunespresenter;

    public static AlbunesFragment newInstance(String param1, String param2) {
        AlbunesFragment fragment = new AlbunesFragment();
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
        // albunespresenter.onAlbumsFetched();
        // adapter = new AlbunesAdapter();
        // recyclerView.setAdapter(adapter);

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
        // adapter.setAlbunes(albums);
        // adapter.notifyDataSetChanged();
    }


    private void showLoading() {
        // Mostrar el TextView y el ProgressBar
        binding.textViewLoading.setVisibility(View.VISIBLE);
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    private void hideLoading() {
        // Ocultar el TextView y el ProgressBar
        binding.textViewLoading.setVisibility(View.GONE);
        binding.progressBar.setVisibility(View.GONE);
    }

}