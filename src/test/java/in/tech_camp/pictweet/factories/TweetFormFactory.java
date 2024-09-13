package in.tech_camp.pictweet.factories;

import com.github.javafaker.Faker;

import in.tech_camp.pictweet.TweetForm;

public class TweetFormFactory {
  private static final Faker faker = new Faker();

  public static TweetForm createTweet() {
    TweetForm tweetForm = new TweetForm();
    tweetForm.setText(faker.lorem().sentence(10));
    tweetForm.setImage(faker.lorem().sentence(10));
    return tweetForm;
  }
}
