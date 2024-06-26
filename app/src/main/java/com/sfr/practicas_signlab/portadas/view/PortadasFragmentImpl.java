package com.sfr.practicas_signlab.portadas.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sfr.practicas_signlab.api.Models.Photo;
import com.sfr.practicas_signlab.databinding.FragmentPortadasBinding;
import com.sfr.practicas_signlab.di.appComponent.AppComponent;
import com.sfr.practicas_signlab.di.appComponent.DaggerAppComponent;
import com.sfr.practicas_signlab.di.appModule.AppModule;
import com.sfr.practicas_signlab.di.appModule.ConnectionModule;
import com.sfr.practicas_signlab.di.appModule.SharedPreferencesModule;
import com.sfr.practicas_signlab.portadas.adapters.PortadasAdapter;
import com.sfr.practicas_signlab.portadas.presenter.PortadasPresenter;

import java.util.ArrayList;

import javax.inject.Inject;


public class PortadasFragmentImpl extends Fragment implements PortadasFragment, SwipeRefreshLayout.OnRefreshListener {

    public PortadasFragmentImpl() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    private PortadasAdapter adapter;
    private FragmentPortadasBinding binding;
    @Inject
    PortadasPresenter portadaspresenter;
    public static PortadasFragmentImpl newInstance() {
        PortadasFragmentImpl fragment = new PortadasFragmentImpl();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Portadas");
        // Utilizamos el objeto de ViewBinding para inflar el diseño
        binding = FragmentPortadasBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        initInjection();
        recyclerView = binding.recyclerView; // Accedemos a las vistas a través del objeto de ViewBinding
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        binding.swipe.setOnRefreshListener(this);

        showLoading();
        portadaspresenter.onPhotosFetched();

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
    public void showPhotos(ArrayList<Photo> photos) {
        hideLoading();
        adapter = new PortadasAdapter(photos);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        // Ocultar el SwipeRefreshLayout una vez que se han cargado las fotos

    }

    private void showLoading() {
        // Mostrar el TextView y el ProgressBar
        binding.LinearLayoutLoading.setVisibility(View.VISIBLE);
        binding.LinearLayoutPortada.setVisibility(View.GONE);

    }

    private void hideLoading() {
        // Ocultar el TextView y el ProgressBar
        binding.LinearLayoutLoading.setVisibility(View.GONE);
        binding.LinearLayoutPortada.setVisibility(View.VISIBLE);

    }

    @Override
    public void onRefresh() {
        portadaspresenter.onPhotosFetched();
        binding.swipe.setRefreshing(false);

    }
}