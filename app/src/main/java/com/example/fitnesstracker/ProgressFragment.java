package com.example.fitnesstracker;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ProgressFragment extends Fragment {

    private PieChart pieChart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_progress, container, false);
        pieChart = view.findViewById(R.id.pie_chart);
        setupPieChart();

        // The button to open the bottom sheet
        Button openBottomSheetButton = view.findViewById(R.id.open_bottom_sheet_button);
        openBottomSheetButton.setOnClickListener(v -> {
            // Open bottom here
            BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
            bottomSheetFragment.show(getChildFragmentManager(), bottomSheetFragment.getTag());
        });

        return view;
    }

    private void setupPieChart() {
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(30f, "Completed Workouts"));
        pieEntries.add(new PieEntry(20f, "Remaining Workouts"));
        pieEntries.add(new PieEntry(25f, "Target Workouts"));
        pieEntries.add(new PieEntry(25f, "Rest"));

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Workout Progress");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextSize(16f); // Text size for value labels
        pieDataSet.setValueTextColor(android.graphics.Color.WHITE); // Text color for value labels
        pieDataSet.setDrawValues(true); // Show values inside the pie chart

        PieData pieData = new PieData(pieDataSet);

        // Set the data to the PieChart
        pieChart.setData(pieData);
        pieChart.setCenterText("Progress");
        pieChart.setCenterTextSize(28f); // Increased size for center text
        pieChart.setHoleRadius(40f); // Set hole radius (if using hole)
        pieChart.setTransparentCircleRadius(45f); // Set transparent circle radius (if using hole)
        pieChart.getLegend().setEnabled(true); // Enable legend
        pieChart.getLegend().setTextColor(android.graphics.Color.BLACK); // Legend text color
        pieChart.animate(); // Animation for pie chart
        pieChart.invalidate(); // Refresh the chart
    }
}
