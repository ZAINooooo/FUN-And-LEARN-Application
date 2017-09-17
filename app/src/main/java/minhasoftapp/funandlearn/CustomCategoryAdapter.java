package minhasoftapp.funandlearn;

/**
 * Created by Dardan on 4/19/2016.
 */
import java.util.ArrayList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hc.game1.R;

import minhasoftapp.funandlearn.CategoriesActivity;

public class CustomCategoryAdapter extends ArrayAdapter<CategoriesActivity.Category> {
    public CustomCategoryAdapter(Context context, ArrayList<CategoriesActivity.Category> categories) {
        super(context, 0, categories);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        CategoriesActivity.Category category = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_template, parent, false);
        }
        // Lookup view for data population
        TextView categoryTitle = (TextView) convertView.findViewById(R.id.card_title);
        TextView categoryHighscore = (TextView) convertView.findViewById(R.id.card_highscore);
        ImageView categoryImage=(ImageView) convertView.findViewById(R.id.card_image);
        RelativeLayout categoryLayout=(RelativeLayout) convertView.findViewById(R.id.cardLayout);
        // Populate the data into the template view using the data object
        assert category != null;
        categoryTitle.setText(category.title);
        categoryHighscore.setText("Highscore: "+ category.highscore);
        categoryImage.setImageResource(category.image);
        categoryLayout.setBackgroundColor(category.color);
        // Return the completed view to render on screen
        return convertView;
    }
}