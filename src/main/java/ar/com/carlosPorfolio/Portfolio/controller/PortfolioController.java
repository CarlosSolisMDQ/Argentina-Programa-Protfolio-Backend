package ar.com.carlosPorfolio.Portfolio.controller;



import ar.com.carlosPorfolio.Portfolio.models.*;
import ar.com.carlosPorfolio.Portfolio.services.*;
import org.bouncycastle.jcajce.BCFKSLoadStoreParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@RestController
@CrossOrigin(origins = "*")
public class PortfolioController {

    @Autowired
    private AboutService interAbout;

    @Autowired
    private EducationService interEducation;

    @Autowired
    private ExperienceService interExperience;

    @Autowired
    private ProjectService interProject;

    @Autowired
    private SkillService interSkill;

    @Autowired
    private UserService interUser;

    @Autowired
    private UiPortfolioImagesService interImages;

//bloque de peticiones get

    @GetMapping("/about")
    @ResponseBody
    public List<About> getAbout()  {
        return interAbout.getAbout();
    }


    @GetMapping("/experience")
    @ResponseBody
    public List<Experience> getExperience()  {
        return interExperience.getExperience();
    }

    @GetMapping("/education")
    @ResponseBody
    public List<Education> getEducation(){
        return interEducation.getEducation();
    }

    @GetMapping("/project")
    @ResponseBody
    public List<Project> getProject() {
        return interProject.getProject();
    }

    @GetMapping("/skill")
    @ResponseBody
    public List<Skill> getSkill() {
        return interSkill.getSkill();
    }

    @GetMapping("/images")
    @ResponseBody
    public List<UiPortfolioimages> getImages()  { return interImages.getUiPortfolioimages(); };




    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/about/crear")
    public String createAbout(@RequestBody About about) throws Exception {
        interAbout.saveAbout(about);
        return "about agregado correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/education/crear")
    public void createEducation(@RequestBody Education education) throws Exception {
        interEducation.saveEducation(education);

    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/experience/crear")
    public void createExperience(@RequestBody Experience experience) throws Exception {
        interExperience.saveExperience(experience);

    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/project/crear")
    public void createProject(@RequestBody Project project) throws Exception {
        interProject.saveProject(project);

    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/skill/crear")
    public void createSkill(@RequestBody Skill skill) throws Exception {
        interSkill.saveSkill(skill);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/images/crear")
    public void createImages(@RequestBody UiPortfolioimages uiPortfolioimages) throws Exception {
        interImages.saveUiPortfolioimages(uiPortfolioimages);

    }

    //bloque de peticiones delete
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/about/borrar/{id}")
    public void deleteAbout(@PathVariable Long id){
        interAbout.deleteAbout(id);

    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/education/borrar/{id}")
    public void deleteEducation(@PathVariable Long id){
        interEducation.deleteEducation(id);

    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/experience/borrar/{id}")
    public void deleteExperience(@PathVariable Long id){
        interExperience.deleteExperience(id);

    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/project/borrar/{id}")
    public void deleteProject(@PathVariable Long id){
        interProject.deleteProject(id);

    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/skill/borrar/{id}")
    public void deleteSkill(@PathVariable Long id){
        interSkill.deleteSkill(id);
    }

    //bloque de peticiones put
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/about/{id}")
    public About editAbout(@PathVariable Long id, @RequestParam ("about") String about){

        About aboutResult = interAbout.findAbout(id);
        String decoded = "";
        //voy a probar codificar y decodificar el string para que puedan entrar caracteres especiales
        try{
            decoded = (String)URLDecoder.decode(about, "UTF-8");
        }catch(Exception e){
            decoded = "error en la conversion decodificacion del String";
        }


        aboutResult.setAbout(decoded);

        interAbout.saveAbout(aboutResult);

        return aboutResult;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/education/{id}")
    public Education editEducation(@PathVariable Long id,
                                   @RequestParam ("escuela") String escuela,
                                   @RequestParam ("carrera") String carrera,
                                   @RequestParam ("fechaInicio") Integer inicio,
                                   @RequestParam ("fechaFin") Integer fin
                                   ){

        Education educationResult = interEducation.findEducation(id);

        educationResult.setEscuela(escuela);
        educationResult.setCarrera(carrera);
        educationResult.setFechaInicio(inicio);
        educationResult.setFechaFin(fin);

        interEducation.saveEducation(educationResult);

        return educationResult;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/experience/{id}")
    public Experience editExperience(@PathVariable Long id,
                                     @RequestParam ("empresa") String empresa,
                                     @RequestParam ("puesto") String puesto,
                                     @RequestParam ("fechaInicio") Integer fechaInicio,
                                     @RequestParam ("fechaFin") Integer fechaFin
                                     ){


        Experience experienceResult = interExperience.findExperience(id);

        experienceResult.setEmpresa(empresa);
        experienceResult.setPuesto(puesto);
        experienceResult.setFechaInicio(fechaInicio);
        experienceResult.setFechaFin(fechaFin);

        interExperience.saveExperience(experienceResult);

        return experienceResult;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/project/{id}")
    public Project editProject(@PathVariable Long id, @RequestParam ("nombre") String nombre,
                               @RequestParam ("descripcion") String descripcion,
                               @RequestParam ("imageURL") String imageURL
                               ){

        Project projectResult = interProject.findProject(id);

        projectResult.setNombre(nombre);
        projectResult.setDescripcion(descripcion);
        projectResult.setImagen(imageURL);

        interProject.saveProject(projectResult);

        return projectResult;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/skills/{id}")
    public Skill editSkill(@PathVariable Long id,
                               @RequestParam ("habilidad") String habilidad,
                               @RequestParam ("porcentaje") Integer porcentaje
    ){

        Skill skillResult = interSkill.findSkill(id);


        skillResult.setHabilidad(habilidad);
        skillResult.setPorcentaje(porcentaje);

        interSkill.saveSkill(skillResult);

        return skillResult;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/images/{id}")
    public UiPortfolioimages editImages(@PathVariable Long id,
                                        @RequestParam ("portada") String portada,
                                        @RequestParam ("foto") String foto){
        UiPortfolioimages imagesResult = interImages.findUiPortfolioimages(id);
        if(!portada.equals("") && !foto.equals("") ){
            imagesResult.setPortada(portada);
            imagesResult.setFoto(foto);
        } else if (!portada.equals("")){
            imagesResult.setPortada(portada);
        } else if (!foto.equals("")){
            imagesResult.setFoto(foto);
        }
        interImages.saveUiPortfolioimages(imagesResult);

        return imagesResult;

    }





}
