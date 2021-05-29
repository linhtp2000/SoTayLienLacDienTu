package com.example.contactapp.Teacher.Exercises;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.contactapp.R;

public class Teacher_ExercisesFragment extends Fragment {

    private TeacherExercisesViewModel mViewModel;

    public static Teacher_ExercisesFragment newInstance() {
        return new Teacher_ExercisesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.teacher__exercises_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TeacherExercisesViewModel.class);
        // TODO: Use the ViewModel
    }

}