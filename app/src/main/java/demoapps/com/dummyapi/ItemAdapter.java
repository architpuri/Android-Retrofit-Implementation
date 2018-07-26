package demoapps.com.dummyapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<listData> items;
    private OnItemClickListener onItemClickListener;

    public ItemAdapter(ArrayList<listData> item) {
        items = item;
        Log.v("Adapter", "Entered Adapater");
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHoldertop extends RecyclerView.ViewHolder {
        public TextView textItemName;
        public CheckBox checkItem;

        public ViewHoldertop(View itemView) {
            super(itemView);
            textItemName = itemView.findViewById(R.id.text_row_item);
            checkItem = itemView.findViewById(R.id.row_checkbox);
            checkItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    items.set(getAdapterPosition(), new listData(items.get(getAdapterPosition()).getRowText(), isChecked));
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("clicked","clikced position=="+getAdapterPosition());
                    onItemClickListener.onItemClick(getAdapterPosition());
                }
            });
        }
    }
    public class ViewHolderparagraph extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public ViewHolderparagraph(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img_start_index_item);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("ImageView Clicked","Image at position ="+getAdapterPosition());
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        switch(viewType){
            case 0:
            {
                View imageView = inflater.inflate(R.layout.list_start_index,parent,false);
                ItemAdapter.ViewHolderparagraph viewHolderparagraph = new ItemAdapter.ViewHolderparagraph(imageView);
                return viewHolderparagraph;
            }
            default:
            {
                View listView = inflater.inflate(R.layout.list_row, parent, false);
                ItemAdapter.ViewHoldertop viewHoldertop = new ItemAdapter.ViewHoldertop(listView);
                return viewHoldertop;
            }
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, int position) {
        Log.v("Adapter", "Binding of View Holder to be done");
        listData data = items.get(position);
        switch (viewHolder.getItemViewType()){
            case 0:{
                ViewHolderparagraph viewHolderparagraph = (ViewHolderparagraph) viewHolder;
                viewHolderparagraph.imageView.setImageResource(R.mipmap.ic_launcher);
                break;
            }
            default:{
                ViewHoldertop viewHoldertop = (ViewHoldertop) viewHolder;
                viewHoldertop.textItemName.setText(data.getRowText());
                viewHoldertop.checkItem.setChecked(data.getCheckState());
                Log.v("Adapter First One", "Binding of View Holder done");
                break;
            }
        }
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    //interface declare
    interface OnItemClickListener{
        void onItemClick(int pos);
    }


}
