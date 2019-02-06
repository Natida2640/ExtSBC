//package ni.mind.th.ac.sutheast.extsbc;
//
//import android.content.Context;
//import android.net.Uri;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.Toast;
//
//import javax.xml.transform.Result;
//
//import me.dm7.barcodescanner.zxing.ZXingScannerView
//
///**
// * A simple {@link Fragment} subclass.
//
// */
//public class QRFragment extends Fragment {
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private ZXingScannerView zXingScannerView;
//
//    private String resultQRcode;
//
//    private String mParam1;
//    private String mParam2;
//
//    private OnFragmentInteractionListener mListener;
//
//    public QRFragment() {
//        // Required empty public constructor
//    }
//
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        // QR Scan Controller
//        Button button = getView().findViewById(R.id.btnQRscan);
//        button.setOnClickListener(//new View.OnClickListener(){
//
//            zXingScannerView = new ZXingScannerView(getActivity());
//            getActivity().setContentView(zXingScannerView);
//            zXingScannerView.startCamera();
//
//            zXingScannerView.setResultHandler(new ZXingScannerView.ResultHandler() {
//            @Override
//            public void handleResult(Result result) {
//
//                zXingScannerView.stopCamera();
//                getActivity().setContentView(R.layout.activity_main);
//                String resultString = result.getText().toString();
//                Toast.makeText(getActivity(),"QR code =" + resultString,
//                        Toast.LENGTH_LONG).show();
//                Log.d("12MarchV1", "QR code ==> " + resultString);
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.contentMainFragment, new MainFragment()).commit();
//
//            }
//
//        }
//    }
//
//    /*public static QRFragment newInstance(String param1, String param2) {
//        QRFragment fragment = new QRFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }*/
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_qr, container, false);
//    }
//
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
//}
//
package ni.mind.th.ac.sutheast.extsbc;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class QRFragment extends Fragment implements ZXingScannerView.ResultHandler{

    private ZXingScannerView zXingScannerView;
    private  String resultQRcode;


    public QRFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();

    }

    @Override
    public void onPause() {
        super.onPause();
        zXingScannerView.stopCamera(); // ปิดหน้ากล้อง
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        zXingScannerView = new ZXingScannerView(getActivity());
        return zXingScannerView;

    }

    @Override
    public void handleResult(Result result) {

        resultQRcode = result.toString().trim();
        Log.d("6janV2","result ==> "+ resultQRcode);

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contentQRfragment.detailFragment(resultQRcode)).commit();

        Handler handler = new Handler();  //Handler ระบบน่วงเวลา
        handler.postDelayed(new Runnable() {//postDelayed ทำให้ดีเล ช้าลง 2000=0วิ
            @Override
            public void run() {
                zXingScannerView.resumeCameraPreview(QRFragment.this);
            }
        }, 2000);

    }
}

