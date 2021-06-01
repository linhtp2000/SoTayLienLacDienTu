package com.example.contactapp.Teacher.ExerciseEdit;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.contactapp.R;

public class Teacher_Exercise_EditFragment extends Fragment {

    private TeacherExerciseEditViewModel mViewModel;

    public static Teacher_Exercise_EditFragment newInstance() {
        return new Teacher_Exercise_EditFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.teacher__exercise__edit_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TeacherExerciseEditViewModel.class);
        // TODO: Use the ViewModel
    }

}