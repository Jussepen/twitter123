# Project 3 - *twitter*

**fake twitter ** is an android app that allows a user to view his Twitter timeline and post a new tweet. The app utilizes [Twitter REST API](https://dev.twitter.com/rest/public).

Time spent: **16** hours spent in total

## User Stories

The following **required** functionality is completed:

* [ x ]	User can **sign in to Twitter** using OAuth login
* [ x ]	User can **view tweets from their home timeline**
  * [ x ] User is displayed the username, name, and body for each tweet
  * [ x ] User is displayed the [relative timestamp](https://gist.github.com/nesquena/f786232f5ef72f6e10a7) for each tweet 
* [ x ] User can **compose and post a new tweet**
  * [ x ] User can click a “Compose” icon in the Action Bar on the top right
  * [ x ] User can then enter a new tweet and post this to twitter
  * [ x ] User is taken back to home timeline with **new tweet visible** in timeline
  * [ x ] Newly created tweet should be manually inserted into the timeline and not rely on a full refresh

The following **stretch** features are implemented:

* [ x ] User can **see a counter with total number of characters left for tweet** on compose tweet page
* [ x ] User can **pull down to refresh tweets timeline**
* [ x ] User is using **"Twitter branded" colors and styles**
* [ x ] User can **see embedded image media within a tweet** on list or detail view.

The following **bonus** features are implemented:

* [ x ] User can **click a link within a tweet body** on tweet details view. The click will launch the web browser with relevant page opened.
* [ x ] Use Parcelable instead of Serializable using the popular [Parceler library](http://guides.codepath.org/android/Using-Parceler).

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='' title='Video Walkthrough' width='' alt='Video Walkthrough' />


## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android
