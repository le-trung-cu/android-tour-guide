package funix.prm.prm1391x_tourguide_cultrfx02223funixeduvn;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class CatalogFragment extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;  // communication Fragment vs Activity

    public CatalogFragment() {
    }

    public static CatalogFragment newIntance(){
        CatalogFragment catalog = new CatalogFragment();
        return catalog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_catalog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // xử lý khi người dùng chọn 1 danh mục
        View btnOpenHostel = view.findViewById(R.id.btnOpenHostel);
        btnOpenHostel.setOnClickListener(this);

        View btnOpenATM = view.findViewById(R.id.btnOpenATM);
        btnOpenATM.setOnClickListener(this);

        View btnOpenHospital = view.findViewById(R.id.btnOpenHospital);
        btnOpenHospital.setOnClickListener(this);

        View btnOpenMetro = view.findViewById(R.id.btnOpenMetro);
        btnOpenMetro.setOnClickListener(this);

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onClick(View v) {
        if(mListener == null)
            return;
        switch (v.getId()){
            case R.id.btnOpenHostel:
                mListener.onViewLocationList(R.array.hn_hotels, R.drawable.hotel);
                break;
            case R.id.btnOpenATM:
                mListener.onViewLocationList(R.array.hn_atms, R.drawable.atm_machine);
                break;
            case R.id.btnOpenHospital:
                mListener.onViewLocationList(R.array.hn_hospitals, R.drawable.hospital);
                break;
            case R.id.btnOpenMetro:
                mListener.onViewLocationList(R.array.hn_metro, R.drawable.metro);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mListener.onDisplayCatalog();
    }

    public interface OnFragmentInteractionListener {
        // hiển thị danh sach địa điểm
        void onViewLocationList(int resourceId, int flagImgId);
        // ẩn icon-back trên action bar
        void onDisplayCatalog();
    }
}
