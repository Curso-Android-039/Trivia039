package com.example.trivia039;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.trivia039.databinding.FragmentTitleBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TitleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TitleFragment extends Fragment {

    FragmentTitleBinding binding;



    public TitleFragment() {
        // Required empty public constructor
    }



    public static TitleFragment newInstance() {
        TitleFragment fragment = new TitleFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentTitleBinding.inflate(inflater,container,false);
        View view= binding.getRoot();

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!binding.editTextText.getText().toString().isEmpty()){
                    addLogotriviaFragment(binding.editTextText.getText().toString());
                }
                else {
                    Toast.makeText(getContext(),"Debes Escribir Tu nombre",Toast.LENGTH_LONG).show();
                }
            }
        });

        return  view;
    }

    private void addLogotriviaFragment(String name){
        Bundle bundle = new Bundle();
        bundle.putString("clave1", name);

        Navigation.findNavController(binding.getRoot())
                .navigate(R.id.action_titleFragment_to_logoTriviaFragment,bundle);
    }

}