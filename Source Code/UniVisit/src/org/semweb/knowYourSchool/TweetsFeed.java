package org.semweb.knowYourSchool;

import java.util.*;

import twitter4j.Status;
import twitter4j.Query;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.QueryResult;
public class TweetsFeed{
public Map<Integer, List<String>> getTwitterFeed(String s) {
  ConfigurationBuilder cb = new ConfigurationBuilder();
  cb.setDebugEnabled(true)
   .setOAuthConsumerKey("PTFrFoX9YbAEOLTvjlSbKvUqk")
   .setOAuthConsumerSecret("LoooBudj6u40QnGuSxFZEill47T0yHF7dN2q5yUMpQo78rEvOZ")
   .setOAuthAccessToken("796037993182076928-xVydbkXYgigC9hYMFac8KIPP7SQy0Y1")
   .setOAuthAccessTokenSecret("gUHm38AJIeQ2ogXXrk5a1jXksG4oCoCZy5xOnXbIBTR0u");
     
  TwitterFactory tf = new TwitterFactory(cb.build());
  Twitter twitter = tf.getInstance();
  Map<Integer, List<String>> output = new HashMap<Integer, List<String>>();
  List<String> tweeted = new ArrayList<String>();

      try {
          Query query = new Query(s);
          QueryResult result;
          result = twitter.search(query);
          List<Status> tweets = result.getTweets();
          
          for (Status tweet : tweets) {
              tweeted.add("@" + tweet.getUser().getScreenName() + " - " + tweet.getText()); 
          }
          output.put(0, tweeted);
          return output;
      } catch (TwitterException te) {
          //te.printStackTrace();
          tweeted.add("Failed to search tweets: " + te.getMessage());
          output.put(0, tweeted);
          return output;
      }
}
}