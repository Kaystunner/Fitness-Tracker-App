package com.example.fitnesstracker;// BottomSheetFragment.java
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fitnesstracker.R;

public class BottomSheetFragment extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bottom_sheet_layout, container, false);
    }

    public void onWorkoutClick(View view) {
        // Handle workout click
    }

    public void onSleepTrackClick(View view) {
        // Handle sleep track click
    }

    public void onNutritionClick(View view) {
        // Handle nutrition click
    }

    public void onHydrationClick(View view) {
        // Handle hydration click
    }
}
