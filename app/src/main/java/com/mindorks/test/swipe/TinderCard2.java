package com.mindorks.test.swipe;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindorks.placeholderview.common.Click;
import com.mindorks.placeholderview.common.Layout;
import com.mindorks.placeholderview.common.NonReusable;
import com.mindorks.placeholderview.common.Resolve;
import com.mindorks.placeholderview.common.View;
import com.mindorks.swipeplaceholderview.swipe.SwipeCancelState;
import com.mindorks.swipeplaceholderview.swipe.SwipeIn;
import com.mindorks.swipeplaceholderview.swipe.SwipeInState;
import com.mindorks.swipeplaceholderview.swipe.SwipeOut;
import com.mindorks.swipeplaceholderview.swipe.SwipeOutState;
import com.mindorks.test.R;

/**
 * Created by janisharali on 19/08/16.
 */
@NonReusable
@Layout(R.layout.tinder_card_view)
public class TinderCard2 {

    private static int count;
    private CardCallback callback;

    @View(R.id.profileImageView)
    private ImageView profileImageView;

    @View(R.id.nameAgeTxt)
    private TextView nameAgeTxt;

    @View(R.id.locationNameTxt)
    private TextView locationNameTxt;

    public TinderCard2(CardCallback callback) {
        this.callback = callback;
    }

    @Click(R.id.profileImageView)
    private void onClick(){
        Log.d("DEBUG", "profileImageView");
    }

    @Resolve
    private void onResolve(){
        nameAgeTxt.setText("Name " + count++);
    }

    @SwipeOut
    private void onSwipedOut(){
        callback.onSwipingEnd();
    }

    @SwipeCancelState
    private void onSwipeCancelState(){
        callback.onSwipingEnd();
    }

    @SwipeIn
    private void onSwipeIn(){
        callback.onSwipingEnd();
    }

    @SwipeInState
    private void onSwipeInState(){
        callback.onSwiping();
    }

    @SwipeOutState
    private void onSwipeOutState(){
        callback.onSwiping();
    }

    public interface CardCallback{
        void onSwiping();
        void onSwipingEnd();
    }
}
