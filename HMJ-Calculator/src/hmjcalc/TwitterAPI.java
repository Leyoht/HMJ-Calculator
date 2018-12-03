/*
 * Will print into the HMJGUI when called
 */
package hmjcalc;

import java.util.List;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author dtdkn
 */
public class TwitterAPI {
    public static void main(String[] args) throws TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("Yebigru41qqV31Oj8nVC0b8wq")
                .setOAuthConsumerSecret("okyapaGHoWsSmkuKvuvw3khgcWyAVUqngIxCsaHqioz98hkuK6")
                .setOAuthAccessToken("114903666-Du1AcMxmTy2PWN4SBd61CMq9WpWMBHAiM6lw3wsJ")
                .setOAuthAccessTokenSecret("Ib7FDF6qpiAv2xE1HJE4k4cvt70nfqpKHY428CipdoH8s");
        
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter4j.Twitter twitter = tf.getInstance();
        
        List<Status> status = twitter.getHomeTimeline();
        for (Status st : status) {
            /* There has to be a way to take the getTimeZone data (which prints
            * a string, by the way) and find out if it's 5 o'clock based on that
            * timezone information
            * Currently .getTimeZone just sends a null value*/
            System.out.println(st.getUser().getLocation()+st.getUser().getTimeZone());
        }
    }
    
    //We need another method to look at the .getTimeZone data and channel it through the for loop
}
