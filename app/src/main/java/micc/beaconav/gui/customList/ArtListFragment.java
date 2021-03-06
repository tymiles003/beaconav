package micc.beaconav.gui.customList;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

import micc.beaconav.FragmentHelper;
import micc.beaconav.R;
import micc.beaconav.db.dbHelper.DbManager;
import micc.beaconav.db.dbHelper.IArtRow;
import micc.beaconav.db.dbHelper.museum.MuseumRow;
import micc.beaconav.db.dbJSONManager.JSONHandler;
import micc.beaconav.db.dbJSONManager.tableScheme.TableRow;

/**
* Created by Mr_Holmes on 21/01/15.
*/
public class ArtListFragment extends Fragment
{

    private AdapterView.OnItemClickListener listItemNameOnClickListener = null;
    private AdapterView.OnItemClickListener listItemBtnOnClickListener = null;

    private ListView listView;
    private List<IArtRow> artListItems;


    public ArtListFragment() {}


    //probabilmente questo metodo non serve
    @Override
    public void onAttach(Activity parentActivity) {
        super.onAttach(parentActivity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        return inflater.inflate(R.layout.fragment_art_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        DbManager.museumDownloader.startDownload();


        DbManager.museumDownloader.addHandler(new JSONHandler<MuseumRow>() {

            @Override
            public void onJSONDownloadFinished(MuseumRow[] result) {
                IArtRow[] artRows = result;
                inflateList(artRows);
            }
        });

    }


    public void setListItemNameOnClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.listItemNameOnClickListener = onItemClickListener;
    }

    public void setListItemBtnOnClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.listItemBtnOnClickListener = onItemClickListener;
    }



// * * * * * * * * * * * * * * *  HELPERS * * * * * * * * * * * * * * * * * * * * *

    private void inflateList(final IArtRow[] result) {

        artListItems = new ArrayList<>();
        for(int i = 0; i < result.length; i++)
        {
            artListItems.add(result[i]);
        }

        listView = (ListView) getView().findViewById(R.id.descriptionList);
        ListAdapter adapter = new ListAdapter(getActivity(), artListItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(result[position] instanceof MuseumRow)
                FragmentHelper.simulateMuseumOnMapClickOn((MuseumRow)result[position]);

            }
        });
        // questi 2 metodi settano i listener per ogni elemento della lista
        // sanno già a che positione si trova
        listView.setItemsCanFocus(true);

    }

}