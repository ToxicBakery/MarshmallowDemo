package com.example.ToxicBakery.androidmdemo.fragment;

import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ToxicBakery.androidmdemo.R;
import com.example.ToxicBakery.androidmdemo.data.FragmentRef;
import com.example.ToxicBakery.androidmdemo.data.IDataSet;
import com.example.ToxicBakery.androidmdemo.fragment.demo.FragmentAssistApi;
import com.example.ToxicBakery.androidmdemo.fragment.demo.FragmentDirectShare;
import com.example.ToxicBakery.androidmdemo.fragment.demo.FragmentFlashlightAPI;
import com.example.ToxicBakery.androidmdemo.fragment.demo.FragmentSimplifiedPermissions;
import com.example.ToxicBakery.androidmdemo.fragment.demo.FragmentTextSelection;
import com.example.ToxicBakery.androidmdemo.fragment.demo.FragmentThemeableColorStateList;
import com.example.ToxicBakery.androidmdemo.fragment.demo.FragmentVoiceInteractions;

import java.util.ArrayList;
import java.util.List;

public class FragmentMenu extends Fragment implements IDataSet.IOnFragmentRefSelectedListener {

    public static final String TAG = "FragmentMenu";

    private DemoAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IDataSet dataSet = new DataSet();
        adapter = new DemoAdapter(dataSet, this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onFragmentRefSelected(@NonNull FragmentRef fragmentRef) {
        Class<? extends Fragment> fragmentClass = fragmentRef.getFragmentClass();
        Fragment fragment = null;

        try {
            fragment = fragmentClass.newInstance();
        } catch (Exception e) {
            Log.e(TAG, "Failed to create fragment.", e);
        }

        if (fragment != null) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment, fragmentClass.getName())
                    .addToBackStack(null)
                    .commit();
        }
    }

    private static final class DataSet implements IDataSet {

        private static final List<FragmentRef> CLASSES = new ArrayList<>();

        static {
            // Not yet implemented it seems in M v2 Preview
            //CLASSES.add(new FragmentRef(R.string.fragment_title_assist_api, FragmentAssistApi.class));
            CLASSES.add(new FragmentRef(R.string.fragment_title_direct_share, FragmentDirectShare.class));
            CLASSES.add(new FragmentRef(R.string.fragment_title_simplified_permissions, FragmentSimplifiedPermissions.class));
            CLASSES.add(new FragmentRef(R.string.fragment_title_text_selections, FragmentTextSelection.class));
            CLASSES.add(new FragmentRef(R.string.fragment_title_themeable_colorstate_list, FragmentThemeableColorStateList.class));
            CLASSES.add(new FragmentRef(R.string.fragment_title_voice_interactions, FragmentVoiceInteractions.class));
            CLASSES.add(new FragmentRef(R.string.fragment_title_flashlight_api, FragmentFlashlightAPI.class));
        }

        @Override
        @NonNull
        public FragmentRef getItemClass(@IntRange(from = 0) int position) {
            return CLASSES.get(position);
        }

        @Override
        @IntRange(from = 0)
        public int count() {
            return CLASSES.size();
        }

    }

    private static final class DemoAdapter extends RecyclerView.Adapter<ViewHolder> {

        private final IDataSet dataSet;
        private final IDataSet.IOnFragmentRefSelectedListener onFragmentRefSelectedListener;

        public DemoAdapter(@NonNull IDataSet dataSet,
                           @NonNull IDataSet.IOnFragmentRefSelectedListener onFragmentRefSelectedListener) {
            this.dataSet = dataSet;
            this.onFragmentRefSelectedListener = onFragmentRefSelectedListener;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.demo_item, viewGroup, false);

            return new ViewHolder(view, onFragmentRefSelectedListener);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int position) {
            FragmentRef fragmentRef = dataSet.getItemClass(position);
            viewHolder.bind(fragmentRef);
        }

        @Override
        public int getItemCount() {
            return dataSet.count();
        }

    }

    private static final class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView title;
        private final IDataSet.IOnFragmentRefSelectedListener onFragmentRefSelectedListener;

        private FragmentRef fragmentRef;

        public ViewHolder(@NonNull View itemView
                , @NonNull IDataSet.IOnFragmentRefSelectedListener onFragmentRefSelectedListener) {
            super(itemView);
            this.onFragmentRefSelectedListener = onFragmentRefSelectedListener;
            itemView.setOnClickListener(this);
            title = (TextView) itemView.findViewById(android.R.id.text1);
        }

        private void bind(FragmentRef fragmentRef) {
            this.fragmentRef = fragmentRef;
            title.setText(fragmentRef.getTitle());
        }

        @Override
        public void onClick(View view) {
            onFragmentRefSelectedListener.onFragmentRefSelected(fragmentRef);
        }

    }

}
