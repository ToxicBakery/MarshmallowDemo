package com.example.ToxicBakery.androidmdemo.fragment;

import com.example.ToxicBakery.androidmdemo.R;
import com.example.ToxicBakery.androidmdemo.data.FragmentRef;
import com.example.ToxicBakery.androidmdemo.fragment.demo.FragmentFaceTracking;
import com.example.ToxicBakery.androidmdemo.fragment.demo.FragmentNearby;

import java.util.LinkedList;
import java.util.List;

class MenuProvider implements IMenuProvider {

    private static final List<FragmentRef> CLASSES = new LinkedList<>();

    static {
        CLASSES.add(new FragmentRef(R.string.fragment_title_face_tracking, FragmentFaceTracking.class));
        CLASSES.add(new FragmentRef(R.string.fragment_title_nearby, FragmentNearby.class));
    }

    @Override
    public List<FragmentRef> getFragmentRefs() {
        return new LinkedList<>(CLASSES);
    }

}
