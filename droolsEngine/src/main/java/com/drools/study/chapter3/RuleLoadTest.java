package com.drools.study.chapter3;

import com.drools.study.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import utils.KieUtils;

/**
 * Created by zp on 2019/4/15.
 * @author zp
 */
public class RuleLoadTest {

    @Test
    public void ruleLoad2KieSession(){

         KieUtils.initAndClear();
         KieFileSystem kFileSystem = KieUtils.getKieFileSystem();
         KieServices ks = KieUtils.getKieServices();
         KieRepository kr = KieUtils.getKieRepository();

         // 拼接一个规则
         String ruleDrl= "package  com.rules\n" +
                 "\n" +
                 "import com.drools.study.model.Person\n" +
                 "\n" +
                 "\n" +
                 "rule \"有参数的规则\"\n" +
                 "when\n" +
                 "    $p : Person( $p.getAge() > 18)\n" +
                 "then\n" +
                 "    System.out.println($p.getName() + \" 可以去网吧了！\");\n" +
                 "end";

         // 把定义的 规则  写入 规则文件中去
         kFileSystem.write("src/main/resources/com/rules/test.drl",ruleDrl);

         // 对 规则文件 进行建立
         KieBuilder kb = ks.newKieBuilder(kFileSystem);
         kb.buildAll();

        //建立的规则文件有个编号，用KieRepository仓库获取编号，并加载到Container容器中
//        ReleaseId releaseId = kr.getDefaultReleaseId();
//        String a = releaseId.getArtifactId();
//        String b = releaseId.getGroupId();
//        String c = releaseId.getVersion();
//        String d = releaseId.toExternalForm();
//        System.out.println("测试开始");
//        System.out.println(a+"\n"+b+"\n"+c+"\n"+d);
//        System.out.println("测试结束");
        KieContainer kContainer = ks.newKieContainer(kr.getDefaultReleaseId());

         // 把 容器中的规则放在KieSession中
        KieUtils.setKieContainer(kContainer);

        KieContainer kieContainer = KieUtils.getKieContainer();
        KieSession kieSession = kieContainer.newKieSession();
        Person p = new Person();
        p.setAge(23);
        p.setName("李华");
        kieSession.insert(p);
        int count = kieSession.fireAllRules();
        System.out.println("触发了"+count+"条规则");
        kieSession.dispose();


    }


}
