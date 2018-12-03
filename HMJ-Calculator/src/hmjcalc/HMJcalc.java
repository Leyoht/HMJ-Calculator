/*
== Developers ==
 Christopher Hale, Nicholas Jani, Kaustubh Joshi,
 Harrison Knill, Alexander Reynaud, Kevin Saligoe
== Professor ==
 Dr. Eric Matson
== Course ==
 Object-Oriented Application Development*/
package hmjcalc;

import hmjcalc.objects.Person;

public class HMJcalc {
    //Google Places key: AIzaSyC8x423-pOCpAk7RWb2v3G86xS8-DbUSwk
    
    //private List<Status> currentTweets;
    /*private void GetMostRecent20HomeTimeLine()
        {
            var twitterContext = new TwitterContext(authorizer);

            var tweets = from tweet in twitterContext.Status
                         where tweet.Type == StatusType.Home &&
                         tweet.Count == 20
                         select tweet;

            currentTweets = tweets.ToList();

    }*/
    
    //THE FOLLOWING WILL GO IN HMJGUI
    private void btnHowManyDrinks_Click() {
        /*boolean isLegal;
        double numberOfDrinks;
        isLegal = drinker.areYouLegal();

        if (isLegal) { //should work with the textbox or display in JPanel
            numberOfDrinks = drinker.howManyShouldIDrink();

            result.Text = "you should have " + numberOfDrinks + " drinks";
        } else {
            result.Text = "you are not old enough to drink. Try again later";
        }*/
    }
    /*private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (cmbBars.SelectedIndex == 0)
            {
                txtPopularDrinks.Text = "Blue Hawaiian: Malibu, Blue Curacao, Pineapple" + Environment.NewLine +
                                        "Grasshopper: Creme de Menthe Dark, Creme de Cacao Light, Half and Half" + Environment.NewLine +
                                        "Sex on the Beach: Vodka, Amaretto, Peach, Blackberry Brandy, OJ, Grenadine";
            }
            else if (cmbBars.SelectedIndex == 1)
            {
                txtPopularDrinks.Text = "Thursday: $1.50 Double Well Mixers, $2.50 Bud Light Drafts, $2.50 Fireball Shots" + Environment.NewLine +
                                        "Friday: $4 Double Wells, $3 Shots(Fireball, Lemon Drop, Cheesecake, etc)" + Environment.NewLine +
                                        "Saturday: $4 Double Wells, $3 Shots(Fireball, Lemon Drop, Cheesecake, etc)";
            }
            else if (cmbBars.SelectedIndex == 2)
                txtPopularDrinks.Text = "Thursday: $3.50 32 ox Mixed Drinks (Shirley Temple, Long Islands, etc)";

        }

        private void btnBeer_Click(object sender, EventArgs e)
        {
            txtAlcoholContent.Text = "4.5% ABV";
        }

        private void btnWine_Click(object sender, EventArgs e)
        {
            txtAlcoholContent.Text = "12% ABV";
        }

        private void btnShots_Click(object sender, EventArgs e)
        {
            txtAlcoholContent.Text = "40% ABV";
        }

        private void btnMixedDrinks_Click(object sender, EventArgs e)
        {
            txtAlcoholContent.Text = "13% ABV";
        }*/
    public static void main(String[] args) {
        Person drinker = new Person();
    }
}
