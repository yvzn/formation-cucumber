package fr.exemple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.Period;

@Controller
public class DroitRetraiteController {

    @Autowired
    private DroitRetraiteService droitRetraiteService;

    @RequestMapping("/ageLegal")
    public String ageLegal(
            @RequestParam(value = "dateNaissance", required = false, defaultValue = "") String paramDateNaissance, Model model) {

        if (StringUtils.hasText(paramDateNaissance)) {
            LocalDate dateNaissance = LocalDate.parse(paramDateNaissance);
            Individu individu = new Individu();
            individu.setDateNaissance(dateNaissance);
            Period ageLegalDepartRetraite = droitRetraiteService.calculerAgeLegalDepartRetraite(individu);

            String resultat = String.format("%d années %d mois", ageLegalDepartRetraite.getYears(), ageLegalDepartRetraite.getMonths());
            model.addAttribute("resultat", resultat);
        }

        model.addAttribute("dateNaissance", paramDateNaissance);
        return "ageLegal";
    }
}
