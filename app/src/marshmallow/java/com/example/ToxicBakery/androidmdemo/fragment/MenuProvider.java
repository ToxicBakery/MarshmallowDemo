package com.example.ToxicBakery.androidmdemo.fragment;

import com.example.ToxicBakery.androidmdemo.R;
import com.example.ToxicBakery.androidmdemo.data.FragmentRef;
import com.example.ToxicBakery.androidmdemo.fragment.demo.FragmentDirectShare;
import com.example.ToxicBakery.androidmdemo.fragment.demo.FragmentFaceTracking;
import com.example.ToxicBakery.androidmdemo.fragment.demo.FragmentFlashlightAPI;
import com.example.ToxicBakery.androidmdemo.fragment.demo.FragmentNearby;
import com.example.ToxicBakery.androidmdemo.fragment.demo.FragmentSimplifiedPermissions;
import com.example.ToxicBakery.androidmdemo.fragment.demo.FragmentTextSelection;
import com.example.ToxicBakery.androidmdemo.fragment.demo.FragmentThemeableColorStateList;

import java.util.LinkedList;
import java.util.List;

class MenuProvider implements IMenuProvider {

    private static final List<FragmentRef> CLASSES = new LinkedList<>();

    static {
        // Not yet implemented it seems in M v2 Preview
        //CLASSES.add(new FragmentRef(R.string.fragment_title_assist_api, FragmentAssistApi.class));
        CLASSES.add(new FragmentRef(R.string.fragment_title_direct_share, FragmentDirectShare.class));
        CLASSES.add(new FragmentRef(R.string.fragment_title_face_tracking, FragmentFaceTracking.class));
        CLASSES.add(new FragmentRef(R.string.fragment_title_nearby, FragmentNearby.class));
        CLASSES.add(new FragmentRef(R.string.fragment_title_simplified_permissions, FragmentSimplifiedPermissions.class));
        CLASSES.add(new FragmentRef(R.string.fragment_title_text_selections, FragmentTextSelection.class));
        CLASSES.add(new FragmentRef(R.string.fragment_title_themeable_colorstate_list, FragmentThemeableColorStateList.class));
        //CLASSES.add(new FragmentRef(R.string.fragment_title_voice_interactions, FragmentVoiceInteractions.class));
        CLASSES.add(new FragmentRef(R.string.fragment_title_flashlight_api, FragmentFlashlightAPI.class));
    }

    @Override
    public List<FragmentRef> getFragmentRefs() {
        return new LinkedList<>(CLASSES);
    }

}
