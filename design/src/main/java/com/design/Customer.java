package com.design;

import com.google.inject.Inject;

public class Customer extends Person {
    private Brief brief;
    private DesignService designService; 
    

    public Customer() {
        super("Замовник"); 
    }
    
 
    @Inject
    public void setDesignService(DesignService designService) {
        this.designService = designService;
    }
    
    public Brief fillBrief() {
        System.out.println("Замовник " + getName() + " заповнює бриф");
        brief = new Brief("Деталі проєкту");
        

        if (designService != null) {
            designService.saveBrief(brief);
        }
        
        return brief;
    }
    
    public void acceptConcepts() {
        System.out.println("Замовник " + getName() + " приймає концепти");
    }
    
    public void approveEdits() {
        System.out.println("Замовник " + getName() + " погоджує правки");
    }
}