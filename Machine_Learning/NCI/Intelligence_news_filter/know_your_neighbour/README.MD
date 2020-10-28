I tried to get data from twitter based on hastag
tracklist = ['#covid19', '#lockdown', '#socialdistancing']
Update location:-
https://stackoverflow.com/questions/34061693/scrape-tweets-by-tweet-location-and-user-location
myStream.filter(location= [-122.75,36.8,-121.75,37.8])


These are the key information from data.For more details you can look at the text file

I got this data in tweet_text_file
There are several key component:
created_at:
user -It is user detail-name,location,friend count,followercount etc
retweeted_status-It has also all the detail of user.
geo location is currently coming null
extended_entities-Any image has been added to the tweet
"quote_count": 0,
"reply_count": 1,
"retweet_count": 2,
"favorite_count": 1,


Twitter standard api rule:
We can get the last 30 days tweet with standard API.
Here is official statement from twitter.
Twitter  data endpoint paginates at either the specified maxResults or after 30 days.

For example, if you have 800 Tweets in a given 30 day period, you will have to make two requests to pull the complete results; because the maximum number of Tweets that can be returned per request is 500 (maxResults). And if you just have 400 Tweets in month one, and then 100 Tweets in month two, you will also have to use two requests to pull the full results; because pagination takes place after a period of 30 days even if the first request returns less than the specified maxResults Tweets.
