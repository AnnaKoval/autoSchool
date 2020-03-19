package steps;

import pages.CardPage;

public class CardPageSteps extends WebDriverSteps {
    public CardPage onCardPage() {
        return onPage(CardPage.class);
    }
}
