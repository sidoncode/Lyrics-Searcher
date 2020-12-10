# Lyrics-Searcher

## Sources Used:-

### using public api respository
### 1) Using the Adbobe Xd for Desgining
### 2)

### Things left to be added
## icon to be added
## desgin of search fragment
## color of button more soothing color
## 



### key Points To Be Remembered:
### 1) android:focusableInTouchMode="false" -> Used for not appering keyboard in the activity/fragment
### 2) Code For multiline input in edittext

            lyrics_cv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (v.getId() == R.id.lyrics_cv) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (event.getAction() & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_UP:
                            v.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }
                }
                return false;
            }
        });**/  
The Above on (point number 2) is used for Multiline input in the EditText Field        
https://rapidapi.com/
## Regards.
### Siddharth :)
