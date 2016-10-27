package com.palle.annu.groceryshopping;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FruitFragment extends Fragment {

    ListView mListView;
    String [] str ={"Apple","Banana","Mango","0range","Grapse"};
    ArrayAdapter mArrayAdapter;


    public FruitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fruit, container, false);

        mListView = (ListView) v.findViewById(R.id.listView);
        mArrayAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,str);
        mListView.setAdapter(mArrayAdapter);

        mArrayAdapter.notifyDataSetChanged();

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String  fruit_name = str[position];
                AddProductFragment addProductFragment = new AddProductFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container1,addProductFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        return v;

    }



}
