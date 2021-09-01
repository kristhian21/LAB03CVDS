package edu.eci.cvds.tdd.registry;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void validateUnderAgeResult() {

        Person person = new Person("Juan", 102740123, 17, Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void validateDeadResult() {

        Person person = new Person("Kristhian", 1002740443, 20, Gender.MALE, false);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void validateDuplicatedResult() {

        Person person = new Person("Maria", 103281003, 20, Gender.FEMALE, true);

        RegisterResult result = registry.registerVoter(person);

        result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }

    @Test
    public void validateInvalidAgeResult() {

        Person person = new Person("Jose", 199281003, -12, Gender.FEMALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void validateValidResult() {

        Person person = new Person("David", 124381113, 21, Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }
}