package com.mindorks.test.swipe;

import android.util.Log;

import com.mindorks.placeholderview.common.Click;
import com.mindorks.placeholderview.common.Layout;
import com.mindorks.placeholderview.common.NonReusable;
import com.mindorks.placeholderview.common.Position;
import com.mindorks.swipeplaceholderview.SwipePlaceHolderView;
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
@Layout(R.layout.swipe_card_view)
public class SwipeCard {

//    @View(R.id.mainView)
//    private LinearLayout mainView;

    @Position
    private int mPosition;

    private SwipePlaceHolderView mSwipePlaceHolderView;

    public SwipeCard(SwipePlaceHolderView swipePlaceHolderView) {
        mSwipePlaceHolderView = swipePlaceHolderView;
    }

    @Click(R.id.rejectBtn)
    private void rejectBtnClick(){
        mSwipePlaceHolderView.doSwipe(this, false);
        Log.d("DEBUG", "rejectBtn");
    }

    @Click(R.id.acceptBtn)
    private void acceptBtnClick(){
        mSwipePlaceHolderView.doSwipe(this, true);
        Log.d("DEBUG", "acceptBtn");
    }

    @SwipeOut
    private void onSwipedOut(){
        Log.d("DEBUG", "onSwipedOut");
    }

    @SwipeCancelState
    private void onSwipeCancelState(){
        Log.d("DEBUG", "onSwipeCancelState");
    }

    @SwipeIn
    private void onSwipeIn(){
        Log.d("DEBUG", "onSwipedIn");
    }

    @SwipeInState
    private void onSwipeInState(){
        Log.d("DEBUG", "onSwipeInState");
    }

    @SwipeOutState
    private void onSwipeOutState(){
        Log.d("DEBUG", "onSwipeOutState");
    }
}
