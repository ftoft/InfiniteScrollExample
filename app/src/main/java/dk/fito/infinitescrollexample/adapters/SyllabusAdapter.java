package dk.fito.infinitescrollexample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import dk.fito.infinitescrollexample.R;
import dk.fito.infinitescrollexample.service.responses.GetSyllabusesResponse;

public class SyllabusAdapter extends ArrayAdapter<GetSyllabusesResponse.Document> {
    public SyllabusAdapter(Context context) {
        super(context, R.layout.list_item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        GetSyllabusesResponse.Document doc = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView tvId = (TextView) convertView.findViewById(R.id.txtID);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.txtTitle);

        tvId.setText(doc.getId());
        tvTitle.setText(doc.getTitle());

        return convertView;
    }
}
