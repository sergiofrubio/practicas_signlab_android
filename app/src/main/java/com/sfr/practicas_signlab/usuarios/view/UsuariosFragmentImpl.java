package com.sfr.practicas_signlab.usuarios.view;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sfr.practicas_signlab.api.Models.User;
import com.sfr.practicas_signlab.databinding.FragmentUsuariosBinding;
import com.sfr.practicas_signlab.detalleusuario.view.DetalleUsuarioActivity;
import com.sfr.practicas_signlab.di.appComponent.AppComponent;
import com.sfr.practicas_signlab.di.appComponent.DaggerAppComponent;
import com.sfr.practicas_signlab.di.appModule.AppModule;
import com.sfr.practicas_signlab.di.appModule.ConnectionModule;
import com.sfr.practicas_signlab.di.appModule.SharedPreferencesModule;
import com.sfr.practicas_signlab.usuarios.adapters.UsuariosAdapter;
import com.sfr.practicas_signlab.usuarios.presenter.UsuariosPresenter;

import java.util.ArrayList;

import javax.inject.Inject;

public class UsuariosFragmentImpl extends Fragment implements UsuariosFragment, UsuariosAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {
    public UsuariosFragmentImpl() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    private UsuariosAdapter adapter;
    private FragmentUsuariosBinding binding;
    @Inject
    UsuariosPresenter usuariospresenter;

    public static UsuariosFragmentImpl newInstance() {
        UsuariosFragmentImpl fragment = new UsuariosFragmentImpl();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Usuarios");
        // Utilizamos el objeto de ViewBinding para inflar el diseño
        binding = FragmentUsuariosBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        initInjection();
        recyclerView = binding.recyclerView; // Accedemos a las vistas a través del objeto de ViewBinding
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        binding.swipe.setOnRefreshListener(this);

        showLoading();
        usuariospresenter.onUsersFetched();
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
    public void showUsers(ArrayList<User> users) {
        hideLoading();
        // Pasar los datos al adaptador
        adapter = new UsuariosAdapter(users, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }


    private void showLoading() {
        // Mostrar el TextView y el ProgressBar
        binding.LinearLayoutLoading.setVisibility(View.VISIBLE);
        binding.LinearLayoutUsuario.setVisibility(View.GONE);

    }

    private void hideLoading() {
        // Ocultar el TextView y el ProgressBar
        binding.LinearLayoutLoading.setVisibility(View.GONE);
        binding.LinearLayoutUsuario.setVisibility(View.VISIBLE);

    }

    @Override
    public void onItemClick(User user) {
        Intent intent = new Intent(requireContext(), DetalleUsuarioActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);

    }

    @Override
    public void onRefresh() {
        usuariospresenter.onUsersFetched();
        binding.swipe.setRefreshing(false);

    }
}