package com.drools.study.chapter1;

import com.drools.study.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by zp on 2019/4/14.
 * @author zp
 */
public class RulesTest {
    @Test
    public void droolsRules(){
        System.setProperty("drools.dateformat", "yyyy-MM-dd");
        KieServices kieService = KieServices.Factory.get();
        KieContainer kieContainer = kieService.getKieClasspathContainer("base-rules");
        KieSession kieSession = kieContainer.newKieSession("rules");
        //System.setProperty("drools.dateformat", "yyyy-MM-dd"); //  设置 drl文件的时间格式，放在这里是错误的
        Person p= new Person();
        p.setAge(20);
        p.setName("张三");
        kieSession.insert(p);
        int count = kieSession.fireAllRules();
        System.out.println("Fire "+count+" rule(s)");
        kieSession.dispose();

    }
    @Test
    public void globalTest(){
//        KieServices kieServices = KieServices.Factory.get();
//        KieContainer kieContainer = kieServices.getKieClasspathContainer();
//        KieSession kieSession = kieContainer.newKieSession("rules");
//        kieSession.setGlobal("","");

    }

}
