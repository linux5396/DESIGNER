package com.qgailab.designer.struct.facade;

/**
 * @author linxu
 * @date 2020/2/2
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public abstract class ServiceFacade {
    protected LoginService loginService;
    protected KernalService kernalService;
    protected borderService borderService;

    public ServiceFacade(LoginService loginService, KernalService kernalService, com.qgailab.designer.struct.facade.borderService borderService) {
        this.loginService = loginService;
        this.kernalService = kernalService;
        this.borderService = borderService;
    }

    protected void dokernal(){
        loginService.login("","");
        kernalService.doKernalService();
    }
}
