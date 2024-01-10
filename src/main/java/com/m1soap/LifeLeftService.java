package com.m1soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.time.Year;


@WebService(serviceName = "LifeLeft")
public class LifeLeftService {

    private static final Integer MEN_LIFE_EXPECTANCY = 79;
    private static final Integer WOMEN_LIFE_EXPECTANCY = 85;

    public final String MAN = "Homme";
    public final String WOMAN = "Femme";



    @WebMethod
    public String yearsLeftToLive(String firstName, String sex, Integer yearOfBirth) {

        int referenceLifeExpentancy;
        if (sex.equals(MAN))
            referenceLifeExpentancy = MEN_LIFE_EXPECTANCY;
        else if (sex.equals(WOMAN))
            referenceLifeExpentancy = WOMEN_LIFE_EXPECTANCY;
        else
            return "sexe inconnu" + sex ;                    ;

        int yearsLeft = referenceLifeExpentancy - (Year.now().getValue() - yearOfBirth );

        return "Bonjour " + firstName + ", il vous reste " + yearsLeft + " années à vivre !";
    }

}
