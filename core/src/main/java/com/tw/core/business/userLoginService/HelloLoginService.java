package com.tw.core.business.userLoginService;

import com.tw.core.bean.Person;
import com.tw.core.service.personservice.PersonService;
import com.tw.core.util.CookiesHelper;
import com.tw.core.util.MD5Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by marry on 7/15/15.
 */
public class HelloLoginService {
    PersonService personService = new PersonService();
    public Person getLoginPerson(HttpServletResponse response,HttpServletRequest request,String name,String password){
        List<Person> people = personService.getPeople();
        Person person = null;
        for (int i = 0; i < people.size(); i++) {
            if(people.get(i).getName().equals(name) && people.get(i).getPassword().equals(MD5Util.GetMD5Code(password))){
                person = people.get(i);
                CookiesHelper.setCookies(person, response, request);
                break;
            }
        }
        return person;
    }

}
