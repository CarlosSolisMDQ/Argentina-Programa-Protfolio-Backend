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


//bloque de peticiones post

//    @PostMapping("/login")
//    public User userLogin(@RequestParam("user") String username, @RequestParam("password") String pwd) throws LoginException {
//        //interUser.login(user);
//
//
//        //hay que validar el password y el usuario. Así como está retorna un token sin importar que se ponga
//        String token = getJWTToken(username);
//        User user = new User();
//        user.setUser(username);
//        user.setToken(token);
//        return user;
//        //aca lo que hay que retornar es el token
//
//
//
//
//
//    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/about/crear")
    public String createAbout(@RequestBody About about) throws Exception {
        interAbout.saveAbout(about);
        return "about agregado correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/education/crear")
    public String createEducation(@RequestBody Education education) throws Exception {
        interEducation.saveEducation(education);
        return "educacion agregada correctamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/experience/crear")
    public String createExperience(@RequestBody Experience experience) throws Exception {
        interExperience.saveExperience(experience);
        return "experiencia agregada correctamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/project/crear")
    public String createProject(@RequestBody Project project) throws Exception {
        interProject.saveProject(project);
        return "proyecto creado correctamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/skill/crear")
    public String createSkill(@RequestBody Skill skill) throws Exception {
        interSkill.saveSkill(skill);
        return "skill creada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/images/crear")
    public String createImages(@RequestBody UiPortfolioimages uiPortfolioimages) throws Exception {
        interImages.saveUiPortfolioimages(uiPortfolioimages);
        return "imagenes actualizadas";
    }

    //bloque de peticiones delete
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/about/borrar/{id}")
    public String deleteAbout(@PathVariable Long id){
        interAbout.deleteAbout(id);
        return "about borrada exitosamente";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/education/borrar/{id}")
    public String deleteEducation(@PathVariable Long id){
        interEducation.deleteEducation(id);
        return "educacion borrada exitosamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/experience/borrar/{id}")
    public String deleteExperience(@PathVariable Long id){
        interExperience.deleteExperience(id);
        return "experiencia borrada exitosamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/project/borrar/{id}")
    public String deleteProject(@PathVariable Long id){
        interProject.deleteProject(id);
        return "proyecto borrado exitosamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/skill/borrar/{id}")
    public String deleteSkill(@PathVariable Long id){
        interSkill.deleteSkill(id);
        return "skill borrada exitosamente";
    }

    //bloque de peticiones put
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/about/{id}")
    public About editAbout(@PathVariable Long id, @RequestParam ("about") String about){
        //aqui llamamos al servicio del portfolio, despues securizar la ruta.
        About aboutResult = interAbout.findAbout(id);

        aboutResult.setAbout(about);

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
        //aqui llamamos al servicio del portfolio, despues securizar la ruta.
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

        //aqui llamamos al servicio del portfolio, despues securizar la ruta.
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
        //aqui llamamos al servicio del portfolio, despues securizar la ruta.
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
        //aqui llamamos al servicio del portfolio, despues securizar la ruta.
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
        } else if (portada.equals("")){
            imagesResult.setPortada(portada);
        } else if (foto.equals("")){
            imagesResult.setFoto(foto);
        }
        interImages.saveUiPortfolioimages(imagesResult);

        return imagesResult;

    }

    //aqui pongo la funcion para obtener el token de login

//    private String getJWTToken(String username) {
//        String secretKey = "mySecretKey";
//        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
//                .commaSeparatedStringToAuthorityList("ROLE_USER");
//
//        String token = Jwts
//                .builder()
//                .setId("user")
//                .setSubject(username)
//                .claim("authorities",
//                        grantedAuthorities.stream()
//                                .map(GrantedAuthority::getAuthority)
//                                .collect(Collectors.toList()))
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 600000))
//                .signWith(SignatureAlgorithm.HS512,
//                        secretKey.getBytes()).compact();
//
//        return "Bearer " + token;
//    }



}
