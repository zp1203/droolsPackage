package utils;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;

/**
 * Created by zp on 2019/4/15.
 * @author zp
 */
public class KieUtils {

    private static KieServices kieServices;

    private static KieContainer kieContainer;

    private static KieFileSystem kieFileSystem;

    private static KieBuilder kieBuilder;

    private static KieRepository kieRepository;

    private static KieBase kieBase;

    private static KieSession kieSession;

    private static KieHelper kieHelper;



    public static KieServices getKieServices() {
        return kieServices;
    }

    public static void setKieServices(KieServices kieServices) {
        KieUtils.kieServices = kieServices;
    }

    public static KieContainer getKieContainer() {
        return kieContainer;
    }

    public static void setKieContainer(KieContainer kieContainer) {
        KieUtils.kieContainer = kieContainer;
        kieSession = kieContainer.newKieSession();
    }

    public static KieFileSystem getKieFileSystem() {
        return kieFileSystem;
    }

    public static void setKieFileSystem(KieFileSystem kieFileSystem) {
        KieUtils.kieFileSystem = kieFileSystem;
    }

    public static KieBuilder getKieBuilder() {
        return kieBuilder;
    }

    public static void setKieBuilder(KieBuilder kieBuilder) {
        KieUtils.kieBuilder = kieBuilder;
    }

    public static KieRepository getKieRepository() {
        return kieRepository;
    }

    public static void setKieRepository(KieRepository kieRepository) {
        KieUtils.kieRepository = kieRepository;
    }

    public static KieBase getKieBase() {
        return kieBase;
    }

    public static void setKieBase(KieBase kieBase) {
        KieUtils.kieBase = kieBase;
    }

    public static KieSession getKieSession() {
        return kieSession;
    }

    public static void setKieSession(KieSession kieSession) {
        KieUtils.kieSession = kieSession;
    }


    public static KieHelper getKieHelper() {
        return kieHelper;
    }

    public static void setKieHelper(KieHelper kieHelper) {
        KieUtils.kieHelper = kieHelper;
    }


    public static void initAndClear(){
        kieServices = KieServices.Factory.get();
        kieRepository = kieServices.getRepository();
        kieFileSystem = kieServices.newKieFileSystem();
        kieHelper = new KieHelper();
    }

}
