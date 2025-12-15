package com.design;

import com.google.inject.Inject;
import java.util.List;

public class BriefController {
    private final DesignService designService; // Використовуємо DesignService

    @Inject
    public BriefController(DesignService designService) {
        this.designService = designService;
    }

    public List<Brief> getAllBriefs() {
        return designService.getAllBriefs();
    }
}