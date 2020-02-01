package com.qgailab.designer.struct.facade;

/**
 * @author linxu
 * @date 2020/2/2
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class Client {
    private ServiceFacade facade;

    public Client(ServiceFacade facade) {
        this.facade = facade;
    }

    public void doService() {
        facade.dokernal();
    }
    /*private LoginService loginService;
    private KernalService kernalService;
    private borderService borderService;

    public Client(LoginService loginService, KernalService kernalService, com.qgailab.designer.struct.facade.borderService borderService) {
        this.loginService = loginService;
        this.kernalService = kernalService;
        this.borderService = borderService;
    }

    public void startKernal() {
        loginService.login("", "");
        kernalService.doKernalService();
    }

    public void startBorder() {
        loginService.login("", "");
        borderService.doBorderService();
    }*/
}
