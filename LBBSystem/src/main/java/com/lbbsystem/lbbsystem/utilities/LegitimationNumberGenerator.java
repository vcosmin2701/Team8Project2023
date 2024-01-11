package com.lbbsystem.lbbsystem.utilities;

import com.lbbsystem.lbbsystem.ejb.UsersBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.Random;

@Stateless
public class LegitimationNumberGenerator {
    @Inject
    UsersBean usersBean;

    public Long generateUniqueLegitimationNumber() {
        Random random = new Random();
        Long generatedNumber = (long) (1000000 + random.nextInt(9000000));

        while (!isLegitimationNumberUnique(generatedNumber)) {
            generatedNumber = (long) (1000000 + random.nextInt(9000000));
        }

        return generatedNumber;
    }

    private boolean isLegitimationNumberUnique(Long legitimationNumber) {
        return usersBean.findUserByLegitimationNumber(legitimationNumber)==null;}
}