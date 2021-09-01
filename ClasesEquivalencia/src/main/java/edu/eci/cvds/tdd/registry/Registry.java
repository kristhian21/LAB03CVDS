package edu.eci.cvds.tdd.registry;

import java.util.HashMap;

public class Registry {

    HashMap<String, Person> votantes = new HashMap<>();

    public RegisterResult registerVoter(Person person) {
        RegisterResult resultado = null;

        if(person.getAge() < 18 && person.getAge() > 0){
            resultado = RegisterResult.UNDERAGE;
        }
        if(person.getAge() < 0){
            resultado = RegisterResult.INVALID_AGE;
        }
        if(!person.isAlive()){
            resultado = RegisterResult.DEAD;
        }
        if(votantes.containsKey(String.valueOf(person.getId()))){
            resultado = RegisterResult.DUPLICATED;
        }
        if(person.isAlive() && person.getAge() >= 18){
            resultado = RegisterResult.VALID;
            votantes.put(String.valueOf(person.getId()), person);
        }

        return resultado;
    }
}