package com.codecool.krk.gamesapi.studio;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studios")
public class StudioController {

    private StudioService studioService;

    public StudioController(StudioService studioService) {
        this.studioService = studioService;
    }

    @GetMapping("")
    public Iterable<Studio> getAllStudios() {
        Iterable<Studio> studios = this.studioService.findAllStudios();
        return studios;
    }

    @GetMapping("/{id}")
    public Studio getStudio(@PathVariable Integer id) {
        Studio studio = this.studioService.findStudioById(id);
        return studio;
    }

    @PostMapping("")
    public Studio addStudio(@RequestBody Studio studio) {
        this.studioService.saveStudio(studio);
        return studio;
    }

    @DeleteMapping("/{id}")
    public void deleteStudio(@PathVariable Integer id) {
        this.studioService.deleteStudio(id);
    }
}
