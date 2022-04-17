package com.wei.batch.processor;

import com.wei.batch.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;


/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Slf4j
public class PersonItemProcessor implements ItemProcessor<Person,Person> {

    /*******************************
     *  @Author WEIYJ 
     *  @Description //TODO 
     *  @Date 2022/4/16 20:37
      * @Param: null
        @Return     
     ********************************/
    @Override
    public Person process(Person person) throws Exception {
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();
        final Person transformedPerson = new Person(firstName, lastName);
        log.info("Converting (" + person + ") into (" + transformedPerson + ")");
        return transformedPerson;
    }
}
