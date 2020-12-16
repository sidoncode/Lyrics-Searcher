# Lyrics-Searcher

## Sources Used:-

## using public api respository
### 1) Using the Adbobe Xd for Desgining
### 2) The Api is free for Student/Devs
### 3) The design and ux was carried out by ui kits(free for dev projects) available in the internet

## Things left to be added
### icon to be added -> done
### desgin of search fragment -> done
### color of button more soothing color -> done
## 



## key Points To Be Remembered:
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
### 3) No response code for Failed / Not found statuses for the toast / message for the user
### 4) Only status code is availabe is 200.(Success Api Call)

<p align="center">

## Screen-Shots

  <a target="_blank" rel="noopener noreferrer" href="https://user-images.githubusercontent.com/40432616/102018789-7fe3f780-3d95-11eb-9204-212faeb821fa.jpg"><img src="https://user-images.githubusercontent.com/40432616/102018789-7fe3f780-3d95-11eb-9204-212faeb821fa.jpg" style="max-width:100%;" width="256" height="455"></a>
  <a target="_blank" rel="noopener noreferrer" href="https://user-images.githubusercontent.com/40432616/102018794-82465180-3d95-11eb-90d0-5bc242f32851.jpg"><img src="https://user-images.githubusercontent.com/40432616/102018794-82465180-3d95-11eb-90d0-5bc242f32851.jpg" style="max-width:100%;" width="256" height="455"></a>
  <a target="_blank" rel="noopener noreferrer" href="https://user-images.githubusercontent.com/40432616/102018795-82dee800-3d95-11eb-87f3-48099f3d6567.jpg"><img src="https://user-images.githubusercontent.com/40432616/102018795-82dee800-3d95-11eb-87f3-48099f3d6567.jpg" style="max-width:100%;" width="256" height="455"></a>
  <a target="_blank" rel="noopener noreferrer" href="https://user-images.githubusercontent.com/40432616/102018797-85d9d880-3d95-11eb-8c00-0e036af0229b.jpg"><img src="https://user-images.githubusercontent.com/40432616/102018797-85d9d880-3d95-11eb-8c00-0e036af0229b.jpg" style="max-width:100%;" width="256" height="455"></a>
</p>

The Above on (point number 2) is used for Multiline input in the EditText Field https://rapidapi.com/

## Regards.
### Siddharth :)
