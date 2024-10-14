package com.example.fitnesstracker;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView; // Import CardView
import android.widget.Button; // Import Button

public class WorkoutFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workouts, container, false);

        // Initialize card views for workouts
        CardView card1 = view.findViewById(R.id.card1);
        CardView card2 = view.findViewById(R.id.card2);
        CardView card3 = view.findViewById(R.id.card3);
        CardView card4 = view.findViewById(R.id.card4);
        CardView card5 = view.findViewById(R.id.card5);
        CardView card6 = view.findViewById(R.id.card6);
        CardView card7 = view.findViewById(R.id.card7);
        CardView card8 = view.findViewById(R.id.card8);

        // Initialize button to open the bottom sheet
        Button openBottomSheetButton = view.findViewById(R.id.open_bottom_sheet_button);

        // Set onClick listeners for workout cards
        card1.setOnClickListener(v -> {
            // Handle card 1 click
        });

        card2.setOnClickListener(v -> {
            // Handle card 2 click
        });

        card3.setOnClickListener(v -> {
            // Handle card 3 click
        });

        card4.setOnClickListener(v -> {
            // Handle card 4 click
        });

        card5.setOnClickListener(v -> {
            // Handle card 5 click
        });

        card6.setOnClickListener(v -> {
            // Handle card 6 click
        });

        card7.setOnClickListener(v -> {
            // Handle card 7 click
        });

        card8.setOnClickListener(v -> {
            // Handle card 8 click
        });

        // Set onClick listener for the button to open the bottom sheet
        openBottomSheetButton.setOnClickListener(v -> {
            // Open your bottom sheet here
            BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
            bottomSheetFragment.show(getChildFragmentManager(), bottomSheetFragment.getTag());
        });

        return view;
    }
}
