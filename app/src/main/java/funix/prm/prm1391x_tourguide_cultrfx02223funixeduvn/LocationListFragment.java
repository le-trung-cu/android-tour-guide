package funix.prm.prm1391x_tourguide_cultrfx02223funixeduvn;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LocationListFragment extends Fragment {

    private int mResourceId;   // array id, danh sách địa điểm
    private int mFlagImgId; // flag image id
    private OnFragmentInteractionListener mListener;

    public LocationListFragment() {
    }

    public static LocationListFragment newIntance(int resourceId, int mFlagImgId){

        LocationListFragment fragment = new LocationListFragment();

        Bundle args = new Bundle();
        args.putInt("mResourceId", resourceId);
        args.putInt("mFlagImgId", mFlagImgId);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListener){
            mListener = (OnFragmentInteractionListener) context;
        }else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            mResourceId = getArguments().getInt("mResourceId");
            mFlagImgId = getArguments().getInt("mFlagImgId");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_location_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // nạp danh sách địa điểm
        String[] locationList = getResources().getStringArray(mResourceId);
        CustomAdapter customAdapter = new CustomAdapter(locationList, mFlagImgId);
        ListView listView = view.findViewById(R.id.listLocations);
        listView.setAdapter(customAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mListener.onDisplayLocationList(mResourceId);
    }

    public interface OnFragmentInteractionListener {
        // hiển thị icon-back trên action bar
        void onDisplayLocationList(int resourceId);
    }
}
