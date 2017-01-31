package com.mindorks.test.gallery;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.common.Animate;
import com.mindorks.placeholderview.common.Animation;
import com.mindorks.placeholderview.common.Layout;
import com.mindorks.placeholderview.common.NonReusable;
import com.mindorks.placeholderview.common.Resolve;
import com.mindorks.placeholderview.common.View;
import com.mindorks.test.Image;
import com.mindorks.test.R;

import java.util.List;

/**
 * Created by janisharali on 19/08/16.
 */
@Animate(Animation.CARD_TOP_IN_DESC)
@NonReusable
@Layout(R.layout.gallery_item_small_placeholder)
public class ImageTypeSmallPlaceHolder {

    @View(R.id.placeholderview)
    private PlaceHolderView mPlaceHolderView;

    private Context mContext;
    private List<Image> mImageList;

    public ImageTypeSmallPlaceHolder(Context context, List<Image> imageList) {
        mContext = context;
        mImageList = imageList;
    }

    @Resolve
    private void onResolved() {
        mPlaceHolderView.getBuilder()
                .setHasFixedSize(false)
                .setItemViewCacheSize(10)
                .setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));

        for(Image image : mImageList) {
            mPlaceHolderView.addView(new ImageTypeSmall(mContext, mPlaceHolderView, image.getUrl()));
        }
    }
}
