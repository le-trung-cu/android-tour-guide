package funix.prm.prm1391x_tourguide_cultrfx02223funixeduvn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private String[] resource;  // danh sách địa điểm
    private int flagImg; // hình ảnh

    public CustomAdapter(String[] resource, int flagImg){
        this.resource = resource;
        this.flagImg = flagImg;
    }

    @Override
    public int getCount() {
        return resource.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(parent.getContext(),R.layout.row_item, null);

        ImageView img = convertView.findViewById(R.id.img);
        TextView title = convertView.findViewById(R.id.title);
        TextView detail = convertView.findViewById(R.id.detail);

        View locationTextBox = convertView.findViewById(R.id.locationTextBox);

        locationTextBox
                .setBackgroundColor(parent.getResources()
                        .getColor(coverFlagImgToColor(flagImg)));

        String str = resource[position];
        int index = str.indexOf(",");
        String titleStr = str.substring(0, index);
        String detailStr = str.substring(index + 2);

        img.setImageResource(flagImg);
        title.setText(titleStr);
        detail.setText(detailStr);

        return convertView;
    }

    private int coverFlagImgToColor(int flagImg){
        switch (flagImg){
            case R.drawable.atm_machine:
                return R.color.color1;
            case R.drawable.hospital:
                return R.color.color2;
            case R.drawable.hotel:
                return R.color.color3;
            case R.drawable.metro:
                return R.color.color4;
            default: return R.color.color4;
        }
    }
}
