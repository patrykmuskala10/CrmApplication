package pl.patrykmuskala.CrmApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.patrykmuskala.CrmApplication.Model.Panel;
import pl.patrykmuskala.CrmApplication.Repository.PanelRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/panels")
public class PanelService {

    @Autowired
    PanelRepository panelRepository;

    @GetMapping
    public Iterable<Panel> getPanels() {
        return panelRepository.findAll();
    }

    @GetMapping("/id={id}")
    public Optional<Panel> getPanelById(@PathVariable(value = "id") int id) {
        return panelRepository.findById(id);
    }

    @GetMapping("/manufacturer={manufacturer}")
    public Iterable<Panel> getPanelsByManufacturer(@PathVariable(value = "manufacturer") String manufacturer) {
        return panelRepository.findAllByManufacturer(manufacturer);
    }

    @PostMapping
    public Panel createPanel(@RequestBody Panel panel) {
        return panelRepository.save(panel);
    }
}
