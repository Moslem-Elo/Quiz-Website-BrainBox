package htwberlin.Projekt.Controller;

import htwberlin.Projekt.Entitys.Theme;
import htwberlin.Projekt.Service.ThemeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/themes")
public class ThemeController {

    private final ThemeService themeService;



    @GetMapping
    public List<Theme> getAllThemes() {
        return themeService.getAllThemes();
    }

    @GetMapping("/{id}")
    public Theme getThemeById(@PathVariable Long id) {
        return themeService.getThemeById(id).orElseThrow(() -> new ResourceNotFoundException("Theme not found with id " + id));
    }

    @PostMapping
    public Theme createTheme(@RequestBody Theme theme) {
        return themeService.createTheme(theme);
    }

    @PutMapping("/{id}")
    public Theme updateTheme(@PathVariable Long id, @RequestBody Theme themeDetails) {
        Theme theme = themeService.getThemeById(id).orElseThrow(() -> new ResourceNotFoundException("Theme not found with id " + id));
        theme.setName(themeDetails.getName());
        return themeService.updateTheme(theme);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTheme(@PathVariable Long id) {
        Theme theme = themeService.getThemeById(id).orElseThrow(() -> new ResourceNotFoundException("Theme not found with id " + id));
        themeService.deleteTheme(theme);
        return ResponseEntity.ok().build();
    }
}

