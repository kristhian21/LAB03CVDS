package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {

    ArrayList votantes = new ArrayList<Person>();

    public RegisterResult registerVoter(Person p) {
        RegisterResult resultado = null;

        if(p.getAge() < 18){
            resultado = RegisterResult.UNDERAGE;
        }
        else if(p.getAge() > 125){
            resultado = RegisterResult.INVALID_AGE;
        }
        else if(!p.isAlive()){
            resultado = RegisterResult.DEAD;
        }
        else if(p.isAlive() && p.getAge() > 18 && p.getAge() > 125){
            resultado = RegisterResult.VALID;
            votantes.add(p);
        }
        else if(votantes.contains(p)){
            resultado = RegisterResult.DUPLICATED;
        }

        return resultado;
    }
}