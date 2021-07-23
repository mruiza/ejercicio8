package tasks;

import interactions.Select;
import model.ConvertNominalEffectiveRateData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import java.util.List;
import static userinterface.FromNominalRateToEffectiveRatePage.*;

public class Convert implements Task {

    private final List<ConvertNominalEffectiveRateData> convertNominalEffectiveRateData;

    public Convert(List<ConvertNominalEffectiveRateData> convertNominalEffectiveRateData) {
        this.convertNominalEffectiveRateData = convertNominalEffectiveRateData;
    }


    public static Convert fromNominalToEffectiveRate(List<ConvertNominalEffectiveRateData> convertNominalEffectiveRateData) {
        return Tasks.instrumented(Convert.class, convertNominalEffectiveRateData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(NOMINAL_RATE_TO_EFFECTIVE_RATE_BUTTON),
                Enter.theValue(convertNominalEffectiveRateData.get(0).getRate_interest()).into(INTEREST_RATE_TEXT),
                SelectFromOptions.byVisibleText(convertNominalEffectiveRateData.get(0).getPeriodicity()).from(PERIODICITY_LISTA),
                SelectFromOptions.byVisibleText(convertNominalEffectiveRateData.get(0).getCapitalization()).from(CAPITALIZATION_LISTA)
        );
    }
}
