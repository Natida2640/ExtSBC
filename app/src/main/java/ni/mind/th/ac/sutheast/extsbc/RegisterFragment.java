package ni.mind.th.ac.sutheast.extsbc;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    private String genderString, dateString, levelString, divisionString, sectionString;


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Create Toolber
        createToolber();

//        Create Division
        createDivision();

    }   //Main Method

    private void createDivision() {

        String[] strings = new String[]{"ชั่นปีที่1", "ชั่นปีที่2", "ชั่นปีที่3", "ชั่นปีที่4",};

        Spinner spinner = getView().findViewById(R.id.spinnerDivision);
    }

    private void createToolber() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarRegister);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.register));
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle(getString(R.string.message_have_space));
        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.itemCloud) {

            EditText id1EditText = getView().findViewById(R.id.edtID1);
            EditText id2EditText = getView().findViewById(R.id.edtID2);
            EditText passEditText = getView().findViewById(R.id.edtPassword1);
            EditText pass2EditText = getView().findViewById(R.id.edtPassword2);
            EditText nameEditText = getView().findViewById(R.id.edtName);
            EditText surnameEditText = getView().findViewById(R.id.edtSurname);
            EditText ageEditText = getView().findViewById(R.id.edtAge);
            EditText addressEditText = getView().findViewById(R.id.edtAddress);
            EditText emailEditText = getView().findViewById(R.id.edtEmail);
            EditText phoneEditText = getView().findViewById(R.id.edtPhone);

            String id1 = id1EditText.getText().toString().trim();
            String id2 = id2EditText.getText().toString().trim();
            String pass = passEditText.getText().toString().trim();
            String pass2 = pass2EditText.getText().toString().trim();
            String name = nameEditText.getText().toString().trim();
            String surname = surnameEditText.getText().toString().trim();
            String age = ageEditText.getText().toString().trim();
            String address = addressEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String phone = phoneEditText.getText().toString().trim();

            if (id1.isEmpty() ||
                    id2.isEmpty() ||
                    pass.isEmpty() ||
                    pass2.isEmpty() ||
                    name.isEmpty() ||
                    surname.isEmpty() ||
                    age.isEmpty() ||
                    address.isEmpty() ||
                    email.isEmpty() ||
                    phone.isEmpty()) {
//                Have Space
                showAlert("Have Space", "Please Fill All Blank");
            } else {

            }

        }
        return super.onOptionsItemSelected(item);
    }

    private void showAlert(String title, String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(title).setMessage(message).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);


        inflater.inflate(R.menu.menu_register, menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

}
