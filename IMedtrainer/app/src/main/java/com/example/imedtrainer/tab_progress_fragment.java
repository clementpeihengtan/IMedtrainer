package com.example.imedtrainer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;


public class tab_progress_fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public tab_progress_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tab_progress_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static tab_progress_fragment newInstance(String param1, String param2) {
        tab_progress_fragment fragment = new tab_progress_fragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_progress_fragment, container, false);
        LineChart mChart = view.findViewById(R.id.linechart);

//        mChart.setOnChartGestureListener();
//        mChart.setOnChartValueSelectedListener();

        mChart.getLegend().setEnabled(false);
        mChart.getDescription().setText("Progress");

        mChart.setViewPortOffsets(0, 0, 0, 0);
//        mChart.setBackgroundColor(Color.rgb(82, 219, 255));
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(false);

//        mChart.setDrawGridBackground(false);
//        mChart.setMaxHighlightDistance(300);

        XAxis x = mChart.getXAxis();
        x.setEnabled(true);
        x.setLabelCount(6);
        x.setDrawGridLines(false);

        YAxis y = mChart.getAxisLeft();
        y.setAxisMaximum(100);
        y.setAxisMinimum(0);
//        y.setTypeface(mTfLight);
//        y.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        y.setEnabled(true);
        mChart.getAxisRight().setEnabled(false);
//        mChart.getAxisLeft().setEnabled(false);

        ArrayList<Entry> yValues = new ArrayList<>();
        yValues.add(new Entry(0, 60f));
        yValues.add(new Entry(5, 40f));
        yValues.add(new Entry(10, 70f));
        yValues.add(new Entry(15, 20f));

        LineDataSet set1 = new LineDataSet(yValues, "Usage against time");
        set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set1.setFillAlpha(255);
        set1.setDrawCircles(false);
        set1.setDrawFilled(true);
        set1.setDrawValues(false);
        set1.setDrawHorizontalHighlightIndicator(false);
        set1.setFillColor(R.color.pale_green);
        set1.setColor(R.color.pale_green);
//        set1.setFillFormatter(new IFillFormatter() {
//            @Override
//            public float getFillLinePosition(ILineDataSet dataSet, LineDataProvider dataProvider) {
//                return -10;
//            }
//        });

//        set1.setFillAlpha(110);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);
        mChart.setData(data);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
