package demoapps.com.dummyapi;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;

public class selectionDialogFragement extends DialogFragment {

    public selectionDialogFragement(){
    }

    @BindView(R.id.expbtn) TextView form;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_select_btns,container);
    }

}
